create table users (
	id int not null auto_increment primary key,
	name varchar(255),
	email varchar(255) unique,
	passward char(32),
	score double,
	sex enum('male', 'female') default 'male',
	memo text,
	created datetime,
	key score (score)
);

-- int 整数
-- varchar　可変文字列(だいたい)
-- char　文字列
-- text　文字列(決まっていない)
-- double　小数
-- enum　文字列定数
-- default　↑のデフォルト
-- datetime
-- not null　空欄禁止
-- primary key　主キー
-- unique　ユニークキー?
insert into users (name,email,passward,score,memo,created) values
	('Tohru', 'toru@mail.com', 'xxx', 5.5, 'memomemomemo', '2015-04-12 17:37:00');