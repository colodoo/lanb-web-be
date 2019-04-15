package com.colodoo.framework.manager.codeType.service.mapper;

import java.util.List;

import com.colodoo.framework.exception.DAOException;
import com.colodoo.framework.manager.codeType.model.CodeTypeVO;
import com.colodoo.framework.manager.codeType.model.CodeType;

/**
 * @author colodoo
 * @date 2019-4-15 15:53:51
 * @description 
 */
public interface CodeTypeSQLMapper {
	
	public List<CodeType> getCodeTypeList(CodeTypeVO model) throws DAOException;

}
