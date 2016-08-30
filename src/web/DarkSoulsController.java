package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DarkSoulsController 
{
	@Autowired
	private BossDAO bossDAO;
	
	@RequestMapping("Souls.do")
	public ModelAndView firstBoss(String firstBoss)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view.jsp");
		mv.addObject("firstBoss", bossDAO.getFirstBoss());
		mv.addObject("bossList", bossDAO.getBosses());
		return mv;	
	}
	
	@RequestMapping("DropDown.do")
	public ModelAndView findBoss(String menu)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view.jsp");
		mv.addObject("bossList", bossDAO.getBosses());
		
		return mv;	
	}
}
