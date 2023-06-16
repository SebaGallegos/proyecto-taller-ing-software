# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

-- apply changes
create table user (
  id                            integer not null,
  name                          varchar(255),
  email                         varchar(255),
  constraint pk_user primary key (id)
);


# --- !Downs

-- drop all
drop table if exists user;
