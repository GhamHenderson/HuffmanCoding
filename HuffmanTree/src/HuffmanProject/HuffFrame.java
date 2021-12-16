package HuffmanProject;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Color;
import java.util.Locale;

public class HuffFrame {

	ListArrayBased freqTable = new ListArrayBased();
	buildTree tree = new buildTree();
	public JFrame frame;
	public JTextField inputBox;
	encodeHuffman huff = new encodeHuffman();
	public String input;
	public HuffFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(new GridLayout(3, 1));
		
		inputBox = new JTextField();
		inputBox.setBackground(Color.WHITE);
		frame.getContentPane().add(inputBox);
		inputBox.setColumns(10);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel);
		
		JLabel outputBox = new JLabel();
		frame.getContentPane().add(outputBox);

		JButton encodeButton = new JButton("Encode");
		encodeButton.setBackground(Color.GRAY);
		try{
			//lambda Action listener used last year with luke, this is the encode button.
			encodeButton.addActionListener(e ->{
				System.out.println("Encode Box Clicked");
				String getValue = inputBox.getText();
				if (getValue.length() == 1) {
					outputBox.setText(huff.encodeChar(HuffRun.root, "", getValue.toUpperCase().charAt(0)));
				}
				else if (getValue.length() > 1){
					outputBox.setText(huff.encodeString(HuffRun.root, "", getValue.toUpperCase()));
				}
			});
		}
		catch (NullPointerException e) {
			outputBox.setText("Please enter a value into the top textbox");
		}

		panel.add(encodeButton);
		JButton decodeButton = new JButton("Decode");
		decodeButton.setBackground(Color.GRAY);
		try {
			decodeButton.addActionListener(e -> {
				String getValue = inputBox.getText();
				decodeHuff huffDecode = new decodeHuff();
				outputBox.setText(huffDecode.decode(HuffRun.root,getValue));
				System.out.println(huffDecode.decode(HuffRun.root, getValue));
			});
		}catch (NullPointerException e){
			e.printStackTrace();
			outputBox.setText("Please enter a value into the top textbox");
		}
		panel.add(decodeButton);
	}
}