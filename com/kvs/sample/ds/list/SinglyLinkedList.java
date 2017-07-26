package com.kvs.sample.ds.list;

public class SinglyLinkedList {
	
	Node head;
	Node tail;
	
	public void add(int data){
		Node newNode = new Node(data);
		if(null==head){
			head = newNode;
			tail= newNode;
		}else {
			tail.setNode(newNode);
			tail=newNode;
		}
	}
	
	public void remove(int data){
		Node temp= head;
		Node ref=null;
		Node prev=null;
		
		while(true){
			
			if(temp.getData()==(data)){
				ref=temp;
				break;
			}else{
				prev=temp;
				temp=temp.getNode();
			}
		}
		
		if(null!=ref){
			//prev.setNode(ref.getNode());	q1
			//ref=null;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SinglyLinkedList [" + (head != null ? "head=" + head + ", " : "") + (tail != null ? "tail=" + tail : "")
				+ "]";
	}	

	public static void main (String args[]){
		SinglyLinkedList list=new SinglyLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		
		System.out.println(list);
		
		list.remove(5);
		list.remove(9);
		list.remove(2);
		
		System.out.println(list);
	}
}

class Node{

	private int data;
	
	private Node node;
	
	public Node(int data) {
		this.data = data;
	}
	
	public Node(int data, Node node) {
		this.data = data;
		this.node = node;
	}

	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * @return the node
	 */
	public Node getNode() {
		return node;
	}

	/**
	 * @param node the node to set
	 */
	public void setNode(Node node) {
		this.node = node;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node [data=" + data + ", " + (node != null ? "node=" + node : "") + "]";
	}
	
	
	
}
