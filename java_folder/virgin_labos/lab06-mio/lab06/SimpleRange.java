package lab06;

public class SimpleRange implements Range {

    // dichiarazione dei campi da completare

	// initializes a range from start (inclusive) to end (exclusive)
	protected SimpleRange(int start, int end) {
	    // completare
	}

	// returns a range from start (inclusive) to end (exclusive)
	public static SimpleRange withStartEnd(int start, int end) {
	    // completare
	}

	// returns a range from 0 (inclusive) to end (exclusive)
	public static SimpleRange withEnd(int end) {
	    // completare
	}

	// implements the abstract method of Iterable, returns a new SimpleRangeIterator
	@Override
	public SimpleRangeIterator iterator() {
	    // completare
	}

}
