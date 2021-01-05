public class ReverseElementsInGroupsOfK {
    static class LinkedList {
        Node head;

        static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
            }
            Node(){

            }
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList = addNodeAtTail(linkedList, 1);
        linkedList = addNodeAtTail(linkedList, 2);
        linkedList = addNodeAtTail(linkedList, 3);
        linkedList = addNodeAtTail(linkedList, 4);
        linkedList = addNodeAtTail(linkedList, 5);
        linkedList = addNodeAtTail(linkedList, 6);
        linkedList = addNodeAtTail(linkedList, 7);
        linkedList = addNodeAtTail(linkedList, 8);
        System.out.println("Linked List before reversing:");
        LinkedList.Node curr = linkedList.head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
        int k = 3;
        System.out.println("K is: " + k);
        System.out.println("After reversing the list becomes:");
        linkedList = reverseListInGroupOfK(linkedList, k);
        curr = linkedList.head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public static LinkedList reverseListInGroupOfK(LinkedList linkedList, int k) {
        if(linkedList.head == null || linkedList.head.next == null)
            return linkedList;
        LinkedList tempLinkedList = new LinkedList();
        // tempLinkedList = addNodeAtTail(tempLinkedList, 0);
        LinkedList.Node dummyNode = new LinkedList.Node();
        tempLinkedList.head = dummyNode;
        tempLinkedList.head.next = linkedList.head;
        LinkedList.Node prevNode = tempLinkedList.head;
        LinkedList.Node currNode = linkedList.head;

        while(currNode!=null && currNode.next!=null){
            for (int i = 1; i < k ; i++) {
                currNode = currNode.next;
                if(currNode == null){
                    tempLinkedList.head = tempLinkedList.head.next;
                    return tempLinkedList;
                }
            }
            LinkedList.Node nextGroup = currNode.next;
            LinkedList.Node currentPointer = prevNode.next;
            LinkedList.Node previousPointer = prevNode;
            
            while(currentPointer != nextGroup){
                LinkedList.Node nextNode = currentPointer.next;
                currentPointer.next = previousPointer;
                previousPointer = currentPointer;
                currentPointer = nextNode;
            }

            LinkedList.Node tailNode = prevNode.next;
            tailNode.next = nextGroup;
            prevNode.next = previousPointer;
            prevNode = tailNode;

            currNode = nextGroup;
        }
        tempLinkedList.head = tempLinkedList.head.next;
        return tempLinkedList;
    }

    public static LinkedList addNodeAtTail(LinkedList linkedList, int data) {
        LinkedList.Node newNode = new LinkedList.Node(data);
        // newNode.data = data;
        newNode.next = null;
        if (linkedList.head == null) {
            linkedList.head = newNode;
        } else {
            LinkedList.Node lastNode = linkedList.head;
            while (lastNode.next != null)
                lastNode = lastNode.next;
            lastNode.next = newNode;
        }
        return linkedList;
    }
}