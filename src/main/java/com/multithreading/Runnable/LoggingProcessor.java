package com.multithreading.Runnable;

import java.lang.System.Logger;
import java.util.concurrent.Callable;
import java.util.logging.Level;

public class LoggingProcessor implements Callable<Boolean> {

	@Override
	public Boolean call() throws Exception {
		
		java.util.logging.Logger.getLogger(LoggingProcessor.class.getName()).log(Level.INFO,"Logging Something !!"+Thread.currentThread().getName());
		return true;
	}

}
