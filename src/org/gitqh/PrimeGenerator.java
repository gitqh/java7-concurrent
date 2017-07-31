package org.gitqh;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-20-16:06
 */
public class PrimeGenerator extends Thread {

    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }

    @Override
    public void run() {
        long number = 1L;
        while (true){
            if (isPrime(number)){
                System.out.printf("Number %d is prime\n",number);
            }
            if (isInterrupted()){
                System.out.println("the prime generator has been interrupted");
                return;
            }
            number++;
        }
    }

    private boolean isPrime(long number) {
        if (number<=2){
            return true;
        }
        for (long i=2;i<number;i++){
            if ((number%i)==0){
                return false;
            }
        }
        return true;
    }
}
