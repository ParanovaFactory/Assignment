package classes;

import java.util.Iterator;

import interfaces.I_List;

public class List<T> implements I_List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public List() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public List(Node<T> node) {
        this.head = node;
        this.tail = node;
        this.size = 1;
    }

    @Override
    public Node<T> getHead() {
        return head;
    }

    @Override
    public Node<T> getTail() {
        return tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    public boolean isValidIndex(int index) {
        if (size == 0) return false;
        if (index < 0) return false;
        if (index >= size) return false;
        return true;
    }
    
    @Override
    public Node<T> get(int index) {
        if (!isValidIndex(index)) {
            return null;
        }
        
        Node<T> current;
        if (index <= size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.getPrev();
            }
        }
        return current;
    }

    @Override
    public boolean insert(int index, Node<T> node) {
        if (index < 0 || index > size) {
            return false;
        }
        if (index == 0) {
            node.setNext(head);
            if (head != null) {
                head.setPrev(node);
            }
            head = node;
            if (tail == null) {
                tail = node;
            }
        } else if (index == size) {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        } else {
            Node<T> current = get(index);
            node.setPrev(current.getPrev());
            node.setNext(current);
            current.getPrev().setNext(node);
            current.setPrev(node);
        }
        size++;
        return true;
    }

    @Override
    public boolean append(Node<T> node) {
        if (node == null) {
            return false;
        }
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
        size++;
        return true;
    }

    public boolean append(T content) {
        if (content == null) {
            return false;
        }
        Node<T> newNode = new Node<>(content);
        return append(newNode);
    }
    
    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        if (current == head) {
            head = current.getNext();
            if (head != null) {
                head.setPrev(null);
            }
        } else {
            current.getPrev().setNext(current.getNext());
        }

        if (current == tail) {
            tail = current.getPrev();
            if (tail != null) {
                tail.setNext(null);
            }
        } else {
            current.getNext().setPrev(current.getPrev());
        }

        size--;
        return true;
    }
    
    @Override
    public boolean remove(T content) {
        if (head == null) {
            System.out.println("List is empty, cannot remove.");
            return false;
        }

        Node<T> current = head;
        System.out.println("Starting removal of node with content: " + content);

        while (current != null) {
            System.out.println("Checking node with content: " + current.getContent());

            if (current.getContent() != null && current.getContent().equals(content)) {
                System.out.println("Found node with content: " + content);

                // Node'un head olup olmadığı kontrolü
                if (current == head) {
                    head = current.getNext();
                    if (head != null) {
                        head.setPrev(null);
                    }
                    System.out.println("Removed head node.");
                } 
                // Node'un tail olup olmadığı kontrolü
                else if (current == tail) {
                    tail = current.getPrev();
                    if (tail != null) {
                        tail.setNext(null);
                    }
                    System.out.println("Removed tail node.");
                } 
                // Orta bir node ise
                else {
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                    System.out.println("Removed middle node.");
                }

                size--;
                System.out.println("Node removed successfully.");
                return true;
            }

            current = current.getNext();
        }

        System.out.println("Node with content " + content + " not found.");
        return false;
    }

    @Override
    public boolean swap(int index1, int index2) {
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size || index1 == index2) {
            return false;
        }
        
        Node<T> node1 = get(index1);
        Node<T> node2 = get(index2);
        
        if (node1 == null || node2 == null) {
            return false;
        }
        
        Node<T> node1Prev = node1.getPrev();
        Node<T> node1Next = node1.getNext();
        Node<T> node2Prev = node2.getPrev();
        Node<T> node2Next = node2.getNext();

        if (node1Next == node2) {
            node1.setNext(node2Next);
            node1.setPrev(node2);
            node2.setNext(node1);
            node2.setPrev(node1Prev);
            
            if (node2Next != null) node2Next.setPrev(node1);
            if (node1Prev != null) node1Prev.setNext(node2);
            
        } else if (node2Next == node1) {
            node2.setNext(node1Next);
            node2.setPrev(node1);
            node1.setNext(node2);
            node1.setPrev(node2Prev);
            
            if (node1Next != null) node1Next.setPrev(node2);
            if (node2Prev != null) node2Prev.setNext(node1);
            
        } else {
            node1.setNext(node2Next);
            node1.setPrev(node2Prev);
            node2.setNext(node1Next);
            node2.setPrev(node1Prev);
            
            if (node1Next != null) node1Next.setPrev(node2);
            if (node1Prev != null) node1Prev.setNext(node2);
            if (node2Next != null) node2Next.setPrev(node1);
            if (node2Prev != null) node2Prev.setNext(node1);
        }
        
        if (head == node1) head = node2;
        else if (head == node2) head = node1;
        
        if (tail == node1) tail = node2;
        else if (tail == node2) tail = node1;
        
        return true;
    }


    public Iterator<Node<T>> iterator() {
        return new Iterator<Node<T>>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Node<T> next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                Node<T> temp = current;
                current = current.getNext();
                return temp;
            }
        };
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        List<?> other = (List<?>) obj;
        if (size != other.size) return false;
        
        Node<T> currentThis = head;
        Node<?> currentOther = other.head;
        
        while (currentThis != null) {
            if (!currentThis.equals(currentOther)) {
                return false;
            }
            currentThis = currentThis.getNext();
            currentOther = currentOther.getNext();
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        Node<T> current = head;
        while (current != null) {
            result = 31 * result + (current != null ? current.hashCode() : 0);
            current = current.getNext();
        }
        return result;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.getContent());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}