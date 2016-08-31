package web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("oldBoss")
public class DarkSoulsController 
{
	@Autowired
	private BossDAO bossDAO;
	
	@ModelAttribute("oldBoss")
	public Boss initSessionObject() 
	{
		return null;
	}
	
	@RequestMapping("Souls.do")
	public ModelAndView firstBoss(String firstBoss)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view.jsp");
		mv.addObject("firstBoss", bossDAO.getFirstBoss());
		mv.addObject("bossList", bossDAO.getBosses());
		mv.addObject("oldBoss", bossDAO.getFirstBoss());
		return mv;	
	}
	
	@RequestMapping("DropDown.do")
	public ModelAndView findBoss(@RequestParam("menu") String selected,
								 @RequestParam("button") String button,
								 @ModelAttribute("oldBoss") Boss boss)
	{
		ModelAndView mv = new ModelAndView();
		if (button.equals("Previous"))
		{
			//int currentBossNum = bossDAO.getFindBoss(selected).getNumber();
			int currentBossNum = boss.getNumber();
			if ((currentBossNum - 1) >= 0)
			{				
				boss = bossDAO.getBossByNumber(currentBossNum - 1);
				mv.addObject("oldBoss", boss);	
			}
			if ((currentBossNum - 1) < 0)
			{
				boss = bossDAO.getBossByNumber(18);
				mv.addObject("oldBoss", boss);	
			}
		}
		
		if (button.equals("Next"))
		{
			//int currentBossNum = bossDAO.getFindBoss(selected).getNumber();
			int currentBossNum = boss.getNumber();
			if ((currentBossNum + 1 ) <= 18)
			{
				boss = bossDAO.getBossByNumber(currentBossNum + 1);
				mv.addObject("oldBoss", boss);
			}
			if ((currentBossNum + 1) > 18)
			{
				boss = bossDAO.getBossByNumber(0);
				mv.addObject("oldBoss", boss);
			}
		}
		
		if (button.equals("Feeble Cursed One"))
		{
			mv.addObject("selectedBoss", bossDAO.getFindBoss(selected));
			mv.addObject("oldBoss", bossDAO.getFindBoss(selected));	
		}
		
		mv.setViewName("selected.jsp");
		mv.addObject("bossList", bossDAO.getBosses());
		
		return mv;	
	}
}
