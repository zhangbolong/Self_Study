/** Stacks */

/* Exmaple API: stack of string data type */
public class StackOfStrings{

    void push(String item);
    String pop();
    boolean isEmpty();
    int size();
}

/** Clients: 
        read strings from standard intput,
        if strings equals "-", pop string from stack and print
        Otherwise, push string into stack
*/
public static void main(String[] args){
    Scanner StdIn = new Scanner(System.in);
    StackOfStrings stack = new StackOfStrings();
    while(!in.nextLine().isEmpty()){
        String s = StdIn.nextLine();
        if(s.equals("-")){
            System.out.print(stack.pop());
        }
        else{
            stack.push(s);
        }
    }    
}

/* Stack implemented with linked list */

public class LinkedStackOfStrings{
    private Node first = null;
    
    /* Private inner class */
    private class Node{
        String item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void push(String item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public String pop(){
        String item = first.item();
        first = first.next;
        return item;
    }
}

/*Java stack space: 
                      object overhead: 16 bytes; 
                      inner class extra overhead(private class Node) 8bytes;
                      String : 8bytes;
                      Node : 8bytes;
    In total the inner class takes 40 bytes
*/

/** Stack Array Implementation
        Use array s[] to store N items on stack
        push(): add a new item at s[N];
        pop(): remove item from s[N-1]
    Defect: array size need to declaired and will overflow if exceeds capacity
*/

public class FixedCapacityArrayStackOfString{
    private String[] s;
    private int N = 0;
    /* The argument int capacity need tunes */
    public FixedCapacityArrayStackOfString(int CAPACITY){
        s = new String[CAPACITY];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void push(String item){
        // Increment N after assign string to array
        s[N++] = item; 
    }

    public String pop(){
        // Decrement N before return the string
        return s[--N];
    }
}

/** Issue about array implemented stack
    Underflow: throw exception if pop from an empty stack
    overflow: use resizing array for array implementation
    Loitering: the string is still in the array after called pop()
*/