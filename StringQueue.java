
public class StringQueue {
	private String[] elements;
	public int count;
	
	public StringQueue () {
		elements = new String[10];
	}
	
	public void enqueue (String item) {
		if (elements.length <= count) {
			String[] resize = new String[elements.length + 5];
			for (int i = 0; i < elements.length; i++) {
				resize[i] = elements[i];
			}
			elements = resize;
		}
		elements[count++] = item;
	}
	
	public String dequeue () {
		if (count <= 0) {
			throw new ArrayIndexOutOfBoundsException ();
		} else {
		String ans = elements[0];
		elements[0] = null;
		String[] newElements = new String[elements.length - 1];
		for (int i = 0; i < newElements.length; i++) {
			newElements[i] = elements[i + 1];
		}
		elements = newElements;
		--count;
		return ans;
		}
	}
	
	public String dequeue (int x) {
		String ans = "";
		if(x > count){
			throw new ArrayIndexOutOfBoundsException();
		} else {
			while (x > 0){
				ans = dequeue();
				x--;
			}
		}
			return ans;
	}
	
	public String toString () {
        if(count <= 0) {
            return "EMPTY";
        } else {
            String print = "";
            for (int i = 0; i < count - 1; i++) {
                print = print + elements[i] + ", ";
            }
            print = print + elements[count - 1];
            return print;
        }
    }
	
	public void singit (int pos, String name) {
		if (pos > count) {
			throw new IllegalArgumentException();
		} else {
		String[] finalArray = new String [elements.length + 1];
		for (int i = 0; i < elements.length; i++) {
				if (i < pos - 1) {
					finalArray[i] = elements[i];
				} else {
					finalArray[pos - 1] = name;
					finalArray[i + 1] = elements[i];
				}
		}	
		elements = finalArray;
		count++;
		}
	}
	
	public String peekFirst () {
		return elements [0];
	}
	
	public String peekLast () {
		return elements [count - 1];
	}
	
	public static void main (String[] args) {
		StringQueue queue = new StringQueue ();
		queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        System.out.println(queue);
        //queue.dequeue();
        //queue.dequeue(3);
        queue.singit(2, "X"); 
        queue.singit(4, "Y");
        queue.singit(6, "No");
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue.dequeue());
        System.out.println(queue);
        queue.dequeue(2);
        System.out.println(queue);
        System.out.println("FIRST: "+ queue.peekFirst() +"\n" + "LAST: " + queue.peekLast());
	}
	
}
