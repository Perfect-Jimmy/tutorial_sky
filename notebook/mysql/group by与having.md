# group by与having
## group by根据某种规则对数据进行分组,它必须配合聚合函数进行使用
```
统计各个部门的男女数量
select sex,dept,count(1) from employee group by dept,sex
```

## having子句增加的原因是sql中where关键字无法与聚合函数一起使用,having函数可以对分组后的各组数据进行筛选
