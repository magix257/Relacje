package pl.slawek;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
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
				
				@RequestMapping(value="/getColors", method=RequestMethod.GET)
			   
				public ModelAndView getColors(ModelAndView mv) throws IOException {
					
					List<Colors> list = new ArrayList<>();
					 colorsRepo.findAll().iterator().forEachRemaining(list::add);
					 
					 ObjectMapper Obj = new ObjectMapper(); 
					 String jsonStr = Obj.writeValueAsString(list);
					 JsonFactory factory = new JsonFactory();
					 JsonParser  parser  = factory.createParser(jsonStr);
					 parser.close();
					 
					 
//				      
//				     
//						FileWriter fstream = new FileWriter("src\\main\\webapp\\json_demo.txt",false);
//						
//						fstream.write(jsonStr);
//						fstream.close();
				     
				//List<Colors> colors = new Gson().fromJson(Obj, new TypeToken<List<Colors>>()       {}.getType());
				     mv.addObject("Colors", jsonStr);
				     mv.setViewName("result.jsp");
				  
				     
				       return mv;

}

}
	