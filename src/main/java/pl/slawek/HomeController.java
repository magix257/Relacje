package pl.slawek;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
				public String getColors(@ModelAttribute Colors c, Orders o, Model m) 
				{
				
				m.addAttribute("result", colorsRepo.findAll());
				
				return "result.jsp";
			}
		//POKAZUJE ZLECENIA W BAZIE
				@RequestMapping("getOrders")
				public String getOrders(@ModelAttribute Colors c, Orders o, Model m) 
				{
					
					
					StringBuilder out = new StringBuilder();
//					StringBuilder out2 = new StringBuilder();
//					StringBuilder out3 = new StringBuilder();
				
					ordersRepo.findAll().forEach(orders -> {
						out.append("<tr>").append("<td>").append(orders.getOrderId()).append("</td>");
						
						orders.getColors().forEach(colors -> {
							out.append("<td>").append(colors.getColorName()).append("</td>");
						});
						
						orders.getColors().forEach(colors -> {
//							 class="form-control"  disabled="disabled" style="background-color: rgb(255,0,0)"></td></tr>");
                             out.append("<td>").append(colors.getR()).append("<td>").append(colors.getG()).append("<td>").append(colors.getB()).append("<td>").append("<input").append(" disabled=\"disabled\" style=\"background-color: "
                             		+ "rgb(").append(colors.getR()).append(",").append(colors.getG()).append(",").append(colors.getB()).append(")\">").append("</td>").append("</tr>");
//							
						});
						
					});
					
 m.addAttribute("result", out.toString());
// m.addAttribute("result2", out2.toString());
// m.addAttribute("result3", out3.toString());
					
					return "result.jsp";
			}
		
				
	
}
	