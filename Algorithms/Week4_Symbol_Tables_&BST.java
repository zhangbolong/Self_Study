// Symbol tables (sorted Map)
/** Symbol tables
    Insert a value with specific key.
    given a key, search for the corresponding value

    $ Conventions: 
            NULL is not allowed in value
    $ Basic API:
            Method get() returns NULL if key not present
            Method put() overwrites old value with new value

    $ Type:
            1. value: any generic Type.
*/
/* API */
public class ST<Key, Value>{
    ST()
    void put(Key key, Value value)
    Value Get(Key key)
    boolean constains(Key key)
    boolean isEmpty()
    int size()
    Iterable<Key> keys()
}

/** Test Clients */
public static void main(String[] args){
    ST<String, Integer> st = new ST<String, Integer>();
    for(int i =0; ! StdIn.isEmpty(); i++){
        String key = StdIn.readString();
        st.put(key,i);
    }
    for(String s : st.keys()){
        StdOut.println(s + " " + st.get(s));
    }
}

/** Frequency Counters
    $ Read in a sequence eof string from standard intput and print out one that
                 occurs with highest frequency.        
*/
public class FrequencyCounter{
    public static void main(String[] args){
        int minlen = Integer.parseInt(args[0]);
        while(!StdIn.isEmpty()){
            String word = StdIn.readString();
            if(word.length() < minlen)){
                continue;
            }
            if(!st.contains(word)){
                st.put(word, 1);
            }else{
                st.put(word. st.get(word) + 1);
            }
            String max = "";
            st.put(max, 0);
            for(String word : st.keys()){
                if(st.get(word) > st.get(max)){
                    max = word;
                }
            }
            StdOut.println(max + " " + st.get(max));
        } 
    }
}

/*Implementation*/
public Value get(Key key){
    if(isEmpty()){
        return null;
    }
    int i = rank(key);
    if(i < N && keys[i].compareTo(key) == 0){
        return vals[i];
    }else{
        return null;
    }
}

private int rank(Key key){
    int lo = 0, hi = N -1;
    // Start the binary search
    while(lo <= hi){
        int mid = lo + (hi -lo) /2;
        int cmp = key.compareTo(keys[mid]);
        if(cmp < 0){
            hi = mid - 1;
        }else if(cmp > 0){
            lo = mid + 1;
        }else(
            return mid;
        )
    }
    return lo;
}

// Binary Search Trees
/** Binary search Trees
    $ Larger than all keys in its left subtree
    $ Smaller than all keys in its right subtree

    $ A node is compreised of four fields:
            A key and a value.
            A reference to the left and right subtree
    $ Realistic Search time : 2*ln N
    $ Realistic Tree height: 4.3 ln N
    $ Worse case tree height: N
*/

/* Node represetation*/
private class Node{
    private Key key;
    private Value val;
    Private Node left, right;
    public Node(Key key, Value value){
        this.key = key;
        this. val = val;
    }
}


/* BST Implementation */
public class BST<Key extends Comparable<Key>, Value>{
    private node root;

    private class Node{
        private Key key;
        private Value val;
        Private Node left, right;
        public Node(Key key, Value value){
            this.key = key;
            this. val = val;
        }
    }

    public void put(Key key, Value val){
        root = put(root, key, val);
    }

    // Private for put()
    private Node put(Node x, Key key, Value val){
        // Recursion stop statement
        if(x == null) return new Node(key,val);
        // Start recursion
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = put(x.left, key , val);
        else if(cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        return x;
    }

    public Value get(Key key){
        Node x = root;
        While(x != null){
            int cmp = key.compareTo(x.key);
            if(cmp < 0){
                x = x.left;
            }else if(cmp > 0){
                x = x.right;
            }else{
                return x.val;
            }
            return null;
        }
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node x){
        if(x.left == null) return x. right;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node x, Key key){
        if(x == null) return null;
        // Find the key want to delete
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = delete(x.left, key);
        else if(cmp > 0) x.right = delete(x.right, key);
        else{
            if(x.right == null) return x.left;
            if(x.left == null) return x.right;

            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    } 

    public Iterable<Key> iterator(){
        Queue<key> q = new Queue<Key>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node x, Queue<Key> q){
        if(x ==null) return;
        inorder(x.left, q);
        q.enqueue(x.key);
        inorder(x.right, q);
    }
}


