package pl.slawek;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class HomeController {

	@Autowired
	OrdersRepo ordersRepo;
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	ColorsRepo colorsRepo;
	
	
	@RequestMapping("/")
	@ResponseBody
	public ModelAndView home(@ModelAttribute Colors c, Orders o, ModelAndView mv) {
		
		mv.addObject("result", customerRepo.findAll());
		mv.setViewName("home.jsp");
		
		return mv;
		
	}
	
	//DODAJE ZLECENIE DO BAZY
	@RequestMapping("addOrder")
	public String addOrder(@ModelAttribute Colors c, Orders o, Customer cu, Model m) 
	{
		StringBuilder out = new StringBuilder();
		
	
		ordersRepo.save(o);
		  o.setColors(new ArrayList<>());
		  o.getColors().add(c);
		  c.setOrders(new ArrayList<>());
		  c.getOrders().add(o);
		  colorsRepo.save(c);
		
		
		customerRepo.save(cu);
		
		
		ordersRepo.findAll().forEach(orders -> {
			out.append("Order: ").append(orders.getOrderId());
			
			orders.getColors().forEach(colors -> {
				out.append("Kolor: ").append(colors.getColorName()).append(" ").append(colors.getR()).append(colors.getG()).append(colors.getB()).append("<br>");
			});
			
		});
		
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
				public String getColors() throws JsonProcessingException {
					
					List<Colors> list = new ArrayList<>();
					 colorsRepo.findAll().iterator().forEachRemaining(list::add);
					 
					 ObjectMapper Obj = new ObjectMapper(); 
					 
				     String jsonStr = Obj.writeValueAsString(list); 
				  
				     
				        return jsonStr;

}

}
	