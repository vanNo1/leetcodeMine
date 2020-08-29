package com.van.leetcode.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMainTest {
    @Resource
    private Environment env;
    @Test
    public void test(){
        System.out.println(env.getProperty("spring.application.name"));
    }

}