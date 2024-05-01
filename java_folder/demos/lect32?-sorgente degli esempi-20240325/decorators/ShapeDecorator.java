package decorators;

import static java.util.Objects.requireNonNull;

public abstract class ShapeDecorator implements Shape {
	private final Shape decorated; // the object to be decorated

	protected ShapeDecorator(Shape decorated) {
		this.decorated = requireNonNull(decorated);
	}

	@Override
	public double perimeter() {
		return decorated.perimeter(); // delegation
	}

	@Override
	public double area() { // delegation
		return decorated.area();
	}

	@Override
	public String toString() { // delegation
		return decorated.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof ShapeDecorator sd)
			return decorated.equals(sd.decorated);
		return false;
	}

	@Override
	public int hashCode() { // delegation
		return decorated.hashCode();
	}
}
