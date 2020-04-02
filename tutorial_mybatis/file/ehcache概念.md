Cache	缓存接口，定义缓存操作。实现有：RedisCache、EhCacheCache、 ConcurrentMapCache等
CacheManager	
 缓存管理器，管理各种缓存（Cache）组件

@Cacheable	
主要针对方法配置，能够根据方法的请求参数对其结果进行缓存

@CacheEvict	清空缓存
@CachePut	
 保证方法被调用，又希望结果被缓存。

@EnableCaching	
开启基于注解的缓存

keyGenerator	
缓存数据时key生成策略

serialize	缓存数据时value序列化策略

##---------------------
value	
缓存的名称，在 spring 配置文件中定义，必须指定 至少一个
例如： @Cacheable(value=”mycache”) 或者 @Cacheable(value={”cache1”,”cache2”}

 

key	
缓存的 key，可以为空，如果指定要按照 SpEL 表达 式编写，如果不指定，则缺省按照方法的所有参数 进行组合
例如： @Cacheable(value=”testcache”,key=”#userName”


condition	
缓存的条件，可以为空，使用 SpEL 编写，返回 true 或者 false，只有为 true 才进行缓存/清除缓存，在 调用方法之前之后都能判断
例如： @Cacheable(value=”testcache”,condition=”#userNam e.length()>2”)

 

allEntries (@CacheEvict )
是否清空所有缓存内容，缺省为 false，如果指定为 true，则方法调用后将立即清空所有缓存
例如：@CachEvict(value=”testcache”,allEntries=true)

 

beforeInvocation (@CacheEvict)
是否在方法执行前就清空，缺省为 false，如果指定 为 true，则在方法还没有执行的时候就清空缓存， 缺省情况下，如果方法执行抛出异常，则不会清空 缓存
例如：@CachEvict(value=”testcache”， beforeInvocation=true)
unless (@CachePut) (@Cacheable)	用于否决缓存的，不像condition，该表达式只在方 法执行之后判断，此时可以拿到返回值result进行判 断。条件为true不会缓存，fasle才缓存	例如：@Cacheable(value=”testcache”,unless=”#result == null”)
Cache SpEL available metadata
