package travianFarmList;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class parseSource extends JFrame
{
	JButton run, exit;
	JTextArea text;
	
	public parseSource()
	{
		event listener = new event();
		
		JPanel main, flow;
		JLabel expla;
		
		main = new JPanel();
		main.setLayout(new BorderLayout());
		flow = new JPanel();
		flow.setLayout(new FlowLayout());
		expla = new JLabel("Parse in your source code:", SwingConstants.CENTER);
		run = new JButton("Run");
		exit = new JButton("Exit");
		text = new JTextArea();
		text.setBorder(LineBorder.createGrayLineBorder());
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
			{
				System.exit(99);
			}
			else
			{

				ReadSource read = new ReadSource(text.getText());
				if(ReadSource.villages.size() >= 1)
				{
					dispose();
					GenerateList gui = new GenerateList();
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				    Dimension frameSize = gui.getSize();
				    if (frameSize.height > screenSize.height)
				    {
				    	frameSize.height = screenSize.height;
				    }
				    if (frameSize.width > screenSize.width)
				    {
				    	frameSize.width = screenSize.width;
				    }
					gui.setVisible(true);
					gui.setTitle("FarmList Helper V0.1");
					gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					gui.setLocation((screenSize.width - frameSize.width) / 2 - 400,
			                (screenSize.height - frameSize.height) / 2 -200);
					gui.setSize(800,400);
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
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    Dimension frameSize = gui.getSize();
	    if (frameSize.height > screenSize.height)
	    {
	    	frameSize.height = screenSize.height;
	    }
	    if (frameSize.width > screenSize.width)
	    {
	    	frameSize.width = screenSize.width;
	    }
	    gui.setLocation((screenSize.width - frameSize.width) / 2 - 153,
                (screenSize.height - frameSize.height) / 2 - 140);
		gui.setSize(306,280);
	}
}