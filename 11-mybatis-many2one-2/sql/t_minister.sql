
set foreign_key_checks=0;

drop table if exists `t_minister`;
create table `t_minister` (
  `mid` int(11) not null auto_increment,
  `mname` varchar(255) not null,
  `countryid` int(11) not null,
  primary key (`mid`)
) engine=innodb auto_increment=6 default charset=utf8;

insert into `t_minister` values ('1', 'aaa', '1');
insert into `t_minister` values ('2', 'bbb', '1');
insert into `t_minister` values ('3', 'ccc', '2');
insert into `t_minister` values ('4', 'ddd', '2');
insert into `t_minister` values ('5', 'eee', '2');
