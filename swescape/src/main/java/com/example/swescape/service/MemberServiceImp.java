package com.example.swescape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.swescape.dao.MemberDao;
import com.example.swescape.entity.LoginForm;
import com.example.swescape.entity.Member;

@Service("memberService")
@Transactional
public class MemberServiceImp implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public Member getMemberToLogin(LoginForm loginForm) {
        return memberDao.getMemberByLoginForm(loginForm);
    }
    
    @Override
	public Member getMemberById(String id) {
    	return memberDao.getMemberById(id);
	}
    
    @Override
	public List<Member> getMemberList() {
		return memberDao.getMemberList();
	}

    @Override
    public int join(Member member) {
    	
    	// id 중복이거나, 닉네임 중복인 경우, 회원가입 불가
    	if(checkIdDuplicate(member.getId())){
    		return 1;
    	}
    	else if (checkNicknameDuplicate(member.getNickname())) {
    		return 2;
    	}
    	// id 중복, 닉네임 중복이 모두 아닌 경우, 회원가입 허용
    	else {
    		memberDao.insertMember(member);
    		return 0;
    	}
    }

    @Override
    public boolean checkIdDuplicate(String id) {

        boolean isIdDuplicate;

        // 해당 아이디를 가진 계정이 존재하지 않을 때
        if (memberDao.getIdById(id) == null) {
            isIdDuplicate = false;
        }
        // 해당 아이디를 가진 계정이 존재할 때
        else {
            isIdDuplicate = true;
        }

        return isIdDuplicate;
    }

    @Override
    public boolean checkNicknameDuplicate(String nickname) {

        boolean isNicknameDuplicate;

        // 해당 아이디를 가진 계정이 존재하지 않을 때
        if (memberDao.getIdByNickname(nickname) == null || memberDao.getIdByNickname(nickname).equals("")) {
            isNicknameDuplicate = false;
        }
        // 해당 아이디를 가진 계정이 존재할 때
        else {
            isNicknameDuplicate = true;
        }

        return isNicknameDuplicate;
    }
}