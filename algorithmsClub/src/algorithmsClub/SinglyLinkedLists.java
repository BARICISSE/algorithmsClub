package algorithmsClub;


public class SinglyLinkedLists<Integer> {
	public SNode<Integer> head;
	public SNode<Integer> tail;
	public int size;
	
	
	SinglyLinkedLists(){
		this.head = null;
		this.tail = null;
		size = 0;
		
		
	}
	
	public void addFirst(SinglyLinkedLists list, SNode element){
		SNode newNode = element;
		SNode listHead = list.head;
		SNode listTail = list.tail;
		
		if(list ==null){
			list.head = element;
			list.tail = element;
			
		}
		else{
			newNode.next = listHead;
			list.head = newNode;
					
		}
		
		list.size ++ ;
	}
	
	public void removeFirst(SinglyLinkedLists list){
		if(list == null){
			tail = null;
		}
		else{
			SNode tempNode = list.head;
			list.head = list.head.next;
			tempNode.next = null;
		}
		list.size --;
	}
	
	public void addLast(SinglyLinkedLists list, SNode element ){
		list.tail.next = element;
		list.tail = element;
		list.size ++;
	}
	
	public void removeLast(SinglyLinkedLists list){
		if(list.head == list.tail){
			list.head = null;
			list.tail = null;
					
		}
		else{
			SNode temp = list.head;
			while(temp.next != list.tail){
				temp = temp.next;
				
			}
			temp.next = null;
			list.tail = temp;
			
		}
		list.size -- ;
	}

}
