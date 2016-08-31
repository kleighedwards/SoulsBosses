package web;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;


public class BossFileDAO implements BossDAO
{
	private static final String FILE_NAME="/WEB-INF/bosses.csv";
	private List<Boss> bosses = new ArrayList<>();
	
	@Autowired 
	private WebApplicationContext wac;

	/*
	 * The @PostConstruct method is called by Spring after 
	 * object creation and dependency injection
	 */
	@PostConstruct
	public void init() {
		// Retrieve an input stream from the servlet context
		// rather than directly from the file system
		try (
				InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));
			) {
			String line;
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(":");
				String number = tokens[0];
				String name = tokens[1];
				String location = tokens[2];
				String summons = tokens[3];
				String weapon = tokens[4];
				String weakness = tokens[5];
				String optional = tokens[6];
				bosses.add(new Boss(number, name, location, summons, weapon, weakness, optional));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		
		for (Boss boss : bosses) {
			System.out.println(boss);
		}
	}

	@Override
	public List<Boss> getBosses() 
	{
		return bosses;
	}

	@Override
	public Boss getFirstBoss() 
	{
		return bosses.get(0);
	}

	@Override
	public Boss getFindBoss(String name) {
		Boss b = null;
		
		for(Boss boss : bosses)
		{
			if (boss.getName().equals(name))
			{
				b = boss;
				break;
			}
		}
			
			return b;
	}
	
}
