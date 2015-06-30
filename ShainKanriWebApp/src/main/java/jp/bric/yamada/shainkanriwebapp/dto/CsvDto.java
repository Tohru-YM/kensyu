package jp.bric.yamada.shainkanriwebapp.dto;


import java.util.Date;

import org.seasar.s2csv.csv.annotation.column.CSVColumn;
import org.seasar.s2csv.csv.annotation.column.CSVConvertor;
import org.seasar.s2csv.csv.annotation.column.CSVDateType;
import org.seasar.s2csv.csv.annotation.column.CSVIntRange;
import org.seasar.s2csv.csv.annotation.column.CSVLongRange;
import org.seasar.s2csv.csv.annotation.column.CSVLongType;
import org.seasar.s2csv.csv.annotation.column.CSVMask;
import org.seasar.s2csv.csv.annotation.column.CSVMaxLength;
import org.seasar.s2csv.csv.annotation.column.CSVRequired;
import org.seasar.s2csv.csv.annotation.entity.CSVEntity;
import org.seasar.s2csv.csv.convertor.CSVDateConvertor;

@CSVEntity(header=true)
public class CsvDto {

	@CSVRequired
	@CSVLongType
	@CSVLongRange(min=0, max=10000)
	@CSVColumn(columnIndex=0, columnName="社員番号")
	public Long shainBangou;

	@CSVRequired
	@CSVMaxLength(maxlength=16)
	@CSVColumn(columnIndex=1, columnName="氏名")
	public String shimei;

	@CSVRequired
	@CSVIntRange(min = 1, max = 2)
	@CSVColumn(columnIndex=2, columnName="性別")
	public Short seibetsu;

	@CSVRequired
	@CSVConvertor(convertor=CSVDateConvertor.class,convertSetProp="pattern=yyyy-MM-dd")
	@CSVDateType(datePattern="yyyy-mm-dd")
	@CSVColumn(columnIndex=3, columnName="生年月日")
	public Date seinengappi;

	@CSVRequired
	@CSVMaxLength(maxlength=128)
	@CSVColumn(columnIndex=4, columnName="住所")
	public String jusyo;

	@CSVRequired
	@CSVMask(mask="\\d{7,11}")
	@CSVMaxLength(maxlength=16)
	@CSVColumn(columnIndex=5, columnName="電話番号")
	public String denwabangou;




}