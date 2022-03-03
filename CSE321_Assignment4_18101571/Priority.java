import java.util.LinkedList;
import java.util.PriorityQueue;

public class Priority {
	
	static LinkedList<Process> plist = new LinkedList<Process>();
	static PriorityQueue<Process> pQ = new PriorityQueue<Process>(new PriorityComparatorPriority());	
	static int queued = 0;
	static int time = 0;
	
	//looks for newly arriving processes and adds to queue assuming the processes 
	//in plist are sorted in ascending order of arrival time
	
	public static void search() { 
		
		int n = plist.size();
		
		for(int i=queued; i<n; i++) {
			
			if(plist.get(i).arr_time <= time) {
				pQ.add(plist.get(i));
				queued++;
			}
			else {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		
		int total_turn_time = 0;
		int total_wait_time = 0;
		
		Process p1 = new Process("p1",10,0,3);
		Process p2 = new Process("p2",1,0,1);
		Process p3 = new Process("p3",2,0,4);	
		Process p4 = new Process("p4",1,0,5);
		Process p5 = new Process("p5",5,0,2);
		
		plist.add(p1);
		plist.add(p2);
		plist.add(p3);
		plist.add(p4);
		plist.add(p5);
		
		search();
		
		
		while(!pQ.isEmpty()) {
			
			Process process = pQ.peek(); //head of queue has most priority (least priority value)
			
			if(process.start_time == -1) {
				process.start_time = time;
			}
			
			time++;
			process.rem_burst_time--;
						
			if(process.rem_burst_time == 0) {
				
				process.fin_time = time;
				process.turn_time = process.fin_time - process.arr_time;
				process.wait_time = process.turn_time - process.burst_time;
				
				total_turn_time += process.turn_time;
				total_wait_time += process.wait_time;
				
				pQ.remove(process);
			}
			
			search(); //search for newly arriving processes
					
		}
		
		int n = plist.size();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Process: " + plist.get(i).id +"; CT: " + plist.get(i).fin_time + "; TAT: " + plist.get(i).turn_time + "; WT: " + plist.get(i).wait_time + "\n");
		}
		
		System.out.println("Average TAT: " + (total_turn_time / n) + "; Average WT: " + (total_wait_time/n));

	}
}