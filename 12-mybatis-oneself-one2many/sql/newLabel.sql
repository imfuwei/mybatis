set foreign_key_checks=0;

drop table if exists `newlabel`;
create table `newlabel` (
  `id` int(11) not null auto_increment,
  `name` varchar(255) not null,
  `pid` int(11) not null,
  primary key (`id`)
) engine=innodb auto_increment=12 default charset=utf8;

insert into `newlabel` values ('1', '娱乐新闻', '0');
insert into `newlabel` values ('2', ' 体育新闻', '0');
insert into `newlabel` values ('3', ' nba', '2');
insert into `newlabel` values ('4', 'cba', '2');
insert into `newlabel` values ('5', '火箭', '3');
insert into `newlabel` values ('6', ' 湖人', '3');
insert into `newlabel` values ('7', ' 北京金隅', '4');
insert into `newlabel` values ('8', ' 浙江广厦', '4');
insert into `newlabel` values ('9', ' 青岛双星', '4');
insert into `newlabel` values ('10', ' 港台明星', '1');
insert into `newlabel` values ('11', ' 内地影视', '1');
