package com.example.swescape.service;

import java.util.List;

import com.example.swescape.entity.LoginForm;
import com.example.swescape.entity.Member;

public interface MemberService {

    // 로그인 시에 Member 객체 가져오기
    Member getMemberToLogin(LoginForm loginForm);
    
    // id로 Member 객체 가져오기
    Member getMemberById(String id);
    
    // Member List 가져오기
    List<Member> getMemberList();

    // 회원가입
    int join(Member member);

    // 아이디 중복체크
    boolean checkIdDuplicate(String id);

    // 닉네임 중복체크
    boolean checkNicknameDuplicate(String nickname);
}