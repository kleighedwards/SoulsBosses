package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DarkSoulsController 
{
	@Autowired
	private BossDAO bossDAO;
	
	@RequestMapping("Souls.do")
	public ModelAndView findBoss(@RequestParam("Light the Bonfire") String bonfire)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view.jsp");
		mv.addObject("result", bossDAO.getBossByName());
		
		return mv;	
	}
}
