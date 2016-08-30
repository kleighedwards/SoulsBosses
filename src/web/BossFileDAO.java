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
	private static final String FILE_NAME="/WEB-INF/boss.csv";
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
				String[] tokens = line.split("|");
				String name = tokens[0];
				String location = tokens[1];
				String summons = tokens[4];
				String weapon = tokens[5];
				String weakness = tokens[6];
				String optional = tokens[7];
				bosses.add(new Boss( name, location, summons, weapon, weakness, optional));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Override
	public Boss getBossByName() 
	{
		return null;
	}
	
}
