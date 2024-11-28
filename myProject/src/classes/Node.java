package classes;

import interfaces.I_Node;

public class Node<T> implements I_Node<T> {
    private T content;
    private Node<T> prev;
    private Node<T> next;

    public Node() {
        this.content = null;
        this.prev = null;
        this.next = null;
    }

    public Node(T content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }

    @Override
    public T getContent() {
        return content;
    }

    @Override
    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public Node<T> getPrev() {
        return prev;
    }

    @Override
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    @Override
    public Node<T> getNext() {
        return next;
    }

    @Override
    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Node<?> other = (Node<?>) obj;
        if (content == null) return other.content == null;
        return content.equals(other.content);
    }


    @Override
    public int hashCode() {
        return content != null ? content.hashCode() : 0;
    }
}