
import java.util.*;
public class Main1{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String in = s.nextLine();
        String[] t = in.split(" ");
        String f = t[t.length - 1];
        System.out.println(f.toCharArray().length);
    }
}