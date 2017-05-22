set foreign_key_checks=0;

drop table if exists `t_country`;
create table `t_country` (
  `cid` int(11) not null auto_increment,
  `cname` varchar(255) not null,
  primary key (`cid`)
) engine=innodb auto_increment=3 default charset=utf8;

insert into `t_country` values ('1', 'usa');
insert into `t_country` values ('2', 'china');
