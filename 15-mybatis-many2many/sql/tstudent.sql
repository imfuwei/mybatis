
set foreign_key_checks=0;


drop table if exists `tstudent`;
create table `tstudent` (
  `sid` int(11) not null auto_increment,
  `sname` varchar(255) not null,
  primary key (`sid`)
) engine=innodb auto_increment=3 default charset=utf8;

insert into `tstudent` values ('1', '张三');
insert into `tstudent` values ('2', ' 李四');
