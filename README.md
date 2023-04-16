
# CPU Scheduling Algorithms

This project is an implementation of various CPU scheduling algorithms in Java. The primary goal is to simulate and compare the performance of different scheduling algorithms. These algorithms are fundamental in understanding how operating systems manage and allocate CPU resources to processes.


## Implemented Algorithms

The following CPU scheduling algorithms are implemented in this project:
- First Come First Serve (FCFS)
- Shortest Job First (SJF)
- Priority Scheduling
- Round Robin (RR)
## Project Structure
The project is organized into the following packages and classes:

- `scheduling`: The main package containing the scheduling algorithm implementations and the Process class.
- `SchedulingAlgorithm`: An abstract base class for all scheduling algorithms.
- `FCFS`: Implementation of the FCFS scheduling algorithm.
- `SJF`: Implementation of the SJF scheduling algorithm.
- `Priority`: Implementation of the Priority Scheduling algorithm.
- `RoundRobin`: Implementation of the RR scheduling algorithm.
- `Process`: A class representing a process with attributes like ID, arrival time, burst time, waiting time, turnaround time, and priority.
## Usage/Examples

To use this project, instantiate the desired scheduling algorithm class with the required parameters, such as the number of processes and an array of Process objects. Then, call the `calculate()` method on the instance to simulate the scheduling and calculate waiting times and turnaround times for the processes and the `print()` method to display those calculations.

Here's an example of how to use the Round Robin scheduling algorithm:
```java
int numberOfProcesses = 4;
Process[] processes = new Process[]{
    new Process(0, 5, 0),
    new Process(1, 10, 1),
    new Process(2, 6, 2),
    new Process(3, 3, 3)
};
int timeQuantum = 2;

RoundRobin roundRobin = new RoundRobin(numberOfProcesses, processes, timeQuantum);
roundRobin.calculate();
roundRobin.print();
```


## Lessons Learned

Throughout the development of this project, several important lessons were learned. These lessons not only relate to the technical aspects of implementing CPU scheduling algorithms but also to the understanding of operating system concepts.

- **Understanding scheduling algorithms**: Gaining a deeper understanding of various CPU scheduling algorithms, their advantages and disadvantages, and how they affect the overall performance of a system is crucial. This project helped solidify knowledge of different scheduling techniques and their real-world applications.

- **Efficiency and performance**: Implementing scheduling algorithms efficiently, considering time and space complexity, is critical. The project allowed for the exploration of different data structures, such as queues and priority queues, which are essential for optimizing performance.

- **Debugging and problem-solving**: Throughout the development process, several issues were encountered that required debugging and problem-solving skills. These challenges provided valuable experience in identifying and resolving issues related to logic and implementation.

- **Code organization and readability**: Creating well-structured, modular, and readable code is vital for any project. This project was built with the importance of creating a clean and organized codebase in mind, which in turn makes it easier to maintain and extend in the future.

In conclusion, this project not only provided valuable experience in implementing and understanding CPU scheduling algorithms but also served as an excellent opportunity to improve essential programming skills such as debugging, problem-solving, code organization, and documentation.


## Feedback

As a student working on this project, I understand that there are various ways to implement CPU scheduling algorithms, and I'm always looking to learn and improve. I welcome any feedback, optimization tips, or alternative approaches that can help enhance the performance and efficiency of the algorithms in this project.

Please feel free to open an issue or create a pull request with your suggestions or improvements. Your input is greatly appreciated, as it not only helps me grow as a developer but also benefits the project as a whole. Thank you for your interest in this project and for contributing to a collaborative learning environment!

