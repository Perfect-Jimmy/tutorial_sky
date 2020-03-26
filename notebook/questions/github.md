# github

```
Update failed
remote: Enumerating objects: 175, done.
RPC failed; curl 56 LibreSSL SSL_read: SSL_ERROR_SYSCALL, errno 54
The remote end hung up unexpectedly
early EOF
index-pack failed
```
解决：缓冲区设置大一点
git config --global http.postBuffer 2097152000　　      # 2GB