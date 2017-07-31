package org.gitqh.UserValidator;

import java.util.concurrent.Callable;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-27-12:27
 */
public class TaskValidator implements Callable<String> {

    private UserValidator userValidator;
    private String user;
    private String passwd;

    public TaskValidator(UserValidator userValidator, String user, String passwd) {
        this.userValidator = userValidator;
        this.user = user;
        this.passwd = passwd;
    }

    @Override
    public String call() throws Exception {
        if (!userValidator.validate(user, passwd)){
            System.out.println(userValidator.getName() +" : the user has not been found");
        }
        return null;
    }
}
