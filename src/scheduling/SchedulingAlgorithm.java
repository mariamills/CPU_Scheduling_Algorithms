package scheduling;

public abstract class SchedulingAlgorithm {
    protected final int numberOfProcesses;
    protected final Process[] processes;
    protected double averageWaitingTime;
    protected double averageTurnAroundTime;

    protected SchedulingAlgorithm(int numberOfProcesses, Process[] processes) {
        this.numberOfProcesses = numberOfProcesses;
        this.processes = processes;
    }

    public abstract void calculate();

    // Calculate the average waiting time
    private double calculateAvgWaitTime() {
        int totalWaitingTime = 0;
        // Sum the waiting times of all the processes
        for (int i = 0; i < numberOfProcesses; i++) {
            totalWaitingTime += processes[i].getWaitingTime();
        }
        averageWaitingTime = (double) totalWaitingTime / numberOfProcesses;
        // Round the average waiting time to 1 decimal place
        return Math.round(averageWaitingTime * 10.0) / 10.0;
    }

    // Calculate the average turn around time
    private double calculateAvgTurnaroundTime() {
        int totalTurnAroundTime = 0;
        // Sum the turn around times of all the processes
        for (int i = 0; i < numberOfProcesses; i++) {
            totalTurnAroundTime += processes[i].getTurnAroundTime();
        }
        averageTurnAroundTime = (double) totalTurnAroundTime / numberOfProcesses;
        // Round the average turn around time to 1 decimal place
        return Math.round(averageTurnAroundTime * 10.0) / 10.0;
    }

    // Display the waiting times of all the processes
    private void displayWaitingTimes() {
        System.out.println("Waiting times: ");
        for (int i = 0; i < numberOfProcesses; i++) {
            System.out.print("Process " + processes[i].getId() + ": " + processes[i].getWaitingTime() + " | ");
        }
        System.out.println("\n");
    }

    // Display the turn around times of all the processes
    private void displayTurnAroundTimes() {
        System.out.println("Turn around times: ");
        for (int i = 0; i < numberOfProcesses; i++) {
            System.out.print("Process " + processes[i].getId() + ": " + processes[i].getTurnAroundTime() + " | ");
        }
        System.out.println("\n");
    }

    // Display the average waiting time and turn around time
    public void print() {
        displayWaitingTimes();
        displayTurnAroundTimes();
        System.out.println("Average waiting time: " + calculateAvgWaitTime());
        System.out.println("Average turn around time: " + calculateAvgTurnaroundTime());
        System.out.println("--------------------------------------------");
    }
}
