package tld.meine.trainingsapp;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList /*implements Iterable<Trainingseinheit>, Iterator<Trainingseinheit> */{

    private Node currentNode;
    private int currentSize;

    private class Node {
        private Node next;
        private Node prev;
        private Trainingseinheit training;

        public void setNextNode(Node next)
        {
            this.next = next;
        }

        public void setPrevNode(Node prev)
        {
            this.prev = prev;
        }

        public Node(Trainingseinheit training) {

            this.training = training;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }

        public Trainingseinheit getTraining() {
            return training;
        }
    }

    public DoublyLinkedList()
    {
        this.currentNode = null;
        this.currentSize = 0;
    }

    /*@Override
    public Iterator<Trainingseinheit> iterator()
    {
        return this;
    }*/

    /*@Override
    public boolean hasNext()
    {
        return true;
    }*/

    public void add(Trainingseinheit e)
    {
        Node newNode = new Node(e);

        if(size() == 0)
        {
            newNode.setNextNode(newNode);
            newNode.setPrevNode(newNode);
        }
        else
        {
            Node ahead = currentNode;
            Node behind = currentNode.getNext();
            ahead.setNextNode(newNode);
            behind.setPrevNode(newNode);
            newNode.setNextNode(behind);
            newNode.setPrevNode(ahead);
        }
        currentNode = newNode;
        this.currentSize++;

    }

    public void removeCurrent()
    {
        if(size() == 0) throw new NoSuchElementException();
        Node hinten = currentNode.getPrev();
        Node vorne = currentNode.getNext();
        hinten.setNextNode(vorne);
        vorne.setPrevNode(hinten);
        currentNode = hinten;
        currentSize--;
    }

    public void removeTraining(Trainingseinheit t)
    {
        for(int i = 0; i<currentSize; i++){
            if(next() == t){
                removeCurrent();
            }
        }
    }

    public Trainingseinheit find(Fitnessgeraet f)
    {
        for(int i = 0; i<currentSize; i++){
            if(next().getFitnessgeraet() == f){
                return getCurrent();
            }

        }
        throw new NoSuchElementException();

    }



    public Trainingseinheit getCurrent()
    {
        if(size() == 0) throw new NoSuchElementException();
        return currentNode.getTraining();
    }

    public Trainingseinheit next()
    {
        if(size() == 0) throw new NoSuchElementException();
        currentNode = currentNode.getNext();
        return currentNode.getTraining();
    }

    public Trainingseinheit prev()
    {
        if(size() == 0) throw new NoSuchElementException();
        currentNode = currentNode.getPrev();
        return currentNode.getTraining();
    }

    public Trainingseinheit get(int offset)
    {
        if(size() == 0) throw new NoSuchElementException();

        offset = offset % this.currentSize;
        if(offset < 0)
            offset += currentSize;

        Node runPointer = currentNode;
        for(int i = 0; i<offset; i++){
           runPointer = runPointer.getNext();
        }
        return runPointer.getTraining();
    }

    public int size()
    {
        return this.currentSize;
    }
}
