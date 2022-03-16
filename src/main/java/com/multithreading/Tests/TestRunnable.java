package com.multithreading.Tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import javax.swing.text.AbstractDocument.BranchElement;

public class TestRunnable {

	public static void main(String args[])
	{
	
	Runnable runnable=()->
	{
		try(BufferedReader br=new BufferedReader(new FileReader(new File("G:\\Core-java\\Multithreading\\Ex_Files_Java_EE_Concurrency\\Exercise Files\\Chapter2\\02_03\\begin\\sample.txt"))))
		{
			
			String line=null;
			
			while((line=br.readLine())!=null)
			{
				System.out.println(Thread.currentThread().getName()+"  "+line);
			}
			
			
		}
		catch(FileNotFoundException e)
		{
			
		}
		catch(Exception e1)
		{
		    		}
		
	};
	
	Executor executor=Executors.newSingleThreadExecutor();
	executor.execute(runnable);
	
	}
}
