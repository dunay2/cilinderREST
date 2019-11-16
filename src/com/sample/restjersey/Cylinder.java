package com.sample.restjersey;

public class Cylinder {
	
private double radio;
private double height;
private static final double PI=3.1416;

public Cylinder(double radio, double height) {
	super();
	this.radio = radio;
	this.height = height;
}
public double getRadio() {
	return radio;
}
public double getHeight() {
	return height;
}

public double getBaseArea() {
	return PI*radio*radio;
}

public double getSideArea() {
	return 2*PI*radio*height;
}

public double getVolume() {
	return PI*radio*radio*height;
}

public double getSurface() {		
	return 2*getBaseArea()+getSideArea();
}


}
