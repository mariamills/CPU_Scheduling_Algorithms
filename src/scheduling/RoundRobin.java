package scheduling;

import java.util.*;

/*
 * Round Robin scheduling algorithm
 * Static Non-preemptive implementation
 */

public class RoundRobin extends SchedulingAlgorithm {
    private final int timeQuantum;

    public RoundRobin(int numberOfProcesses, Process[] processes, int timeQuantum) {
        super(numberOfProcesses, processes);
        this.timeQuantum = timeQuantum;
    }

    @Override
    public void calculate() {
        long startTime = System.nanoTime();

        Arrays.sort(processes, Comparator.comparingInt(Process::getArrivalTime));

        int currentTime = 0;
        int processIndex = 0;

        Queue<Process> readyQueue = new LinkedList<>();

        Map<Integer, Integer> originalBurstTimes = new HashMap<>();
        for (int i = 0; i < numberOfProcesses; i++) {
            processes[i].setId(i);
            originalBurstTimes.put(processes[i].getId(), processes[i].getBurstTime());
        }

        while (processIndex < numberOfProcesses || !readyQueue.isEmpty()) {
            while (processIndex < numberOfProcesses && processes[processIndex].getArrivalTime() <= currentTime) {
                readyQueue.add(processes[processIndex++]);
            }


            if (!readyQueue.isEmpty()) {
                Process currentProcess = readyQueue.poll();
                int remainingTime = Objects.requireNonNull(currentProcess).getBurstTime() - timeQuantum;

                // If the process has finished
                if (remainingTime <= 0) {
                    currentTime += currentProcess.getBurstTime();
                    currentProcess.setBurstTime(0);

                    // Set turnaround time and waiting time
                    currentProcess.setTurnAroundTime(currentTime - currentProcess.getArrivalTime());
                    currentProcess.setWaitingTime(currentProcess.getTurnAroundTime() - originalBurstTimes.get(currentProcess.getId()));
                } else {
                    // If the process has not finished
                    currentTime += timeQuantum;
                    currentProcess.setBurstTime(remainingTime);
                    readyQueue.add(currentProcess);
                }
            } else {
                currentTime = processes[processIndex].getArrivalTime();
            }
        }

        long endTime = System.nanoTime();
        System.out.println("\u001B[31m" + "Round Robin Time taken: " + (endTime - startTime) / 1_000_000.0 + " ms" + "\u001B[0m");
    }

}
