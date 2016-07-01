package com.mule.spring.messageProcessors;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.processor.MessageProcessor;

public class LoggerMessageProcessor implements MessageProcessor {

	private static Logger logger = LogManager.getLogger(LoggerMessageProcessor.class);
	
	@Override
	public MuleEvent process(MuleEvent event) throws MuleException 
	{		
		String exceptionMessage = 
        		ExceptionUtils.getFullStackTrace(event.getMessage().getExceptionPayload().getException());
        logger.error(exceptionMessage);	
		return event;
	}

}
