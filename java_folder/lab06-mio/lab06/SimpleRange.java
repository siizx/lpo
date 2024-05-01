package lab06;

public class SimpleRange implements Range {

    // dichiarazione dei campi da completare
	// un range ha un inizio ed una fine.. quindi:

	final int start;
	final int end;

	// initializes a range from start (inclusive) to end (exclusive)
	protected SimpleRange(int start, int end) {
	    // completare
		// inizializza i campi di questo oggetto: (costruttore)
		this.start = start;
		this.end = end;
	}

	// returns a range from start (inclusive) to end (exclusive)
	// e' un static factory method. factory perche' il suo scopo e'
	// creare nuove istanze SimpleRange.
	// perche' si usano i factory methods?
	// semplicemente perche' possiamo attribuirgli nomi piu descrittivi!
	public static SimpleRange withStartEnd(int start, int end) {
	    // completare
		return new SimpleRange(start,end);
		// infatti quando lo andremo a chiamare sapremo sia su
		// quale classe stiamo lavorando e anche quali parametri
		// passare, e in quale ordine.

	}

	// returns a range from 0 (inclusive) to end (exclusive)
	public static SimpleRange withEnd(int end) {
	    // completare
		// altro static factory method.
		//questo lascia a zero (default value) start, e end = end.
		return new SimpleRange(0,end);
	}

	// implements the abstract method of Iterable, returns a new SimpleRangeIterator
	@Override
	public SimpleRangeIterator iterator() {
	    // completare
		// mi sembra che stiamo creando un nuovo oggetto iterator, ma gli servono
		// i valori dell'oggetto su cui deve iterare.
		// in questo caso:
		return new SimpleRangeIterator(this.start, this.end);
	}

}
