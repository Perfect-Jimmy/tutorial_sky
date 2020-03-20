# dcl_数据控制语言
## 用户管理
* 创建用户
```
用户创建后没有任何权限,账号有两部分组成:用户名+ip地址
create user 'jimmy'@'%' identified by '123456'
```
* 删除用户
* 修改密码
* 赋予权限
* 撤销权限

## 权限管理
grant授权   revoke撤销授权