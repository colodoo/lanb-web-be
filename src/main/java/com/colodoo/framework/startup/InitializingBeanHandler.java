package com.colodoo.framework.startup;

import com.colodoo.framework.utils.SpringContextsUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class InitializingBeanHandler implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        // do something...
    }
}
