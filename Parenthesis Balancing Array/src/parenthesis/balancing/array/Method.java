
package parenthesis.balancing.array;

public class Method implements Stack
{
	char a[];
	int size;
	int len;
	
	public Method(int l)
	{
		len=l;
		a = new char[len];
		size = 0;
		
	}
	@Override
	public void push(char e) 
	{
		if(size==a.length)
		{
			System.out.println("Stack Overflow");
		}
		a[size]=e;
		size++;
		
	}

	@Override
	public char pop() 
	{
		if(size==0)
		{
			//System.out.println("Stack underflow");
			return '0';
		}
		char bracket=a[size-1];
		a[size-1]='0';
		size--;
		return bracket;
		
	}

	@Override
	public char peek() 
	{
		if(size==0)
		{
			System.out.println("Stack underflow");
			return '0';
		}
		char bracket=a[size-1];
		return bracket;
	}
	public int size()
	{
		return size;
	}
	
}