package com.goce.datastructures;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {

    public static void main(String args[])
    {
        // Creating empty priority queue
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

        // Adding items to the pQueue using add()
        pQueue.add(40);
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);

        Queue<Integer> qQueue = new LinkedList<Integer>();

        // Adding items to the pQueue using add()
        qQueue.add(20);
        qQueue.add(10);
        qQueue.add(40);
        qQueue.add(15);

        // Printing the top element of PriorityQueue
        System.out.println(pQueue.peek());

        // Printing the top element and removing it
        // from the PriorityQueue container
        while (!pQueue.isEmpty()){
            System.out.println(pQueue.remove());
        }

        // Printing the top element and removing it
        // from the Queue container
        System.out.println("-------------------------");
        while (!qQueue.isEmpty()){
            System.out.println(qQueue.remove());
        }


        int[][] listArray = {{1,4,5,2}, {1,3,4},{2,6}};

        ListNode[] lists = new ListNode[3];
        int listCount = 0;

        for (int[] innerList : listArray) {
            ListNode root = null, head = null;

            for (int value : innerList) {
                ListNode node = new ListNode(value);

                if (head == null) {
                    head = node;
                } else {
                    root = head;
                    while (root.next != null) {
                        root = root.next;
                    }

                    // Insert the new_node at last node
                    root.next = node;
                }
            }
            lists[listCount++] = head;
        }

        mergeKLists(lists);

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for(ListNode head: lists){
            while(head != null){
                minHeap.add(head.val);
                head = head.next;
            }
        }

        ListNode nextNode = null, head = null;
        nextNode = head;

        while (!minHeap.isEmpty()) {
            if(head == null) {
                head = new ListNode(minHeap.remove());
                nextNode = head;
            }
            else {
                nextNode.next = new ListNode(minHeap.remove());
                nextNode = nextNode.next;
            }
        }

        return head;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
