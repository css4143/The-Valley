package game.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import game.controller.GameRunnerMVC;
import game.model.Option;
import game.model.Player;
import java.awt.Font;

public class GameUI extends JFrame{

	private JPanel contentPane;
	private GameRunnerMVC controller;
	private JTextArea textArea;
	private JTextPane textPane1;
	private JTextPane textPane2;
	private JTextPane textPane3;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	
	
	public void runEvent(String description, List<Option> options,
			Player player) {
		textPane1.setText("Health: "+player.getHealth());
		textPane2.setText("Money: "+player.getMoney());
		textPane3.setText("Life Satisfaction: "+player.getSatisfaction());
		textArea.setText(description);
		
		if(options == null){
			return;
		}
		
		JButton[] buttons = { button1, button2, button3, button4, button5, button6 };
		
		for(JButton b: buttons){
			b.setText("");
		    for( ActionListener al : b.getActionListeners() ) {
		        b.removeActionListener( al );
		    }
		}
	
		if(options.size() >= 1){
			button1.setText(options.get(0).getDescription());
			button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controller.evaluateOption(options.get(0), player);
				}
			});
		}
		if(options.size() >= 2){
			button2.setText(options.get(1).getDescription());
			button2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controller.evaluateOption(options.get(1), player);
				}
			});
		}
		if(options.size() >= 3){
			button3.setText(options.get(2).getDescription());
			button3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controller.evaluateOption(options.get(2), player);
				}
			});
		}
		if(options.size() >= 4){
			button4.setText(options.get(3).getDescription());
			button4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controller.evaluateOption(options.get(3), player);
				}
			});
		}
		if(options.size() >= 5){
			button5.setText(options.get(4).getDescription());
			button5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controller.evaluateOption(options.get(4), player);
				}
			});
		}
		if(options.size() >= 6){
			button6.setText(options.get(5).getDescription());
			button6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controller.evaluateOption(options.get(5), player);
				}
			});
		}
	}

	/**
	 * Create the frame.
	 */
	public GameUI(GameRunnerMVC controller) {
		this.controller = controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(10, 25, 455, 196);
		textArea.setText("");
		contentPane.add(textArea);
		
		textPane1 = new JTextPane();
		textPane1.setBounds(10, 0, 149, 20);
		textPane1.setText("Health: 50");
		contentPane.add(textPane1);
		
		textPane2 = new JTextPane();
		textPane2.setBounds(169, 0, 134, 20);
		textPane2.setText("Money: 50");
		contentPane.add(textPane2);
		
		textPane3 = new JTextPane();
		textPane3.setBounds(313, 0, 134, 20);
		textPane3.setText("Satisfaction: 50");
		contentPane.add(textPane3);
		
		button1 = new JButton("");
		button1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button1.setBounds(10, 230, 222, 40);
		contentPane.add(button1);
		
		button2 = new JButton("");
		button2.setBounds(243, 230, 222, 40);
		contentPane.add(button2);
		
		button3 = new JButton("");
		button3.setBounds(10, 281, 222, 40);
		contentPane.add(button3);
		
		button4 = new JButton("");
		button4.setBounds(243, 281, 222, 40);
		contentPane.add(button4);
		
		button5 = new JButton("");
		button5.setBounds(10, 332, 222, 40);
		contentPane.add(button5);
		
		button6 = new JButton("");
		button6.setBounds(243, 332, 222, 40);
		contentPane.add(button6);
	}
}
