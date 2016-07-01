package com.mule.spring;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.interceptor.Interceptor;
import org.mule.processor.AbstractInterceptingMessageProcessor;

public class MyCustomInterceptor extends AbstractInterceptingMessageProcessor implements Interceptor
{
	private static Logger logger = LogManager.getLogger(MyCustomInterceptor.class);
	
    @Override
    public MuleEvent process(MuleEvent event) throws MuleException
    {
        String exceptionMessage = 
        		ExceptionUtils.getFullStackTrace(event.getMessage().getExceptionPayload().getException());
        logger.error(exceptionMessage);
        return processNext(event);
    }
}
