package web;

public class Boss 
{
	private String name;
	private String location;
	private String weapon;
	private String optional;
	private String summons;
	private String weaknesses;
	
	public Boss(){}
	
	public Boss(String name, String location, String summons, String weapon,
				String weaknesses, String optional)
	{
		this.name = name;
		this.location = location;
		this.weapon = weapon;
		this.optional = optional;
		this.summons = summons;
		this.weaknesses = weaknesses;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getLocation() 
	{
		return location;
	}
	
	public void setLocation(String location) 
	{
		this.location = location;
	}
	
	public String getWeapon() 
	{
		return weapon;
	}
	
	public void setWeapon(String weapon) 
	{
		this.weapon = weapon;
	}
	
	public String getOptional() 
	{
		return optional;
	}
	
	public void setOptional(String optional) 
	{
		this.optional = optional;
	}
	
	public String getSummons() 
	{
		return summons;
	}
	
	public void setSummons(String summons) 
	{
		this.summons = summons;
	}
	
	public String getWeaknesses() 
	{
		return weaknesses;
	}
	
	public void setWeaknesses(String weaknesses) 
	{
		this.weaknesses = weaknesses;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Location: " + location + ", Weapon: " + weapon + ", Optional: " + optional
				+ ", Summons: " + summons + ", Weaknesses: " + weaknesses;
	}
	
	
}
