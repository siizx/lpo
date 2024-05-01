package lab06;

/*
 *@ invariant: step != 0
 */

public class StepRange extends SimpleRange {
 
        // dichiarazione dei campi da completare

        // initializes a range from start (inclusive) to end (exclusive) with arbitrary step
	protected StepRange(int start, int end, int step) {
	    // completare
	}

	// returns a range from start (inclusive) to end (exclusive) with arbitrary step
	public static StepRange withStartEndStep(int start, int end, int step) {
	    // completare
	}

	// returns a range from start (inclusive) to end (exclusive) with step 1
	public static StepRange withStartEnd(int start, int end) {
	    // completare
	}

	// returns a range from 0 (inclusive) to end (exclusive) with step 1
	public static SimpleRange withEnd(int end) {
	    // completare
	}

	// implements the abstract method of Iterable, returns a new StepRangeIterator
	@Override
	public StepRangeIterator iterator() {
	    // completare
	}

}
