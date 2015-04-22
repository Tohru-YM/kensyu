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

insert into users (name,email,passward,score,memo,created,sex) values
	('Aさん','A@mail.com','XXX',5.8,'memo2','2015-04-13 13:50:27','female'),
	('Bさん','B@mail.com','yyy',4.8,'memo3','2015-04-13 13:50:27','female'),
	('Cさん','C@mail.com','YYY',5.0,'memo4','2015-04-21 14:32:51','male'),
	('Dさん','D@mail.com','zzz',6.0,'memo5','2015-04-19 21:16:03','male'),
	('Eさん','E@mail.com','ZZZ',7.3,'memo6','2015-04-18 02:10:16','female');

create table users (
	id int not null auto_increment primary key,
	name varchar(255),
	email varchar(255) unique,
	team enum('red', 'blue', 'yellow'),	
	score double,
	created datetime,
	key score (score)
);

insert into users (name,email,team,score,created) values
	('Aさん','A@dotinstall.com','blue','5.5','2015-04-22 10:00:00'),
	('Bさん','B@dotinstall.com','yellow','8.2','2015-04-21 15:00:00'),
	('Cさん','C@dotinstall.jp','red','2.3','2015-04-23 12:00:00'),
	('Dさん','D@dotinstall.com','blue','4.5','2015-04-25 13:00:00'),
	('Eさん','','yellow','7.4','2015-04-28 15:00:00'),
	('Fさん','F@dotinstall.jp','blue','4.2','2015-04-29 16:00:00');
 -- 基本文
-- select * from users ;
-- select count(*) from users; レコードの総件数
-- select distinct team from users; チームに何が入っているか重複なしで
-- select max(score) from users; スコアの最大値
-- select min(score) from users;
-- select avg(score) from users;
-- select sum(score) from users;
-- select team,sum(score) from users group by team; それぞれのチームごとの合計
-- select * from users order by rand() limit 1; ランダムに１つ表示
-- select email,length(email) from users; 文字数表示
-- select concat(name,'(',team,')') from users; 文字列連結
-- select concat(name,'(',team,')') as label from users; 貼り付けだとasがうまく動かない?
-- select name,substring(team,1,2) from users ; teamの１文字目から２文字表示
-- select name,substring(team,1,2) as aaa from users ;
-- select now(); 現在時刻
-- select name,hour(created) from users; 
-- select name, datediff(now(), created) from users; 現在時刻からどのくらいか?
-- update users set email = 'E@dotinstall.co.jp' where id = 5 ;
-- delete from users where score <= 3 ;
-- desc users ;
-- alter table users add full_name varchar(255) after name; フィールド追加
-- alter table users change full_name full_name varchar(100) after name; フィールド変更
-- alter table users drop full_name; フィールド削除
-- alter table users add index team (team) ; キー追加
-- alter table users drop index team  ;
-- alter table users rename blog_users ; テーブル名変更
-- select * from users order by name desc; 
-- select * from users limit 3; 

create table users (
	id int not null auto_increment primary key,
	name varchar(255),
	email varchar(255) unique,
	team enum('red', 'blue', 'yellow'),	
	score double,	
	created datetime
);

insert into users (name,email,team,score,created) values
	('Gさん','G@gmail.com','blue',5.5,'2015-04-21 11:00:00'),
	('Hさん','H@gmail.com','yellow',8.2,'2015-05-21 12:00:00'),		
	('Iさん','I@gmail.jp','red',2.3,'2015-06-21 13:00:00');

create table posts (
	id int not null auto_increment primary key,
	user_id int not null,
	title varchar(255),
	body text,
	created datetime
);


insert into posts (user_id,title,body,created) values
	(1,'title-1 by Gさん','body-1','2015-04-21 14:00:00'),
	(1,'title-2 by Gさん','body-2','2015-04-21 12:00:00'),
	(2,'title-3 by Hさん','body-3','2015-04-21 13:00:00'),
	(3,'title-4 by Iさん','body-4','2015-04-21 10:00:00'),
	(3,'title-5 by Iさん','body-5','2015-04-21 09:00:00');

select users.name, posts.title from users, posts where users.id = posts.user_id;
select users.name, posts.title, posts.created from users, posts 
where users.id = posts.user_id order by posts.created desc;