set foreign_key_checks=0;
drop table if exists `tmiddle`;
create table `tmiddle` (
  `id` int(11) not null auto_increment,
  `studentid` int(11) not null,
  `courseid` int(11) not null,
  primary key (`id`)
) engine=innodb auto_increment=5 default charset=utf8;

insert into `tmiddle` values ('1', '1', '1');
insert into `tmiddle` values ('2', '1', '2');
insert into `tmiddle` values ('3', '2', '1');
insert into `tmiddle` values ('4', '2', '3');
