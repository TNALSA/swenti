create table article (
    id int primary key auto_increment=1,
    title varchar(512) not null,
    details varchar(8192) not null,
    media varchar(32) not null,
    link varchar(512) not null,
    images json not null ,
    writer varchar(32) not null,
    writed_date datetime not null,
    view int default 0 not null,
    site varchar(32) not null
)