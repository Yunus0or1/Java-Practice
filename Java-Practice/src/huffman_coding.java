
import java.util.*;

class Item {
    String character;
    int freq;

    Item left;
    Item right;

    public Item(String character, int freq) {
        this.character = character;
        this.freq = freq;
    }
}

class HuffManComparator implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return o1.freq - o2.freq;
    }
}

public class huffman_coding {

    private static void printHuffMan(Item item, String type) {
        if (item.left == null || item.right == null) {
            System.out.println(item.character + ":" + type);
            return;
        }

        printHuffMan(item.left, type + "0");
        printHuffMan(item.right, type + "1");
    }

    public static void main(String[] args) {

        PriorityQueue<Item> pQueue = new PriorityQueue<Item>(new HuffManComparator());

        pQueue.add(new Item("a", 5));
        pQueue.add(new Item("b", 9));
        pQueue.add(new Item("c", 12));
        pQueue.add(new Item("d", 13));
        pQueue.add(new Item("e", 16));
        pQueue.add(new Item("f", 45));

        while (pQueue.size() > 1) {
            Item item1 = pQueue.poll();
            Item item2 = pQueue.poll();

            Item newItem = new Item(item1.character + "-" + item2.character,
                    item1.freq + item2.freq);

            newItem.left = item1;
            newItem.right = item2;

            pQueue.add(newItem);
        }

        Item root2 = pQueue.poll();
        printHuffMan(root2, "");
    }
}
