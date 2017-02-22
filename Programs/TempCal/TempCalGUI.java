import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class TempCalGUI extends JFrame implements ActionListener{
		JTextField inputBox;
		JButton convertButton;
		JButton clearButton;
		JLabel lblConvert;
		JLabel lblResult;
		JPanel[] panel = new JPanel[3];
		
	public TempCalGUI(){

		setTitle("TempCalculator");
		setSize(380, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(3,1));
		
		for(int i = 0; i < 3; i++){
			panel[i] = new JPanel();
			panel[i].setBorder(BorderFactory.createLineBorder(Color.black));
			panel[i].setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		}
		
		JLabel celcius = new JLabel("Celcius:");
		celcius.setSize(50,20);
		celcius.setLocation(10,20);
		
		inputBox = new JTextField(10);
		inputBox.setSize(100,20);
		inputBox.setLocation(70,20);
		
		convertButton = new JButton("Convert");
		convertButton.setSize(80,20);
		convertButton.setLocation(180,20);
		
		clearButton = new JButton("Clear");
		clearButton.setSize(80,20);
		clearButton.setLocation(220,20);
		
		JLabel lblFarenheit = new JLabel("Farenheit:");
		lblFarenheit.setSize(50,20);
		lblFarenheit.setLocation(10,50);
		
		lblConvert = new JLabel();
		lblConvert.setSize(50,20);
		lblConvert.setLocation(10,50);
		lblConvert.setVisible(false);
		
		JLabel lblForecast = new JLabel("Forecast:");
		lblForecast.setSize(50,20);
		lblForecast.setLocation(10,80);
		
		lblResult = new JLabel();
		lblResult.setSize(50,20);
		lblResult.setLocation(10,50);
		lblResult.setVisible(false);
		
		convertButton.addActionListener(this);
		clearButton.addActionListener(this);
		
		panel[0].add(celcius);
		panel[0].add(inputBox);
		panel[0].add(convertButton);
		panel[0].add(clearButton);
		panel[1].add(lblFarenheit);
		panel[1].add(lblConvert);
		panel[2].add(lblForecast);
		panel[2].add(lblResult);
		
		add(panel[0]);
		add(panel[1]);
		add(panel[2]);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == convertButton){
			double tempVal = Double.parseDouble(inputBox.getText());
			TempCalculator tc = new TempCalculator(tempVal);
			lblConvert.setText(Double.toString(tc.convertCelToFah()));
			lblConvert.setVisible(true);
			lblResult.setText(tc.getTempForecast('c'));
			lblResult.setVisible(true);
		}
		else if(event.getSource() == clearButton){
			inputBox.setText(null);
			lblConvert.setVisible(false);
			lblResult.setVisible(false);
		}
	}
}