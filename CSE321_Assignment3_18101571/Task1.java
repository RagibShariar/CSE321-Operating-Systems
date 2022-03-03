package Lab3;

class MyThread1 extends Thread{
	
	int start, finish;
	boolean pause = false;
	
	public MyThread1(int s, int f) {
		
		start = s;
		finish = f;
		
	}
	
	@Override
	public void run() {
		
		print(start, finish);
		
		if(start == 1) {
			pause = true;
			
			while(pause);
			
			print(21, 30);
		}
		
	}
	
	public void print(int a, int b) {
		for(int i = a; i<=b; i++) {
			System.out.println(i);
			try {
				sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class Task1 {
	
	public static void main(String[] args) {
		
		MyThread1 thread1 = new MyThread1(1, 10);
		MyThread1 thread2 = new MyThread1(11, 20);
								
		thread1.start();
		thread2.start();
		
		try {
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread1.pause = false;
						
	}

}
