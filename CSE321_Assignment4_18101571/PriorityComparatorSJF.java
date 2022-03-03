import java.util.Comparator;

//sorts in ascending order based on remaining burst time

public class PriorityComparatorSJF implements Comparator<Process>{
	
	public  int compare(Process p1, Process p2) {
		
		if(p1.rem_burst_time < p2.rem_burst_time) {
			return -1;
		}
		
		else if(p1.rem_burst_time > p2.rem_burst_time) {
			return 1;
		}
		
		return 0;
	}
	
}
