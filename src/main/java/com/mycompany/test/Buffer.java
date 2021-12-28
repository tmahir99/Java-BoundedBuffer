/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test;

/**
 *
 * @author mahir
 */

public interface Buffer <E>
{
	// producers call this method
	public void insert(E item);

	// consumers call this method
	public E remove();
}

