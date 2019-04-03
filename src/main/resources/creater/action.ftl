package ${packageName}.action;

import ${packageName}.model.${tableName?cap_first};
import ${packageName}.model.${tableName?cap_first}VO;
import ${packageName}.service.${tableName?cap_first}Service;
import com.colodoo.framework.utils.Contants;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
* @author ${name!"colodoo"}
* @date ${.now?date} ${.now?time}
* @description
*/
@Controller
@RequestMapping(value = "/${tableName}")
@CrossOrigin
public class ${tableName?cap_first}Action {

    @Autowired
    ${tableName?cap_first}Service ${tableName}Service;

	/**
	 * 新增数据
	 * 
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/save")
    @ResponseBody
    public Map<String, Object> save(@RequestBody ${tableName?cap_first} model) {
        Map<String, Object> rspMap = new HashMap<String, Object>();
        int ret = ${tableName}Service.save${tableName?cap_first}(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", Contants.MSG_SAVE_FAIL);
        }
        return rspMap;
    }

	/**
	 * 删除数据
	 * 
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Map<String, Object> delete(@RequestBody ${tableName?cap_first} model) {
        Map<String, Object> rspMap = new HashMap<String, Object>();
        int ret = ${tableName}Service.delete${tableName?cap_first}(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", Contants.MSG_DELETE_FAIL);
        }
        return rspMap;
    }

	/**
	 * 更新数据
	 * 
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Map<String, Object> update(@RequestBody ${tableName?cap_first} model) {
        Map<String, Object> rspMap = new HashMap<String, Object>();
        int ret = ${tableName}Service.update${tableName?cap_first}(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", Contants.MSG_UPDATE_FAIL);
        }
        return rspMap;
    }

	/**
	 * 根据id查找单条数据
	 * 
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/queryById")
    @ResponseBody
    public Map<String, Object> queryById(@RequestBody ${tableName?cap_first} model) {
        Map<String, Object> rspMap = new HashMap<String, Object>();
        rspMap.put("rows", ${tableName}Service.queryById(model));
        return rspMap;
    }

	/**
	 * 查找列表
	 * 
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/query")
    @ResponseBody
    public List<${tableName?cap_first}> query(@RequestBody ${tableName?cap_first}VO model) {
        return ${tableName}Service.query(model);
    }

	/**
	 * 查找分页列表
	 * 
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/queryPage")
    @ResponseBody
    public Map<String, Object> queryPage(@RequestBody ${tableName?cap_first}VO model) {
        Map<String, Object> rspMap = new HashMap<String, Object>();
        PageInfo<${tableName?cap_first}> info = ${tableName}Service.query(model.getPage(), model);
        rspMap.put(Contants.TABLE_ROWS, info.getList());
        rspMap.put(Contants.TABLE_TOTAL, info.getTotal());
        return rspMap;
    }
}
