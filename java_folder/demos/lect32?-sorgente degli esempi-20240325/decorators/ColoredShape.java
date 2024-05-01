package decorators;

import java.awt.Color;
import static java.util.Objects.requireNonNull;
import static java.util.Objects.hash;

public class ColoredShape extends ShapeDecorator {

	private final Color color;

	public ColoredShape(Shape decorated, Color color) {
		super(decorated);
		this.color = requireNonNull(color);
	}

	@Override
	public String toString() {
		return super.toString() + " with color " + color;
	}

	@Override
	public final boolean equals(Object obj) {
		return super.equals(obj) && (obj instanceof ColoredShape cs) && color.equals(cs.color);
	}

	@Override
	public final int hashCode() {
		return hash(super.hashCode(), color.hashCode());
	}
}
