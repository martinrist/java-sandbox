package com.martinrist.sandbox.swing.mouseEvents;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.martinrist.sandbox.swing.DefaultFrame;

public class MouseEventLogger {

	private static final Logger LOG = Logger.getLogger(MouseEventLogger.class);

	public static void main(String[] args) {

		new MouseEventLogger().run();
	}

	private void run() {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				JFrame frame = new DefaultFrame("Mouse Event Logger");
				frame.setVisible(true);
				frame.addMouseListener(new MouseListener() {

					private void logEvent(MouseEvent e) {
						LOG.info("Received event: " + e);
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						logEvent(e);
					}

					@Override
					public void mousePressed(MouseEvent e) {
						logEvent(e);
					}

					@Override
					public void mouseExited(MouseEvent e) {
						logEvent(e);
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						logEvent(e);
					}

					@Override
					public void mouseClicked(MouseEvent e) {
						logEvent(e);
					}
				});
			}
		});

	}
}
