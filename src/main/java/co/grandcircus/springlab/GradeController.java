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
		//Here we took the ListofGrades created from the findAll DAO. After iterating through the grade list we calculated
		//the total percentage with getTotal and getScore
		List<Grade>ListofGrades = gradeDao.findAll();
		double total = 0;
		double score = 0;
		for(Grade Grade : ListofGrades) {
		 total = total + Grade.getTotal();
		 score = score + Grade.getScore();
		}
		int percent = (int) (100 * score/total);
		
		String message = null;
		if (percent == 0) {message = "There are no scores to display";}
		
		model.addAttribute("percent", percent);
		model.addAttribute("grades", ListofGrades);
		model.addAttribute("message", message);
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
	
//	@RequestMapping("/delete")
//	public String remove(@RequestParam("id") Long id) {
//		gradeDao.delete(id);
//		return "delete";
//	}
	//by including Model model and assigning to a variable we can "pass" information along from html to html 
	//Remember to include the addAttribute to the html markup
	//http://localhost:8080/delete?id=39&name=Computer%20Gaming%20101   example of mark up
	//<a href ="/delete?id=${grade.id}&name=${grade.name}">Delete</a> example of href link for markup
	
	@RequestMapping("/delete")
	public String deleteApproval(@RequestParam("id") Long id,
			                     @RequestParam("name") String name, 
			                     Model model) {
		Long deleteID = id;
		String testName = name;
		
		model.addAttribute("deleteID", deleteID);
		model.addAttribute("testName", testName);
		
		return "delete";
	}
	
	@RequestMapping("/deleteapproval")
	public String remove(@RequestParam("deleteID") Long deleteID, Model model ) {
		gradeDao.delete(deleteID);
		return "redirect:/";
	}
	
	@RequestMapping("/confirmation/add")
	public String showAdd() {		
		return "confirmation";
	}
}









