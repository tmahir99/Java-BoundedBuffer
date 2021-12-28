/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test;

/**
 *
 * @author mahir
 */
import java.util.Date;
public class Consumer implements Runnable
{ 
	private Buffer buffer;
	public Consumer(Buffer buffer) { 
			this.buffer = buffer;
	}
	public void run() { 
			Date message;
			while (true) { 
				// nap for awhile
				SleepUtilities.nap();
				// consume an item from the buffer
				message = (Date)buffer.remove();
				
			}
	}
}
