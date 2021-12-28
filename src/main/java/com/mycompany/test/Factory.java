/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test;

import java.awt.Dimension;

/**
 *
 * @author mahir
 */
public class Factory
{ 
	public static void main(String args[]) { 
			BoundedBuffer buffer = new BoundedBuffer();
			// now create the producer and consumer threads
			Thread producer = new Thread(new Producer(buffer));
			Thread consumer = new Thread(new Consumer(buffer));
			producer.start();
			consumer.start();
                        buffer.setTitle(new String("Producer&Consumer"));
                        buffer.setPreferredSize(new Dimension(5000, 5000));
                        buffer.setResizable(false);


	}
}

