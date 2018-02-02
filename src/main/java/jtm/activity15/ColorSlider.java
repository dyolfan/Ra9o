package jtm.activity15;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.miginfocom.swing.MigLayout;

// TODO Install WindowBulder plugin on Eclipse
// Then right click on this class in Project Explorer 
// and choose "Open With" and choose "WindowBuilder editor"
// Then choose "Design" tab of the editor
// HINT:
// You can create reference implementation of application in following way:
// 1. select menu: New — Other...,
// 2. choose tree: WindowBuilder — Swing Application — Application window
// 3. press Next, enter Class name and press Finish.
// Note that both — Application window and JFrame use JFrame. Only application 
// initialization is different.

public class ColorSlider {

	private JFrame frmColorSlider;
	private JSlider redSlider, greenSlider, blueSlider;
	private JTextArea txtTest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ColorSlider cs = new ColorSlider();
	}

	/**
	 * Create the application objects and add listeners
	 */
	public ColorSlider() {
		initialize();
		add_listeners();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmColorSlider = new JFrame();

		// Form properties
		frmColorSlider.setTitle("Color slider");
		frmColorSlider.setBounds(100, 100, 450, 300);
		frmColorSlider.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmColorSlider.getContentPane().setLayout(new MigLayout("", "[][][grow]", "[][][][][][grow]"));
		txtTest = new JTextArea();
		txtTest.setText("Test area");

		frmColorSlider.getContentPane().add(txtTest, "cell 0 3 3 3,grow");

		// Color labels
		JLabel lblR = new JLabel("R");
		frmColorSlider.getContentPane().add(lblR, "cell 1 0");
		JLabel lblG = new JLabel("G");
		frmColorSlider.getContentPane().add(lblG, "cell 1 1");
		JLabel lblB = new JLabel("B");
		frmColorSlider.getContentPane().add(lblB, "cell 1 2");

		// TODO add JSliders: redSlider, greenSlider, blueSlider into form
		// set their range accordingly to RGB id range
		// Layout them correctly against appropriate labels
		// red slider should be in "cell 2 0", green in "cell 2 1",
		// and blue in "cell 2 2"

		// Make JFrame visible
		frmColorSlider.setVisible(true);

	}

	private void add_listeners() {
		// TODO add event listeners to all sliders and call change_color method
		// from them
	}

	public void change_color() {
		// TODO change background id of txtTest object accordingly to
		// id slider values. Use Color object for that
	}

	// These methods provide publics getters for redSlider, greenSlider and
	// blueSlider values for Unit tests
	// Do not change these methods!
	public int getRedSliderValue() {
		return redSlider.getValue();
	}

	public int getGreenSliderValue() {
		return greenSlider.getValue();
	}

	public int getBlueSliderValue() {
		return blueSlider.getValue();
	}

	// These methods provide publics setters for redSlider, greenSlider and
	// blueSlider values for Unit tests
	// Do not change these methods!
	public void setRedSliderValue(int value) {
		redSlider.setValue(value);
	}

	public void setGreenSliderValue(int value) {
		greenSlider.setValue(value);
	}

	public void setBlueSliderValue(int value) {
		blueSlider.setValue(value);
	}

}
