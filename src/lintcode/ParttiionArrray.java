package lintcode;

public class ParttiionArrray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int [] a = {7,7,9,8,6,6,8,7,9,8,6,6};
		int b = partitionArray(a, 10);
		System.out.println(b);
	}

	



	public static int partitionArray(int[] nums, int k) {
        // write your code here
        int count = 0;
        int i = 0;
        int j = nums.length - 1;
        if(j == 0)
            return 0;
        while(i < j){
            while(i < j && nums[i] < k){
                i++;count++;
            }
            
            while(i < j && nums[j] >= k){
                j--;
            }
            if(i < j){
            nums[i] = nums[i] + nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] = nums[i] - nums[j];
        }}
        
        return count;
    }
}
