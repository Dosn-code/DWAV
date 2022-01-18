package com.pcwk.ehr.member.service;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.cmn.SearchVO;
import com.pcwk.ehr.member.domain.UserVO;

public interface UserService {

	
	/**
	 * 단건 사용자 조회
	 * @param inVO
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public UserVO doSelectOne(UserVO inVO) throws SQLException;
	
	/**
	 * 단건 삭제
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doDelete(UserVO inVO)throws SQLException;	
	
	/**
	 * 수정
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doUpdate(UserVO inVO)throws SQLException;
	
	
	/**
	 * 목록 조회(검색) 
	 * @param inVO
	 * @return List<UserVO>
	 * @throws SQLException
	 */
    List<UserVO>  doRetrieve(SearchVO inVO)throws SQLException;
	
	/**
	 * 최초 회원 가입시 호스트 여부: USER
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int add(UserVO inVO) throws SQLException;

	public void makeHosts() throws Exception;

    
	/**
	 * 호스트가 될 수 있는지?
	 * @param user
	 * @return Boolean
	 * @throws IllegalAccessException 
	 */
	public Boolean canMakeHost(UserVO user) throws IllegalAccessException;
	
    
	/**
	 * 호스트로 만들기 --> 호스트 crud조건으로 들어가야하지않냐
	 * @param inVO
	 * @throws SQLException
	 */
	public void makeHost(UserVO inVO) throws SQLException;	
}
