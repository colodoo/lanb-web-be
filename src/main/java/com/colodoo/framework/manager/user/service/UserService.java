package com.colodoo.framework.manager.user.service;

import com.colodoo.framework.base.abs.BaseService;
import com.colodoo.framework.common.Msg;
import com.colodoo.framework.common.SessionObject;
import com.colodoo.framework.manager.log.model.Log;
import com.colodoo.framework.manager.log.model.LogExample;
import com.colodoo.framework.manager.log.service.LogService;
import com.colodoo.framework.manager.role.service.RoleMapper;
import com.colodoo.framework.manager.roleUser.model.RoleUser;
import com.colodoo.framework.manager.roleUser.model.RoleUserExample;
import com.colodoo.framework.manager.roleUser.service.RoleUserMapper;
import com.colodoo.framework.manager.user.model.User;
import com.colodoo.framework.utils.Contants;
import com.colodoo.framework.utils.DateUtils;
import com.colodoo.framework.utils.RequestUtils;
import com.colodoo.framework.utils.StringUtil;
import com.colodoo.framework.easyui.Page;
import com.colodoo.framework.exception.DAOException;
import com.colodoo.framework.manager.user.model.UserExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	@Autowired
	RoleUserMapper roleUserMapper;
	@Autowired
	HttpSession session;
	@Autowired
	LogService logService;
	@Autowired
	SessionObject sessionObject;

	public int save(User model) {
		model.setUserId(StringUtil.uuid());
		model.setCreateDate(new Date());
		model.setLastDate(new Date());
		return userMapper.insert(model);
	}

	public int delete(User model) {
		return userMapper.deleteByPrimaryKey(model.getUserId());
	}

	public int update(User model) {
		return userMapper.updateByPrimaryKey(model);
	}

	public User queryById(User model) {
		return userMapper.selectByPrimaryKey(model.getUserId());
	}

	public List<User> query() {
		return userMapper.selectByExample(null);
	}

	public PageInfo query(Page page) {
		PageHelper.startPage(page.getPage(), page.getRows());
		return new PageInfo(userMapper.selectByExample(null));
	}

	/**
	 * 登录校验
	 *
	 * @param model
	 * @return
	 * @throws DAOException 
	 */
	public Msg loginCheck(User model, HttpServletRequest request) throws DAOException {
		Msg msg = new Msg();
		// 是否存在空参数
		if (model.getUserName() == null || "".equals(model.getUserName()) || model.getPassword() == null || "".equals(model.getPassword())) {
			msg.setSuccess(false);
			return msg;
		}
		UserExample example = new UserExample();
		example.createCriteria().andUserNameEqualTo(model.getUserName()).andPasswordEqualTo(model.getPassword()).andEnableEqualTo(Contants.TRUE);
		List<User> users = userMapper.selectByExample(example);
		if (users.size() == 1) {
			msg.setSuccess(true);
			// 成功以后填充sessionObject
			User user = users.get(0);
			sessionObject.setUser(user);
			RoleUserExample roleUserExample = new RoleUserExample();
			roleUserExample.createCriteria().andUserIdEqualTo(user.getUserId());
			List<RoleUser> roleUsers = roleUserMapper.selectByExample(roleUserExample);
			sessionObject.setRoleUsers(roleUsers);
			return msg;
		} else {
			this.failLogin(model, request);
			msg.setSuccess(false);
			return msg;
		}
	}

	/**
	 * 登录失败操作
	 *
	 * @param model
	 * @throws DAOException 
	 */
	public void failLogin(User model, HttpServletRequest request) throws DAOException {
		// 插入一条失败登录失败日志
		Log log = new Log();
		log.setCreateTime(new Date());
		log.setLogContent("登录失败");
		log.setLogSource(RequestUtils.getRemoteAddress(request));
		log.setLogType("LOGIN_FAILD");
		logService.saveLog(log);
		/*LogExample logExample = new LogExample();
		logExample.createCriteria().andCreateTimeBetween(DateUtils.getDayBegin(), DateUtils.getDayEnd()).andLogSourceEqualTo(RequestUtils.getRemoteAddress(request)).andLogTypeEqualTo("LOGIN_FAILD");
		List<Log> logs = logService.find(logExample);
		if(logs.size() >= Contants.MAX_LOGIN_TRY_COUNT) {
			model.setEnable(Contants.FALSE);
			model.setTryCount(0);
			userMapper.updateByPrimaryKeySelective(model);
		}*/
		/*UserExample example = new UserExample();
		example.createCriteria().andUserNameEqualTo(model.getUserName());
		// 防止出现没有数据的问题,重新查实体类
		List<User> users = userMapper.selectByExample(example);
		if (users.size() == 1) {
			model = users.get(0);
			// 如果已经锁号,直接停止所有操作
			if (model.getEnable().equals(Contants.FALSE)) {
				return;
			}
			// 如果超出限制次数,则锁号
			if (model.getTryCount() >= Contants.MAX_LOGIN_TRY_COUNT) {
				model.setEnable(Contants.FALSE);
				model.setTryCount(0);
				userMapper.updateByPrimaryKeySelective(model);
			} else {// 登录失败次数+1
				model.setTryCount(model.getTryCount() + 1);
				userMapper.updateByPrimaryKeySelective(model);
			}
		}*/
	}

	public boolean saveRegister(User model) throws Exception {
		// 先判断信息的完整性
		if (model.getUserName() == null || "".equals(model.getUserName()) || model.getPassword() == null || "".equals(model.getPassword())) {
			return false;
		}
		// 防止恶意注册,进行数据的二次验证
		// 再进行操作
		model.setEnable(Contants.TRUE);
		model.setTryCount(0);
		int ret = save(model);
		if (ret > 0) {
			return true;
		}
		
		return false;
	}
}
