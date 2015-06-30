create table SHAIN (
    SHAIN_ID bigint not null auto_increment,
    SHAIN_BANGOU bigint not null,
    SHIMEI varchar(16) not null,
    SEIBETSU smallint not null,
    SEINENGAPPI date not null,
    JUSYO varchar(128) not null,
    DENWABANGOU varchar(16) not null,
    TOUROKU_NICHIJI timestamp not null,
    KOUSHIN_NICHIJI timestamp not null,
    constraint SHAIN_PK primary key(SHAIN_ID)
);
