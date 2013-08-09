package com.martinrist.sandbox.swing.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.martinrist.sandbox.swing.DefaultFrame;

@SuppressWarnings("serial")
class ChoiceComponentsFrame extends DefaultFrame {

	private static final int DEFAULT_FONT_SIZE = 10;
	private static final String TEXT_CONTENT = "The quick brown fox jumps over the lazy dog";
	private static final int DEFAULT_TEXT_PANEL_HEIGHT = 50;

	private static final Map<String, Integer> DEFAULT_FONT_SIZES = new LinkedHashMap<>();
	static {
		DEFAULT_FONT_SIZES.put("Small", 10);
		DEFAULT_FONT_SIZES.put("Medium", 12);
		DEFAULT_FONT_SIZES.put("Large", 14);
		DEFAULT_FONT_SIZES.put("Extra Large", 16);
	}

	private JLabel textLabel;
	private JCheckBox boldCheckBox;
	private JCheckBox italicCheckBox;
	private JPanel fontControlsPanel;
	private JPanel fontSizePanel;
	private JPanel fontSelectionPanel;
	private ButtonGroup fontSizeButtonGroup;
	private JComboBox<String> fontComboBox;

	public ChoiceComponentsFrame(final String title) {
		super(title);
		setUpTextLabel();
		setUpFontControlsPanel();
		pack();
	}

	private void setUpTextLabel() {
		textLabel = new JLabel(TEXT_CONTENT, SwingConstants.CENTER);
		textLabel.setFont(new Font("SansSerif", Font.PLAIN, DEFAULT_FONT_SIZE));
		textLabel.setPreferredSize(new Dimension(textLabel.getSize().width, DEFAULT_TEXT_PANEL_HEIGHT));
		add(textLabel, BorderLayout.CENTER);
	}

	private void setUpFontControlsPanel() {
		createFontControlsPanel();
		setUpTextStyleControls();
		setUpFontSizeControls();
		setUpFontSelectionControls();
	}

	private void createFontControlsPanel() {
		fontControlsPanel = new JPanel();
		fontControlsPanel.setLayout(new GridLayout(3, 1));
		add(fontControlsPanel, BorderLayout.NORTH);
	}

	private void setUpTextStyleControls() {

		JPanel fontStylePanel = new JPanel();
		fontStylePanel.setBorder(createdTitledEtchedBorder("Font Style"));
		fontControlsPanel.add(fontStylePanel);

		boldCheckBox = new JCheckBox(new BoldAction("Bold"));
		fontStylePanel.add(boldCheckBox);
		italicCheckBox = new JCheckBox(new ItalicAction("Italic"));
		fontStylePanel.add(italicCheckBox);
	}

	private void setUpFontSizeControls() {

		fontSizePanel = new JPanel();
		fontSizePanel.setBorder(createdTitledEtchedBorder("Font Size"));
		fontControlsPanel.add(fontSizePanel);

		fontSizeButtonGroup = new ButtonGroup();
		for (Map.Entry<String, Integer> size : DEFAULT_FONT_SIZES.entrySet()) {
			addFontSizeButton(size.getKey(), size.getValue());
		}

	}

	private Border createdTitledEtchedBorder(String title) {
		Border etchedBorder = BorderFactory.createEtchedBorder();
		Border titledBorder = BorderFactory.createTitledBorder(etchedBorder, title);
		return titledBorder;
	}

	private void addFontSizeButton(final String label, final Integer fontSize) {
		JRadioButton button = new JRadioButton(label, false);
		fontSizePanel.add(button);
		fontSizeButtonGroup.add(button);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeTextLabelFont(new FontMutator() {
					@Override
					public void changeFontAttributes() {
						size = fontSize;
					}
				});
			}
		});
	}

	private void setUpFontSelectionControls() {

		fontSelectionPanel = new JPanel();
		fontControlsPanel.add(fontSelectionPanel);
		fontComboBox = new JComboBox<String>();
		fontSelectionPanel.add(fontComboBox);

		populateFontComboBox();

		fontComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> fontComboBox = (JComboBox<String>) e.getSource();
				final String selectedFont = fontComboBox.getItemAt(fontComboBox.getSelectedIndex());

				changeTextLabelFont(new FontMutator() {
					@Override
					public void changeFontAttributes() {
						name = selectedFont;
					}
				});

			}
		});

	}

	private void populateFontComboBox() {
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] availableFontNames = env.getAvailableFontFamilyNames();
		for (String fontName : availableFontNames) {
			fontComboBox.addItem(fontName);
		}
	}

	private void changeTextLabelFont(FontMutator mutator) {
		Font currentFont = textLabel.getFont();
		textLabel.setFont(mutator.changeFont(currentFont));
	}

	class BoldAction extends AbstractAction {

		public BoldAction(final String label) {
			putValue(NAME, label);
		}

		@Override
		public void actionPerformed(final ActionEvent e) {
			changeTextLabelFont(new FontMutator() {
				@Override
				public void changeFontAttributes() {
					if (boldCheckBox.isSelected()) {
						style += Font.BOLD;
					} else {
						style -= Font.BOLD;
					}
				}
			});
		}
	}

	class ItalicAction extends AbstractAction {

		public ItalicAction(final String label) {
			putValue(NAME, label);
		}

		@Override
		public void actionPerformed(final ActionEvent e) {

			changeTextLabelFont(new FontMutator() {
				@Override
				public void changeFontAttributes() {
					if (italicCheckBox.isSelected()) {
						style += Font.ITALIC;
					} else {
						style -= Font.ITALIC;
					}
				}
			});
		}

	}

}