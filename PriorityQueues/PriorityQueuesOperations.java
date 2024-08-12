package PriorityQueues;
import java.util.PriorityQueue;
/*
 * Same as queues but here when we try to remove 
 * data we will get the output in ascending order only
 * since here priority is given to smallest number
 * 
 * eg==ranks system etcc
 */
public class PriorityQueuesOperations {
    static class Student implements Comparable<Student>{ //overridding (since student class is comparing in student class itself)
        String name;
        int rank;
        public Student(String name,int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank-s2.rank;
        }

    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        //PriorityQueue<Integer> pq = new PriorityQueue<>();//by default gives asc
        //add comparator
        //PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("A",4));//O(logn)--for add
        pq.add(new Student("B",3));
        pq.add(new Student("C",1));
        pq.add(new Student("D",9));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name+"-> "+pq.peek().rank);//O(1)--for peek
            pq.remove(); // O(log(n))--for remove
        }
    }
}


