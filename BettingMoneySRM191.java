import java.util.*;

class BettingMoneySRM191 {

public static int moneyMade(int[] amounts, int[] centsPerDollar, int finalResult) {
	
	int ret = 0;
	int inp = 0;
	int ndx = 0;
	int pay = 0;
	
	while (ndx < amounts.length) {

		if (ndx == finalResult) {
			pay = (( amounts[ndx] * centsPerDollar[ndx])) ;
		   System.out.println("pay: "+ pay);
		}
		else {
			inp += (amounts[ndx]*100);
		}
		System.out.println("ret: "+ ret);
		
		ndx++;
	}

	System.out.println("inp: "+ inp);
	ret = inp - pay;
	return ret;
}

public static void main(String[] args) {
	
	int[] bets = {100,100,100,100}; 
	int[] pays = {5,5,5,5};
	int fin  = 0;
	
	int tot = BettingMoneySRM191.moneyMade(bets,pays,fin);
	System.out.println("company makes  : " + tot);

}
}
