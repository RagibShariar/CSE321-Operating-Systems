import java.util.LinkedList;
import java.util.Queue;

public class RR {
	static LinkedList<Process> plist = new LinkedList<Process>();
	static Queue<Process> pQ = new LinkedList<Process>();	
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
		
		int tQ = 4; //time_quantum
		int total_turn_time = 0;
		int total_wait_time = 0;
		
		Process p1 = new Process("p1",24,0);
		Process p2 = new Process("p2",3,0);
		Process p3 = new Process("p3",3,0);	
		
		plist.add(p1);
		plist.add(p2);
		plist.add(p3);
		

		search();
		
		while(!pQ.isEmpty()) {
			
			Process process = pQ.remove();
			
			if(process.start_time == -1) {
				process.start_time = time;
			}
			
			if(process.rem_burst_time >= tQ) {
				
				time += tQ;
				process.rem_burst_time -= tQ;
				search(); //search for new process before re-appending old process 
				
				if(process.rem_burst_time != 0) {
					
					pQ.add(process);										
				}
				
				else{
					
					process.fin_time = time;
					process.turn_time = process.fin_time - process.arr_time;
					process.wait_time = process.turn_time - process.burst_time;
					
					total_turn_time += process.turn_time;
					total_wait_time += process.wait_time;
					
				}
			}
			
			else {
				
				time += process.rem_burst_time;
				process.fin_time = time;
				process.turn_time = process.fin_time - process.arr_time;
				process.wait_time = process.turn_time - process.burst_time;
				
				total_turn_time += process.turn_time;
				total_wait_time += process.wait_time;
				
				search();
			}			
		}
		
		int n = plist.size();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Process: " + plist.get(i).id +"; CT: " + plist.get(i).fin_time + "; TAT: " + plist.get(i).turn_time + "; WT: " + plist.get(i).wait_time + "\n");
		}
		
		System.out.println("Average TAT: " + (total_turn_time / n) + "; Average WT: " + (total_wait_time/n));

	}

}