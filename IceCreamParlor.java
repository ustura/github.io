
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IceCreamParlor {

	public static int[] pickTwo(final int M, final int[] cost) {
		int[] ret = new int[2];
		
		int i=0;
		int j=0;
		
		all:
		while( i < cost.length) {
			
			int other = M-cost[i];

			j = i+1;
			while( j < cost.length) {
				if (other == cost[j]) {
					break all;
				}
				j++;
			}
			i++;
		}
		ret[0]=i+1;
		ret[1]=j+1;
		
		return ret;
	}
	
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner scn = new Scanner(System.in);
        
        int T = 0;
        int M;
        int N;
        int[] cost = null;
        int[][] pick = null;
        
        if (scn.hasNextInt() ) {
			T = scn.nextInt();
		}
		
		pick = new int[T][];
		int j=0;

		while (T-- >0) {
			M = scn.nextInt();
			N = scn.nextInt();

			cost = new int[N];
			//pick[j] = new int[2];
			int i=0;

			while (N-- >0) {
				cost[i++] = scn.nextInt();
			}
			
			pick[j++] = pickTwo(M,cost);
		}

        //System.out.println("pick.length : " + pick.length ) ;//p[0] + " " + p[1]);

        for(int k=0; k< pick.length; k++) {
            int[] p = pick[k];
            System.out.println(p[0] + " " + p[1]);
        }
        
    }
}
