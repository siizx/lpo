package decorators;

import static java.util.Objects.hash; // computes efficient hash codes

public class Circle implements Shape {
	private double radius;

	protected Circle(double radius) {
		if (radius <= 0)
			throw new IllegalArgumentException();
		this.radius = radius;
	}

	@Override
	public double perimeter() {
		return 2 * Math.PI * this.radius;
	}

	@Override
	public double area() {
		return Math.PI * this.radius * this.radius;
	}

	@Override
	public String toString() {
		return "a circle of radius " + radius;
	}

	@Override // redefines 'equals()' of 'Object'
	// 'final' means cannot be redefined in subclasses
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof Circle c)
			return radius == c.radius;
		return false;
	}

	@Override // redefines hashCode()' of 'Object'
	public final int hashCode() {
		return hash(radius);
	}
}
