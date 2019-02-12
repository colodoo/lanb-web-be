package com.colodoo.framework.base.abs;

import com.colodoo.framework.common.SessionObject;
import com.colodoo.framework.exception.DAOException;
import com.colodoo.framework.redis.RedisService;
import com.colodoo.framework.utils.Contants;
import com.colodoo.framework.utils.SpringContextsUtil;
import com.colodoo.framework.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author colodoo
 * @date 2018/8/7 22:49
 * @description 1; 继承的条件是你的*Mapper.xml和Server层文件在同一包下
 * 2; T为传递的实体类
 * 3; 编写的初衷是为了简化DAO层的代码量
 */
@Slf4j
@Transactional(rollbackFor = Exception.class)
public abstract class BaseService<M> {

    @Autowired
    private HttpSession session;

    @Autowired
    private RedisService redis;

    @Autowired
    private SqlSessionFactory sessionFactory;

    /*抽象方法相关*/
    private static final String MAPPER_SUFFIX = "Mapper";
    private static final String EXAMPLE_SUFFIX = "Example";

    /*Mapper方法相关*/
    private static final String MAPPER_INSERT = "insertSelective";
    private static final String MAPPER_DELETE = "deleteByPrimaryKey";
    private static final String MAPPER_UPDATE = "updateByPrimaryKeySelective";
    private static final String MAPPER_SELECT_BY_EXAMPLE = "selectByExample";
    private static final String MAPPER_SELECT_BY_PK = "selectByPrimaryKey";

    private static final String REALTION_MAPPER = "RealtionMapper";

    //private static final String MAPPER_CREATE_CRITERIA = "createCriteria";

    //mapper类
    private Class mapperClazz;
    //Mapper接口Bean
    private Object mapper;
    //实体类
    private Class<M> modelClazz;
    //Example类
    private Class exampleClazz;

    /*增删改部分*/

