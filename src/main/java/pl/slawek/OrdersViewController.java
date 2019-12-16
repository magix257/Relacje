package pl.slawek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrdersViewController {
	
	@Autowired
	OrdersRepo ordersRepo;
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	ColorsRepo colorsRepo;
	
	//POKAZUJE ZLECENIA W BAZIE
	@RequestMapping("getOrders")
	public String getOrders(@ModelAttribute Colors c, Orders o, Model m) 
	{
		
		
		StringBuilder out = new StringBuilder();
//		StringBuilder out2 = new StringBuilder();
//		StringBuilder out3 = new StringBuilder();
	
		ordersRepo.findAll().forEach(orders -> {
			out.append("<tr>").append("<td>").append(orders.getOrderId()).append("</td>");
			
			orders.getColors().forEach(colors -> {
				out.append("<td>").append(colors.getColorName()).append(colors.getColorId()).append("</td>");
			});
			
			orders.getColors().forEach(colors -> {
//				 class="form-control"  disabled="disabled" style="background-color: rgb(255,0,0)"></td></tr>");
                 out.append("<td>").append(colors.getR()).append("<td>").append(colors.getG()).append("<td>").append(colors.getB()).append("<td>").append("<input").append(" disabled=\"disabled\" style=\"background-color: "
                 		+ "rgb(").append(colors.getR()).append(",").append(colors.getG()).append(",").append(colors.getB()).append(")\">").append("</td>").append("</tr>");
//				
			});
			
		});
		
m.addAttribute("result", out.toString());
//m.addAttribute("result2", out2.toString());
//m.addAttribute("result3", out3.toString());
		
		return "result.jsp";
}

}
