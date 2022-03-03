package Lab3;

public class Task2 {
		
	private volatile static int maxCount = 0;
	private volatile static int maxInt;
	
	synchronized private static void find(int maxThread, int intMaxThread) {
		
		if(maxThread > maxCount) {
			maxCount = maxThread;
			maxInt = intMaxThread;
		}
	
	}
	
	private static class MyThread2 extends Thread{
		int start, finish;
		
		public MyThread2(int a, int b) {
			start = a;
			finish = b;
		}
		
		public void run() {
			
			int maximumDivisor = 0;
			int maximumInt = 0;
			
			for(int i = start; i<=finish; i++) {
				
				int divisor = count(i);
				
				if(divisor > maximumDivisor) {
					maximumDivisor = divisor;
					maximumInt = i;
				}
			}
			
			find(maximumDivisor, maximumInt);
			
		}
	}
	
	public static int count(int number) {
		
		int total = 0;
		
		for(int i = 1; i<=number/2; i++) {
			if(number % i == 0) {
				total++;
			}
		}
		
		return (total+1);
		
	}
	
	public static void main(String[] args) {
		
		MyThread2 thread1 = new MyThread2(1, 10000);
		MyThread2 thread2 = new MyThread2(10001, 20000);
		MyThread2 thread3 = new MyThread2(20001, 30000);
		MyThread2 thread4 = new MyThread2(30001, 40000);
		MyThread2 thread5 = new MyThread2(40001, 50000);
		MyThread2 thread6 = new MyThread2(50001, 60000);
		MyThread2 thread7 = new MyThread2(60001, 70000);
		MyThread2 thread8 = new MyThread2(70001, 80000);
		MyThread2 thread9 = new MyThread2(80001, 90000);
		MyThread2 thread10 = new MyThread2(90001, 100000);
		
		long time1 = System.nanoTime();
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
		thread8.start();
		thread9.start();
		thread10.start();
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
			thread5.join();
			thread6.join();
			thread7.join();
			thread8.join();
			thread9.join();
			thread10.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long time2 = System.nanoTime();
		
		System.out.println(maxInt + " has the largest number of divisors between 1 and 100000. Divisor Count: " + maxCount);
		System.out.println("Time taken using multithreading: " + (time2-time1) + " ns");
		
		time1 = System.nanoTime();
		
		thread1.run();
		thread2.run();
		thread3.run();
		thread4.run();
		thread5.run();
		thread6.run();
		thread7.run();
		thread8.run();
		thread9.run();
		thread10.run();
		
		time2 = System.nanoTime();
		
		System.out.println();
		System.out.println(maxInt + " has the largest number of divisors between 1 and 100000. Divisor Count: " + maxCount);
		System.out.println("Time taken using single threading: " + (time2-time1) + " ns");
		
	}

}
