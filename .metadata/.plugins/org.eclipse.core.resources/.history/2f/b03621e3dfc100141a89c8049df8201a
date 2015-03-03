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
		ArrayList<JEditorPane> panels = new ArrayList<JEditorPane>();
		JPanel pane = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		for(int i = 0; i < points.size(); i++)
		{
			xLabels.add(new JTextField(String.valueOf(points.get(i).getX())));
			yLabels.add(new JTextField(String.valueOf(points.get(i).getY())));
			links.add(new JTextField("http://ts2.travian.us/karte.php?x=" +
									 String.valueOf(points.get(i).getX()) +
									 "&y=" + String.valueOf(points.get(i).getY())));
			panels.add(new JEditorPane());
			panels.get(i).setLayout(new GridBagLayout());
									 
		}
	}
}
