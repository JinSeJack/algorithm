package lintcode;

public class MergerArray {

	public static int[] mergeSortedArray(int[] a, int[] b) {
		int c[] = new int[a.length + b.length];
		int al = 0;
		int bl = 0;
		int i = 0;
		while(i < c.length){
			if(al == a.length){
				c[i] = b[bl++];
				i++;
				continue;
			}
			if(bl == b.length){
				c[i] = a[al++];
				i++;
				continue;
			}
			if(a[al] <= b[bl]){
				c[i] = a[al++];
			}else{
				c[i] = b[bl++];
			}
			i++;
		}
		return c;
		
	}
	
	public static void main(String[] args) {
		int a[] = { 2, 3, 5, 6 };
		int b[] = { 2, 4, 5, 7 };
		mergeSortedArray(a, b);
	}

}
