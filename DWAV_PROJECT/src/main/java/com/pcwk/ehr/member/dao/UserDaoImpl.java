package com.pcwk.ehr.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;

import com.pcwk.ehr.cmn.SearchVO;
import com.pcwk.ehr.member.domain.Level;
import com.pcwk.ehr.member.domain.UserVO;

/**
 *         <!-- dao -->
        <bean id="userDao" class="com.pcwk.ehr.member.dao.UserDaoImpl">
          <!-- setter통한 의존관계 주입 -->
          <property name="dataSource" ref="dataSource"/>
        </bean>
 * @author HKEDU
 *
 */
@Repository("userDao") // 서버가 시작될 때, 객체를 만들지 않고도 이 클래스는 자동으로 메모리에 등록됨
public class UserDaoImpl implements UserDao {
	final static Logger LOG = LogManager.getLogger(UserDaoImpl.class);

	//sqlSession 객체를 개발자가 직접 생성하지 않고 스프링에서 연결시켜줌
	//의존관계 주입, 마이바티스에서 제공하는 sqlSession클래스에 종속되어있음
	//root-context.xml에서 mybatis 관련 설정 확인
	@Inject
	SqlSessionTemplate  sqlSessionTemplate;
	
	
	
	final String NAMESPACE = "com.pcwk.ehr.member";
	
	
	public UserDaoImpl() {}


    //OK
	@SuppressWarnings("deprecation")
	public List<UserVO>  getAll(){
		List<UserVO>  list = new ArrayList<UserVO>();
		
        String statement = this.NAMESPACE +".getAll";
		
		list = this.sqlSessionTemplate.selectList(statement);
		
		for (UserVO vo : list) {
			LOG.debug("vo:" + vo);
		}
		
		
		return list;
	}

	/**
	 * OK
	 * 등록건수 
	 * @return
	 * @throws SQLException
	 */
	public int getCount() throws SQLException{
		int count = 0;
		String statement = NAMESPACE +".getCount";
		
		count = this.sqlSessionTemplate.selectOne(statement);
		LOG.debug("==============================");
		LOG.debug("=count="+count);
		LOG.debug("==============================");			
		
		return count;
	}

	
    /**OK
     * 전체 삭제 
     * @throws SQLException
     */
    public void deleteAll() throws SQLException{
    	String statement = NAMESPACE+".deleteAll";
    	LOG.debug("==============================");
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");	
		
		int flag = this.sqlSessionTemplate.delete(statement);
		LOG.debug("==============================");
		LOG.debug("=flag="+flag);
		LOG.debug("==============================");    	
    }

	/**OK
	 * 사용자 등록 
	 * @param inVO
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int doInsert(final UserVO inVO) throws SQLException{
		int flag = 0;
		String statement = NAMESPACE +".doInsert";
		
		LOG.debug("==============================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("==============================");	
		
		flag = this.sqlSessionTemplate.insert(statement, inVO);
	    LOG.debug("flag:"+flag);
		return flag;
	}
	
	/**OK
	 * 사용자 조회
	 * @param inVO
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@SuppressWarnings("deprecation")
	public UserVO doSelectOne(UserVO inVO) throws SQLException{
		UserVO outVO = null;
		String statement = NAMESPACE +".doSelectOne";
		
		LOG.debug("==============================");
		LOG.debug("=inVO="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");	
		
		
		outVO = sqlSessionTemplate.selectOne(statement, inVO);
		
		LOG.debug("==============================");
		LOG.debug("=outVO="+outVO.toString());
		LOG.debug("==============================");	
		return outVO;
	}

	/**
	 * 단건 삭제
	 */
	public int doDelete(UserVO inVO) throws SQLException {
		int flag = 0;
		String statement = NAMESPACE + ".doDelete";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);		
		LOG.debug("==============================");
		flag = sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("=flag="+flag);		
		return flag;
	}

	public int doUpdate(UserVO inVO) throws SQLException {
		int flag = 0;
		String statement = NAMESPACE +".doUpdate";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");		
		flag = this.sqlSessionTemplate.update(statement, inVO);
		LOG.debug("flag="+flag);
		return flag;
	}

	public List<UserVO> doRetrieve(SearchVO inVO) throws SQLException {

		String statement = NAMESPACE +".doRetrieve";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");	
		
		List<UserVO> list = sqlSessionTemplate.selectList(statement, inVO);
		
		for(UserVO vo  :list) {
			LOG.debug(vo);
		}
		
		return list;
	}



}
























