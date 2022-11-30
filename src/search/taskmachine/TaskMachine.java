package search.taskmachine;

import java.util.PriorityQueue;
import java.util.Queue;

class TaskMachine {
    public static void main(String[] args) {
        minTime(8);
    }
    static void minTime(int k){
        int taskCount = k;
        Queue<Machine> queue = new PriorityQueue<>();
        queue.add(new Machine(0,2));
        queue.add(new Machine(0,3));
        queue.add(new Machine(0,7));
        int totalTime = 0;
        while(taskCount > 0){
            Machine machine = queue.poll();
            queue.add(new Machine(machine.endTime + machine.offset, machine.offset));
            taskCount--;
        }

        while(! queue.isEmpty()){
            totalTime = queue.poll().endTime;
        }
        System.out.println("totalTime = "+ totalTime);
    }

}
class Machine implements Comparable<Machine>{
    int endTime;
    int offset;

    public Machine(int endTime, int offset) {
        this.endTime = endTime;
        this.offset = offset;
    }

    @Override
    public int compareTo(Machine o) {
        return this.endTime - o.endTime;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "endTime=" + endTime +
                ", offset=" + offset +
                '}';
    }
}