package hash;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashSet<E> implements Set<E> {
	static final int DEFAULT_CAPACITY = 16;
	private int size;
	private final ArrayList<LinkedList<E>> buckets;
	private int capacity;

	public HashSet(int capacity) {
		if (capacity < 0)
			throw new IllegalArgumentException();
		this.capacity = capacity;
		buckets = new ArrayList<>(capacity);
		for (int i = 0; i < capacity; i++) {
			buckets.add(new LinkedList<E>()); // appends a new empty bucket
		}
	}

	public HashSet() {
		this(DEFAULT_CAPACITY);
	}

	private int hash(E e) { // uses 'int hashCode()'
		return Math.abs(e.hashCode() % capacity); // '%' = reminder operator
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(E element) {
		return buckets.get(hash(element)).contains(element);
	}

	public boolean add(E element) {
		var b = buckets.get(hash(element));
		if (b.contains(element))
			return false;
		size++;
		return b.add(element); // appends the new element
	}

	public boolean remove(E element) {
		var removed = buckets.get(hash(element)).remove(element);
		if (removed)
			size--;
		return removed;
	}
}