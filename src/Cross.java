import java.util.Scanner;

public class Cross {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int xx = 0; xx < n; xx++) {
			int x = s.nextInt();
			int a = xx + 1;
			System.out.println("Case #" + a + ":");
			if(x == 1){
				System.out.println("o");
				continue;
			}
			int[][] t = initContainer(x);

			printCross(t, xx);

		}

	}

	private static void printCross(int[][] t, int xx) {
		int centeri = (t[0].length + 1) / 2 - 1;
		int cneterj = centeri;
		int a = t[0].length;
		
		setByCenter(t, centeri, cneterj, t[0].length);
		
		for(int i = 0; i < t[0].length; i ++){
			
			for(int j = 0; j < t[0].length; j ++){
				if(t[i][j] == 0){
					System.out.print(" ");
				}else{
					System.out.print("o");
				}
			}
			System.out.println();
		}
	}

	/**
	 * ������Ϊ3��ͼ����Ϊ��С��Ԫ��ӡ���ҵ����ģ����ҳ���Ϊ3ʱ��ʼ��ӡ��ǰλ���Լ���������4��λ�ã�
	 * ���ȴ�����ʱ����С��Ԫ��ͬ����Ϊ���δ����м䲿����Ҫ������ӡ����������Ҫ��
	 * @param t
	 * @param center
	 * @param centerj
	 * @param i
	 */
	private static void setByCenter(int[][] t, int center, int centerj, int i) {
		int cd = i;
		while(cd > 3){
			cd /= 3;
			setByCenter(t, center, centerj, cd);
			
		}
		t[center][centerj] = 1;
		t[center + 1][centerj] = 1;
		t[center][centerj + 1] = 1;
		t[center - 1][centerj] = 1;
		t[center][centerj - 1] = 1;
		// TODO Auto-generated method stub
		if (i/3 == 1) {
			
			return;
		}
		i /= 3;
		setByCenter(t, center - i, centerj, i); //left center
		setByCenter(t, center + i, centerj, i); //right center
		setByCenter(t, center, centerj - i, i); //up center
		setByCenter(t, center, centerj + i, i); //bottom center
	}

	private static int[][] initContainer(int x) {
		int a = 1;

		for (int i = 1; i < x; i++) {
			a *= 3;
		}
		int[][] b = new int[a][a];
		return b;
	}

}
