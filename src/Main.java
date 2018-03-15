import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		char[] temp = input.toCharArray();
		char a = s.next().charAt(0);
		int b = 0;
		for(int i = 0; i < temp.length - 1; i++){
			if(a == temp[i]){
				b++;
			}else if(a<97){
				if(a+32 == temp[i])
					b++;
			}else if(a>=97){
				if(a-32 == temp[i]){
					b++;
				}
			}
		}
		
		System.out.println(b);
	}

}
