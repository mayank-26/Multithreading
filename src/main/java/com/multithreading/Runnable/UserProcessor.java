package com.multithreading.Runnable;

import java.util.StringTokenizer;
import java.util.concurrent.Callable;

import com.multithreading.Beans.User;
import com.multithreading.DAO.UserDAO;

public class UserProcessor implements Callable<Integer>{
    private String userRecord;
    private UserDAO dao;

    public UserProcessor(String userRecord, UserDAO dao) {
        this.userRecord = userRecord;
        this.dao = dao;
    }

    @Override
    public Integer call() throws Exception {
        int rows= 0;
        System.out.println(Thread.currentThread().getName()+" processing record for : "+userRecord);
        StringTokenizer tokenizer = new StringTokenizer(userRecord, ",");
        User user=null;
        while(tokenizer.hasMoreTokens()){
            user = new User();
            user.setEmailAddress(tokenizer.nextToken());
            user.setName(tokenizer.nextToken());
            user.setId(Integer.valueOf(tokenizer.nextToken()));
            rows = dao.saveUser(user);
        }
       return rows;
    }

}
