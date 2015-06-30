/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/
package org.seasar.s2csv.csv.controller;

import java.util.ArrayList;
import java.util.List;

import org.seasar.framework.container.SingletonS2Container;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.seasar.s2csv.csv.S2CSVParseCtrl;
import org.seasar.s2csv.csv.convertor.CSVConvertCtrl;
import org.seasar.s2csv.csv.desc.CSVEntityDesc;
import org.seasar.s2csv.csv.exception.CSVFormatException;
import org.seasar.s2csv.csv.exception.runtime.CSVValidationResultException;
import org.seasar.s2csv.csv.exception.runtime.CSVValidationResultRuntimeException;
import org.seasar.s2csv.csv.io.CSVParser;
import org.seasar.s2csv.csv.validator.CSVValidateCtrl;
import org.seasar.s2csv.csv.validator.CSVValidateResult;

public class CSVParseCtrlImpl<T> implements S2CSVParseCtrl<T> {
	private CSVConvertCtrl maker;
	private CSVValidateCtrl validator;
	private CSVParser parser;
	private CSVEntityDesc csvEntityDesc;
	@Binding(bindingType = BindingType.NONE)
	private boolean validateFlag;
	private Object validateEntity;
	private boolean next;
	private String[] currentLine;
	public final String[] getCurrentLine() {
		return currentLine;
	}

	public final void setCurrentLine(String[] currentLine) {
		this.currentLine = currentLine;
	}

	private long currentNo;

	public final long getCurrentNo() {
		return currentNo;
	}

	public CSVParseCtrlImpl() {
	}

	public void setCSVParser(CSVParser parser) {
		this.parser = parser;
	}

	public void setCSVEntityDesc(CSVEntityDesc csvEntityDesc) {
		this.csvEntityDesc = csvEntityDesc;
	}

	public void setCSVMaker(CSVConvertCtrl maker) {
		this.maker = maker;
	}

	public void setCSVValidator(CSVValidateCtrl validator) {
		this.validator = validator;
	}

	public void setValidateFlag(boolean validateFlag) {
		this.validateFlag = validateFlag;
	}

	public boolean readNext() {
		boolean tmpHeaderCheck = false;
		if ((!this.next) && (this.csvEntityDesc.isCheckHeader())) {
			tmpHeaderCheck = true;
		}
		this.next = this.parser.isNext();
		if (this.next) {
			if (tmpHeaderCheck) {
				int hedLength = this.csvEntityDesc.getHeaderNames().length;
				String[] heders = this.parser.getHeader();
				for (int i = 0; i < hedLength; i++) {
					String hed1 = this.csvEntityDesc.getHeaderNames()[i];
					String hed2 = heders[i];
					if (!hed1.equals(hed2)) {
						throw new CSVFormatException(1L);
					}
				}
			}
			this.currentLine = this.parser.nextLine();
			this.currentNo = this.parser.getCurrentLineNo();
		} else {
			this.currentLine = null;
			this.currentNo = -1L;
			close();
		}
		return this.next;
	}

	public T parse() throws CSVValidationResultRuntimeException {
		T o = null;

		T entity = (T) SingletonS2Container.getComponent(this.csvEntityDesc
				.getEntityClass());
		if (this.validateFlag) {
			CSVValidateResult valRes = validateLine(entity, this.currentLine,
					this.currentNo);
			if (valRes != null) {
				throw new CSVValidationResultRuntimeException(valRes);
			}
		}
		o = this.maker.covToObj(entity, this.currentLine);

		return o;
	}

	public List<T> parseAll() throws CSVValidationResultException {
		List<CSVValidateResult> validateResult = new ArrayList();

		List cache = new ArrayList();
		try {
			while (readNext()) {
				try {
					T o = parse();
					cache.add(o);
				} catch (CSVValidationResultRuntimeException e) {
					validateResult.add(e.getValidateResult());
				}
			}
		} finally {
			close();
		}
		if (validateResult.size() > 0) {
			throw new CSVValidationResultException(cache, validateResult);
		}
		return cache;
	}

	public void close() {
		this.parser.close();
	}

	public CSVValidateResult validateLine(Object validateEntity, String[] line,
			long lineNo) {
		return this.validator.validate(validateEntity, line, lineNo);
	}

	public List<CSVValidateResult> validateAll() {
		List<CSVValidateResult> result = new ArrayList();
		try {
			Object entity = SingletonS2Container
					.getComponent(this.csvEntityDesc.getEntityClass());
			while (readNext()) {
				CSVValidateResult vaRes = validateLine(entity,
						this.currentLine, this.currentNo);
				if (vaRes != null) {
					result.add(vaRes);
				}
			}
		} finally {
			close();
		}
		return result;
	}

	public CSVValidateResult validate() {
		if (this.validateEntity == null) {
			this.validateEntity = SingletonS2Container
					.getComponent(this.csvEntityDesc.getEntityClass());
		}
		return validateLine(this.validateEntity, this.currentLine,
				this.currentNo);
	}
}
