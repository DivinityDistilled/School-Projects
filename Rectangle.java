/*  Zane Sanchez
	CS 2336
	Rectangle class
*/
import java.util.Scanner;
public class Rectangle {

	double height=1;
	double width=1;
	
	Rectangle() {
	}
	
	Rectangle(double h,double w) {
		height = h;
		width = w;
	}
	// Getters
	double getArea() {
		return(height*width);
	}
	
	double getPerimeter()  {
		return((height*2)+(width*2));
	}
	
	double getHeight() {
		return height;
	}
	
	double getWidth() {
		return width;
	}
	// Setters
	void setHeight(double h) {
		height = h;
	}
	
	void setWidth(double w) {
		width = w;
	}
	public static void main(String [] args) {
		Rectangle rectangle1 = new Rectangle(40,4);
		System.out.println("Rectangle 1:");
		System.out.println("Width: "+rectangle1.getWidth());
		System.out.println("Height: "+rectangle1.getHeight());
		System.out.println("Area: "+rectangle1.getArea());
		System.out.println("Perimeter: "+rectangle1.getPerimeter());
		
		Rectangle rectangle2 = new Rectangle(35.9,3.5);
		System.out.println("\nRectangle 2:");
		System.out.println("Width: "+rectangle2.getWidth());
		System.out.println("Height: "+rectangle2.getHeight());
		System.out.println("Area: "+rectangle2.getArea());
		System.out.println("Perimeter: "+rectangle2.getPerimeter());
		
	}
	
}

