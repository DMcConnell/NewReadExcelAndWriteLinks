package travianFarmList;

import java.util.ArrayList;

import javax.swing.JFrame;

public class ReadSource
{
	static ArrayList<Point> points = new ArrayList<Point>();
	
	public ReadSource(String source)
	{
		boolean stillTrue = true;
		try
		{
			source = source.substring(source.indexOf("<span class='koord'>"),source.indexOf("</table></div"));
		}
		catch(Exception e)
		{
			stillTrue = false;
			ErrorGUI error1 = new ErrorGUI("   The page source you copied in could not be analyzed.   ");
			error1.setVisible(true);
			error1.setTitle("Error");
			error1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			error1.setLocationRelativeTo(null);
			error1.pack();
		}
		while(stillTrue)
		{
			int x, y, check;
			
			x = Integer.parseInt(source.substring(50,source.indexOf("</span></span>")));
			source = source.substring(source.indexOf("<span class='koordk2'>"));
			y = Integer.parseInt(source.substring(28,source.indexOf("</span> )")));
			check = source.indexOf("<span class='koord'>");
			points.add(new Point((double)x,(double)y));
			if(check == -1)
				break;
			source = source.substring(check);
		}
	}
	
	public static ArrayList<Point> getPoints()
	{
		return points;
	}
}
