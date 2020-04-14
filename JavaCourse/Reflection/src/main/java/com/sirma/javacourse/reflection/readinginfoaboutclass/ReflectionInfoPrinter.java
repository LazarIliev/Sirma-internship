package com.sirma.javacourse.reflection.readinginfoaboutclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for getting a RandomClass fields and methods and print it out.
 */
public class ReflectionInfoPrinter {
	private static final Logger logger = LoggerFactory.getLogger(ReflectionInfoPrinter.class);

	public static void main(String[] args)  {
		RandomClass randomClass = new RandomClass();
		String methodsInfo = ClassInfo.getClassMethodsSignature(randomClass);
		logger.info(methodsInfo);
		try {
			String fieldsInfo = ClassInfo.getClassFields(randomClass);
			logger.info(fieldsInfo);
		} catch (IllegalAccessException e){
			logger.info(e.getMessage(), e);
		}
	}
}
