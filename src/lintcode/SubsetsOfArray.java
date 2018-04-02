package lintcode;

import java.util.ArrayList;
import java.util.List;




public class SubsetsOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubsetsOfArray s = new SubsetsOfArray();
		int[] nums = {1, 5, 2, 3};
		s.subsets(nums);
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> r = new ArrayList<List<Integer>>();
		boolean[] f = new boolean[nums.length];
		sort(nums);
		deal(r, nums, 0, f);
//		ArrayList<Integer> t = new ArrayList<Integer>();
//		getR(r, nums, 0, t);
		return r;
		
	}

	
	
	private void sort(int[] nums) {
		// TODO Auto-generated method stub
		quickSort(nums, 0, nums.length - 1);
	}

	private void quickSort(int[] nums, int low, int high) {
		// TODO Auto-generated method stub
		if(low >= high){
			return;
		}
		int a = low;
		int b = high;
		int t = nums[low];
		while(a < b){
			while(a < b && nums[b] >= t){
				b--;
			}
			nums[a] = nums[b];
			while(b > a && nums[a] <= t){
				a++;
			}
			nums[b] = nums[a];
		}
		nums[a] = t;
		quickSort(nums, 0, a - 1);
		quickSort(nums, a + 1, high);
	}

	private void getR(List<List<Integer>> r, int[] nums, int i, ArrayList<Integer> t) {
		// TODO Auto-generated method stub
		if(i == nums.length){
			r.add(t);
			return;
		}
		getR(r, nums, i + 1, t);
		t.add(nums[i]);
		getR(r, nums, i + 1, t);
	}

	private void deal(List<List<Integer>> r, int[] nums, int i, boolean[] f) {
		// TODO Auto-generated method stub
		if(i == nums.length){
			ArrayList<Integer> l = new ArrayList<Integer>();
			for(int j = 0; j < nums.length; j++){
				if(f[j])
				l.add(nums[j]);
			}
			r.add(l);
			i--;
			return;
		}
		f[i] = true;
		deal(r, nums, i + 1, f);
		f[i] = false;
		deal(r, nums, i + 1, f);
	}

}
