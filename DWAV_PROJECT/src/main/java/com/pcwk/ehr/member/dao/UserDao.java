package com.pcwk.ehr.member.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.pcwk.ehr.cmn.SearchVO;
import com.pcwk.ehr.member.domain.UserVO;




public interface UserDao {
	
	/**
	 * 전체 회원 조회
	 * @return
	 */
	List<UserVO> getAll();

	/**
	 * 총 회원 수 
	 * @return
	 * @throws SQLException
	 */
	int getCount() throws SQLException;

	/**
	 * 전체 삭제 
	 * @throws SQLException
	 */
	void deleteAll() throws SQLException;

	/**
	 * 회원 가입
	 * @param inVO
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int doInsert(UserVO inVO) throws SQLException;

	/**
	 * 회원 조회
	 * @param inVO
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	UserVO doSelectOne(UserVO inVO) throws SQLException;
	
	/**
	 * 회원 탈퇴
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int doDelete(UserVO inVO)throws SQLException;
	
	/**
	 * 회원 정보 수정
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int doUpdate(UserVO inVO)throws SQLException;
	
	
	/**
	 * 유저 검색 조회 
	 * @param inVO
	 * @return List<UserVO>
	 * @throws SQLException
	 */
    List<UserVO>  doRetrieve(SearchVO inVO) throws SQLException;
    
    
    
}