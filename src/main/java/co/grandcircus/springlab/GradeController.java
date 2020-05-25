package co.grandcircus.springlab;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GradeController {
	
	@Autowired 
	private GradeDao gradeDao;
	
	@RequestMapping("/form")
	public String index() {
		
		return"form";
		//return "form";	
	}
	
	@RequestMapping("/")
	public String list(Model model) {
		List<Grade>ListofGrades = gradeDao.findAll();
		double total = 0;
		double score = 0;
		for(Grade Grade : ListofGrades) {
		 total = total + Grade.getTotal();
		 score = score + Grade.getScore();
		}
		int percent = (int) (100 * score/total);
		
		model.addAttribute("percent", percent);
		model.addAttribute("grades", ListofGrades);
		return "index";
	}

	@PostMapping("/confirmation")
	public String submitAdd(Grade grade, Model model) {	
		Double percentage = 100 * grade.getScore()/grade.getTotal();
		grade.setPercentage(percentage);
		gradeDao.create(grade);
		model.addAttribute("grade", grade);
		return "confirmation";
	}
	
	@RequestMapping("/delete")
	public String remove(@RequestParam("id") Long id) {
		gradeDao.delete(id);
		return "redirect:/";
	}
	
	@RequestMapping("/confirmation/add")
	public String showAdd() {		
		return "confirmation";
	}
	
    
	
}