    /**
     * 插入方法
     *
     * @param model 实体类
     * @return int
     */
    public int insert(M model) throws DAOException {
        int ret;
        Method insert = this.getMethod(MAPPER_INSERT, this.getModelClass());
        try {
            ret = (int) insert.invoke(this.getMapper(), model);
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return ret;
    }

    /**
     * 删除方法1
     *
     * @param uuid uuid方法作为参数
     * @return int
     */
    public int delete(String uuid) throws DAOException {
        int ret;
        Method insert = this.getMethod(MAPPER_DELETE, String.class);
        try {
            ret = (int) insert.invoke(this.getMapper(), uuid);
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return ret;
    }

    /**
     * 删除方法2
     *
     * @param pk 数字递增方法作为参数
     * @return
     */
    public int delete(Long pk) throws DAOException {
        int ret;
        Method delete = this.getMethod(MAPPER_DELETE, Long.class);
        try {
            ret = (int) delete.invoke(this.getMapper(), pk);
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return ret;
    }

    /**
     * 更新方法
     *
     * @param model 实体类
     * @return int
     */
    public int update(M model) throws DAOException {
        int ret;
        Method update = this.getMethod(MAPPER_UPDATE, this.getModelClass());
        try {
            ret = (int) update.invoke(this.getMapper(), model);
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return ret;
    }

    /*查询部分*/

    /**
     * 根据uuid取实体类
     *
     * @param uuid
     * @return 实体
     */
    public M get(String uuid) throws DAOException {
        M model;
        Method get = this.getMethod(MAPPER_SELECT_BY_PK, String.class);
        try {
            model = (M) get.invoke(this.getMapper(), uuid);
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return model;
    }

    /**
     * 根据递增id取实体类
     *
     * @param id
     * @return 实体
     */
    public M get(Long id) throws DAOException {
        M model;
        Method get = this.getMethod(MAPPER_SELECT_BY_PK, Long.class);
        try {
            model = (M) get.invoke(this.getMapper(), id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return model;
    }

    /**
     * 查找
     *
     * @return 查询列表
     */
    public List<M> find(Object example) throws DAOException {
        List<M> list;
        Method find = this.getMethod(MAPPER_SELECT_BY_EXAMPLE, this.getExampleClass());
        try {
            list = (List<M>) find.invoke(this.getMapper(), example);
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return list;
    }

    /**
     * 无参数查询
     *
     * @return 查询列表
     */
    public List<M> find() throws DAOException {
        return this.find(null);
    }

    /*复杂关联查询*/

    /*批量操作*/

    /**
     * 批量删除,字符串逗号分隔方式
     *
     * @param ids
     * @return
     */
    public int batchDelete(String ids) {
        String[] idsArray = ids.split(",");
        int ret = this.batchDelete(idsArray);
        return ret;
    }

    /**
     * 批量删除,字符串数组方式
     *
     * @param dis
     * @return
     */
    public int batchDelete(String[] dis) {
        int ret = Contants.CODE_ZERO;
        for (String id : dis) {
            try {
                this.delete(id);
                ret++;
            } catch (DAOException e) {
                e.printStackTrace();
                continue;
            }
        }
        if (ret == Contants.CODE_ZERO) {
            ret = Contants.CODE_FAILED;
        }
        return ret;
    }

    /*灵活查询*/
    public List select(String statementId, Object parm) {
        List list = null;
        Method method;
        try {
            if (parm == null) {
                method = this.getMethod(statementId);
                list = (List) method.invoke(this.getMapper());
            } else {
                method = this.getMethod(statementId, parm.getClass());
                list = (List) method.invoke(this.getMapper(), parm);
            }
        } catch (IllegalAccessException e) {
            log.error(e.getMessage());
        } catch (InvocationTargetException e) {
            log.error(e.getMessage());
        }
        return list;
    }

    /*公共部分*/

    /**
     * 获得Mapper对象
     *
     * @return
     */
    public Object getMapper() {
        if (this.mapper == null) {
            this.mapper = this.getApplicationContext().getBean(this.getMapperClass());
        }
        return this.mapper;
    }

    /**
     * 获得实体类
     *
     * @return 实体类
     */
    private Class<M> getModelClass() {
        if (this.modelClazz == null) {
            this.modelClazz = (Class<M>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return this.modelClazz;
    }

    /**
     * 获得mapper类
     *
     * @return
     */
    private Class getMapperClass() {
        if (this.mapperClazz == null) {
            //创建一个基于Service的类
            String serviceTypeName = this.getClass().getTypeName();
            String mapperTypeName = serviceTypeName.substring(0, serviceTypeName.length() - 7) + MAPPER_SUFFIX;
            try {
                this.mapperClazz = Class.forName(mapperTypeName);
            } catch (ClassNotFoundException e) {
                log.error(e.getMessage());
            }
        }
        return this.mapperClazz;
    }

    /**
     * 获得容器
     *
     * @return
     */
    private ApplicationContext getApplicationContext() {
        return SpringContextsUtil.getApplicationContext();
    }

    /**
     * 取Mapper接口函数
     *
     * @return
     */
    public Method getMethod(String methodName, Class<?>... parameterTypes) {
        Method method = null;
        try {
            method = this.getMapperClass().getMethod(methodName, parameterTypes);
            method.setAccessible(true);
        } catch (NoSuchMethodException e) {
            log.error(e.getMessage());
        }
        return method;
    }

    /**
     * 取Example类
     *
     * @return
     */
    private Class<M> getExampleClass() {
        try {
            if (this.exampleClazz == null) {
                this.modelClazz = (Class<M>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
                String exampleClazzName = this.modelClazz.getTypeName() + EXAMPLE_SUFFIX;
                this.exampleClazz = Class.forName(exampleClazzName);
            }
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage());
        }
        return this.exampleClazz;
    }

    /**
     * 取当前Mybatis会话
     *
     * @return
     */
    public SqlSession getMybatisSession() {
        return this.sessionFactory.openSession();
    }

    /*其他方法*/
    public String uuid() {
        return StringUtil.uuid();
    }

    /*redius相关*/
    public RedisService getRedis() {
        return redis;
    }

    /*取当前会话对象*/
    public SessionObject getSessionObject() {
        return (SessionObject) session.getAttribute(Contants.SESSION_OBJECT_KEY);
    }

}
