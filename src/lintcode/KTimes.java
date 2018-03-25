package lintcode;

import java.util.Scanner;

public class KTimes {

	public int digitCounts(int k, int n) {
		if(k == 0 && n == 0){
			return 1;
		}
		int c = 0;
		int loc = 1;//��ǰλ��
		int locn = 0;//��ǰλ����ֵ
		int hloc = 0;//����λֵ
		int lloc = 0;//����λֵ
		while(n / loc != 0){
			
			
			lloc = n % loc;
			int dealloc = loc;
			loc *= 10;
			locn = n % loc;
			locn = locn / (loc / 10);
			hloc = n / loc;
			if(k == 0 && hloc == 0){
				break;
			}
			
			if(k > locn){
				c += hloc * dealloc;
			}else if(k == locn){
				c += hloc * dealloc + lloc + 1;
			}else{
				c += (hloc + 1) * dealloc;
			}
			
		}
		return c;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		int n = s.nextInt();
		KTimes kt = new KTimes();
		System.out.println(kt.digitCounts(k, n));
	}

}
