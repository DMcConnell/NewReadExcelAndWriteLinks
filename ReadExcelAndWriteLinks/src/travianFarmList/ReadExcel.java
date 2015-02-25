package travianFarmList;

import java.io.File;
import java.util.*;

import javax.swing.JFrame;

import jxl.*;

public class ReadExcel
{
	public static ArrayList<Point> points = new ArrayList<Point>();
	
	public ReadExcel(String path)
	{
		int rows = 0, cols = 0;
		boolean pass = true;
		try
		{
			Workbook workbook = Workbook.getWorkbook(new File(path));
			Sheet sheet = workbook.getSheet(0);
			rows = sheet.getRows();
			cols = sheet.getColumns();
			if(cols > 2)
			{
				ErrorGUI error1 = new ErrorGUI("   There are too many columns.   ");
				error1.setVisible(true);
				error1.setTitle("Error");
				error1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				error1.setLocationRelativeTo(null);
				error1.pack();
				pass = false;
			}
			if(pass == true)
			{
				Cell cell1;
				Cell cell2;
				NumberCell cellA;
				NumberCell cellB;
	
				for(int i = 0; i < rows; i++)
				{
					cell1 = sheet.getCell(0,i);
					cell2 = sheet.getCell(1,i);
					if(cell1.getType() != CellType.NUMBER ||cell2.getType() != CellType.NUMBER)
					{
						ErrorGUI error1 = new ErrorGUI("   At least one cell is not only a number.   ");
						error1.setVisible(true);
						error1.setTitle("Error");
						error1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						error1.setLocationRelativeTo(null);
						error1.pack();
						pass = false;
						break;
					}
					else
					{
						cellA = (NumberCell) cell1;
						cellB = (NumberCell) cell2;
						Point point = new Point(cellA.getValue(), cellB.getValue());
						points.add(point);
					}
				}
			}
			workbook.close();
		}
		catch(Exception e)
		{
			ErrorGUI error = new ErrorGUI("   The file at the path you specified could not be found.   ");
			error.setVisible(true);
			error.setTitle("Error");
			error.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			error.setLocationRelativeTo(null);
			error.pack();
		}
	}
	
	public static ArrayList<Point> getPoints()
	{
		return points;
	}
}