

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Custom implementation of a Set using an internal array structure.
 * Ensures unique elements and dynamically adjusts capacity as needed.
 *
 * @param <E> the type of elements maintained by this set
 */
public class CustomSet<E> implements Set<E> {

    private static final int INITIAL_CAPACITY = 15;
    private static final double GROWTH_FACTOR = 1.3;

    private Object[] elements;
    private int size;

    /**
     * Default constructor that initializes the set with default capacity.
     */
    public CustomSet() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    /**
     * Constructor that initializes the set with a single element.
     *
     * @param element the element to add
     */
    public CustomSet(E element) {
        this();
        add(element);
    }

    /**
     * Constructor that initializes the set with elements from a given collection.
     *
     * @param collection the collection of elements to add
     */
    public CustomSet(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @SuppressWarnings("unchecked")
            @Override
            public E next() {
                return (E) elements[currentIndex++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        System.arraycopy(elements, 0, array, 0, size);
        return array;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) java.util.Arrays.copyOf(elements, size, a.getClass());
        }
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(E e) {
        if (e == null) {
            throw new IllegalArgumentException("Null elements are not allowed in CustomSet.");
        }
        if (contains(e)) {
            return false;
        }
        ensureCapacity();
        elements[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                // Shift elements to the left
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                elements[--size] = null; // Avoid memory leaks
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c) {
            if (add(e)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(elements[i])) {
                remove(elements[i--]);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object o : c) {
            if (remove(o)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * Ensures the internal array has enough capacity to accommodate additional elements.
     * If not, increases the capacity based on the growth factor.
     */
    private void ensureCapacity() {
        if (size >= elements.length) {
            int newCapacity = (int) (elements.length * GROWTH_FACTOR);
            Object[] newElements = new Object[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}