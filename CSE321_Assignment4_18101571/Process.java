public class Process {
	
	public String id;
	public int burst_time;
	public int rem_burst_time;
	public int arr_time;
	public int start_time = -1;
	public int fin_time;
	public int wait_time;
	public int turn_time;
	public int priority; // for priority scheduling
	
	public Process(String s, int b, int a) {
		id = s;
		burst_time = b;
		rem_burst_time = b;
		arr_time = a;
	}
	
	public Process(String s, int b, int a, int p) { // for priority scheduling
		id = s;
		burst_time = b;
		rem_burst_time = b;
		arr_time = a;
		priority = p;
	}

}
