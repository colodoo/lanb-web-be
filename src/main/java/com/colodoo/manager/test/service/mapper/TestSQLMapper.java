package com.colodoo.manager.test.service.mapper;

import java.util.List;

import com.colodoo.framework.exception.DAOException;
import com.colodoo.manager.test.model.TestVO;
import com.colodoo.manager.test.model.Test;

/**
 * @author colodoo
 * @date 2019-4-3 11:37:54
 * @description 
 */
public interface TestSQLMapper {
	
	public List<Test> getTestList(TestVO model) throws DAOException;

}
