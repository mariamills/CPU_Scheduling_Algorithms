package scheduling;

import java.util.Objects;

public class Process {
    private int id;
    // The time at which a process arrives in the ready queue
    private int arrivalTime;
    // The time required by a process for CPU execution
    private int burstTime;
    // The time a process has spent waiting in the ready queue
    private int waitingTime;
    // The time required for completion of a process after arrival
    private int turnAroundTime;
    // The priority of a process
    private int priority;


    public Process(int id, int burstTime) {
        this.id = id;
        this.burstTime = burstTime;
    }

    public Process(int id, int burstTime, int arrivalTime) {
        this(id, burstTime);
        this.arrivalTime = arrivalTime;
    }

    public Process(int id, int burstTime, int arrivalTime, int priority) {
        this(id, burstTime, arrivalTime);
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }


    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "scheduling.Process{" +
                "id=" + id +
                ", arrivalTime=" + arrivalTime +
                ", burstTime=" + burstTime +
                ", waitingTime=" + waitingTime +
                ", turnAroundTime=" + turnAroundTime +
                ", priority=" + priority +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Process process = (Process) o;
        return id == process.id && arrivalTime == process.arrivalTime && burstTime == process.burstTime && waitingTime == process.waitingTime && turnAroundTime == process.turnAroundTime && priority == process.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, arrivalTime, burstTime, waitingTime, turnAroundTime, priority);
    }
}
