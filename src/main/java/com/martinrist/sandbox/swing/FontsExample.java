package com.martinrist.sandbox.swing;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class FontsExample {

	public static void main(String[] args) {

		new FontsExample().run();
	}

	private void run() {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				FontFrame frame = new FontFrame("Fonts Example");
				frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				frame.setVisible(true);

			}
		});
	}
}

class FontFrame extends DefaultFrame {

	private static final long serialVersionUID = 1L;

	JComponent fontComponent;

	public FontFrame(String title) {

		super(title);
		fontComponent = new FontComponent();
		add(fontComponent);

	}
}

class FontComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	private static final int NUMBER_TO_LIST = 10;
	private static final int FONT_SIZE = 12;
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	// TODO: Get this from font metrics rather than hard-coding
	private static final int LINE_SPACING = 50;

	private final String[] availableFontFamilyNames = GraphicsEnvironment.getLocalGraphicsEnvironment()
			.getAvailableFontFamilyNames();

	private final Stroke dashedStroke = new BasicStroke(1.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, 10.0f,
			new float[] { 5.0f, 5.0f }, 5.0f);

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		FontRenderContext frc = g2.getFontRenderContext();

		for (int i = 0; i < Math.min(availableFontFamilyNames.length, NUMBER_TO_LIST); i++) {

			String fontName = availableFontFamilyNames[i];
			Font font = new Font(fontName, Font.PLAIN, FONT_SIZE);
			g.setFont(font);

			String displayString = fontName + ALPHABET;
			g.drawString(displayString, 0, (i + 1) * LINE_SPACING);

			Rectangle2D bounds = font.getStringBounds(displayString, frc);
			g2.setStroke(dashedStroke);
			bounds.setRect(bounds.getMinX(), (i + 1) * LINE_SPACING - bounds.getHeight(), bounds.getWidth(),
					bounds.getHeight());
			g2.draw(bounds);

		}

	}
}