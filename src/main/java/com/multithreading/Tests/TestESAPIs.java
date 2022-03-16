package com.multithreading.Tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.multithreading.Runnable.LoggingProcessor;

public class TestESAPIs {
	
	public static void main(String args[]) throws InterruptedException
	{   //Thread pool of 2 Threads
		ExecutorService executorService=Executors.newFixedThreadPool(2);
		List<Callable<Boolean>> callables=new ArrayList<>();
		//Tasks
		callables.add(new LoggingProcessor());
		callables.add(new LoggingProcessor());
		callables.add(new LoggingProcessor());
		callables.add(new LoggingProcessor());
		callables.add(new LoggingProcessor());
		callables.add(new LoggingProcessor());
		callables.add(new LoggingProcessor());
		//Executor Service invoking all tasks and these are then performed by the above 2 threads
		//It is a invokeAll procedure
		List<Future<Boolean>> list=executorService.invokeAll(callables);
		
		//Getting every future object
		for(Future<Boolean> future:list)
		{
			try {
				System.out.println("Operation Result"+future.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//with invokeAny it will only return first operation result
		//we should use invokeAny method we want assurance that task executed atleast once
		
		try {
			System.out.println(executorService.invokeAny(callables));
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
