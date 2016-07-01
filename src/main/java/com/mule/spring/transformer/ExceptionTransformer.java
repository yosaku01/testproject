package com.mule.spring.transformer;

import java.io.ByteArrayOutputStream;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

public class ExceptionTransformer extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
			String exceptionMessageStr = null;		
			try 
			{
				    ByteArrayOutputStream buf = new java.io.ByteArrayOutputStream();
				    message.getExceptionPayload().getException().printStackTrace(new java.io.PrintWriter(buf, true));
				    exceptionMessageStr = buf.toString();
					buf.close();
					message.setOutboundProperty("http.status", "500");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return exceptionMessageStr;
	}

}
