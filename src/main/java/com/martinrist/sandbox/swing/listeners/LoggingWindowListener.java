package com.martinrist.sandbox.swing.listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintStream;

public class LoggingWindowListener extends WindowAdapter {

	private final PrintStream out;

	public LoggingWindowListener(PrintStream out) {
		this.out = out;
	}

	private void logEvent(WindowEvent e) {
		out.println("Window Listener received event : " + e);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		logEvent(e);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		logEvent(e);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		logEvent(e);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		logEvent(e);
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		logEvent(e);
	}

	@Override
	public void windowIconified(WindowEvent e) {
		logEvent(e);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		logEvent(e);
	}

	@Override
	public void windowGainedFocus(WindowEvent e) {
		logEvent(e);
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		logEvent(e);
	}

	@Override
	public void windowStateChanged(WindowEvent e) {
		logEvent(e);
	}

}
