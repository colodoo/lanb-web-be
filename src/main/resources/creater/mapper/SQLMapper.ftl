package ${packageName}.service.mapper;

import java.util.List;

import com.colodoo.framework.exception.DAOException;
import ${packageName}.model.${tableName?cap_first}VO;
import ${packageName}.model.${tableName?cap_first};

/**
 * @author ${name!"colodoo"}
 * @date ${.now?date} ${.now?time}
 * @description 
 */
public interface ${tableName?cap_first}SQLMapper {
	
	public List<${tableName?cap_first}> get${tableName?cap_first}List(${tableName?cap_first}VO model) throws DAOException;

}
