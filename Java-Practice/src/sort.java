class BinarySearch {
    private int array[] = {3, 4, 5, 6, 7, 8, 9};


    void searchElement(int item) {
        int startPoint = 0;
        int endPoint = this.array.length - 1;

        while (startPoint <= endPoint) {
            int guess = ((startPoint + endPoint) / 2);
            System.out.println(startPoint + " " + endPoint + " " + guess);

            if (item == this.array[guess]) {
                System.out.println("FOUND AT: " + guess);
                return;
            } else if (item > this.array[guess]) {
                startPoint = guess + 1;
            } else if (item < this.array[guess]) {
                endPoint = guess - 1;
            }

        }

        System.out.println("Did not find the item");

    }
}


class QuickSort {

    void sortArray(int array[], int high, int low) {
        if (low > high) return;
        int partitionIndex = this.partition(array, high, low);

        this.sortArray(array, partitionIndex - 1, low);
        this.sortArray(array, high, partitionIndex + 1);

    }

    void printArray(int array[]) {
        for (int item : array) {
            System.out.print(item);
            System.out.print(", ");
        }
        System.out.println("");
    }


    int partition(int array[], int high, int low) {
        System.out.println("HIGH: " + high + ", " + "LOW: " + low + ", ");

        int pivot = high;
        int secondPivot = low;

        int n = low;
        while (n != high) {
            if (array[n] <= array[pivot]) {
                int temp = array[n];
                array[n] = array[secondPivot];
                array[secondPivot] = temp;

                secondPivot = secondPivot + 1;
            }

            n = n + 1;
        }

        int temp = array[pivot];
        array[pivot] = array[secondPivot];
        array[secondPivot] = temp;

        System.out.println("PI: " + secondPivot);
        System.out.print("Sorted: ");
        this.printArray(array);
        return secondPivot;
    }
}

class MergeSort {
    void mergeArray(int[] array, int left, int mid, int right) {
        System.out.println("LEFT: " + left + ", " + "MID: " + mid + ", " + "RIGHT: " + right + ",");

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];


        for (int i = 0; i < n1; i++) {
            L[i] = array[i + left];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = array[mid + 1 + j];
        }

        System.out.print("L ");
        this.printArray(L);

        System.out.print("R ");
        this.printArray(R);

        int i = 0;
        int j = 0;
        int n = left;

        while (i != L.length && j != R.length) {
            if (L[i] >= R[j]) {
                array[n] = L[i];
                i = i + 1;
            } else if (R[j] > L[i]) {
                array[n] = R[j];
                j = j + 1;
            }
            n = n + 1;
        }

        // Pushing the rest
        while (i != L.length) {
            array[n] = L[i];
            n++;
            i++;
        }

        while (j != R.length) {
            array[n] = R[j];
            n++;
            j++;
        }

    }

    void divideArray(int[] array, int left, int right, String type) {
        if (left >= right) return;

        int mid = (left + right) / 2;
//        System.out.println(left + ", " + mid + ", " + right + "," + type);
        this.divideArray(array, left, mid, "F");
        this.divideArray(array, mid + 1, right, "S");

        this.mergeArray(array, left, mid, right);
    }

    void printArray(int array[]) {
        for (int item : array) {
            System.out.print(item);
            System.out.print(", ");
        }
        System.out.println("");
    }
}

class HeapSort {
    void heapSortMax(int array[]) {
        int n = array.length;
        int totalNonLeaf = (n / 2) - 1;

        for (int i = totalNonLeaf; i >= 0; i--) {
            maxHeapify(array, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            maxHeapify(array, i, 0);
        }

        this.printArray(array);
    }

    void heapSortMin(int array[]) {
        int n = array.length;
        int totalNonLeaf = (n / 2) - 1;

        for (int i = totalNonLeaf; i >= 0; i--) {
            minHeapify(array, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            minHeapify(array, i, 0);
        }
    }

    void minHeapify(int[] array, int n, int root) {
        int lowest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < n && array[left] < array[lowest]) {
            lowest = left;
        }

        if (right < n && array[right] < array[lowest]) {
            lowest = right;
        }

        if (lowest != root) {
            int temp = array[lowest];
            array[lowest] = array[root];
            array[root] = temp;

            minHeapify(array, n, lowest);
        }
    }

    void maxHeapify(int[] array, int n, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        // In the last leaf, left/right could be bigger than n
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != root) {
            int temp = array[root];
            array[root] = array[largest];
            array[largest] = temp;

            maxHeapify(array, n, largest);
        }
    }

    void printArray(int array[]) {
        for (int item : array) {
            System.out.print(item);
            System.out.print(", ");
        }
        System.out.println("");
    }
}

public class sort {

    public static void main(String[] args) {

//        int array[] = {0, 2, 9, 1, 5};
//        QuickSort qs = new QuickSort();
//        int high = array.length -1 ;
//        int low = 0;
//        qs.sortArray(array, high, low);

//        int array[] = {0, 2, 8, 6, 7, 4, 5, 8, 1, 9, 2};
//        MergeSort ms = new MergeSort();
//        ms.divideArray(array, 0, array.length - 1, "MAIN");
//        ms.printArray(array);


        int array[] = {0, 2, 8, 6, 7, 4, 5};
        HeapSort hs = new HeapSort();
        hs.heapSortMin(array);

    }
}
