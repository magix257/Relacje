package pl.slawek;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class OrdersViewController {
	
	@Autowired
	OrdersRepo ordersRepo;
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	ColorsRepo colorsRepo;
	
	//POKAZUJE ZLECENIA W BAZIE
	@RequestMapping("getOrders")
	public String getOrders(@ModelAttribute Colors c, Orders o, Model m) throws JsonProcessingException {
		
		List<Orders> list = new ArrayList<>();
		ordersRepo.findAll().iterator().forEachRemaining(list::add);
		 
		 ObjectMapper Obj = new ObjectMapper(); 
		 
	     String jsonStr = Obj.writeValueAsString(list); 
	  
	     
	        return jsonStr;
		
	
}

}
