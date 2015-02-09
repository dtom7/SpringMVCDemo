package com.example.springmvc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

/*@Component*/
public class MyPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String arg1)
			throws BeansException {
		System.out.println("In MyPostProcessor");
	    if( bean instanceof RequestMappingHandlerAdapter )
	    {
	      RequestMappingHandlerAdapter adapter = ( RequestMappingHandlerAdapter ) bean;
	      adapter.setSynchronizeOnSession( true );
	    }

	    return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String arg1)
			throws BeansException {
		// TODO Auto-generated method stub
		return bean;
	}

}
