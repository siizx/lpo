package lab06;

import java.util.NoSuchElementException;

class StepRangeIterator extends SimpleRangeIterator {

        // dichiarazione dei campi da completare
	int step = 1;

	private static int checkStep(int step){
		if(step == 0){
			throw new IllegalArgumentException("Step cannot be 0");
		}
		else return step;
	}

	StepRangeIterator(int next, int end, int step) {
	    // completare
		super(next,end);
		this.step =  checkStep(step);
	}

	@Override
	public boolean hasNext() {
	    // completare
		if(checkStep(step) == 0) {
			throw new IllegalArgumentException("Step must be greater than zero.");
		}else
			if(end > start) return true;
			return false;
	}

	@Override
	public Integer next() {
	    // completare
		if (this.hasNext()) {
			int res = this.start;
			this.start = this.start + step;
			return res;
		}else throw new NoSuchElementException();
	}
}
