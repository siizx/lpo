package hash;

public interface Set<E> {
	int size();

	boolean isEmpty();

	boolean contains(E element); // in 'java.util.Set' 'element' has type 'Object'

	boolean add(E element); // returns 'true' iff the set has been changed

	boolean remove(E element); // returns 'true' iff the set has been changed
}