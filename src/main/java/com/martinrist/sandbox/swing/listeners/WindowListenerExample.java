package com.martinrist.sandbox.swing.listeners;

import java.awt.event.WindowAdapter;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.martinrist.sandbox.swing.DefaultFrame;

public class WindowListenerExample {

	public static void main(String[] args) {

		new WindowListenerExample().run();

	}

	private void run() {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				JFrame frame = new WindowListenerFrame("Window Listener Example");

				WindowAdapter listener = new LoggingWindowListener(System.out);
				frame.addWindowListener(listener);
				frame.addWindowFocusListener(listener);
				frame.addWindowStateListener(listener);

				frame.setVisible(true);
			}
		});

	}
}

class WindowListenerFrame extends DefaultFrame {

	private static final long serialVersionUID = 1L;

	public WindowListenerFrame(String name) {
		super(name);
	}

}
