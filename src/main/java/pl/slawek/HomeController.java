package pl.slawek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@Autowired
	OrdersRepo ordersRepo;
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	ColorsRepo colorsRepo;
	
	
	@RequestMapping("/")
	public String home(Model m) {
		
		m.addAttribute("result",colorsRepo.findAll());
		return "home.jsp";
	}
	
	//DODAJE ZLECENIE DO BAZY
	@RequestMapping("addOrder")
	public String addOrder(@ModelAttribute Orders z, Model m) 
	{
		ordersRepo.save(z);
		m.addAttribute("result",ordersRepo.findAll());
		
		return "result.jsp";
	}
	
	//DODAJ KOLOR DO BAZY
		@RequestMapping("addColors")
		public String addColors(@ModelAttribute Colors k, Model m) 
		{
			colorsRepo.save(k);
		m.addAttribute("result", colorsRepo.findById(k.getColorId()));
		
		return "result.jsp";
	}
	
	
}
	