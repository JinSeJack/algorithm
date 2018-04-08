package lintcode;

import java.util.*;
import java.util.Map.Entry;

public class DiceSummer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiceSummer d = new DiceSummer();
		d.dicesSum(1);
	}

	public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
		List<Map.Entry<Integer, Double>> r = new ArrayList<Map.Entry<Integer, Double>>();
		double [][]p = new double[n + 1][6 * n + 1];
		for(int i = 1; i <= 6; i++){
			p[1][i] = 1.0 / 6;
		}
		for(int i = 2; i <= n; i++){
			for(int j = i; j < 6 * n + 1; j++){
				for(int k = 1; k <= 6; k++){
					if(j > k){
						p[i][j] += p[i - 1][j - k];
					}
				}
				p[i][j] /= 6.0;
			}
		}
		for(int i = n; i <= 6 * n; i++){
			r.add(new AbstractMap.SimpleEntry<Integer, Double>(i, p[n][i]));
		}
		
		return r;
    }
}
