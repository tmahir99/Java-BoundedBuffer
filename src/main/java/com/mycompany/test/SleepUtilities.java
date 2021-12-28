/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test;

/**
 *
 * @author mahir
 */
public class SleepUtilities
{
	/**
	 * Nap between zero and NAP_TIME seconds.
	 */
	public static void nap() {
		nap(NAP_TIME);
	}

	/**
	 * Nap between zero and duration seconds.
	 */
	public static void nap(int duration) {
        	int sleeptime = (int) (NAP_TIME * Math.random() );
        	try { Thread.sleep(sleeptime*2000); }
        	catch (InterruptedException e) {}
	}

	private static final int NAP_TIME = 5;
}