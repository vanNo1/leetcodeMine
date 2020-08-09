package com.van.leetcode.test;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;
@Getter
@Setter
@Accessors(chain = true)
@ToString
public class GroupDTO {
    @JSONField(name = "GroupId")
    private String groupId;
    @JSONField(name = "NewMemberList")
    private List<Account> newMemberList;

@Setter
@Getter
@ToString
@Accessors(chain = true)
    static class Account{
        @JSONField(name = "Member_Account")
        private String member_Account;
    }
}
