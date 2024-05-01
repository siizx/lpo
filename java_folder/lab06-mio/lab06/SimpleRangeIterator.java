package lab06;

import java.util.Iterator;
import java.util.NoSuchElementException;

class SimpleRangeIterator implements Iterator<Integer> {

    // dichiarazione dei campi da completare
	int start;
	final int end;
	SimpleRangeIterator(int next, int end) {
	    // completare
		// sembra essere un semplice contruttore, giusto?
		this.start = next;
		this.end = end;
	}

	@Override
	public boolean hasNext() {
	    // completare
		return this.end > this.start;
	}

	@Override
	public Integer next() {
	    // completare
		// The this keyword is optional when calling methods or
		// accessing variables of the current instance.
		// Some developers prefer to use this for clarity,
		// while others prefer to leave it out when it's not necessary.
		// It's mostly a matter of personal preference and coding style.
		// So, you can use either "if (!hasNext()) {" or "if (!this.hasNext()) {".
		// Both are correct and will work the same way.
		if(this.hasNext()) {
			int res = start;
			start++;
			return res;
		}
		throw new NoSuchElementException();
	}

}
