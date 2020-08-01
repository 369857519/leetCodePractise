create table student
(
    id bigint(64) auto_increment comment '自增id',
    name varchar(24) default 0 comment '学生名',
    age int(3) default 0 comment '年龄',
    admission_date datetime default current_timestamp comment '入学时间',
    grade varchar(2) default '' comment '年级',
    classes varchar(10) default '' comment '班级',
    email varchar(50) default '无' comment '邮箱',
    create_time timestamp default current_timestamp comment '创建时间',
    update_time timestamp default current_timestamp on update current_timestamp comment '更新时间',
    primary key (id),
    INDEX id_name_idx (id,name)
) ENGINE = innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='测试';

insert into student (name,age,admission_date,grade,classes,email) values('hehe',10,'2020-09-01','1','1','369857519@qq.com');

alter table student add address varchar(20) not null ;
alter table student drop column address;
alter table student modify email varchar(100);
rename table student to student_rename;
rename table student_rename to student;

# 如果删除表的时候，遇到多个表关联的情况，需要进行级联删除
drop table student;

/*
 约束：NOT NULL,UNIQUE KEY,PRIMARY KEY,FOREIGN KEY,CHECK
 */
alter table student add check ( student.id<1000 )

/*
 索引
 在数据库中用来加速对表的查询，通过使用快路径访问定位数据，减少了磁盘I/O。会降低插入，修改和删除的性能
 I/O知识迁移：磁盘预读会读取块空间；数据访问空间和时间局部性原理
 回表：先查索引再查Id
 索引覆盖、最左匹配
 */
create index name_idx on student(name);
explain select * from student where name='hehe';

/*
 数据库设计三范式：列不可分，列主键相关，属性不能有其它非主键字段
 */