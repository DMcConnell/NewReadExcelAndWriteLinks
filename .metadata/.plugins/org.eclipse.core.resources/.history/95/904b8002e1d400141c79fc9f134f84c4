package travianFarmList;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class parseSource extends JFrame
{
	public parseSource()
	{
		event listener = new event();
		
		JPanel main, flow;
		JLabel expla;
		JTextField text;
		JButton run, exit;
		
		main = new JPanel();
		main.setLayout(new BorderLayout());
		flow = new JPanel();
		flow.setLayout(new FlowLayout());
		expla = new JLabel("Parse in your list:   ");
		run = new JButton("Run");
		exit = new JButton("Exit");
		text = new JTextField();
		run.addActionListener(listener);
		exit.addActionListener(listener);
		main.add(expla, BorderLayout.NORTH);
		main.add(text, BorderLayout.CENTER);
		flow.add(run);
		flow.add(exit);
		main.add(flow, BorderLayout.SOUTH);
		add(main);
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
		parseSource gui = new parseSource();
		gui.setVisible(true);
		gui.setTitle("FarmList Helper V0.1");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setLocationRelativeTo(null);
		gui.pack();
	}
}
