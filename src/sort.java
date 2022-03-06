import java.util.ArrayList;


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
        if(low > high) return;
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
        System.out.println("HIGH: " + high + ", " + "LOW: " +  low + ", ");

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

public class sort {
    public static void main(String[] args) {
        int array[] = {0, 2, 8, 6, 7, 4, 5, 8, 1, 9, 2};
//        int array[] = {0, 2, 9, 1, 5};
        QuickSort qs = new QuickSort();
        int high = array.length -1 ;
        int low = 0;
        qs.sortArray(array, high, low);

    }
}
