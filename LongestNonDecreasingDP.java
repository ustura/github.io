import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestNonDecreasingDP {

public static int find(int[] arr) {

    int lnd = 0;
    Integer[] lndArr = new Integer[arr.length];
    
    for (int ndx = 0; ndx < arr.length ; ndx++ ) {
        lndArr[ndx] = 1;
        for (int ndx2 = 0; ndx2 < ndx-1 ; ndx2++ ) {
                
                if ( arr[ndx2] <= arr[ndx] && (1 + lndArr[ndx2]) >  lndArr[ndx]) {
                    lndArr[ndx] = 1 + lndArr[ndx2];
                }
        }
            
    }
    List<Integer> lndList = Arrays.asList(lndArr);

    for (Integer i : lndList) {
     System.out.println(i);        
    }    
    
    return Collections.max(lndList);
}

 public static void main(String[] args) {
     
     //int[] arr = {1,0,3,-1,0,4,5,6,7 };
     int[] arr = {1,0,3,10,10,8,7,6,5 };
     
     int lnd = LongestNonDecreasingDP.find(arr);
     System.out.println("lnd : " + lnd);         
     }
}
