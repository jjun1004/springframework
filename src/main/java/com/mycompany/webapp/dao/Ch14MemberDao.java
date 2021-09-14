package com.mycompany.webapp.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.webapp.dto.Ch14Member;

@Repository
public class Ch14MemberDao {
	private static final Logger logger = LoggerFactory.getLogger(Ch14MemberDao.class);
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	/*	public int insert(Ch14Member member) {
			int rows = sqlSessionTemplate.insert("member.insert", member);
			return rows;
		} // RuntimeException이 발생해서 try catch 잡지 않고 service에서 에러처리 하도록 해야함
	*/	
	public void insert(Ch14Member member) {
		logger.info("실행");
		sqlSessionTemplate.insert("mybatis.mapper.member.insert", member);
	} // RuntimeException이 발생해서 try catch 잡지 않고 service에서 에러처리 하도록 해야함
	
	/*	public Ch14Member selectByMid(String mid) {
			Ch14Member member = sqlSessionTemplate.selectOne("member.selectByMid", mid);
			return member;
		} // RuntimeException이 발생해서 try catch 잡지 않고 service에서 에러처리 하도록 해야함
	*/	
	
	public Ch14Member selectByMid(String mid) {
		return sqlSessionTemplate.selectOne("mybatis.mapper.member.selectByMid", mid);
	} // RuntimeException이 발생해서 try catch 잡지 않고 service에서 에러처리 하도록 해야함
}
