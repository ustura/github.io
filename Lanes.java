/*
Constraints 
2 <= N <= 100000 
1 <= T <= 1000 
0 <= i < j < N 
2 <= j-i+1 <= min(N,1000) 
1 <= width[k] <= 3, where 0 <= k < N



8 5
2 3 1 2 3 2 3 3
0 3
4 6
6 7
3 5
0 7

Sample Output #00

1
2
3
2
1
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Lanes {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        int N=2;
        int T=1;
        int i=0, j=0;
        Integer[] width = null;
        int[] ti = null;
        int[] tj = null;
        
        Scanner scn = new Scanner(System.in);
        
        N = scn.nextInt();
        if (N<2 || N > 100000) { return; }
        System.err.println("N: " + N);
        
        T = scn.nextInt();
        if (T<1 || T > 1000) { return; }
        System.err.println("T: " + T);
        
        width = new Integer[N];
        
        i=0;
        while (i<N) {
            width[i] = scn.nextInt();
            i++;
        }

        i=0;
        ti = new int[T];
        tj = new int[T];
        
        while (i<T) {
            ti[i] = scn.nextInt();
            tj[i] = scn.nextInt();
            i++;
        }

				//End of input
        List<Integer> aSegmentList = null; 
        Integer[] aSegmentArr = null; 
        i=0;
        while (i<T) {
            
            aSegmentArr = Arrays.copyOfRange(width,ti[i],tj[i]+1);
            aSegmentList = new ArrayList<Integer>(aSegmentArr.length);
            aSegmentList = Arrays.asList(aSegmentArr);
            System.out.println(Collections.min(aSegmentList));
            i++;
        }
    }
}



