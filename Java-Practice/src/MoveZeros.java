import java.util.ArrayList;
import java.util.List;

class MoveZeros {
    public void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0;
        for (int i = 0 ; i < nums.length; i ++){
            if(nums[i] == 0){
                continue;
            }else {
                int j = i;
                while(j != lastNonZeroIndex){
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j-1] = temp;
                    j--;
                }
                lastNonZeroIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {0,1,0,3,12};
        MoveZeros s = new MoveZeros();
        s.moveZeroes(A);
    }
}
