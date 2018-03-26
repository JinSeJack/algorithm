package lintcode;

public class KMaxNum {

	/**
	 * 利用快速排序找第k大的数
	 * @param n
	 * @param low
	 * @param high
	 * @param k
	 * @return
	 */
	public static int quickSort(int n[], int low, int high, int k){
		int m = 0;
		if(low < high){
			int a = quickSortPart(n, low, high);
			if(a == k - 1)
				return n[a];
			quickSort(n, low, a - 1, k);
			quickSort(n, a + 1, high, k);
		}
		return n[k - 1];
	}
	
	public static int quickSortPart(int n[], int low, int high) {
		int c = n[low];
		while (low < high) {
			while (low < high && n[high] <= c)
				--high;
			n[low] = n[high];
			while (low < high && n[low] >= c)
				++low;
			n[high] = n[low];
		}
		n[low] = c;
		return low;
	}

	public static void main(String[] args) {
		int num[] = { 2, 3, 5, 6, 1, 34, 65 };
		System.out.println(quickSort(num, 0, 6, 3));
		
	}

}
