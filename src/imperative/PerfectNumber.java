package imperative;
import java.util.*;

public class PerfectNumber {
	
	public enum STATE{
		DEFICIENT, PERFECT, ABUNDANT
	}
	
	public static Set<Integer> divisors(int n){
		Set<Integer> Div = new HashSet<Integer>();
		for(int i=1; i<=n; i++) {
			if(n%i == 0) {
				Div.add(i);
			}
		}
		return Div;
	}

	public static STATE process(int n) {
		if(n == 1) return STATE.DEFICIENT;
		Set<Integer> Div = new HashSet<Integer>();
		Div = divisors(n);
		int total = 0;
		Iterator<Integer> Each = Div.iterator();
		while (Each.hasNext()) {
		   total+= (int)Each.next();
		}
		total-=n;
		if (total < n ) return STATE.DEFICIENT;
		if (total == n ) return STATE.PERFECT;
		return STATE.ABUNDANT;			
	}
}