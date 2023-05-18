package q1;

/**
 * A utility class for reducing a SortedGroup by removing elements that are less than or equal to a given value.
 */
public class CollectionReducer {

    /**
     * Reduces a SortedGroup by removing elements that are less than or equal to a given value.
     *
     * @param sGroup The SortedGroup to reduce.
     * @param x      The value to compare against.
     * @param <T>    The type of elements in the SortedGroup, must implement Comparable.
     * @return A new SortedGroup containing the elements that are greater than the given value.
     */
    public static <T extends Comparable<T>> SortedGroup<T> reduce(SortedGroup<T> sGroup, T x) {
        SortedGroup<T> result = new SortedGroup<>();

        for (T element : sGroup.getElements()) {
            if (element.compareTo(x) > 0) {
                result.add(element);
            }
        }

        return result;
    }
}
