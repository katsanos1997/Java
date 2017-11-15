

class PriorityQueueTest
{
	public static void main(String[] args){
		PriorityQueue pq1 = new PriorityQueue();
		pq1.insert(10);
		pq1.insert(2);
		pq1.insert(12);
		
		System.out.println(pq1);
		
		PriorityQueue pq2 = new PriorityQueue();
		pq2.insert(12);
		pq2.insert(10);
		pq2.insert(2);		
		
		System.out.println(pq2);
		
		if (pq1.equals(pq2)){
			System.out.println("The two queues are the same!");
		}else{
			System.out.println("The two queues are NOT the same!");
		}
		
		System.out.println(pq1);
		System.out.println(pq2);
		 
		pq1.insert(5);
		System.out.println(pq1.extractMax());
		System.out.println(pq1.getMax());
		pq1.merge(pq2);
		System.out.println(pq1);
		
		pq2.insert(2); pq2.insert(5); pq2.insert(10); pq2.insert(12);
		if (pq1.equals(pq2)){
			System.out.println("The two queues are the same!");
		}else{
			System.out.println("The two queues are NOT the same!");
		}
		
	}
}
