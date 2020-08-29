package com.van.leetcode.test.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class CaffeineStudyTest {
    @Resource
    private Cache caffeineCache;
    @Test
    public void test(){
        caffeineCache.put("hello","hi");
        System.out.println(caffeineCache.getIfPresent("hello"));
    }

}