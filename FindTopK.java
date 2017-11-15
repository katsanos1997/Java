class FindTopK
{
	public static void main(String[] args){
		int[] values = {2, 5, 15, 34, 6, 12, 10, 15, 3, 9, 4, 23, 2};
		int K = 5;
		printTopK(values, K);
	}
	
	private static void printTopK(int[] values, int K){
		    //int x; tha morouse na exei scanner gia capacity
			PriorityQueue z = new PriorityQueue();
			for (int i =0;i<values.length;i++){
				z.insert(values[i]);
			}
			int [] MaxK= new int [K];
			for (int i =0;i<K;i++){
				MaxK[i]=z.extractMax();
			}
			for (int i=0 ; i<K;i++){
				System.out.println(MaxK[i]);
			}
	}
}
