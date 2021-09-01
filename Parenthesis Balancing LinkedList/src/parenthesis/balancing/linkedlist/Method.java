package parenthesis.balancing.linkedlist;

public class Method implements Stack
{
	Node newNode,head=null,tail=null;
	int size;
	int length;
	
	public Method(int l){
		length=l;
		newNode=new Node('0',null);
		size = 0;
	}
	
	@Override
	public void push(char e) 
	{
		if(size==length)
		{
			System.out.println("Stack Overflow");
		}
		else
		{
			newNode=new Node(e,null);
			if(head==null)
			{
				head=newNode;
				tail=newNode;
				newNode.next=null;
				size++;
			}
			else
			{
				newNode.next=tail;
				head=newNode;
				tail=newNode;
				size++;
			}
				
		}
		
	}

	@Override
	public char pop() 
	{
		if(size==0)
		{
			return '0';
		}
		else
		{
			Node after_Node=head.next;
			Node poped=head;
			head=after_Node;
			tail=after_Node;
			size--;
			return poped.bracket;
		}
	}

	@Override
	public char peek() 
	{
		Node peeked=head;
		return peeked.bracket;
	}
	
	public int sizing()
	{
		return size;
	}
	
}
