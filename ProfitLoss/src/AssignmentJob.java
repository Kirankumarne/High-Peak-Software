import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Factory implements Comparable<Factory> {
    int startTime;
    int endTime;
    int profit;

    public Factory(int startTime, int endTime, int profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }

    // Compare jobs based on their end time
    public int compareTo(Factory otherJob) {
        return this.endTime - otherJob.endTime;
    }
}
public class AssignmentJob {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Jobs");
        int n = sc.nextInt();
        List<Factory> work = new ArrayList<>();

        // Read  the jobs
        System.out.println("Enter the job Start time,End time,Earnings");
        for (int i = 0; i < n; i++) {
        	
            int startTime = sc.nextInt();
            int endTime = sc.nextInt();
            int profit = sc.nextInt();
            work.add(new Factory(startTime, endTime, profit));
        }

        // Sort the jobs based on their end time
        Collections.sort(work);

        // Select the jobs that fit within Lokesh's available time
        int lokeshEndTime = 0;
        int lokeshProfit = 0;
        int otherJobs = 0;
        int otherProfit = 0;
        for (Factory job : work) {
            if (job.startTime >= lokeshEndTime) {
                // This job can be assigned to Lokesh
                lokeshEndTime = job.endTime;
                lokeshProfit += job.profit;
            } else {
                // This job cannot be assigned to Lokesh
                otherJobs++;
                otherProfit += job.profit;
            }
        }

        // Print the number of jobs and profit left for others
        System.out.println("The number of tasks and earnings available for others");
        System.out.println("Task: " + otherJobs);
        System.out.println("Earnings: " + otherProfit);

        sc.close();
	}

}
