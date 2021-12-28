/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author mahir
 */
public class BoundedBuffer extends JFrame implements Buffer,ActionListener
{ 
	private static final int BUFFER_SIZE = 5;
	public Object[] buffer;
	private int in, out;
        private int count = 0 ;
	private Semaphore mutex;
	private Semaphore empty;
	private Semaphore full;
        JTextField tf = new JTextField();
        JTextField buf = new JTextField();//buffer state
        JTextField con = new JTextField();//consumer state
        JLabel l1 = new JLabel();
        JLabel l2 = new JLabel(); 

	// Continued on next Slide
	public BoundedBuffer() { 
		// buffer is initially empty
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setLayout(new FlowLayout());
                
                
                l1.setPreferredSize(new Dimension(150, 50));
                l1.setText(new String("==================>"));
                l2.setPreferredSize(new Dimension(150, 50));
                l2.setText(new String("==================>"));

                
                tf.setPreferredSize(new Dimension(150,50));
                tf.setEnabled(false);
                tf.setText(new String("PRODUCER"));
                tf.setBackground(Color.red);
                
                buf.setPreferredSize(new Dimension(300,100));
                buf.setEnabled(false);
                
                
                con.setPreferredSize(new Dimension(150,50));
                con.setEnabled(false);
                con.setText(new String("CONSUMER"));
                con.setBackground(Color.red);
               
                
                this.add(tf);
                this.add(l1);
                this.add(buf);
                this.add(l2);
                this.add(con);
                
                this.pack();
                this.setVisible(true);
		in = 0;
		out = 0;
		buffer = new Object[BUFFER_SIZE];
		mutex = new Semaphore(1);
		empty = new Semaphore(BUFFER_SIZE);
		full = new Semaphore(0);
}


public void insert(Object item) { 
	empty.acquire();
	mutex.acquire();
	// add an item to the buffer
	buffer[in] = item;
	in = (in + 1) % BUFFER_SIZE;
        count ++;
	mutex.release();
	full.release();
	System.out.println("Producer dodao ");
        tf.setBackground(Color.GREEN);
        con.setBackground(Color.red);
        buf.setText(new String("Buffer +1     Stanje: " + count));
        
        
}
public Object remove() { 
	full.acquire();
	mutex.acquire();
	// remove an item from the buffer
	Object item = buffer[out];
	out = (out + 1) % BUFFER_SIZE;
        count --;
	mutex.release();
	empty.release();
	System.out.println("Consumer uzeo ");
        tf.setBackground(Color.red);
        con.setBackground(Color.green);
        buf.setText(new String("Buffer -1     Stanje: " + count));
	return item;
}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

