package lintcode;

import java.util.ArrayList;
import java.util.List;

public class Permute {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> r = new ArrayList<List<Integer>>();
		if (nums.length == 0) {
			r.add(new ArrayList<Integer>());
			return r;
		}
		
		List<Integer> t = new ArrayList<Integer>();
		getPermute(r, nums, 0, nums.length);
		return r;
	}

	private void getPermute(List<List<Integer>> r, int[] nums, int k, int l) {
		// TODO Auto-generated method stub
		if(k == l){
			List<Integer> t = new ArrayList<Integer>();
			for (int i : nums) {
				t.add(i);
			}
			r.add(t);
			return;
		}else{
			for(int i = k; i < l; i++){
				swap(nums, k, i);
				getPermute(r, nums, k + 1, l);
				swap(nums, k, i);
			}
		}
	}


	private void swap(int[] nums, int k, int i) {
		// TODO Auto-generated method stub
		int a = nums[k];
		nums[k] = nums[i];
		nums[i] = a;
	}

	public static void main(String[] args) {
		Permute p = new Permute();
		int n[] = { 1, 2, 3 };
		p.permute(n);

	}

}
