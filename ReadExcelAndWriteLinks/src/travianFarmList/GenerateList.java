package travianFarmList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GenerateList extends JFrame
{
	ArrayList<Point> points;
	
	public GenerateList()
	{
		points = ReadExcel.getPoints();
		ArrayList<JTextField> xLabels = new ArrayList<JTextField>();
		ArrayList<JTextField> yLabels = new ArrayList<JTextField>();
		ArrayList<JTextField> links = new ArrayList<JTextField>();
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		Border border = LineBorder.createGrayLineBorder();
		
		for(int i = 0; i < points.size(); i++)
		{
			xLabels.add(new JTextField(String.valueOf(points.get(i).getX())));
			yLabels.add(new JTextField(String.valueOf(points.get(i).getY())));
			links.add(new JTextField("http://ts2.travian.us/karte.php?x=" +
									 String.valueOf(points.get(i).getX()) +
									 "&y=" + String.valueOf(points.get(i).getY())));
		}
		
		JButton label1 = new JButton("X Coord");
		JButton label2 = new JButton("Y Coord");
		JButton label3 = new JButton("Village");
		JButton label4 = new JButton("Account");
		JButton label5 = new JButton("Link");
		
		c.weightx = .1;
		c.gridx = 0;
		c.gridy = 0;
		//label1.setBorder(border);
		add(label1, c);
		c.gridx = 1;
		add(label2, c);
		c.gridx = 2;
		add(label3, c);
		c.gridx = 3;
		add(label4, c);
		c.gridx = 4;
		c.weightx = 1;
		add(label5, c);
	}
}
