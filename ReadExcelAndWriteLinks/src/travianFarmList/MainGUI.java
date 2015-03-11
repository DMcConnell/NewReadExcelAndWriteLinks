package travianFarmList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainGUI extends JFrame
{
	static 	JButton exit, run;
	static JLabel pathLabel;
	static JTextField pathField;
	static JPanel pathPanel, bottomPanel;
	static String path;
	
	public MainGUI()
	{
		event listener = new event();
		
		pathPanel = new JPanel();
		bottomPanel = new JPanel();
		pathLabel = new JLabel("Please enter path to Excel Sheet (with .xls extension): ");
		pathField = new JTextField(30);
		exit = new JButton("Exit");
		run = new JButton("Run");
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		pathPanel.setLayout(new BorderLayout());
		
		run.addActionListener(listener);
		exit.addActionListener(listener);
		
		pathPanel.add(pathLabel, BorderLayout.NORTH);
		pathPanel.add(pathField, BorderLayout.CENTER);
		pathPanel.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.add(run);
		bottomPanel.add(exit);
		
		add(pathPanel);
	}
	
	public class event implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Object source = e.getSource();
			if(source == exit)
				System.exit(99);
			else if(source == run)
			{
				path = pathField.getText();
				ReadExcel read = new ReadExcel(path);
				if(read.getPoints().size() != 0)
				{
					dispose();
					GenerateList go = new GenerateList();
					go.setVisible(true);
					go.setTitle("FarmList Helper V0.1");
					go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					go.setLocationRelativeTo(null);
					go.setSize(750, 500);
				}
			}
		}
	}
	
	public static void main(String [] args)
	{
		MainGUI gui = new MainGUI();
		gui.setVisible(true);
		gui.setTitle("FarmList Helper V0.1");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setLocationRelativeTo(null);
		gui.pack();
	}
}
