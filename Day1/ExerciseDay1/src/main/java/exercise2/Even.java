/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

public class Even
{
  private int n = 0;
  public synchronized int next()
  {
    n++;
    n++;
    return n;
  }
}
//a) Are you able to provoke the expected error on your machine?
// I was able to provoke the expected error only after implementing 4 threads, which means the more threads you have, the easier it is to provoke the wanted reaction.
//Either that or adding more next() methods in each of the threads works.
//b) How often does the problem occur?
// The problem will occure more frequently with the more threads you have, so by having 2 threads, it will occure less frequently than let's say with 5 threads.
//c) Use the synchronization techniques you’ve learned today, to make next() method atomic with respect to itself.

//d) Argue that your solution is correct (argue, don’t prove)



