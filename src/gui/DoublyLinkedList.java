package gui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DoublyLinkedList {

    private class Node {

        private Node next;  //Var. to store next Node of Current Node
        private Node prev; // Var. to store prev Node of Current Node
        private DVD data; // Var. to store data of Current Node

        //Non-parameter Constructor to Node class
        private Node() {
            this.next = null;
            this.prev = null;
            this.data = new DVD();
        }

        // Constructor with Parameter to Node class
        private Node(DVD data) {
            this.next = null;
            this.prev = null;
            this.data = data;
        }

        @Override
        public String toString() {
            return getData().toString();
        }

        /**
         * @return the next
         */
        public Node getNext() {
            return next;
        }

        /**
         * @param next the next to set
         */
        public void setNext(Node next) {
            this.next = next;
        }

        /**
         * @return the prev
         */
        public Node getPrev() {
            return prev;
        }

        /**
         * @param prev the prev to set
         */
        public void setPrev(Node prev) {
            this.prev = prev;
        }

        /**
         * @return the data
         */
        public DVD getData() {
            return data;
        }

        /**
         * @param data the data to set
         */
        public void setData(DVD data) {
            this.data = data;
        }

    }

    Node head; // Var. to store first Node of DoublyLinkedList
    Node tail; // Var. to store last Node of DoublyLinkedList

    //Non-parameter Constructor to DoublyLinkedList class
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(DVD data) {
        if (this.head == null) {
            Node tmp = new Node(data);

            this.head = tmp;
            this.tail = tmp;
        } else {
            if (this.head.getData().compare(this.tail.getData())) {
                if (this.head.getData().getAdSoyad().compareTo(data.getAdSoyad()) <= 0) {
                    Node tmp = new Node(data);
                    this.tail = tmp;
                    this.head.setNext(this.tail);
                    this.tail.setPrev(this.head);
                } else {
                    Node tmp = new Node(data);
                    this.head = tmp;
                    this.head.setNext(this.tail);
                    this.tail.setPrev(this.head);
                }
            } else {
                Node current = this.head;
                while (current != null) {

                    int compareResult = data.getAdSoyad().compareTo(current.getData().getAdSoyad());
                    if (compareResult < 0) {
                        break;
                    } else {
                        if (compareResult == 0) {
                            int compareDateResult = data.getCikisTarihi() - current.getData().getCikisTarihi();

                            if (compareDateResult < 0) {
                                break;
                            } else {
                                current = current.getNext();
                                break;
                            }
                        }
                    }
                    current = current.getNext();
                }

                if (current == null) {

                    Node tmp = new Node(data);
                    tmp.setPrev(this.tail);
                    this.tail.setNext(tmp);
                    this.tail = tmp;
                } else {
                    if (current.getData().compare(this.head.getData())) {
                        Node tmp = new Node(data);
                        this.head.setPrev(tmp);
                        tmp.setNext(this.head);
                        this.head = tmp;
                    } else {
                        if (current.getData().compare(this.tail.getData())) {
                            Node tmp = new Node(data);
                            tmp.setNext(this.tail);
                            tmp.setPrev(this.tail.getPrev());
                            this.tail.prev.setNext(tmp);
                            this.tail.setPrev(tmp);

                        } else {
                            Node tmp = new Node(data);
                            tmp.setPrev(current.getPrev());
                            tmp.setNext(current);
                            current.prev.setNext(tmp);
                            current.setPrev(tmp);
                        }
                    }
                }
            }
        }
    }

    private String printList() {
        Node current = this.head;
        String data = "";
        while (current != null) {

            data += current.getData().toString() + System.lineSeparator();
            current = current.getNext();
        }

        return data;
    }

    @Override
    public String toString() {
        return printList();
    }

    public String ZtoA() {

        Node current = this.tail;
        String data = "";

        while (current != null) {

            data += current.getData().toString() + "\n";
            current = current.getPrev();
        }

        return data;

    }

    public boolean Remove(String name, String dvdName) {

        Node current = this.head;

        while (current != null) {

            if (current.getData().getAdSoyad().equals(name) && current.getData().getDvdBasligi().equals(dvdName)) {
                break;
            }

            current = current.getNext();
        }

        if (current == null) {
            return false;
        } else {
            if (current.getData().compare(this.head.getData())) {
                this.head.next.setPrev(null);
                this.head = this.head.getNext();
                return true;
            } else {
                if (current.getData().compare(this.tail.getData())) {
                    this.tail.prev.setNext(null);
                    this.tail = this.tail.getPrev();
                    return true;
                } else {
                    current.next.setPrev(current.getPrev());
                    current.prev.setNext(current.getNext());
                    return true;
                }
            }
        }
    }

    public DoublyLinkedList before2K() {
        DoublyLinkedList tmp = new DoublyLinkedList();
        Node current = this.head;
        while (current != null) {

            if (current.getData().getCikisTarihi() < 2000) {
                tmp.add(current.getData());
            }

            current = current.getNext();
        }

        return tmp;
    }

    public void saveDatas() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Sakla.txt"));
        Node current = this.head;
        while (current != null) {
            bufferedWriter.write(current.getData().toString());
            bufferedWriter.write(System.lineSeparator());
            current = current.getNext();
        }
        bufferedWriter.close();

    }
    
    public ArrayList<String> find(String adSoyad){
        ArrayList<String> matchingList = new ArrayList<>();
        
        
        Node current = this.head;
        
       while(current != null){
           if(current.data.getAdSoyad().equals(adSoyad)){
               matchingList.add(current.data.toString());
               
           }
           current = current.next;
       }
       
       return matchingList;
    }
}
