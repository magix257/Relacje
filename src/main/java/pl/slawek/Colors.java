package pl.slawek;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Colors {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long colorId;

@Column
private String colorName;

@Column
private Integer r;

@Column
private Integer g;

@Column
private Integer b;
	

@ManyToMany
private Collection<Orders> orders=new ArrayList<>();


public Colors() {}


public Colors(Long colorId, String colorName, Integer r, Integer g, Integer b, Collection<Orders> orders) {
	super();
	this.colorId = colorId;
	this.colorName = colorName;
	this.r = r;
	this.g = g;
	this.b = b;
	this.orders = orders;
}


public Long getColorId() {
	return colorId;
}


public void setColorId(Long colorId) {
	this.colorId = colorId;
}


public String getColorName() {
	return colorName;
}


public void setColorName(String colorName) {
	this.colorName = colorName;
}


public Integer getR() {
	return r;
}


public void setR(Integer r) {
	this.r = r;
}


public Integer getG() {
	return g;
}


public void setG(Integer g) {
	this.g = g;
}


public Integer getB() {
	return b;
}


public void setB(Integer b) {
	this.b = b;
}


public Collection<Orders> getOrders() {
	return orders;
}


public void setOrders(Collection<Orders> orders) {
	this.orders = orders;
}


@Override
public String toString() {
	return "Colors [colorId=" + colorId + ", colorName=" + colorName + ", r=" + r + ", g=" + g + ", b=" + b
			+ ", orders=" + orders + "]";
}



}