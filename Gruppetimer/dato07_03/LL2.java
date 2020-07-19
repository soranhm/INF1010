import java.util.Iterator;
import java.util.NoSuchElementException;

public class LL2<E extends Comparable<E>> implements Iterable<E> { // dette betyr at den er iterabel
	private Node head;
	private Node tail;
	private int size;

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return head == null ;
	}

	public void addFirst(E e){ //addLast er samme bare bytt ut head med tail
		Node n = new Node(e);
		size++;
		if(isEmpty()){
			head = n;
			tail=n;
		}
		else{
			n.next = head;
			head = n;
		}
	}

	public E getFirst(){
		if(isEmpty()) return null;
		return head.data;
	}

	public E removeFirst(){

		if (isEmpty()) return null; // om den er tom
		E tmp = head.data;
		head = head.next;
		if (size ==1) tail = null; // om vi har 1 element

		size --;
		return tmp;

	}

	public void addRec(E e){
		Node ny = new Node(e);
		if(isEmpty()){
			head = ny;
			tail = ny;
			size++;
		}
		else if(e.compareTo(head.data) < 0) {addFirst(e);}
		else if(e.compareTo(head.data) > 0) {addLast(e);}
		else{
			head.addRec(e);
			size++;
		}
	}
	public void addSorted(E e){
		Node ny = new Node(e);
		size++;
		if (isEmpty()){
			head = ny;
			tail = ny;
		}
		else if(e.compareTo(head.data)< 0){ // da skal den nye noden f�rst
			ny.next = head;
			head = ny;

		}
		else if (e.compareTo(tail.data)>0){
			tail.next = ny; //legger ny bakerst
			tail = ny; //for at tail skal peke p� den bakerste noden
		}
		else{
			for(Node n = head; n.next != null ;n = n.next) {//n.next : skal g� til next = null
				if(e.compareTo(n.next.data)<0){
					ny.next = n.next;
					n.next = ny;
					return; //m� hoppe ut av l�kken!
				}
			}

		}
	}

    public void print(){
	      for (Node n = head; n!= null; n = n.next){
				System.out.println(n.data);
			}
		}


	public Iterator<E> iterator(){
		return new MinIterator();
	}

	private class MinIterator implements Iterator<E>{ //dette er en iterator
		Node current = head;

		public E next() throws NoSuchElementException{
			if(!hasNext()) throw new NoSuchElementException();
			E tmp = current.data;
			current = current.next;
			return tmp;
		}
		public boolean hasNext(){
		    return current !=null;
		}
		public void remove(){

		}


	}

	private class Node{
		Node(E e){
			data = e;

		}
		E data;
		Node next;
		public void printAll(){
			if(next != null) next.printAll();
			System.out.println("END");
			/*
			if(next != null) next.printAll();
			System.out.println(data);
			*/
		}
		public void addRec(E e){
			if(e.compareTo(neste.data) < 0){
				Node n = new Node(e);
				n.next = next;
				next = n;
			}
			else {
				if(next != null) neste.addRec(e);
			}
		}
	}

	public void printAll(){
		if(head!=null) head.printAll();
	}

}
