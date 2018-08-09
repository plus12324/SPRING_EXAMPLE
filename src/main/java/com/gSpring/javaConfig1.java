package com.gSpring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gSpring.dao.MemberDao;
import com.gSpring.etc.ServiceRequestFactoryInterFace;

@Configuration
public class javaConfig1 {
	
	@Bean
	public MemberDao memberDao(@Value("#{systemProperties['os.name']}") String msg){
		MemberDao memberDao = new MemberDao();
		memberDao.setMsg(msg);
		return memberDao;		
	}
	
	@Bean
	public ObjectFactoryCreatingFactoryBean serviceRequestFatory(){
		ObjectFactoryCreatingFactoryBean factoryBean = new ObjectFactoryCreatingFactoryBean();
		
		//<bean.....><property name="targetBeanName" value="pojo dto class name"/></bean>
		factoryBean.setTargetBeanName("pojo dto class name");
		
		return factoryBean;
	}
	
	@Bean
	public ServiceLocatorFactoryBean serviceRequestFatory2(){
		ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
		
		//<bean.....><property name="targetBeanName" value="pojo dto class name"/></bean>
		factoryBean.setServiceLocatorInterface(ServiceRequestFactoryInterFace.class);
		
		return factoryBean;
	}
}
