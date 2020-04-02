```
<?xml version="1.0" encoding="UTF-8"?>
<ehcache xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:noNamespaceSchemaLocation="http://ehcache.org/ehcache.xsd"
         updateCheck="false">
    <diskStore path = "Java.io.tmpdir"/> 
    <defaultCache
            eternal="false" <--意味着该缓存会死亡-->
            maxElementsInMemory="900"<--缓存的最大数目-->
            overflowToDisk="false" <--内存不足时,是否启用磁盘缓存,如果为true则表示启动磁盘来存储，如果为false则表示不启动磁盘-->
            diskPersistent="false" 
            timeToIdleSeconds="0"  <--当缓存的内容闲置多少时间销毁-->
            timeToLiveSeconds="60" <--当缓存存活多少时间销毁（单位是秒，如果我们想设置2分钟的缓存存活时间，那么这个值我们需要设置120）-->
            memoryStoreEvictionPolicy="LRU" /> <--自动销毁策略-->
    <!-- 这里的 users 缓存空间是为了下面的 demo 做准备 -->
    <cache
            name="data"
            eternal="false"
            maxElementsInMemory="200"
            overflowToDisk="false"
            diskPersistent="false"
            timeToIdleSeconds="0"
            timeToLiveSeconds="60"
            memoryStoreEvictionPolicy="LRU" />
</ehcache>
<!--<diskStore>==========当内存缓存中对象数量超过maxElementsInMemory时,将缓存对象写到磁盘缓存中(需对象实现序列化接口)  -->
<!--<diskStore path="">==用来配置磁盘缓存使用的物理路径,Ehcache磁盘缓存使用的文件后缀名是*.data和*.index  -->
<!--name=================缓存名称,cache的唯一标识(ehcache会把这个cache放到HashMap里)  -->
<!--maxElementsOnDisk====磁盘缓存中最多可以存放的元素数量,0表示无穷大  -->
<!--maxElementsInMemory==内存缓存中最多可以存放的元素数量,若放入Cache中的元素超过这个数值,则有以下两种情况  -->
                     <!--1)若overflowToDisk=true,则会将Cache中多出的元素放入磁盘文件中  -->
                     <!--2)若overflowToDisk=false,则根据memoryStoreEvictionPolicy策略替换Cache中原有的元素  -->
<!--eternal==============缓存中对象是否永久有效,即是否永驻内存,true时将忽略timeToIdleSeconds和timeToLiveSeconds  -->
<!--timeToIdleSeconds====缓存数据在失效前的允许闲置时间(单位:秒),仅当eternal=false时使用,默认值是0表示可闲置时间无穷大,此为可选属性  -->
                     <!--即访问这个cache中元素的最大间隔时间,若超过这个时间没有访问此Cache中的某个元素,那么此元素将被从Cache中清除  -->
<!--timeToLiveSeconds====缓存数据在失效前的允许存活时间(单位:秒),仅当eternal=false时使用,默认值是0表示可存活时间无穷大  -->
                     <!--即Cache中的某元素从创建到清楚的生存时间,也就是说从创建开始计时,当超过这个时间时,此元素将从Cache中清除  -->
<!--overflowToDisk=======内存不足时,是否启用磁盘缓存(即内存中对象数量达到maxElementsInMemory时,Ehcache会将对象写到磁盘中)  -->
                     <!--会根据标签中path值查找对应的属性值,写入磁盘的文件会放在path文件夹下,文件的名称是cache的名称,后缀名是data  -->
<!--diskPersistent=======是否持久化磁盘缓存,当这个属性的值为true时,系统在初始化时会在磁盘中查找文件名为cache名称,后缀名为index的文件  -->
                     <!--这个文件中存放了已经持久化在磁盘中的cache的index,找到后会把cache加载到内存  -->
                     <!--要想把cache真正持久化到磁盘,写程序时注意执行net.sf.ehcache.Cache.put(Element element)后要调用flush()方法  -->
<!--diskExpiryThreadIntervalSeconds==磁盘缓存的清理线程运行间隔,默认是120秒  -->
<!--diskSpoolBufferSizeMB============设置DiskStore（磁盘缓存）的缓存区大小,默认是30MB  -->
<!--memoryStoreEvictionPolicy========内存存储与释放策略,即达到maxElementsInMemory限制时,Ehcache会根据指定策略清理内存  -->
                                 <!--共有三种策略,分别为LRU(Least Recently Used 最近最少使用)、LFU(Less Frequently Used最不常用的)、FIFO(first in first out先进先出)  -->
```

```
<?xml version="1.0" encoding="UTF-8"?>
<eh:config
        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'
        xmlns:eh='http://www.ehcache.org/v3'
        xsi:schemaLocation="http://www.ehcache.org/v3 http://www.ehcache.org/schema/ehcache-core-3.3.xsd">
    <!--指定缓存目录-->
    <eh:persistence directory="${java.io.tmpdir}/cache-data"/>

    <!--缓存模板-->
    <eh:cache-template name="default">
        <eh:key-type>java.lang.String</eh:key-type>
        <eh:value-type>com.worktrans.hr.core.localcache.CacheData</eh:value-type>
        <eh:expiry>
            <eh:ttl unit="seconds">600</eh:ttl>
        </eh:expiry>
        <eh:resources>
            <!--堆内内存可以放2000个条目，超出部分堆外100MB-->
            <eh:heap unit="entries">10</eh:heap>
            <eh:offheap unit="MB">100</eh:offheap>
        </eh:resources>
    </eh:cache-template>

    <!--实际的缓存区间，继承了default缓存模板,cfa 完全使用模板默认-->
    <eh:cache alias="cfa" uses-template="default">
    </eh:cache>

    <!--下面两个继承了default缓存模板，但覆盖了缓存的过期时间-->
    <eh:cache alias="hr" uses-template="default">
        <eh:key-type>java.lang.String</eh:key-type>
        <eh:value-type>com.worktrans.hr.core.localcache.CacheData</eh:value-type>
        <eh:expiry>
            <eh:none/>
        </eh:expiry>
        <eh:resources>
            <eh:heap unit="entries">5</eh:heap>
            <eh:disk unit="MB" persistent="true">1000</eh:disk>
        </eh:resources>
    </eh:cache>
</eh:config>
```

1 FIFO，first in first out，这个是大家最熟的，先进先出。

2 LFU， Less Frequently Used，就是上面例子中使用的策略，直白一点就是讲一直以来

最少被使用的。如上面所讲，缓存的元素有一个 hit 属性，hit 值最小的将会被清出缓存。

3 LRU，Least Recently Used，最近最少使用的，缓存的元素有一个时间戳，当缓存容量

满了，而又需要腾出地方来缓存新的元素的时候，那么现有缓存元素中时间戳离当前时

间最远的元素将被清出缓存。
