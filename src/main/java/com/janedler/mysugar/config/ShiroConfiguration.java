package com.janedler.mysugar.config;


import com.janedler.mysugar.shiro.StatelessAccessControlFilter;
import com.janedler.mysugar.shiro.StatelessAuthorizingRealm;
import com.janedler.mysugar.shiro.StatelessDefaultSubjectFactory;
import com.janedler.mysugar.utils.Base64Util;
import org.apache.log4j.Logger;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置类.
 */
@Configuration
public class ShiroConfiguration {


    private static final Logger logger = Logger.getLogger(ShiroConfiguration.class);

    /**
     * Shiro内置过滤器，可以实现权限相关的拦截器
     *  常用的过滤器：
     *      anon：无需认证（登录）可以访问
     *      authc：必须认证才可以访问
     *      user：如果使用rememberMe的功能可以直接访问
     *      perms：该资源必须得到资源权限才可以访问
     *      role：该资源必须得到角色权限才可以访问
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(SecurityManager securityManager) {

        logger.info("shiroFilter");

        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        //Add.4.2.start
        factoryBean.getFilters().put("statelessAuthc", statelessAuthcFilter());
        //拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/**", "statelessAuthc");
        filterChainDefinitionMap.put("/user/login", "anon");
        factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        //Add.4.2.end
        return factoryBean;
    }



    /**
     * shiro安全管理器:
     * 主要是身份认证的管理，缓存管理，cookie管理，
     * 所以在实际开发中我们主要是和SecurityManager进行打交道的
     *
     * @return
     */
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {

        logger.info("securityManager");

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        //Add.2.2
        securityManager.setSubjectFactory(subjectFactory());
        //Add.2.5
        securityManager.setSessionManager(sessionManager());
        //Add.4.4
        securityManager.setRealm(statelessRealm());
        //securityManager.setCacheManager(redisCacheManager());
        /*
         * 禁用使用Sessions 作为存储策略的实现，但它没有完全地禁用Sessions
         * 所以需要配合context.setSessionCreationEnabled(false);
         */
        //Add.2.3
        ((DefaultSessionStorageEvaluator) ((DefaultSubjectDAO) securityManager.getSubjectDAO()).getSessionStorageEvaluator()).setSessionStorageEnabled(false);


        return securityManager;
    }

    /**
     * Add.2.1
     * subject工厂管理器.
     *
     * @return
     */
    @Bean
    public DefaultWebSubjectFactory subjectFactory() {
        logger.info("subjectFactory");
        return new StatelessDefaultSubjectFactory();
    }

    /**
     * Add.2.4
     * session管理器：
     * sessionManager通过sessionValidationSchedulerEnabled禁用掉会话调度器，
     * 因为我们禁用掉了会话，所以没必要再定期过期会话了。
     *
     * @return
     */
    @Bean
    public DefaultSessionManager sessionManager() {
        DefaultSessionManager sessionManager = new DefaultSessionManager();
        sessionManager.setSessionValidationSchedulerEnabled(false);
        return sessionManager;
    }


    /**
     * Add.4.3
     * 自己定义的realm.
     *
     * @return
     */
    @Bean
    public StatelessAuthorizingRealm statelessRealm() {
        logger.info("statelessRealm");
        return new StatelessAuthorizingRealm();
    }


    /**
     * Add.4.1
     * 访问控制器.
     *
     * @return
     */
    @Bean
    public StatelessAccessControlFilter statelessAuthcFilter() {
        logger.info("statelessAuthcFilter");
        return new StatelessAccessControlFilter();
    }

    /**
     * Add.5.1
     * 开启shiro aop注解支持.
     * 使用代理方式;所以需要开启代码支持;
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * Add.5.2
     * 自动代理所有的advisor:
     * 由Advisor决定对哪些类的方法进行AOP代理。
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }

}
