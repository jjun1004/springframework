package com.mycompany.webapp.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.Ch14MemberDao;
import com.mycompany.webapp.dto.Ch14Member;

//Root에 WebapplicationContext에서 관리됨
@Service 
public class Ch14MemberService {
	private static final Logger logger = LoggerFactory.getLogger(Ch14MemberService.class);
	
	//열거 타입 선언
	public enum JoinResult {
		SUCCESS,
		FAIL,
		DUPLICATED
	}
	
	@Resource
	private Ch14MemberDao memberDao;
	
	/*
	 * public static final int JOIN_SUCCESS = 0; public static final int JOIN_FAIL =
	 * 1; public static final int JOIN_DUPLICATED = 2;
	 */
	
	//회원 가입을 처리하는 비즈니스 메소드(로직)
	public JoinResult join(Ch14Member member) {
		try {
			// 이미 가입된 아이디인지 확인
			Ch14Member dbMember = memberDao.selectByMid(member.getMid()); //SELECT * FROM member WHERE mid=?
			
			//DB에 회원 정보를 저장
			if(dbMember == null) {
					memberDao.insert(member);
					return JoinResult.SUCCESS;
				} else {
					return JoinResult.DUPLICATED;
				}
		} catch(Exception e) {
			e.printStackTrace();
			return JoinResult.FAIL;
		}
	}

}
