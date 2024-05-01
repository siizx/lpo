package lab06;

/*
 *@ invariant: step != 0
 */

public class StepRange extends SimpleRange {
 
        // dichiarazione dei campi da completare
	int step = 1;

	private static int checkStep(int step){
		if(step ==0) throw new IllegalArgumentException("Step cannot be zero");
		return step;
	}

        // initializes a range from start (inclusive) to end (exclusive) with arbitrary step
	protected StepRange(int start, int end, int step) {
	    // completare
		super(start, end);

		this.step = checkStep(step);
	}

	// returns a range from start (inclusive) to end (exclusive) with arbitrary step
	public static StepRange withStartEndStep(int start, int end, int step) {
	    // completare
		return new StepRange(start,end,checkStep(step));
	}

	// returns a range from start (inclusive) to end (exclusive) with step 1
	public static StepRange withStartEnd(int start, int end) {
	    // completare
		return new StepRange(start, end, 1);
	}

	// returns a range from 0 (inclusive) to end (exclusive) with step 1
	public static SimpleRange withEnd(int end) {
	    // completare
		return new StepRange(0, end, 1);
	}

	// implements the abstract method of Iterable, returns a new StepRangeIterator
	@Override
	public StepRangeIterator iterator() {
	    // completare
	return new StepRangeIterator(this.start, this.end, this.step);
	}

}
