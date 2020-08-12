create table people_info(
    id BIGINT(64) auto_increment comment '自增id',
    name varchar(20) not null comment '名字',
    gender int(2) not null comment '性别: 男 1 女 2',
    class_id int(16) not null comment '班级Id',
    primary key (id)
) engine = innodb AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8MB4 COMMENT='人员表';
drop table people_info;

create table class_info(
    id BIGINT(64) auto_increment comment '自增id',
    name varchar(20) not null comment '班级名称',
    grade_id varchar(20) not null comment '所属年级',
    primary key (id)
) engine = innodb AUTO_INCREMENT=1 default charset=UTF8MB4 comment ='班级信息';
drop table class_info;

create table grade_info(
    id BIGINT(64) auto_increment comment '自增id',
    name varchar(20) not null comment '年级名称',
    primary key (id)
) engine = innodb AUTO_INCREMENT=1 default charset=UTF8MB4 comment ='年级信息';

insert into people_info (name,gender,class_id) values ('lalla',1,1);
insert into class_info (name,grade_id) values ('一班',10);

# 一共有12个属性：下面依次做实验
# id select_type table partitions type possible_keys key key_len ref rows filtered extra

#id 包含一组数字，代表查询中select子语句或者表查询的顺序
#数字相同则从上到下，不同则id值越大的越先执行
explain select * from people_info join class_info ci on people_info.name = ci.name