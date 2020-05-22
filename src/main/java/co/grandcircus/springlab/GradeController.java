package co.grandcircus.springlab;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.jdbcintro.entity.Room;
import co.grandcircus.morespring.Person;


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
//	@PostMapping("/rooms/add")
//	public String submitAdd(Room room) {		
//		roomsDao.create(room);
//		
//		return "redirect:/rooms";
//	}
	
	@PostMapping("/confirmation")
	public String submitAdd(Grade grade) {		
		gradeDao.create(grade);
		
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
	
	@RequestMapping("form/confirmation")
	public String detail(@RequestParam("id") Long id, Model model) {
		Grade grade = gradeDao.findById(id);
		System.out.println(grade);
		model.addAttribute("grade", grade);
		return "confirmation";
	}
}









