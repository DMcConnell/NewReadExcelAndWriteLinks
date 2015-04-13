package travianFarmList;

public class Village
{
	int x,y;
	String city, player;
	
	public Village(int x, int y, String city, String player)
	{
		this.x = x;
		this.y = y;
		this.city = city;
		this.player = player;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getPlayer()
	{
		return player;
	}
}
