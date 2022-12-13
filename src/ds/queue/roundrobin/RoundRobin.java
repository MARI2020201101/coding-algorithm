package ds.queue.roundrobin;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class RoundRobin {
    public static void main(String[] args) {
        Task[] tasks = {
                new Task("p1", 150),
                new Task("p2", 80),
                new Task("p3", 200),
                new Task("p4", 350),
                new Task("p5", 20),
        };
        roundRobin(tasks, 100);
    }
    static void roundRobin(Task[] tasks, int waitLimit){
        int waitTime = 0;
        Queue<Task> queue = new LinkedList<>();
        for (int i = 0; i < tasks.length; i++) {
            queue.add(tasks[i]);
        }
        while(! queue.isEmpty()){
            Task task = queue.poll();
            int remainWaitTime = task.time - waitLimit;
            if(remainWaitTime > 0){
                waitTime += waitLimit;
                queue.add(new Task(task.taskName, remainWaitTime));
            }else{
                waitTime += task.time;
                System.out.println(String.format("%s %d",task.taskName , waitTime));
            }
        }
    }
}
class Task{
    String taskName;
    int time;

    public Task(String taskName, int time) {
        this.taskName = taskName;
        this.time = time;
    }
}
