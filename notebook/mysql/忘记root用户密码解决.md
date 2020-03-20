# 忘记root用户密码解决
1. 停止mysql服务
2. 重启mysql,关闭权限验证
```
mysqld --defaults-file='xx/xx/xx/my.ini' --console --skip-granttables --shared-memory
```
注:defaults-file为配置文件my.ini的完整路径
3. 连接
```
直接输入mysql登录
```
4. 修改密码
```
flush privileges;
alter user 'root'@'localhost' identified by '123456'
```