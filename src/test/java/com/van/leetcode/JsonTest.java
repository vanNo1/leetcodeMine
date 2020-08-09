package com.van.leetcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.van.leetcode.test.GroupDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.acl.Group;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JsonTest {


    @Test
    public void test(){
        String json="{\"CallbackCommand\":\"Group.CallbackAfterNewMemberJoin\",\"GroupId\":\"@TGS#2J4SZEAEL\",\"Type\":\"Public\",\"JoinType\":\"Apply\",\"Operator_Account\":\"leckie\",\"NewMemberList\":[{\"Member_Account\":\"jared\"},{\"Member_Account\":\"tommy\"}]}";
       GroupDTO groupDTO= JSON.parseObject(json, GroupDTO.class);
        System.out.println("asd");
    }
}
