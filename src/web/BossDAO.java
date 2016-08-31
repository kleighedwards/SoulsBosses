package web;

import java.util.List;

public interface BossDAO 
{
	public List<Boss> getBosses();
	public Boss getFirstBoss();
	public Boss getFindBoss(String name);
	public Boss getBossByNumber(int number);
}
