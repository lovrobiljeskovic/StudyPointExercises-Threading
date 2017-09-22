/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Lovro
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Long> s1 = new ArrayBlockingQueue(40);
        ArrayBlockingQueue<Long> s2 = new ArrayBlockingQueue(40);
        long[] numbers = {4, 5, 8, 12, 21, 22, 34, 35, 36, 37, 42};
        for (long i = 0; i < numbers.length; i++) {
            s1.add(i);
        }
        ExecutorService es = Executors.newFixedThreadPool(4);
        es.execute(new Producer(s1, s2));
        es.execute(new Producer(s1, s2));
        es.execute(new Producer(s1, s2));
        es.execute(new Producer(s1, s2));
        es.execute(new Consumer(s2));
        es.shutdown();
        es.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Closing Down");

    }

}
