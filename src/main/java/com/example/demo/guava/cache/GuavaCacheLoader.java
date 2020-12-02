package com.example.demo.guava.cache;

import com.google.common.cache.CacheLoader;

/**
 * @author: sunzhinan
 * @create: 2020-12-01 22:59
 * @description: 随机加载机制，这里的
 */
public abstract class GuavaCacheLoader<K,V> extends CacheLoader<K, V> {

    @Override
    public V load(K k) throws Exception {
        //加载数据
        return null;
    }
}
