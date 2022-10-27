import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;


class FVal {
    int number;
    int value;

    FVal(int number, int value){
        this.number = number;
        this.value = value;
    }
}

class MyComparator implements Comparator<FVal> {

    public int compare(FVal a, FVal b) {
        return b.value - a.value;
    }
}

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> result = new HashMap<>();

        Set<Integer> rr = new HashSet<>();

        for(int i= 0 ; i < nums.length; i++){
            if(!result.containsKey(nums[i])){
                result.put(nums[i], 1);
            }else {
                int current = result.get(nums[i]);
                result.put(nums[i], current+ 1);
            }
        }

        PriorityQueue<FVal> pq = new PriorityQueue<FVal>(new MyComparator());
        ArrayList<Integer> r1 = new ArrayList<>();
        Set<Integer> keys = result.keySet();

        for(Integer key: keys){
            int value = result.get(key);
            pq.add(new FVal(key, value));
        }

        for(int i =0 ; i< k; i ++){
            r1.add(pq.poll().number);
        }

        System.out.println(r1);

        int[] r2 = r1.stream().mapToInt(e -> e).toArray();

        return r2;
    }

    public static void main(String[] args) {
       int[] nums = {1,1,1,2,2,3};
       int k = 2;

       new TopKFrequent().topKFrequent(nums,k);

    }
}
