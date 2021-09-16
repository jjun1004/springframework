package com.mycompany.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.mycompany.webapp.dao.Ch16AccountDao;
import com.mycompany.webapp.dto.Ch16Account;
import com.mycompany.webapp.exception.Ch16NotFoundAccountException;

@Service
public class Ch16AccountService {
	private static final Logger logger = LoggerFactory.getLogger(Ch16AccountService.class);
	
	public enum TransferResult {
		SUCCESS,
		FAIL_NOT_FOUND_ACCOUNT,
		FAIL_NOT_ENOUGH_BALANCE
	}
	
	@Resource
	private TransactionTemplate transactionTemplate;
	
	@Resource
	private Ch16AccountDao accountDao;
	
	public List<Ch16Account> getAccounts() {
		logger.info("실행");
		List<Ch16Account> accounts = accountDao.selectAll();
		return accounts;
	}
	
	public TransferResult transfer1(int fromAno, int toAno, int amount) {
		logger.info("실행");
		
		String result = transactionTemplate.execute(new TransactionCallback<String>() { // 트랜잭션 준비가 끝나면, 메서드 실행 (자바스크립트의 callback 함수와 비슷)
			@Override
			public String doInTransaction(TransactionStatus status) {
				try {
						//출금하기
						Ch16Account fromAccount = accountDao.selectByAno(fromAno);
						fromAccount.setBalance(fromAccount.getBalance() - amount);
						accountDao.updateBalance(fromAccount);
						
						//예금하기
						Ch16Account toAccount = accountDao.selectByAno(toAno);
						toAccount.setBalance(toAccount.getBalance() + amount);
						accountDao.updateBalance(toAccount);
						return "success";
					} catch (Exception e) {
						// 성공적으로 안되면 Rollback 하기 (트랜잭션 작업을 모두 취소)
						status.setRollbackOnly();
						return "fail";
					}
				}
			});
		
			if(result.equals("success")) {
				return TransferResult.SUCCESS;
			} else {
				return TransferResult.FAIL_NOT_FOUND_ACCOUNT;
			}
		}
	
	//@Transactional을 쓸 땐 반드시 RuntimeException 예외를 발생시켜야 함. rollback시키기 위해.
	// 단점, 롤백이 이뤄지기 위해선 예외가 있어야 함.
	@Transactional
	public void transfer2(int fromAno, int toAno, int amount) {
		logger.info("실행");
		
		try {
				//출금하기
				Ch16Account fromAccount = accountDao.selectByAno(fromAno);
				fromAccount.setBalance(fromAccount.getBalance() - amount);
				accountDao.updateBalance(fromAccount);
				
				//예금하기
				Ch16Account toAccount = accountDao.selectByAno(toAno);
				toAccount.setBalance(toAccount.getBalance() + amount);
				accountDao.updateBalance(toAccount);
		} catch (Exception e) {
			throw new Ch16NotFoundAccountException("계좌가 존재하지 않습니다."); // 없어도 런타임 익셉션 (500에러) 이 발생하나 원하는 오류가 발생안함.
		}
	}
}
