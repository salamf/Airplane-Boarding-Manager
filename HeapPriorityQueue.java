/*
* HeapPriorityQueue.java
*
* An implementation of a minimum PriorityQueue using a heap.
* based on the implementation in "Data Structures and Algorithms
* in Java", by Goodrich and Tamassia
*
* This implementation will throw a Runtime, HeapEmptyException
*	if the heap is empty and removeLow is called.
*
* This implementation will throw a Runtime, HeapFullException
*	if the heap is full and insert is called.
*
*/

//Salam Fazil
//V00935894

public class HeapPriorityQueue implements PriorityQueue {

	protected final static int DEFAULT_SIZE = 10000;

	protected Comparable[] storage;
	protected int currentSize;

	/*
	 * Constructor that initializes the array to hold DEFAULT_SIZE elements
	 */
	public HeapPriorityQueue() {
		storage = new Comparable[DEFAULT_SIZE + 1];
		currentSize = 0;
	}
	
	/*
	 * Constructor that initializes the array to hold size elements
	 */
	public HeapPriorityQueue(int size) {
		storage = new Comparable[size + 1];
		currentSize = 0;
	}

	public void insert ( Comparable element ) throws HeapFullException {
		if(size() >= storage.length - 1) {
			throw new HeapFullException();
		}

		storage[++currentSize] = element;

		bubbleUp(currentSize);
	}

	private void bubbleUp(int index) {
		if (index > 1){
			if(storage[index].compareTo(storage[index/2]) < 0){
				swap(index, index/2);
				bubbleUp(index/2);
			}
		}
	}

	private void swap (int index1, int index2){
		Comparable temp = storage[index1];
		storage[index1] = storage[index2];
		storage[index2] = temp;
	}

	public Comparable removeMin() throws HeapEmptyException{
		if(isEmpty()){
			throw new HeapEmptyException();
		}

		Comparable minVal = storage[1];
		swap(1, currentSize);

		storage[currentSize] = null;
		currentSize--;

		bubbleDown(1);

		return minVal;
	}

	private void bubbleDown(int index) {
		if (!isLeaf(index)){
			int indexOfSmallestChild = index * 2;
			if(storage[index * 2 + 1] != null){
				indexOfSmallestChild = smallestChild(index);
			}
			if (storage[index].compareTo(storage[indexOfSmallestChild]) > 0) {
				swap(index, indexOfSmallestChild);
				bubbleDown(indexOfSmallestChild);
			}
		}
	}

	private boolean isLeaf(int index){
		if(index <= currentSize/2) {
			return storage[index * 2] == null && storage[index * 2 + 1] == null;
		}
		return true;
	}


	private int smallestChild(int index){
		if(storage[index * 2 + 1].compareTo(storage[index * 2]) < 0){
			return index * 2 + 1;
		}
		return index * 2;
	}


	public boolean isEmpty(){
		return currentSize == 0;
	}
	
	public int size () {
		return currentSize;
	}

	public String toString() {
		String s = "";
		String sep = "";
		for(int i=0;i<currentSize;i++) {
			s += sep + storage[i];
			sep = " ";
		}
		return s;
	}

	public static void main(String[] args){

		HeapPriorityQueue q1 = new HeapPriorityQueue();

		q1.insert(5);
		q1.insert(13);
		q1.insert(21);
		System.out.println(q1);

		q1.insert(20);
		System.out.println(q1);
		q1.insert(6);
		System.out.println(q1);

//		q1.removeMin();
//
//		System.out.println(q1);

	}

}
