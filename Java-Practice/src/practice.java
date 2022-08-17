import java.util.List;

public class practice {

    static void printArray(int[] array) {
        for (int num : array) {
            System.out.println(num);
        }
    }

    static void rotateArray(int[] array, int rotateKey) {
        if (rotateKey > array.length) {
            rotateKey = rotateKey % array.length;
        }

        System.out.println(rotateKey);

        int[] result = new int[array.length];
        int resultIndex = 0;

        for (int i = rotateKey + 1; i < array.length; i++) {
            result[resultIndex++] = array[i];
        }

        for (int i = 0; i <= rotateKey; i++) {
            result[resultIndex++] = array[i];
        }

        printArray(result);

    }

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5,6,7};
        int rotateKey = 3;

        rotateArray(array, rotateKey);


    }
}

