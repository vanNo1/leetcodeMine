package com.van.leetcode;

import net.minidev.json.JSONUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ThreadLocalTest {
    private String lock="lock";
    private int  count=0;
    private ThreadLocal<Map<String,String>>content=new ThreadLocal<>();
    @Test
    public void test(){
        Map<String,String>map=content.get();
        if (CollectionUtils.isEmpty(map)){
            map=new HashMap<>();
            map.put("value1","key1");
            content.set(map);
        }
        System.out.println(getValue());
    }
    public String getValue(){
      return  content.get().get("value1");
    }
    @Test
    public void thread(){
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"print...");
        }).start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"print...");
        }).start();

    }
    @Test
    public void syn() throws InterruptedException {
       Thread t= new Thread(()->{
            for (int i = 0; i < 10000000; i++) {
                count++;
            }
        });
       t.start();
       Thread t2= new Thread(()->{

            for (int i = 0; i < 10000000; i++) {
                count--;
            }
        });
       t2.start();
       t.join();
       t2.join();
        System.out.println(count);
    }
}
