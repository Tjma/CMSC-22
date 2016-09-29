class StringStack {
	private int count;
	private String[] elements;
	public static final int DEFAULT_SIZE = 10;	


	StringStack () {
		elements = new String[DEFAULT_SIZE];
	}

	StringStack (int size) {
		if (size <= 0) {
			throw new IllegalArgumentException();
		} else {
			elements = new String[size];
		}
	} 

	public void push (String item) {
		if (elements.length <= count) {
			String[] temp = new String[elements.length + 5];
			for(int i = 0; i < elements.length; i++) {
				temp[i] = elements[i];
			}
			elements = temp;
		}
		elements[count++] = item;
	}

	public String pop () {
		if (count <= 0) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
		String ans = elements[count - 1];
		--count;
		return ans;
		}
	}

	public int size () {
		return count;
	}

	public String toString () {
		if(count <=0 ) {
			return "EMPTY";
		} else {
			String print = "";
			for (int i = 0; i < size() - 1; i++) {
				print = print + elements[i] + ",";
			}
			print = print + elements[size()-1];
			return print;
		}
	}

	public String peek () {
		return elements[size() - 1];
	}

	public String pop (int x) {
		String ans = "";
		if(x > size()){
			throw new ArrayIndexOutOfBoundsException();
		} else {
			while (x > 0) {
				ans = pop();
				x--;
			}
		}
			return ans;
	} 

	public static void main(String[] args) {
        StringStack stack = new StringStack(2);
        stack.push("paper");
        stack.push("plastic");
        stack.push("tissue");
        System.out.println(stack); // paper, plastic, tissue
        System.out.println(stack.size()); // 3
        //String item1 = stack.pop();
        //String item2 = stack.pop();
        //String item3 = stack.pop();
        String item4 = stack.peek();
        System.out.println(stack.pop(3));


        //System.out.println(item1); // tissue
        //System.out.println(item2); // plastic
        //System.out.println(item3); // paper
        //System.out.println(stack); // EMPTY
        //System.out.println(item4);
        System.out.println(stack.size()); // 0
    }

}