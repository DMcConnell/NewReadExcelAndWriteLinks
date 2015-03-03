package travianFarmList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GenerateList extends JFrame
{
	ArrayList<Point> points;
	
	public GenerateList()
	{
		points = ReadExcel.getPoints();
		ArrayList<JTextField> xLabels = new ArrayList<JTextField>();
		ArrayList<JTextField> yLabels = new ArrayList<JTextField>();
		ArrayList<JTextField> links = new ArrayList<JTextField>();
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		for(int i = 0; i < points.size(); i++)
		{
			xLabels.add(new JTextField(String.valueOf(points.get(i).getX())));
			yLabels.add(new JTextField(String.valueOf(points.get(i).getY())));
			links.add(new JTextField("http://ts2.travian.us/karte.php?x=" +
									 String.valueOf(points.get(i).getX()) +
									 "&y=" + String.valueOf(points.get(i).getY())));
		}
		
		JLabel label1 = new JLabel("X Coord");
		JLabel label2 = new JLabel("Y Coord");
		JLabel label3 = new JLabel("Village");
		JLabel label4 = new JLabel("Account");
		JLabel label5 = new JLabel("Link");
		
		c.weightx = .25;
		c.gridx = 0;
		c.gridy = 0;
		add(label1);
		c.gridx = 1;
		add(label2);
		c.gridx = 2;
		add(label3);
		c.gridx = 3;
		add(label4);
		c.gridx = 4;
		c.weightx = 1;
		add(label5);
	}
}
