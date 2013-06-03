package com.martinrist.sandbox.lang.innerClasses;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TalkingClock {

	private final int interval;
	private final boolean beep;

	public TalkingClock(int interval, boolean beep) {
		this.interval = interval;
		this.beep = beep;
	}

	public void start() {
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();

		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(1);
	}

	public class TimePrinter implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Date now = new Date();
			System.out.println("At the tone, the time is " + now);
			if (beep) {
				Toolkit.getDefaultToolkit().beep();
			} else {
				System.out.println("Beep!");
			}
		}
	}
}
