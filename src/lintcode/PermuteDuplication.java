package lintcode;

import java.util.ArrayList;
import java.util.List;

public class PermuteDuplication {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> r = new ArrayList<List<Integer>>();
		if (nums.length == 0) {
			r.add(new ArrayList<Integer>());
			return r;
		}

		List<Integer> t = new ArrayList<Integer>();
		getPermute(r, nums, 0, nums.length - 1);
		return r;
	}

	private void getPermute(List<List<Integer>> r, int[] nums, int k, int l) {
		// TODO Auto-generated method stub

		if (k == l) {
			List<Integer> t = new ArrayList<Integer>();
			for (int i : nums) {
				t.add(i);
			}
			r.add(t);
		} else {
			for (int i = k; i <= l; i++) {
				if (isok(nums, k, i)) {
					swap(nums, k, i);
					getPermute(r, nums, k + 1, l);
					swap(nums, k, i);
				}
			}
		}
	}

	private boolean isok(int[] nums, int k, int i) {
		for (int j = k; j < i; j++)
			if (nums[j] == nums[i])
				return false;
		return true;
	}

	private void swap(int[] nums, int k, int i) {
		// TODO Auto-generated method stub
		int a = nums[k];
		nums[k] = nums[i];
		nums[i] = a;
	}

	public static void main(String[] args) {
		PermuteDuplication p = new PermuteDuplication();
		int n[] = { 1, 2, 2 };
		p.permute(n);

	}

}
