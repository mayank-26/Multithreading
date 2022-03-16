package com.multithreading.Tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.multithreading.DAO.UserDAO;
import com.multithreading.Runnable.UserProcessor;

public class TestExecutors {

	public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor()	;
        List<String> users = getUsersFromFile("G:\\Core-java\\Multithreading\\Ex_Files_Java_EE_Concurrency\\Exercise Files\\Chapter3\\03_04\\begin\\new_users.txt"
);
        UserDAO dao = new UserDAO();
        for(String user:users){
            Future<Integer> future = service.submit(new UserProcessor(user, dao));
            try {
                System.out.println("Result of the operation is: "+future.get());
            } catch (InterruptedException ex) {
               // Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
               // Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        service.shutdown();
        
        try {
			System.out.println("Service shut down?"+service.awaitTermination(30,TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			service.shutdownNow();
			e.printStackTrace();
		}
        
        
        System.out.println("Main execution over!");

    }

    public static List<String> getUsersFromFile(String fileName) {
        List<String> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                users.add(line);
            }
        } catch (FileNotFoundException ex) {
           // Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
	}

