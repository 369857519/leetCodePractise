--level简介
set session transaction isolation level repeatable uncommitted ;
set session transaction isolation level repeatable committed ;
set session transaction isolation level repeatable repeatable read ;
set session transaction isolation level repeatable serializable ;

--可能出现的情况
--脏读:其它进程还没提交事务，本进程就读到了变化
--不可重复读:其它进程提交了事务，本进程在一次事务内又一次读取数据，发生了不一致
--幻读:其它进程提交了事务，本进程插入时出错

--表格对照
--          uncommitted   committed   repeatable read     serializable
--脏读         会出现
--不可重复读   会出现       会出现
--幻读        会出现         会出现         会出现

--测试用例1：uncommitted下尝试浮现三种问题
--测试用例2: committed尝试复现会出现的两种问题
--测试用例3：repeatable read尝试浮现会出现的一种问题