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
);

create table comments
(
    articleid    int                                not null
        primary key,
    commentid    int                                not null,
    commentlevel int      default 0                 not null,
    writer       varchar(64)                        not null,
    date         datetime default CURRENT_TIMESTAMP not null,
    details      varchar(1024)                      not null,
    constraint comments_article_id_fk
        foreign key (articleid) references article (id),
    constraint comments_users_id_fk
        foreign key (writer) references users (id)
);
