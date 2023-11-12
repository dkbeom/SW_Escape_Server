package com.example.swescape.dao;

import java.util.List;
import java.util.Map;

import com.example.swescape.entity.LoginForm;
import com.example.swescape.entity.Member;

public interface MemberDao {

    Member getMemberByLoginForm(LoginForm loginForm);
    
    Member getMemberById(String id);
    
    List<Member> getMemberList();

    boolean insertMember(Member member);

    String getIdById(String id);

    String getIdByNickname(String nickname);
}