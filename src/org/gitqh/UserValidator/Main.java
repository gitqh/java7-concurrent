package org.gitqh.UserValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-27-12:33
 */
public class Main {
    public static void main(String[] args) {

        String username = "test";
        String passwd = "test";
        UserValidator ldapValidator = new UserValidator("LDAP");
        UserValidator dbValidator = new UserValidator("db");
        TaskValidator ldapTask = new TaskValidator(ldapValidator, username, passwd);
        TaskValidator dbTask = new TaskValidator(dbValidator, username, passwd);
        List<TaskValidator> taskValidators = new ArrayList<>();
        taskValidators.add(ldapTask);
        taskValidators.add(dbTask);
        ExecutorService executorService = Executors.newCachedThreadPool();
        String result;
        try {
            result = executorService.invokeAny(taskValidators);
            System.out.println("main:result:"+result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("main: end of the execution");
    }
}
