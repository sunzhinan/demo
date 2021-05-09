package com.example.demo.guava.cache;

import com.example.demo.config.CacheConfig;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * @author: sunzhinan
 * @create: 2020-11-30 22:25
 * @description: 缓存抽象类，提供基础方法
 */
public abstract class AbstractCache<K,V> {

    @Autowired
    private CacheConfig cacheConfig;

    private volatile LoadingCache<K,V> loadingCache;

    /**
     * 这里建议设置缓存的最大容量，同时建议使用配置文件设置默认值
     */
    private int maxSize;

    /**
     * 超时时间，建议使用配置文件设置默认值
     */
    private long overTime;

    /**
     * 初始容量
     */
    private int initCapacity;

    /**
     * 标记，备用
     */
    private int mark;

    /**
     * 并发级别
     * Guava提供了设置并发级别的api，使得缓存支持并发的写入和读取。
     * 同 ConcurrentHashMap 类似Guava cache的并发也是通过分离锁实现。
     * 在一般情况下，将并发级别设置为服务器cpu核心数是一个比较不错的选择。
     */
    private int parallelCount;

    /**
     * 这里我不设默认值
     * @param maxSize
     * @param overTime
     * @param initCapacity
     */
    protected AbstractCache(int maxSize, int overTime, int initCapacity) {
        if(maxSize > cacheConfig.getMaxSize()){
            this.maxSize = cacheConfig.getMaxSize();
        }else{
            this.maxSize = maxSize;
        }
        if (overTime > cacheConfig.getOverTime()){
            this.overTime = cacheConfig.getOverTime();
        }else {
            this.overTime = overTime;
        }

        this.initCapacity = initCapacity;
    }

    /**
     * 设置缓存基础信息
     */
    public LoadingCache<K, V> setCache(GuavaCacheLoader<K,V> loader){
        LoadingCache<K, V> cache = CacheBuilder.newBuilder()
                //设置并发级别，并发级别是指可以同时写缓存的线程数
                .concurrencyLevel(parallelCount)
                //设置缓存容器的初始容量
                .initialCapacity(initCapacity)
                //设置缓存最大容量，超过之后就会按照LRU最近虽少使用算法来移除缓存项
                .maximumSize(maxSize)
                //是否需要统计缓存情况,该操作消耗一定的性能,生产环境应该去除
                .recordStats()
                //设置写缓存后n秒钟过期
                .expireAfterWrite(overTime, TimeUnit.SECONDS)
                //设置缓存的移除通知
                .removalListener(notification -> {
                    System.out.println(notification.getKey() + " " + notification.getValue() + " 被移除,原因:" + notification.getCause());
                })
                //build方法中可以指定CacheLoader，在缓存不存在时通过该loader的实现自动加载缓存
                .build(loader);
        return cache;
    }

}
