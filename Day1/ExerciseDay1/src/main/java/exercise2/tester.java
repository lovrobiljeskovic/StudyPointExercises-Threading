/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

import exercise2.Even;

/**
 *
 * @author Lovro
 */
public class tester {
    public static void main(String[] args) {
        Even even = new Even();
        Thread t1 = new Thread(() -> {
            even.next();
            System.out.println("t1: " + even.next());
        });
         Thread t2 = new Thread(() -> {
            even.next();
            even.next();
            even.next();
            even.next();
             System.out.println("t2: " + even.next());
        });
          Thread t3 = new Thread(() -> {
            even.next();
            System.out.println("t3: " + even.next());
          });
    t1.start();
    t2.start();
    t3.start();
    
    
}
}
