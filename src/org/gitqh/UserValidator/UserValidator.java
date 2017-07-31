package org.gitqh.UserValidator;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-27-11:40
 */
public class UserValidator {
    private String name;
    private Random random = new Random();

    public String getName() {
        return name;
    }

    public boolean validate(String name, String passwd){
        try {
            long duration = (long)(Math.random()*10);
            System.out.println("validator " + this.name +": validating a user during " + duration +" seconds" );
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            return false;
        }
        return random.nextBoolean();
    }

    public UserValidator(String name) {
        this.name = name;
    }
}
