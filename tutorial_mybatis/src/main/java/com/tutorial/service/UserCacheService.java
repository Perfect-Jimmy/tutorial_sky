package com.tutorial.service;

import com.tutorial.model.User;
import com.tutorial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 缓存版本
 * @author jimmy
 * @date 2020/4/2 15:49
 */
@Service
public class UserCacheService {
    @Autowired
    private UserRepository userRepository;

    //* @Cacheable : Spring在每次执行前都会检查Cache中是否存在相同key的缓存元素，如果存在就不再执行该方法，而是直接从缓存中获取结果进行返回，否则才会执行并将返回结果存入指定的缓存中。
    //* @CacheEvict : 清除缓存。  @CacheEvict(value="users",allEntries=true)
    //* @CachePut : @CachePut也可以声明一个方法支持缓存功能。使用@CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。

    //缓存其实存放的是以注解里面的key为key 方法的返回值作为key的value，不是注解里面的value

    /**
     * 此处的value指的是ehcache.xml配置文件中定义的缓存策略
     * @Cacheable的几个属性详解：
     * cacheNames/value：指定缓存组件的名字
     * key：缓存数据使用的key,可以用它来指定。默认使用方法参数的值，一般不需要指定
     * keyGenerator：作用和key一样，二选一
     * cacheManager和cacheResolver作用相同：指定缓存管理器，二选一
     * condition：指定符合条件才缓存，比如：condition="#id>3"
     * 也就是说传入的参数id>3才缓存数据
     * unless：否定缓存，当unless为true时不缓存，可以获取方法结果进行判断
     * sync：是否使用异步模式
     */
    @Cacheable(value = "cache-user", key = "'user_'+ #id")
    public User findById(Long id){
        return userRepository.findById(id);
    }


    /**
     * @CacheEvict:清除缓存
     *    1.key:指定要清除缓存中的某条数据
     *    2.allEntries=true:删除缓存中的所有数据
     *    beforeInvocation=false:默认是在方法之后执行清除缓存
     *    3.beforeInvocation=true:现在是在方法执行之前执行清除缓存，
     *                          作用是：只清除缓存、不删除数据库数据
     */
    //@CacheEvict(cacheNames = "person",key = "#id")
    @CacheEvict(cacheNames = "person",allEntries=true)
    public void deletePerson(Integer id){
        System.out.println("删除"+id+"号个人信息");
        //删除数据库数据的同时删除缓存数据
        //personDao.delete(id);

        /**
         * beforeInvocation=true
         * 使用在方法之前执行的好处:
         * 1.如果方法出现异常，缓存依旧会被删除
         */
        //int a=1/0;
    }



    /**
     *   @Caching是 @Cacheable、@CachePut、@CacheEvict注解的组合
     *   以下注解的含义：
     *   1.当使用指定名字查询数据库后，数据保存到缓存
     *   2.现在使用id、age就会直接查询缓存，而不是查询数据库
     */
   /* @Caching(
            cacheable = {@Cacheable(value = "person",key="#name")},
            put={ @CachePut(value = "person",key = "#result.id"),
                    @CachePut(value = "person",key = "#result.age")
            }
    )
    public Person queryPersonByName(String name){
        System.out.println("查询的姓名："+name);
        return personDao.queryByName(name);
    }*/





}
