package com.bridgelab.linkedlist;

public class SinglyLinkedList {

    //Represent a node of the singly linked list
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int size;
    //Represent the head and tail of the singly linked list
    public Node head = null;
    public Node tail = null;

    //addNode() will add a new node to the list
    public void addNode(int data) {
        //Create a new node
        Node newNode = new Node(data);

        //Checks if the list is empty
        if (head == null) {
            //If list is empty, both head and tail will point to new node
            head = newNode;
            tail = newNode;
        } else {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            //newNode will become new tail of the list
            tail = newNode;
        }

        //Size will count the number of nodes present in the list
        size++;
    }

    public void addInMid(int data) {
        //Create a new node
        Node newNode = new Node(data);

        //Checks if the list is empty
        if (head == null) {
            //If list is empty, both head and tail would point to new node
            head = newNode;
            tail = newNode;
        } else {
            Node temp, current;
            //Store the mid position of the list
            int count = (size % 2 == 0) ? (size / 2) : ((size + 1) / 2);
            //Node temp will point to head
            temp = head;
            current = null;

            //Traverse through the list till the middle of the list is reached
            for (int i = 0; i < count; i++) {
                //Node current will point to temp
                current = temp;
                //Node temp will point to node next to it.
                temp = temp.next;
            }

            //current will point to new node
            current.next = newNode;
            //new node will point to temp
            newNode.next = temp;
        }
        size++;
    }

    public void deleteFromStart() {

        //Checks if the list is empty
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else {
            //Checks whether the list contains only one node
            //If not, the head will point to next node in the list and tail will point to the new head.
            if (head != tail) {
                head = head.next;
            }
            //If the list contains only one node
            //then, it will remove it and both head and tail will point to null
            else {
                head = tail = null;
            }
        }
    }

    //display() will display all the nodes present in the list
    public void display() {
        //Node current will point to head
        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of singly linked list: ");
        while (current != null) {
            //Prints each node by incrementing pointer
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    //deleteFromMid() will delete a node from the middle of the list
    void deleteFromMid() {
        Node temp, current;
//Checks if the list is empty
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        else {

            int count = (size % 2 == 0) ? (size/2) : ((size+1)/2);
//Checks whether the head is equal to the tail or not, if yes then the list has only one node.
            if( head != tail ) {
                //Initially, temp will point to head
                temp = head;
                current = null;
//Current will point to node previous to temp
                //If temp is pointing to node 2 then current will point to node 1.
                for(int i = 0; i < count-1; i++){
                    current = temp;
                    temp = temp.next;
                }
                if(current != null) {
                    //temp is the middle that needs to be removed.
                    //So, current node will point to node next to temp by skipping temp.
                    current.next = temp.next;
//Delete temp
                    temp = null;
                }
                //If current points to NULL then, head and tail will point to node next to temp.
                else {
                    head = tail = temp.next;
//Delete temp
                    temp = null;
                }
            }
//If the list contains only one element
            //then it will remove it and both head and tail will point to NULL
            else {
                head = tail = null;
            }
        }
        size--;
    }
    public void deleteFromEnd() {

        //Checks if the list is empty
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        else {
            //Checks whether the list contains only one element
            if(head != tail ) {
                Node current = head;
                //Loop through the list till the second last element such that current.next is pointing to tail
                while(current.next != tail) {
                    current = current.next;
                }
                //Second last element will become new tail of the list
                tail = current;
                tail.next = null;
            }
            //If the list contains only one element
            //Then it will remove it and both head and tail will point to null
            else {
                head = tail = null;
            }
        }
    }

    public void searchNode(int data) {
        Node current = head;
        int i = 1;
        boolean flag = false;
        //Checks whether list is empty
        if(head == null) {
            System.out.println("List is empty");
        }
        else {
            while(current != null) {
                //Compares node to be found with each node present in the list
                if(current.data == data) {
                    flag = true;
                    break;
                }
                i++;
                current = current.next;
            }
        }
        if(flag)
            System.out.println("Element is present in the list at the position : " + i);
        else
            System.out.println("Element is not present in the list");
    }
    public static void main(String[] args) {

        SinglyLinkedList sList = new SinglyLinkedList();

        //Add nodes to the list
        sList.addNode(56);
        sList.addNode(30);
        sList.addNode(70);


        //Displays the nodes present in the list
        sList.display();

        //Inserting node '3' in the middle
        sList.addInMid(3);
        System.out.println("Updated List: ");
        sList.display();


       /* while (sList.head != null) {
            sList.deleteFromStart();
            //Printing updated list
            System.out.println("Updated List: ");
            sList.display();
            */
       /* while(sList.head != null) {
            sList.deleteFromEnd();
            //Printing updated list
            System.out.println("Updated List: ");
            sList.display();

        }*/

        //Search for node 2 in the list
        sList.searchNode(30);

        while(sList.head != null) {
            sList.deleteFromMid();
            //Printing updated list
            System.out.println("Updated List: ");
            sList.display();
        }

    }
}
