package decorators;

import static java.util.Objects.requireNonNull;

public abstract class GenericShapeDecorator<T extends Shape> implements Shape {
	private final T decorated; // the object to be decorated

	protected GenericShapeDecorator(T decorated) {
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
		if (obj instanceof GenericShapeDecorator<?> sd)
			return decorated.equals(sd.decorated);
		return false;
	}

	@Override
	public int hashCode() { // delegation
		return decorated.hashCode();
	}
}
