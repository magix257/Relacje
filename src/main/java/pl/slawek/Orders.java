package pl.slawek;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Orders {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	
@ManyToMany(mappedBy = "orders")
private Collection<Colors> colors=new ArrayList<>();

//@OneToMany(mappedBy = "orders")
//private Collection<Customer> customer=new ArrayList<>();


public Orders() {}

public Orders(Long orderId, Collection<Colors> colors) {
	super();
	this.orderId = orderId;
	this.colors = colors;
}

public Long getOrderId() {
	return orderId;
}

public void setOrderId(Long orderId) {
	this.orderId = orderId;
}

public Collection<Colors> getColors() {
	return colors;
}

public void setColors(Collection<Colors> colors) {
	this.colors = colors;
}

@Override
public String toString() {
	return "Orders [orderId=" + orderId + ", colors=" + colors + "]";
}



}