package travianFarmList;

import java.util.ArrayList;

public class ReadSource
{
	ArrayList<Point> points = new ArrayList<Point>();
	
	public ReadSource(String source)
	{
		boolean stillTrue = true;
		
		source = source.substring(source.indexOf("<span class='koord'>"),source.indexOf("</table></div"));
		while(stillTrue)
		{
			int x, y, check;
			
			x = Integer.parseInt(source.substring(50,source.indexOf("</span></span>")));
			source = source.substring(source.indexOf("<span class='koordk2'>"));
			y = Integer.parseInt(source.substring(28,source.indexOf("</span> )")));
			check = source.indexOf("<span class='koord'>");
			System.out.println(check + "  ");
			if(check == -1)
				break;
			source = source.substring(check);
			points.add(new Point((double)x,(double)y));
		}
		for(int x = 0; x < points.size(); x++)
			System.out.println(points.get(x));
	}
}
