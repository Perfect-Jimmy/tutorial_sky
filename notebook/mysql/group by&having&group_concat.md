# group by与having
## group by根据某种规则对数据进行分组,它必须配合聚合函数进行使用
```
统计各个部门的男女数量
select sex,dept,count(1) from employee group by dept,sex
```

## having子句增加的原因是sql中where关键字无法与聚合函数一起使用,having函数可以对分组后的各组数据进行筛选



## group_concat配合group by一起使用,用于将某一列的值按指定的分隔符进行拼接,默认是逗号
```
统计各个部门人数和人名
select dept,count(1),group_concat(name) from employee group by dept;
统计各个部门人数和人名且根据人名排序,使用*连接
select dept,count(1),group_concat(name order by name desc separator '*') from employee group by dept;
```
