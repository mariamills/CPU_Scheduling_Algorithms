package scheduling;

import java.util.*;

public class SJF extends SchedulingAlgorithm {
    public SJF(int numberOfProcesses, Process[] processes) {
        super(numberOfProcesses, processes);
    }

    @Override
    public void calculate() {
        long startTime = System.nanoTime();

        Arrays.sort(processes, Comparator.comparingInt(Process::getArrivalTime));

        int completedProcesses = 0;
        int currentTime = 0;
        int processIndex = 0;

        Queue<Process> readyQueue = new PriorityQueue<>(Comparator.comparingInt(Process::getBurstTime));

        while (completedProcesses < numberOfProcesses) {
            // Add all processes that have arrived at the current time to the ready queue
            while (processIndex < numberOfProcesses && processes[processIndex].getArrivalTime() <= currentTime) {
                readyQueue.add(processes[processIndex++]);
            }

            if (!readyQueue.isEmpty()) {
                Process currentProcess = readyQueue.poll();
                currentTime += currentProcess.getBurstTime();

                // Set turnaround time
                currentProcess.setTurnAroundTime(currentTime - currentProcess.getArrivalTime());

                // Set waiting time
                currentProcess.setWaitingTime(currentProcess.getTurnAroundTime() - currentProcess.getBurstTime());

                completedProcesses++;
            } else {
                // If there are no processes in the ready queue, set the current time to the arrival time of the next process
                currentTime = processes[processIndex].getArrivalTime();
            }
        }


        long endTime = System.nanoTime();
        System.out.println("\u001B[31m" + "SJF Time taken: " + (endTime - startTime) / 1_000_000.0 + " ms" + "\u001B[0m");
    }

}