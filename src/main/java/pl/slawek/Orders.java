package pl.slawek;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Orders {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	@Column
	private String customerName;
	
	@Column
	private String color1;
	
	@Column
	private String color2;
	
	@Column
	private String color3;
	

@OneToMany(cascade=CascadeType.ALL)
@JoinTable(name="color1",joinColumns=@JoinColumn(name="colorId"),inverseJoinColumns=@JoinColumn(name="orderId"))
private Collection<Colors> colors=new ArrayList<>();

@OneToMany(cascade=CascadeType.ALL)
@JoinTable(name="color2",joinColumns=@JoinColumn(name="colorId"),inverseJoinColumns=@JoinColumn(name="orderId"))
private Collection<Colors> colors2=new ArrayList<>();

@OneToMany(cascade=CascadeType.ALL)
@JoinTable(name="color3",joinColumns=@JoinColumn(name="colorId"),inverseJoinColumns=@JoinColumn(name="orderId"))
private Collection<Colors> colors3=new ArrayList<>();


public Orders() {}


public Orders(Long orderId, String customerName, String color1, String color2, String color3, Collection<Colors> colors,
		Collection<Colors> colors2, Collection<Colors> colors3) {
	super();
	this.orderId = orderId;
	this.customerName = customerName;
	this.color1 = color1;
	this.color2 = color2;
	this.color3 = color3;
	this.colors = colors;
	this.colors2 = colors2;
	this.colors3 = colors3;
}



public String getColor2() {
	return color2;
}


public void setColor2(String color2) {
	this.color2 = color2;
}


public String getColor3() {
	return color3;
}


public void setColor3(String color3) {
	this.color3 = color3;
}


public Collection<Colors> getColors2() {
	return colors2;
}


public void setColors2(Collection<Colors> colors2) {
	this.colors2 = colors2;
}


public Collection<Colors> getColors3() {
	return colors3;
}


public void setColors3(Collection<Colors> colors3) {
	this.colors3 = colors3;
}


public Long getOrderId() {
	return orderId;
}

public void setOrderId(Long orderId) {
	this.orderId = orderId;
}

public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public String getColor1() {
	return color1;
}

public void setColor1(String color1) {
	this.color1 = color1;
}

public Collection<Colors> getColors() {
	return colors;
}

public void setColors(Collection<Colors> colors) {
	this.colors = colors;
}

@Override
public String toString() {
	return "Orders [orderId=" + orderId + ", customerName=" + customerName + ", color1=" + color1 + ", color2=" + color2
			+ ", color3=" + color3 + ", colors=" + colors + ", colors2=" + colors2 + ", colors3=" + colors3 + "]";
}



	
}
