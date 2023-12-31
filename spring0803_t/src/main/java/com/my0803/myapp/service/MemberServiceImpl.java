package com.my0803.myapp.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my0803.myapp.domain.MemberVo;
import com.my0803.myapp.persistance.MemberService_Mapper;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberService_Mapper msm;
	
	@Autowired   //마이바티스 객체를 주입받는다(타입으로 메모리에서 객체를 찾는다)
	public MemberServiceImpl(SqlSession sqlSession) {
		this.msm = sqlSession.getMapper(MemberService_Mapper.class);		
	}
	
	@Override
	public int memberInsert(MemberVo mv) {			
		int value = msm.memberInsert(mv);		
		return value;
	}

	@Override
	public MemberVo memberLogin(String memberId, String memberPwd) {
		MemberVo mv= null;
		
		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("memberId", memberId);
		hm.put("memberPwd", memberPwd);
			
		mv = msm.memberLogin(hm);
		
		return mv;
	}

	@Override   //오버라이딩(재정의) 오버로딩(같은이름다른역할메소드) 둘다
	public MemberVo memberLogin(String memberId) {
		MemberVo mv= null;
		mv = msm.memberLogin2(memberId);
		
	//	System.out.println("저장된 비밀번호"+mv.getMemberPwd());		
		
		return mv;
	}

	@Override
	public int memberIdCheck(String memberId) {
		int value=0;
		value = msm.memberIdCheck(memberId);		
		return value;
	}

	@Override
	public ArrayList<MemberVo> memberList() {
		//System.out.println("msm 값은?"+msm);
		ArrayList<MemberVo> alist =  msm.memberList();	
		return alist;
	}

}
