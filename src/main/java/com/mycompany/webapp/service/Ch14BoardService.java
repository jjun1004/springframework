package com.mycompany.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.Ch14BoardDao;
import com.mycompany.webapp.dto.Ch14Board;
import com.mycompany.webapp.dto.Pager;

@Service
public class Ch14BoardService {
	private static final Logger logger = LoggerFactory.getLogger(Ch14BoardService.class);
	
	@Resource
	private Ch14BoardDao boardDao;
	
	public List<Ch14Board> getBoards(Pager pager) {
		return boardDao.selectByPage(pager);
	}
	
	public Ch14Board getBoard(int bno) {
		return boardDao.selectByBno(bno);
	}
	
	public int getTotalBoardNum() {
		return boardDao.count();
	}
	
	public void writeBoard(Ch14Board board) {
		boardDao.insert(board); // try catch 안해도 500페이지로 넘어가서 에러 처리됨
	}
	
	public void updateBoard(Ch14Board board) {
		boardDao.update(board);
	}
	
	public void removeBoard(int bno) {
		boardDao.deleteByBno(bno);
	}
	
	
}
