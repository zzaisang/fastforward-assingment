CREATE DATABASE IF NOT EXISTS fastforward;
USE fastforward;

drop table if exists stock;

create table stock (
                       symbol varchar(255) not null,
                       transaction_date datetime(6) not null,
                       close_price double precision,
                       high_price double precision,
                       low_price double precision,
                       open_price double precision,
                       volume integer,
                       primary key (symbol, transaction_date)
) engine=InnoDB