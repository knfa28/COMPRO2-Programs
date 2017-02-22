import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConcatGUI extends JFrame implements ActionListener{
	JTextField string1;
	JTextField string2;
	JTextField sum;
	JButton addButton;

	public ConcatGUI()
	{
		setTitle("String Adder");
		setSize(200,150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		string1 = new JTextField();
		string1.setSize(100,20);
		string1.setLocation(10,10);
		
		string2 = new JTextField();
		string2.setSize(100,20);
		string2.setLocation(10,40);
		
		addButton = new JButton("+");
		addButton.setSize(50,20);
		addButton.setLocation(120,20);
		
		sum = new JTextField();
		sum.setSize(100,20);
		sum.setLocation(10,70);
		
		addButton.addActionListener(this);
		
		add(string1);
		add(string2);
		add(addButton);
		add(sum);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == addButton){
			String concatenated = string1.getText() + string2.getText();
			sum.setText(concatenated);
		}
	}
}