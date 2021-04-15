package kh.priorittqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    public class Event{
        
        public Event(String eventType) {
            this.eventType = eventType;
        }
        
        String eventType;

        public String getEventType() {
            return eventType;
        }

        public void setEventType(String eventType) {
            this.eventType = eventType;
        }
    }
    
    public static void main(String[] args) {
        PriorityQueueExample example = new PriorityQueueExample();
        System.out.println("Example 1 with traditional Comparator");
        example.example1();
        
        System.out.println("\nExample 1 with traditional Comparator");
        example.exampleWithLambda();
    }

    private void example1() {
        PriorityQueue<Event> queue = new PriorityQueue<>(
                new Comparator<Event>() {

                    @Override
                    public int compare(Event o1, Event o2) {
                        int result = o1.getEventType().compareTo(o2.getEventType()); 
                        return result;
                    }
                    
                });
        queue.add(new Event("C"));
        queue.add(new Event("A"));
        queue.add(new Event("B"));    
        
        while(!queue.isEmpty()) {
            System.out.println(queue.poll().getEventType());
        }
    }

    private void exampleWithLambda() {
        PriorityQueue<Event> queue = new PriorityQueue<>( ( o1,  o2 ) -> {
                int result = o1.getEventType().compareTo(o2.getEventType()); 
                return result;
        });
        queue.add(new Event("C"));
        queue.add(new Event("A"));
        queue.add(new Event("B"));    
        
        while(!queue.isEmpty()) {
            System.out.println(queue.poll().getEventType());
        }
    }

    
}
