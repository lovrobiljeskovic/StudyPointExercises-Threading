/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import javax.swing.text.Document;

/**
 *
 * @author Lovro
 */
public class Consumer implements Runnable {

    BlockingQueue<Long> queue;

    public Consumer(BlockingQueue<Long> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Long sum = 0L;
        boolean rule = true;
        while (rule) {
            try {
                Long value = queue.poll(10, TimeUnit.SECONDS);
                if (value == null) {
                   rule = false;
                } else {
                    System.out.println("Value:" + value);
                    sum += value;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("SUM: " + sum);
    }
}
