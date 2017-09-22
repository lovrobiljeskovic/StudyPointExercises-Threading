/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;

/**
 *
 * @author Lovro
 */
public class Producer implements Runnable {

    BlockingQueue<Long> numbersToUse;
    BlockingQueue<Long> producedNumbers;

    public Producer(BlockingQueue<Long> numbersToUse, BlockingQueue<Long> producedNumbers) {
        this.numbersToUse = numbersToUse;
        this.producedNumbers = producedNumbers;
    }

    @Override
    public void run() {
        boolean rule = true;
        while (rule) {
            try {
                Long numbers = numbersToUse.poll();

                if (numbers == null) {
                    rule = false;
                } else {
                    Long result = fib(numbers);
                    producedNumbers.put(result);

                }
            } catch (InterruptedException ex) {
            }

        }
    }

    private long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);

        }
    }

}
