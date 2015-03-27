package travianFarmList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class GenerateList extends JFrame
{
	ArrayList<Point> points;
	
	public GenerateList()
	{
		class MouseAdapter implements MouseListener
		{
			String link;
			
			public void mouseClicked(MouseEvent e)
			{
				try {
                    Desktop.getDesktop().browse(new URI(link));
                } catch (URISyntaxException | IOException ex) {
                    //It looks like there's a problem
                }
			}
			
			public void setLink(String link)
			{
				this.link = link;
			}
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub	
			}			
		}
		
		points = ReadExcel.getPoints();
		ArrayList<JLabel> xLabels = new ArrayList<JLabel>();
		ArrayList<JLabel> yLabels = new ArrayList<JLabel>();
		ArrayList<JLabel> links = new ArrayList<JLabel>();
		ArrayList<JLabel> villages = new ArrayList<JLabel>();
		ArrayList<JLabel> accounts = new ArrayList<JLabel>();
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		Border BlackBorder = LineBorder.createBlackLineBorder();
		Border GrayBorder = LineBorder.createGrayLineBorder();
		
		for(int i = 0; i < points.size(); i++)
		{
			xLabels.add(new JLabel(String.valueOf((int)points.get(i).getX()), SwingConstants.CENTER));
			yLabels.add(new JLabel(String.valueOf((int)points.get(i).getY()), SwingConstants.CENTER));
			villages.add(new JLabel("-", SwingConstants.CENTER));
			accounts.add(new JLabel("-", SwingConstants.CENTER));
			links.add(new JLabel("<html><a href = \"\">http://ts2.travian.us/karte.php?x=" +
									 String.valueOf(((int)points.get(i).getX()) +
									 "&y=" + String.valueOf((int)points.get(i).getY()))
									 + "</a></html>", SwingConstants.CENTER));
		}
		
		JLabel XLabel = new JLabel("X Coord", SwingConstants.CENTER);
		XLabel.setBorder(BlackBorder);
		JLabel YLabel = new JLabel("Y Coord", SwingConstants.CENTER);
		YLabel.setBorder(BlackBorder);
		JLabel VilLabel = new JLabel("Village", SwingConstants.CENTER);
		VilLabel.setBorder(BlackBorder);
		JLabel AccLabel = new JLabel("Account", SwingConstants.CENTER);
		AccLabel.setBorder(BlackBorder);
		JLabel LinkLabel = new JLabel("Link", SwingConstants.CENTER);
		LinkLabel.setBorder(BlackBorder);
		
		c.weightx = .1; c.gridx = 0; c.gridy = 0;
		add(XLabel, c);
		c.gridx = 1;
		add(YLabel, c);
		c.weightx= .25; c.gridx = 2;
		add(VilLabel, c);
		c.gridx = 3;
		add(AccLabel, c);
		c.gridx = 4; c.weightx = 1;
		add(LinkLabel, c);
		
		for(int i = 0; i < xLabels.size(); i++)
		{
			MouseAdapter mouse = new MouseAdapter();
			
			c.weightx = .1;
			c.gridx = 0;
			c.gridy = i+1;
			xLabels.get(i).setBorder(GrayBorder);
			add(xLabels.get(i), c);
			c.gridx = 1;
			yLabels.get(i).setBorder(GrayBorder);
			add(yLabels.get(i), c);
			c.gridx = 2;
			accounts.get(i).setBorder(GrayBorder);
			add(accounts.get(i), c);
			c.gridx = 3;
			villages.get(i).setBorder(GrayBorder);
			add(villages.get(i), c);
			c.gridx = 4;
			c.weightx = 1;
			mouse.setLink(unformat(links.get(i).getText()));
			links.get(i).setBorder(GrayBorder);
			links.get(i).setCursor(new Cursor(Cursor.HAND_CURSOR));
			links.get(i).addMouseListener(mouse);
			add(links.get(i), c);
		}
	}
	public String unformat(String formatted)
	{
		formatted = formatted.substring(19);
		return formatted.substring(0, formatted.indexOf("<"));
	}
}