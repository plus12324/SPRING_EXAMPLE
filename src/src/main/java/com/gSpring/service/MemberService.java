package com.gSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gSpring.dao.MemberDao;
import com.gSpring.dto.MemberDto;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	public int selectMember(){
		
		List<MemberDto> memberList = memberDao.selectList("getMemberAll");
		
		return memberList.size();
	}
}
