import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class MostFrequentElement {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> result = new HashMap<>();

        for(int i= 0 ; i < nums.length; i++){
            if(nums[i] %2 == 1){
                continue;
            }
            if(!result.containsKey(nums[i])){
                result.put(nums[i], 1);
            }else {
                int current = result.get(nums[i]);
                result.put(nums[i], current+ 1);
            }
        }

        if(result.size() == 0) return -1;

        ArrayList<Integer> r1 = new ArrayList<>();
        ArrayList<Integer> r2 = new ArrayList<>();

        Set<Integer> keys = result.keySet();
        int highest = -1;

        for(Integer key: keys){
            int value = result.get(key);
            if( value > highest ){
                highest = value;
            }
        }

        int lowest = 10000000;
        for(Integer key: keys){
            int value = result.get(key);
            if( value >= highest && key <= lowest){
                lowest = key;
            }
        }

        return lowest;
    }

    public static void main(String[] args) {
       int[] nums = {0,1,2,2,4,4,1};

       System.out.println(new MostFrequentElement().mostFrequentEven(nums));

    }
}
