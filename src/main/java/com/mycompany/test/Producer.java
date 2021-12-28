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
public class Producer implements Runnable
{ 
	private BoundedBuffer buffer;
	public Producer(BoundedBuffer buffer) { 
			this.buffer = buffer;
	}
	public void run() { 
			Date message;
			int i=0;
			while (true) { 
				// nap for awhile
				SleepUtilities.nap();
				// produce an item & enter it into the buffer
				message = new Date();
				buffer.insert(message);
				
			}
			
	}
}
