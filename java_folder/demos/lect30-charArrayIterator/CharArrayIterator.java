//package demos.lect30;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.util.Objects.requireNonNull;

public class CharArrayIterator implements Iterator<Character> {
    private final Character[] array;
    private int nextIndex;

    public CharArrayIterator(Character[] array) {
        this.array = requireNonNull(array);
    }

    public boolean hasNext() {
        return nextIndex < array.length;
    }

    public Character next() {
        if (!hasNext())
            throw new NoSuchElementException();
        return array[nextIndex++];
    }

    public static void main(String[] args) {
        Character[] a = new Character[] { 'a', 'b', 'c' };
        Iterator<Character> it = new CharArrayIterator(a);
        Iterator<Character> it2 = new CharArrayIterator(a);
        String res = "";
        while (it.hasNext()) {
            res += it.next();
        }
        assert res.equals("abc") && !it.hasNext() && it2.hasNext();
    }
}