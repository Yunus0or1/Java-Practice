import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        int half = nums.length / 3;
        List<Integer> ree = new ArrayList<>();
        HashMap<Integer, Integer> result = new HashMap<>();

        for(int i= 0 ; i < nums.length; i++){
            if(!result.containsKey(nums[i])){
                result.put(nums[i], 1);
            }else {
                int current = result.get(nums[i]);
                result.put(nums[i], current+ 1);
            }
        }
        Set<Integer> keys = result.keySet();
        for(Integer key: keys){
            if(result.get(key) > half){
                ree.add(key);
            }
        }

        return ree;
    }

    public static void main(String[] args) {
       int[] nums = {2,2,1,1,1,2,2};

       System.out.println(new MajorityElement().majorityElement(nums));

    }
}
