import java.util.Comparator;
import java.util.List;

public class QuickSort {
    public static <T> void quickSort(List<T> list, Comparator<? super T> comparator) {
        quickSortHelper(list, 0, list.size() - 1, comparator);
    }

    private static <T> void quickSortHelper(List<T> list, int low, int high, 
                                            Comparator<? super T> comparator) {
        if (low < high) {
            int partitionIndex = partition(list, low, high, comparator);
            
            quickSortHelper(list, low, partitionIndex - 1, comparator);
            quickSortHelper(list, partitionIndex + 1, high, comparator);
        }
    }

    private static <T> int partition(List<T> list, int low, int high, 
                                     Comparator<? super T> comparator) {
        T pivot = list.get(high);
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (comparator.compare(list.get(j), pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }
        
        swap(list, i + 1, high);
        return i + 1;
    }

    private static <T> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}