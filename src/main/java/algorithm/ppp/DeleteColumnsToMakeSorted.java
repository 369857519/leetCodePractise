package algorithm.ppp;

public class DeleteColumnsToMakeSorted {
	public int minDeletionSize(String[] A) {
		int column=A[0].length();
		int row=A.length;
		char[] record=new char[column];
		int[] res=new int[column];
		if(column<2){
			return 0;
		}else{
			for(int j=0;j<column;j++){
				record[j]=A[0].charAt(j);
			}
			for(int i=0;i<column;i++){
				for(int j=1;j<row;j++){
					if(res[i]==1){
						break;
					}else{
						if(A[j].charAt(i)<record[i]){
							res[i]=1;
						}else{
							record[i]=A[j].charAt(i);
						}
					}
				}
			}
		}
		int resCount=0;
		for(int i=0;i<res.length;i++){
			resCount+=res[i];
		}
		return resCount;
	}
}
