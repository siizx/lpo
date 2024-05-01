package decorators;

import java.awt.Color;

public class DecoratorTest {

	public static void main(String[] args) {
		var circle = new Circle(4);
		var coloredCircle = new ColoredShape(circle, Color.blue);
		System.out.println(circle);
		// a circle of radius 4.0
		System.out.println(coloredCircle);
		// a circle of radius 4.0 with color java.awt.Color[r=0,g=0,b=255]
		assert circle.area() == coloredCircle.area();
		assert circle.perimeter() == coloredCircle.perimeter();
		assert !circle.equals(coloredCircle) && !coloredCircle.equals(circle);
		assert coloredCircle.equals(new ColoredShape(new Circle(4), Color.blue));
		assert !coloredCircle.equals(new ColoredShape(new Circle(5), Color.blue));
		assert !coloredCircle.equals(new ColoredShape(new Circle(4), Color.red));
	}

}
