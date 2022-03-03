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


    int[] sortArray(int array[], int high, int low) {
        int partitionIndex = this.partition(array);

        this.sortArray(array, partitionIndex -1, 0);
        this.sortArray(array, array.length-1, partitionIndex);

        return array;
    }

    void printArray (int array[]){
        for (int item: array){
            System.out.println(item);
        }
    }


    int partition(int array[]) {
        int pivot = array.length - 1;
        int secondPivot = 0;

        int n = 0;
        while (n != array.length - 1) {
            if (array[n] >= array[pivot]) {
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

        return secondPivot;
    }
}

public class sort {
    public static void main(String[] args) {
        int array[] = {0, 2, 8, 6, 7, 4, 5, 8, 1, 9, 2};
        QuickSort qs = new QuickSort();
        qs.sortArray(array, array.length, 0);

    }
}
