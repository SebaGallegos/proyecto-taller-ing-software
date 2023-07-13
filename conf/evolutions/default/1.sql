# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

-- apply changes
create table oferta (
  id                            integer not null,
  id_empresa_chi                integer not null,
  id_empresa_ext                integer not null,
  detalle                       TEXT,
  constraint pk_oferta primary key (id)
);

create table user (
  id                            integer not null,
  nombre                        varchar(255),
  email                         varchar(255),
  password                      varchar(255),
  constraint pk_user primary key (id)
);


# --- !Downs

-- drop all
drop table if exists oferta;

drop table if exists user;

