import java.util.Scanner;



public class SnakeArray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int c = 1;
		int i = 0;
		int j = n-1;
		int d = 1;
		int[][] r = new int[n][n];
		while(c <= n * n){
			r[i][j] = c++;
			if(isLast(r, i, j, d)){
				if(d + 1 != 4)
					d = (d + 1) % 4;
				else 
					d = 4;
				
			}
			switch (d) {
				case 1: // down
					i++;
					break;
				case 2: // left
					j--;
					break;
				case 3: // up
					i--;
					break;
				case 4: // right
					j++;
					break;
				default:
					break;
			}
			
		}
		for(int k = 0; k < n; k++){
			for(int l = 0; l < n; l++){
				System.out.print(r[k][l] + " ");
			}
			System.out.println();
		}

	}

	private static boolean isLast(int[][] r, int i, int j, int d) {
		int n = r[0].length;
		boolean re = false;
		switch (d){
		case 1: //down
			if(i + 1 == n || r[i + 1][j] != 0){
				re = true;
			}
			break;
		case 2:
			if(j == 0 || r[i][j - 1] != 0){
				re = true;
			}
			break;
		case 3:
			if(i == 0 || r[i - 1][j] != 0){
				re = true;
			}
			break;
		case 4:
			if(j + 1 == n || r[i][j + 1] != 0){
				re = true;
			}
			break;
			
		default:
			break;
	}
		return re;
	}

}
