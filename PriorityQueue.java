

import java.util.Arrays;

class PriorityQueue {
	private int capacity;
	private int[] Queue;
	private int thesi;

	public PriorityQueue() {
		capacity = 100;
		Queue = new int[100];
		thesi = 0;
	}

	public PriorityQueue(int cap) {
		Queue = new int[cap];
		capacity = cap;
		thesi = 0;
	}

	public int getCapacity() {
		return capacity;
	}

	public int[] getQueue() {
		int [] q=Queue;
		return q;
	}

	public int getthesi() {
		return thesi;
	}

	public boolean insert(int i) {
		if (thesi == capacity) {
			return false;
		} else {
			if (thesi == 0) {
				Queue[thesi] = i;
				thesi++;
				return true;
			} else {
				if (i <= Queue[0]) {//=
					Queue[thesi] = i;
					thesi++;
					return true;
				} else {
					int tmp = Queue[0];
					Queue[0] = i;
					Queue[thesi] = tmp;
					thesi++;
					return true;
				}
			}
		}
	}
	/*public boolean insert(int i){
		int tmp;
		if(thesi==0){
			Queue[0]=i;
			thesi++;
			return true;
		}
		if(thesi<capacity){
			if(Queue[0]<i){
				tmp=Queue[0];
				Queue[0]=i;
				Queue[thesi]=tmp;
				thesi++;
				return true;
			}else{
				Queue[thesi]=i;
				thesi++;
				return true;
			}	
		}return false;
	}*/

	public int getMax() {
		if (thesi == 0)
			return -1;
		else
			return Queue[0];
	}

	public int extractMax() {
		int max;
		int thesiMax = 0;
		int i;
		if (getMax() == -1) {
			return -1;
		}
		int exMax = Queue[0];
		thesi--;
		for (i = 0; i < thesi; i++) {
			Queue[i] = Queue[i + 1];
		}
		max = Queue[0];
		for (i = 1; i < thesi; i++) {
			if (Queue[i] > max) {
				max = Queue[i];
				thesiMax = i;
			}
		}
		int tmp = Queue[0];
		Queue[0] = Queue[thesiMax];
		Queue[thesiMax] = tmp;
		return exMax;
	}

	public boolean merge(PriorityQueue newQueue) {
		if (newQueue.getthesi() + thesi <= capacity) {
			while (newQueue.getMax() != -1) {
				int x=newQueue.extractMax();
				insert(x);
			}
			return true;
		}
		return false;
	}

	/*
	 * public boolean merge (PriorityQueue newQueue) { if
	 * (newQueue.thesi+thesi<=capacity){ for(int i=0;i<newQueue.thesi;i++){
	 * Queue[thesi]=newQueue.Queue[i]; thesi++; newQueue.thesi++; if
	 * (thesi+newQueue.thesi>capacity){ break; } } newQueue.Queue=null; return
	 * true; }else{return false;} }
	 */

	public String toString() {
		String s = " ";
		int l;
		for (l =0; l < thesi; l++)	
		{
			s += Queue[l] + " ";
		}
		return s;
	}

	   public boolean equals (PriorityQueue newQueue) { 
    	int i;
        if (thesi == newQueue.thesi) {
        	
        	int [] Q1= new int[capacity];                 
        	int [] Q2= new int [newQueue.getCapacity()];               
        	for( i = 0; i < Q1.length; i++){
	        	Q1[i] = Queue[i];
        	}	
        	for( i = 0; i < Q2.length; i++){
	        	Q2[i] = Queue[i];
        	}	
        	Arrays.sort(Q1);
        	Arrays.sort(Q2);
        	
        	for (i=0; i<thesi; i++) {
        		if (Q1[i] != Q2[i]) {
        			return false;
        		}
        	}
        	return true;
        }
        else {
        	return false;
        }
	   }
}
