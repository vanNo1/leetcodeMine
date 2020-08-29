package com.van.leetcode.test.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class CaffeineConfig {
    @Bean
    public Cache<String,Object> caffeineCache(){
        return Caffeine.newBuilder().expireAfterAccess(Duration.ofHours(1L)).build();
    }
}
