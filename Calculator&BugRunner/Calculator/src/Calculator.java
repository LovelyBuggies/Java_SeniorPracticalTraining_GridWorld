import java.awt.event.*;
import java.awt.GridLayout;
import javax.swing.*;

public class Calculator extends JFrame{
	private JTextField firNum;
	private JTextField secNum;
	private JTextField operator;
	private JTextField equal;
	private JTextField resNum;
	private JButton addButton;
	private JButton subButton;
	private JButton mulButton;
	private JButton divButton;
	private JButton finishButton;

	private void Event(){
		addButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				operator.setText(addButton.getText());
			}
		});
		subButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				operator.setText(subButton.getText());
			}
		});
		mulButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				operator.setText(mulButton.getText());
			}
		});
		divButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				operator.setText(divButton.getText());
			}
		});
		MouseAdapter ma = new MouseAdapter(){ public void mouseClicked(MouseEvent e){
				Double first = Double.parseDouble(firNum.getText());
				Double second = Double.parseDouble(secNum.getText());
				System.out.println(first.toString() + " " + second.toString());
				Double result = 0.0;
				if(operator.getText().toString().equals("+")){
					result = first + second;
				}
				else if(operator.getText().toString().equals("-")){
					result = first - second;
				}
				else if(operator.getText().toString().equals("*")){
					result = first * second;
				}
				else if(operator.getText().toString().equals("/")){
					result = first / second;
				}
				System.out.println(operator.getText().toString());
				resNum.setText(result.toString());
			}};
		finishButton.addMouseListener(ma);
	}

	public Calculator(){
		setSize(500, 200);
		setLayout(new GridLayout(2, 5, 10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		firNum = new JTextField(5);
		add(firNum);
		operator = new JTextField(5);
		operator.setEditable(false);
		add(operator);
		secNum = new JTextField(5);
		add(secNum);
		equal = new JTextField(5);
		equal.setEditable(false);
		add(equal);
		resNum = new JTextField(5);
		resNum.setEditable(false);
		add(resNum);

		addButton = new JButton("+");
		add(addButton);
		subButton = new JButton("-");
		add(subButton);
		mulButton = new JButton("*");
		add(mulButton);
		divButton = new JButton("/");
		add(divButton);
		finishButton = new JButton("Finish");
		add(finishButton);

		Event();
		setVisible(true);
	}

	public static void main(String[] arg){
		new Calculator();
	}

}
