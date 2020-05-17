package algorithm.categories.binarySearch;

public class Sqrt69 {

	public static void main(String[] args) {
		Sqrt69 sqrt69=new Sqrt69();
		int res=0;
			res=sqrt69.mySqrt(2147395599);
	}
	public int mySqrt(int x) {
		int l=0;int r=x;
		while(l<r){
			long mid=l+r>>>1;
			int intMid=(int)mid;
			long c=mid*mid;
			long n=(mid+1)*(mid+1);
			//小于0超过了int最大值，肯定比x大
			if(c>x){
				r=intMid;
			}else if (c==x){
				return intMid;
			}else if (c<x){
				//小于0超过了int最大值，肯定比x大
				if(n>x){
					return intMid;
				}
				if(n==x){
					return intMid+1;
				}
				l=intMid+1;
			}
		}
		return l;
	}
}
