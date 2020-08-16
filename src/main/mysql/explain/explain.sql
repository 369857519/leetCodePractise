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

insert into people_info (name,gender,class_id) values ('ehfh',1,1);
insert into class_info (name,grade_id) values ('一班',10);
insert into grade_info (name) values ('一年级');


# 一共有12个属性：下面依次做实验
# id select_type table partitions type possible_keys key key_len ref rows filtered extra

#id 包含一组数字，代表查询中select子语句或者表查询的顺序
#数字相同则从上到下，不同则id值越大的越先执行
#1、如果id相同，则从上到下执行
explain select * from people_info join class_info on people_info.name = class_info.name;
#2、如果id不同，子查询的id会递增
explain select * from people_info where people_info.class_id in (select class_id from class_info where class_info.name='一班');
#3、如果id相同和不同同时存在，相同的为一组，从上往下，不同的id大的先执行
explain select * from people_info join class_info on people_info.class_id and class_info.id
join grade_info gi on class_info.grade_id = gi.id where gi.name in(select name from grade_info where name='一年级');

#select_type 用来分辨查询的类型，普通查询还是联合查询还是子查询
#--simple：简单查询、不包含子查询和union
explain select * from people_info;
#--primary:如果包含任何复杂子查询，则最外侧层会标记为primary
explain select t.name,t.id,t.class_id from (select name,id,class_id from people_info) t join class_info on t.class_id=class_info.id;
#--union如果第二个select出现在union之后，则被标记为union
explain select * from people_info where id=1 union select * from people_info where id >3;
#--dependent union:跟union类似，但是表示union或者union all
#--union result: 表示从两个需要中取合集
explain select * from people_info where id in(select id from people_info where id=1 union select id from people_info where id >3);
#--subquery:在select或者where中包含的子查询
explain select * from people_info where id > (select avg(id) from people_info );
#--dependent subquery:表示subquery会受到外部的影响
explain select * from people_info where name in (select distinct class_info.name from class_info);
#--DRIVED: from 子据中出现的子查询
#--UNCHCHEABLE SUBQUERY：表示子查询不能被缓存
#--UNCACHEABLE UNION： 表示union的结果不能被缓存

#table 表示正在访问的表名
#1、物理表名或者别名 2、derivedN的形式，表示产生了衍生表 3、union result表示有一些id参与了union

#type 表示访问类型
# system > const > eq_ref > ref > fulltext > ref_or_null > index_merge > unique_subquery > index_subquery > range > index > ALL
#--all 全表扫描
explain select * from people_info;
#--index 1、查询覆盖索引，只需要在索引拿数据即可 2、使用索引进行了排序，避免了重排序
explain select id from people_info;
#--index_subquery 利用子查询利用了索引
#--unique_subquery 子查询使用了唯一索引
explain select id from class_info where id in (select class_id from people_info where id>4);
#--ref使用了非唯一索引进行数据查找
create index idx_name on people_info(name);
#--ref_or_null 对于某个关联条件既使用了
explain select * from people_info where name is null or name='ehfh';
#--eq_ref
create unique index name on class_info(name);
explain select * from people_info,class_info where people_info.name=class_info.name;
#--const: 表示表最多有一个匹配行
explain select * from people_info where id='1';
#--system 表示表中只有一行记录，系统信息，变量等

#possible_keys 一个或多个，查询涉及的字段上若存在索引，则被列出，但是不一定实际使用

#key 实际使用的索引，如果为null，则没有使用索引，如果使用了覆盖索引，则
explain select name from class_info where name='一班';

#key_len 查询中使用索引的字节数，不失精度清情况下，越短越好

#ref 显示那一列被引用了，可能是个const

#rows 大致需要读取的行数

#filtered 返回行占读到行数的百分比

#extra
#--using filesort 无法索引排序，进行了重排序
#--using temprorary 建立临时表存储了结果
#--using index 覆盖索引
#--using where 使用where条件过滤
#--using join buffer
#--impossible where where总是false
