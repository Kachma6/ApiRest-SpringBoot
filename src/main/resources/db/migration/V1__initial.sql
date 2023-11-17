create table "user"(
                       id bigint not null,
                       username varchar(150) not null,
                       password varchar(150) not null,
                       email varchar(150) not null unique ,
                       created_at timestamp,
                       primary key (id)
);
create sequence user_sequence as integer increment 1;
create table user_detail(
                            id bigint not null,
                            first_name varchar(100) not null,
                            last_name varchar(100) not null,
                            age int,
                            birth_day date,
                            user_id bigint,
                            primary key (id)
);
create sequence user_detail_sequence as integer increment 1;
create table user_rol(
                         id integer not null,
                         active boolean not null,
                         created_at timestamp not null,
                         user_id bigint not null,
                         rol_id integer not null,
                         primary key (id)
);
create sequence user_rol_sequence as integer increment 1;
create table rol(
                    id integer not null,
                    name varchar(100) not null,
                    primary key (id)
);
create sequence rol_sequence as integer increment 1;

alter table user_detail
    add constraint FK_User_Detail_ref_User
        foreign key (user_id)
            references "user" (id)
            on delete restrict
            on update restrict;

alter table user_rol
    add constraint FK_User_Rol_ref_User
        foreign key (user_id)
            references "user" (id)
            on delete restrict
            on update restrict ;

alter table user_rol
    add constraint FK_User_Rol_ref_Rol
        foreign key (rol_id)
            references rol (id)
            on delete restrict
            on update restrict ;

