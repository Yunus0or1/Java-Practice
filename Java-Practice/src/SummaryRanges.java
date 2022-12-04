// import java.util.ArrayList;
// import java.util.List;

// class SummaryRanges {
//     public List<String> summaryRanges(int[] nums) {
//         if (nums.length == 0)
//             return new ArrayList<String>();

//         List<String> result = new ArrayList<>();
//         String tmp = "";
//         int j = 1;
//         int i = 0;
        
//         while(i != nums.length) {
//             if(i == nums.length - 1){
//                 if(tmp.length() == 0){
                    
//                 }
//             }
//             if (nums[j] - nums[1] != 1) {

//                 if (j == endPoint) {
//                     result.add(Integer.toString(nums[j]));
//                 } else {
//                     result.add(nums[j] + "->" + nums[i]);
//                 }

//                 j = i + 1;
//             }else {
//                 tmp
//             }


//         }

//         System.out.println(result);
//         return result;
//     }

//     public static void main(String[] args) {
//         int[] A = { 0, 2, 3, 4, 6, 8, 9 };
//         SummaryRanges s = new SummaryRanges();
//         s.summaryRanges(A);
//     }
// }
