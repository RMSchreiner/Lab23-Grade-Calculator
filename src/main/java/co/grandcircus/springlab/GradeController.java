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
	
//	@RequestMapping("form/confirmation")
//	public String detail(@RequestParam("id") Long id, Model model) {
//		Grade grade = gradeDao.findById(id);
//		System.out.println(grade);
//		model.addAttribute("grade", grade);
//		return "confirmation";
//	}
//	@PostMapping("/form")
//	public String submitAdd(
//			@RequestParam(value="name",required=true) String name,
//			@RequestParam(value="type",required=true) String type,
//			@RequestParam(value="score",required=true) Double score,
//			@RequestParam(value="total",required=true) Double total,
//			Model model) {
//		  
//		    Double percentage= score/total;
//		
//		model.addAttribute("name", name);
//		model.addAttribute("type", type);
//		model.addAttribute("score", score);
//		model.addAttribute("total", total);
//		model.addAttribute("percentage", percentage);
//		
//		return "confirmation";
//	}
	
}









