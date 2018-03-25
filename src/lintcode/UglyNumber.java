package lintcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UglyNumber {

	public static int nthUglyNumber(int n) {
		Queue<Integer> q2 = new LinkedList<Integer>();
		Queue<Integer> q3 = new LinkedList<Integer>();
		Queue<Integer> q5 = new LinkedList<Integer>();
		int a[] = new int[n];
		a[0] = 1;
		q2.add(2);
		q3.add(3);
		q5.add(5);
		int v2 = 0;
		int v3 = 0;
		int v5 = 0;
		int val = 0;
		for(int i = 0; i < n - 1; i++){
			v2 = q2.peek();
			v3 = q3.peek();
			v5 = q5.peek();
			val = Math.min(v2, (Math.min(v3, v5)));
			if(v2 == val){
				q2.add(2 * val);
				q3.add(3 * val);
				q2.remove();
			}
			if(v3 == val){
				q3.add(3 * val);
				q3.remove();
			}
			if(v5 == val){
				q5.remove();
			}
			q5.add(5 * val);
			a[i + 1] = val;
		}
		System.out.println("a");
		return a[n - 1];
    }
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		System.out.println(nthUglyNumber(n));
	}
}
