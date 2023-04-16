package scheduling;

import java.util.Arrays;
import java.util.Comparator;

public class FCFS extends SchedulingAlgorithm {
    public FCFS(int numberOfProcesses, Process[] processes) {
        super(numberOfProcesses, processes);
    }

    @Override
    public void calculate() {
        long startTime = System.nanoTime();

        Arrays.sort(processes, Comparator.comparingInt(Process::getArrivalTime));

        int completedProcesses = 0;
        int currentTime = 0;
        int processIndex = 0;

        while (completedProcesses < numberOfProcesses) {
            Process currentProcess = processes[processIndex];
            currentTime += currentProcess.getBurstTime();

            // Set turnaround time
            currentProcess.setTurnAroundTime(currentTime - currentProcess.getArrivalTime());

            // Set waiting time
            currentProcess.setWaitingTime(currentProcess.getTurnAroundTime() - currentProcess.getBurstTime());

            completedProcesses++;
            processIndex++;
        }

        long endTime = System.nanoTime();

        System.out.println("\u001B[31m" + "FCFS Time taken: " + (endTime - startTime) / 1_000_000.0 + " ms" + "\u001B[0m");
    }
}