package com.automation.tests.day7;

import javax.swing.text.html.HTMLDocument;
import java.lang.reflect.Array;
import java.util.*;

public class officeHour {
    public static void main(String[] args) {
        /*
        under List interface
        -ArrayList (indexes, faster to read , slower when we
         do manupulations(remove or add elements)
         -Vector (same Arraylist but thread safe)
           Stack(last in first out)
         -LinkedList(node(each element reference to previous and next element in the list))
         (performance sensitive, memory allocation)
           [2,4,3]   -->  [2,3]
         [2] [4] [3]
         */
        /*Set Interface (contain only unique values)
        HashSet : no indexes - faster because it is using hashing
        it does not keep an order , allows 1 null
        TreeSet: sorted set --no nulls
        LinkedHashSet: keep the order

         */
        HashSet<String> hashSet=new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        LinkedHashSet<String> linkedHashSet= new LinkedHashSet<>();
     /*   for (String each: Array.
             ) {
            hashSet.add(each);
            treeSet.add(each);
            linkedHashSet.add(each);
        }
*/
        System.out.println("hashSet= "+hashSet);

        System.out.println("TreeSet= "+treeSet);
        System.out.println("LinkedHashSet= "+linkedHashSet);
        Iterator<String> iteratorSet=hashSet.iterator();
while(iteratorSet.hasNext()){
    System.out.println(iteratorSet.next());
}
ArrayList<Integer> drpDown=new ArrayList<>();
drpDown.add(1);
        drpDown.add(2);
        drpDown.add(3);
        drpDown.add(4);
        drpDown.add(5);
// [1,2,3,4,5]
        System.out.println("List= "+drpDown);
       HashSet<Integer> optionsSet=new HashSet<>(drpDown);
        System.out.println(optionsSet);
        if(optionsSet.size()==drpDown.size()){
            System.out.println("expected as same as accual");
        }else {
            System.out.println("options contains duplicates");
        }
    /*
    Queue
    -priority Queue --first in first out , can accept duplicates, does not have index
    -ArrayDequeue--special in adding and removing
     */
      PriorityQueue<String> priorityQueue=new PriorityQueue<>();
      priorityQueue.add("John");
        priorityQueue.add("Kate");
        priorityQueue.add("Tom");
        System.out.println("Queue= "+priorityQueue);
        System.out.println("peek = "+priorityQueue.peek());
        //peeking --it will check and return the first in a queue
        System.out.println("queue after peek: "+priorityQueue);
        System.out.println("poll: " + priorityQueue.poll());
        System.out.println(priorityQueue);
       // polling will return the first value in a queue and remove it
     ArrayDeque<String> deque=new ArrayDeque<>();




    }
}
