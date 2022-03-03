package Lab3;

import java.util.concurrent.ForkJoinPool; 
import java.util.concurrent.RecursiveTask; 

class MyThread3 extends RecursiveTask<Integer>{
	
	int start, finish;
	int[] array;
	
	public MyThread3(int[] a, int b, int c) {
		array = a;
		start = b;
		finish = c;
	}
	
	public int partition(int[] A, int P, int Q){
   	 int x = A[P];
   	 int i = P;
   	 
   	 for(int j = P+1; j<=Q; j++) {
   		 if(A[j]<=x) {
   			 i++;
   			 int temp = A[i];
   			 A[i] = A[j];
   			 A[j] = temp;
   		 }
   	 }
   	 
   	 int temp = A[i];
   	 A[i] = A[P];
   	 A[P] = temp;
   	 
   	 return i;
   	 
    }
	
	
	@Override
	protected Integer compute(){
		
		if(start>=finish) {
			return null;
		}
		
		int pivot = partition(array, start, finish);
		
		MyThread3 leftTree = new MyThread3(array, start, pivot-1);
		MyThread3 rightTree = new MyThread3(array, pivot+1, finish);

		leftTree.fork();
		rightTree.compute();
		leftTree.join();
		
		return null;
	}
}

public class Task3 {
	
	public static void main(String[] args) {
		
		int[] myArray = {8,12,1,0,9,20,15,-2};
		
		System.out.println("Unsorted array: ");
		
		for (int j=0; j<myArray.length; j++) {
			System.out.print(myArray[j] + " ");
		}
		
		System.out.println();
		
		ForkJoinPool myPool = ForkJoinPool.commonPool();
		myPool.invoke(new MyThread3(myArray, 0, myArray.length-1));
		
		System.out.println("\nSorted array: ");
		for (int j=0; j<myArray.length; j++) {
			System.out.print(myArray[j] + " ");
		}
		
	}

}
