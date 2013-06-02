package com.martinrist.sandbox.swing;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimerTest {

	public static void main(String[] args) {

		ActionListener listener = new TimePrinter();
		Timer t = new Timer(2000, listener);
		t.start();

		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(1);
	}
}

class TimePrinter implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		Date now = new Date();
		System.out.println("At the tone, the time is " + now);
		Toolkit.getDefaultToolkit().beep();
	}

}
