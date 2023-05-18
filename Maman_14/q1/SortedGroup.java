package q1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a collection of increasingly sorted elements of type T.
 * The elements in the collection must implement the Comparable<T> interface.
 *
 * @param <T> the type of elements in the collection
 */
public class SortedGroup<T extends Comparable<T>> implements Iterable<T> {
    private List<T> elements;

    /**
     * Constructs an empty SortedGroup.
     */
    public SortedGroup() {
        elements = new ArrayList<>();
    }

    /**
     * Adds an element to the collection while maintaining the sorted order.
     *
     * @param element the element to be added
     */
    public void add(T element) {
        elements.add(element);
        Collections.sort(elements);
    }

    /**
     * Removes any equal elements from the collection and returns the amount of removed elements.
     *
     * @param element the element to be removed
     * @return the number of removed elements
     */
    public int remove(T element) {
        int count = 0;
        Iterator<T> iterator = elements.iterator();
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (current.equals(element)) {
                iterator.remove();
                count++;
            }
        }
        return count;
    }

    /**
     * Returns an iterator over the elements in the collection.
     *
     * @return an iterator over the elements
     */
    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }

    /**
     * Returns the list of elements in the collection.
     *
     * @return the list of elements
     */
    public List<T> getElements() {
        return elements;
    }

    /**
     * Returns the number of elements in the collection.
     *
     * @return the size of the collection
     */
    public int size() {
        return elements.size();
    }

    // Additional methods and functionalities can be added here as per your requirements
}
