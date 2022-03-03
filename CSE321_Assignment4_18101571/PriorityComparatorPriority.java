import java.util.Comparator;

//sorts in ascending order based on priority

public class PriorityComparatorPriority implements Comparator<Process>{
	
	public  int compare(Process p1, Process p2) {
		
		if(p1.priority < p2.priority) {
			return -1;
		}
		
		else if(p1.priority > p2.priority) {
			return 1;
		}
		
		return 0;
	}
	
}
