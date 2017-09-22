/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lovro
 */
public class Exercise1 {

    private static volatile boolean test = true;
    public static void main(String[] args) throws InterruptedException {
           Thread t1 = new Thread(() -> {
    int sum = 0;
    for (int i = 1; i <= 10; i++) {
        sum += i;
        System.out.println("sum is: " +sum);
    }
           });
           Thread t2 = new Thread(() -> {
                 for(int i = 1; i <= 5; i++) {
            System.out.println("t2: " + i);
        } 
                 try{
                     Thread.sleep(2000);
                 } catch (InterruptedException ex) {
                   Logger.getLogger(Exercise1.class.getName()).log(Level.SEVERE, null, ex);
               }
           });
           Thread t3 = new Thread(() -> {
               int i = 10;
                while(test) {
            System.out.println("t3: " + i);
            i++;
             try{
                     Thread.sleep(3000);
                 } catch (InterruptedException ex) {
                   Logger.getLogger(Exercise1.class.getName()).log(Level.SEVERE, null, ex);
               }
        } 
           });
           t1.start();
           t2.start();
           t3.start();
           Thread.sleep(10000);
           test = false;
           
    }  
    }  
//a) Do you observe a need for synchronization techniques on any of the threads in practise, or does your program work by accident?
// I've used volatile as synchronization technique, but the output was almost always the same as if I didn't implement it which suggests it works by accident.

//b) Regardless of whether you observe the problem on your machine, we need to handle it
//What is the problem I’m hinting at, and how can we solve it? (Since I’m such a nice guy, here’s a hint: think about the VolatileExample class from the demo today).
// As I mentioned earlier, using the volatile keyword ensures a happens-before relationship between a thread which reads from the field and the thread that wrote to it.

//c) argue that your solution is correct (argue, don’t prove)
// I have run the code atleast 20 times with synchronized method, I had never got an unexpected result while running it without synchronized, there were few times where I got uneven numbers.

       

    

