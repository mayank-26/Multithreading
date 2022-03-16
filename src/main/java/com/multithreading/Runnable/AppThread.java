package com.multithreading.Runnable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

import ch.qos.logback.classic.Logger;

public class AppThread extends Thread {
    @Override
    public void run() {
        
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("G:\\Core-java\\Multithreading\\Ex_Files_Java_EE_Concurrency\\Exercise Files\\Chapter2\\02_03\\begin\\sample.txt")))){
            String line = null;
            while((line=reader.readLine())!=null){
                System.out.println(Thread.currentThread().getName()+" reading the line: "+line);
            }
        } catch (FileNotFoundException ex) {
          
        } catch (IOException ex) {
            
        }
    }
}
