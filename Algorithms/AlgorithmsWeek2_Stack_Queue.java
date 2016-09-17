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

/** Resizing Arrays
    How to grow and shrink array?
        Ensure array resizing happens infrequently.
    How to grow array?
        If an array is full, create an array twice the size, and copy items. 
    How to shrink the array?
         Halve the size of array s[] when array is quater-full
*/

/** Resizing  array to the double size if full
    implementation:
*/

public class ResizingArrayStackOfString extends FixedCapacityArrayStackOfString {
    private String[] s;
    private int N = 0;
    
    public ResizingArrayStackOfStrings(){
        s = new String[1];
    }

    /* Create a new array, copy and replace the array pointer*/
    private void resize(int capacity){
        String[] copy = new String[CAPACITY];
        for(int i = 0; i< N; i++){
            copy[i] = s[i];    
        }
        s = copy;
    }

    /* Push String inside , if array is full, double the array size */
    public void push(String item){
        if(N == s.length) {
            resize(2 * s.length);
        }
        s[N++] = item;
    }

    /* Pop out string, resize array to half size if valid item less than 1/4 */
    public String pop(){
        Sting item = s[--N];
        s[N] = null;
        if(N>0 && N == s.length/4){
            resize(s.length/2);
        }
        return item;
    }
}

/** Resizing array VS linked list
    Linked list: Every operation takes constant time, 
        BUT: use extra time and space deal with linked list
    Resizing-array: Every operation takes constant (average) time,
        PLUS: less wasted space.
*/

/** QUEUE */
/** Example Queue API
*/
public class QueueOfStrings{
    /* Queue Creator*/
    public QueueOfStrings()

    public void enqueue(String item)

    public String dequeue()

    public boolean isEmpty()

    public size()
}

/**implementation of Queue on Linked list 
    inner class is same as the stack Node class
*/

public class LinkedQueueOfStrings{
    private Node first, last;

    private class Node{        // Inner class
        String item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(String item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        /* In case of Empty Queue*/
        if(isEmpty()){
            first = last;
        }else{
            oldlast.next = last;
        }
    }
    public String dequeue(){
        String item = first.item;
        first = first.next;
        /*In case of Empty Queue*/
        if(isEmpty()){
            last = null;
        }
        return item;
    }
}

/** Queue implementation with resizing array
        Use array q[] to store items
        enqueue: add new item at q[tail]
        dequeue: remove item from q[head]
        Update head and tail modolo the capacity
        Add resizing array: problem! During the resize q[head] becomes q[0]
                in the new array.        
*/


/** JAVA GENERICS */

/** Implement a stack with items of type Object
        Keyword: Type-casting.
*/
StackOfObjects s = new StackOfObjects();
Apple a = new Apple();
Banana b = new Banana();
s.push(a);
s.push(b);
a = (Apple) (s.pop());

/**
    Java Generic: avoid type-casting; Detect error when compile instead of 
            run time errors.
    Java Generics Example:
*/
Stack<Apple> s = new Stack<>();
Apple a = new Apple();
Banana b = new Banana();
s.push(a);
s.push(b);
a = s.pop();  // NO TYPE CASTING NEEDED THERE !!!!

/**
    Generic Stack implementation

    Note that use generic to implement a QueueOnArray is impossible in Java
        Since java don't allow to new a generic type array"new Type[CAPACITY]" 

        Though we can use :
                s = (Type[]) new Object[CAPACITY]
        However casting should be avoided in the code.
*/
public class Stack<Type>{
    private Node first = null;
    
    /* Private inner class */
    private class Node{
        Type item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void push(Type item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public Type pop(){
        Type item = first.item();
        first = first.next;
        return item;
    }
}

/**
    Primitive Types: Integer, Character, double
    Integer has a wrapper of int
*/

/** Iterators & Iteration
    Iterable is a class that returns an Iterator 

    Iterator:  hasNext()   &   next()

    Java support Iterable: make the class implements Iterator()
    Here's a example for a for-each loop
*/
for (String s : stack){
    System.out.println(s);
}
// Equivalency
Iterator<String> i = stack.iterator();
while(i.hasNext()){
    String s = i.next();
    Syste,.out.println(s);
}

/**
    Stack iterator: linked list implementation
*/
public Iterator<Type> iterator() {
    return new ListIterator();
}

private class ListIterator implements Iterator<Type>{
    private Node current = first;

    public boolean hasNext(){
        return current != null;
    }
    public void remove(){
        /* Not supported*/
    }
    public Type next(){
        Type item = current.item;
        current = current.next;
        return item;
    }
}

/** Stack iterator: array implementaion
*/

public class Stack<Type> implements Iterable<Type>{
    public Iterator<Type> iterator(){
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator() implements Iterator<Type>{
        private int i = N;

        public boolean hasNext(){
            return i > 0;
        }

        public void remove() { /* Not supported */}
        public Type next(){
        return s[--i];
        }
    }
}

/**
    Stack & Queue application

    Stack: Parsing in a compiler, JVM, Undo in MS Office word, Back button in 
            Chrome, recursive function.
*/

/** Djikstra's 2-stack algorithm
        Value: push into the value stack.
        Operator push into the operator stack.
        Left parenthesis: ignore
        Right parenthesis: pop operator OP & pop value V1 & pop value V2, 
                push the result of expression onto the value stack
*/

/** Djikstra exmaple:   
        ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
            Value stack: 1
            Operator stack: 
        + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
            Value stack: 1
            Operator stack: 
        2 + 3 ) * ( 4 * 5 ) ) )
            Value stack: 1
            Operator stack: +
        + 3 ) * ( 4 * 5 ) ) )
            Value stack: 1  2
            Operator stack: +
        3 ) * ( 4 * 5 ) ) )
            Value stack: 1  2
            Operator stack: +   +
        ) * ( 4 * 5 ) ) )
            Value stack: 1  2   3
            Operator stack: +   +
        * ( 4 * 5 ) ) )
            Value stack: 1  5
            Operator stack: +
        4 * 5 ) ) )
            Value stack: 1  5
            Operator stack: +  * 
        * 5 ) ) )
            Value stack: 1  5   4
            Operator stack: +  *
        5 ) ) )
            Value stack: 1  5   4
            Operator stack: +  *  *
        ) ) )
            Value stack: 1  5   4   5
            Operator stack: +  *  *
        ) )
            Value stack: 1  5   20
            Operator stack: +  * 
        )
            Value stack: 1  100
            Operator stack: +
        Result
            Value stack: 101
            Operator stack: 
*/

/** implementaion of Djikstra's 2-stack algorithm */
public class Evaluate{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        while(!in.isEmpty()){
            String s = in.nextString();
            if(s.equals("(")) //Do nothing, ignore.
            else if(s.equals("+")){
                ops.push(s);
            }
            else if(s.equals("*")){
                ops.push(s);
            }
            else if(s.equals(")")){
                String op = ops.pop();
                if(op.equals("+")){
                    vals.push(vals.pop() + vals.pop());
                } else if(op.equals("*")){
                    vals.push(vals.pop() * vals.pop());
                }
            }else{
                vals.push(Double.parseDouble(s));
            }
            System.out.println(vals.pop())
        }
    }
}





