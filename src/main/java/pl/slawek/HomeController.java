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
	public String addOrder(@ModelAttribute Colors c, Orders o, Customer cu, Model m) 
	{
		StringBuilder out = new StringBuilder();
		
		ordersRepo.findAll().forEach(orders -> {
			out.append("Order: ").append(o.getOrderId()).append("<br>");
			
			o.getColors().forEach(colors -> {
				out.append("-").append(c.getColorName()).append("<br>");
			});
			
		});
		
		
	    o.getColors().add(c);
	   // o.getCustomer().add(cu);
		ordersRepo.save(o);
		
		
		customerRepo.save(cu);
		
		c.getOrders().add(o);
		
		colorsRepo.save(c);
		
		m.addAttribute("result", out.toString());
		
		return "result.jsp";
	}
	
	//DODAJ KOLOR DO BAZY
		@RequestMapping("addColors")
		public String addColors(@ModelAttribute Colors c, Orders o, Model m) 
		{
			colorsRepo.save(c);
		m.addAttribute("result", colorsRepo.findById(c.getColorId()));
		
		return "result.jsp";
	}
		//POKAZUJE KOLORY W BAZIE
				@RequestMapping("getColors")
				public String getColors(@ModelAttribute Colors c, Orders o, Model m) 
				{
				
				m.addAttribute("result", colorsRepo.findAll());
				
				return "result.jsp";
			}
				//POKAZUJE KOLORY W BAZIE
				@RequestMapping("getOrders")
				public String getOrders(@ModelAttribute Colors k, Orders o, Model m) 
				{
				
				m.addAttribute("result", ordersRepo.findAll());
				
				return "result.jsp";
			}
		
				
	
}
	