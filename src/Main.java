import scheduling.Priority;
import scheduling.Process;
import scheduling.RoundRobin;
import scheduling.SJF;

public class Main {
    public static void main(String[] args) {
        // Number of processes - be sure to change this if you add or remove processes
        final int NUMBER_OF_PROCESSES = 5;
        // Create processes array
        Process[] processes = new Process[NUMBER_OF_PROCESSES];

        // Time quantum for Round Robin
        final int TIME_QUANTUM = 50;

        // Example used in CPU Scheduling slides
        processes[0] = new Process(0, 350, 0, 5);
        processes[1] = new Process(1, 125, 0, 2);
        processes[2] = new Process(2, 475, 0, 3);
        processes[3] = new Process(3, 250, 0, 1);
        processes[4] = new Process(4, 75, 0, 4);

        // First come, first served
        scheduling.FCFS fcfs = new scheduling.FCFS(NUMBER_OF_PROCESSES, processes);
        fcfs.calculate();
        fcfs.print();

        // Shortest job first
        SJF sjf = new SJF(NUMBER_OF_PROCESSES, processes);
        sjf.calculate();
        sjf.print();

        // Priority
        Priority priority = new scheduling.Priority(NUMBER_OF_PROCESSES, processes);
        priority.calculate();
        priority.print();

        // Round-robin
        RoundRobin roundRobin = new scheduling.RoundRobin(NUMBER_OF_PROCESSES, processes, TIME_QUANTUM);
        roundRobin.calculate();
        roundRobin.print();
    }
}