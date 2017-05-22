set foreign_key_checks=0;


drop table if exists `tcourse`;
create table `tcourse` (
  `cid` int(11) not null auto_increment,
  `cname` varchar(255) not null,
  primary key (`cid`)
) engine=innodb auto_increment=4 default charset=utf8;


insert into `tcourse` values ('1', 'javase');
insert into `tcourse` values ('2', 'javaee');
insert into `tcourse` values ('3', 'android');
