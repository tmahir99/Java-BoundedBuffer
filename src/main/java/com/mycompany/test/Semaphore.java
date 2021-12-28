/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test;

/**
 *
 * @author mahir
 */
public class Semaphore
{
   private int value;

   public Semaphore(int value) {
      this.value = value;
   }

   public synchronized void acquire() {
      while (value <= 0) {
         try {
            wait();
         }
         catch (InterruptedException e) { }
      }

      value--;
   }

   public synchronized void release() {
      ++value;

      notify();
   }
}