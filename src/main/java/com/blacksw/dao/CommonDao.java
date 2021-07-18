package com.blacksw.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDao {

	@Autowired
	private SqlSession sqlSession;

	public List<Map<String, Object>> selectList(String sqlId, Map<String, String> paramMap) {
		return sqlSession.selectList(sqlId, paramMap);
	}

	public Map<String, Object> selectMap(String sqlId, Map<String, String> paramMap) {
		List<Map<String, Object>> resultMap = sqlSession.selectList(sqlId, paramMap);
		if (resultMap == null || resultMap.size() < 1) {
			return new HashMap<String, Object>();
		}
		return resultMap.get(0);
	}
	
	public Object selectOne(String sqlId, Map<String, String> paramMap) {
		return sqlSession.selectOne(sqlId, paramMap);
	}

	public int insert(String sqlId, Map<String, String> paramMap) {
		return sqlSession.insert(sqlId, paramMap);
	}

	public int update(String sqlId, Map<String, String> paramMap) {
		return sqlSession.update(sqlId, paramMap);
	}

	public int delete(String sqlId, Map<String, String> paramMap) {
		return sqlSession.delete(sqlId, paramMap);
	}

}
