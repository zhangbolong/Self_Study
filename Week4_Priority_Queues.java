// Priority Queues
/**
    $ Priority Queue: remove the largests( or the smallest) item

    $ Requirement: Gemeric types are comparable

    $ Chanllenge: Find the largest M items in a stream of N items
            Fraud detection: isolate $$ transactions
            File maintenance: find biggest files or directories
    $ Constrains: Not enough memory to store N items
*/ 
public class UnorderedMaxPQ<Key extends Comparable<Key>>{
    private Key[] a;
    private int N;

    public UnorderedMaxPQ(int capacity){
        pq= (key[]) new Comparable[capacity];
    }
    public boolean isEmpty(){
        return N ==0;
    }
    public void insert(key x){
        pq[N++] = x;
    }

    public Key delMax(){
        int max = 0;
        for(int i = 0; i < N; i++){
            if(less(max,i)){
                max = i;
            }
            exch(max, N-1);
            return pq[--N];
        }
    }
}

// Binary Heaps
/** Binary Heaps
    $ Heap == A complete binary tree: perfectly balanced except 
            for the bottom level.
    $ Heap-ordered binary tree.
            Parent's key no smaller than the children's keys
    $ Array representation: 
            Indices start at 1.
            HEAP-ARRAY_RULES !!! 

    $ Properties:
            1. a[1] is the largest key, which is the root.
            2. Parent of node at k is at k/2
            3. Children of node at k are 2k and 2k+1        

    $ Promotion in Heap
            $ When Children's key becomes largeer key than its parents' key:
                    1. Exchange key in child with key in parents
                    2. repeat until heap order restored.
    
    $ Insertion in a heap: add node at the leaf, then swim up.
                Cost: At most 1 + lgN compares

    $ Demotion in a heap: When parent's key becomes smaller than one(or both)
                of its children's:
                    1. Exchange key in partent with key in larger child
                    2. Repeat until heap order restore.
    $ Deletion the maximum in a heap: 
                1. Delete max: exchage root with node at end then sink it down.
                Cost: at most 2lgN compares.
*/

/* Implementation of Promotion in heap */


/* Implementation of Insertion in heap */


/* Implementation of Demotion in heap */


/* Implementation of Deletion in heap */


/** Full implementation of binary heap */
public class MaxPQ<Key extends Comparable<Key>>{
    private Key[] pq;
    private int N;

    public MaxPQ(int capacity){
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty(){
        return N == 0;
    }
    public void insert(Key key){
        pq[++N] = x;
        swimUp(N); 
    }
    public Key delMax(){
        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N+1] = null;
        return max;
    }

    private void swimUp(int k){
        while(k > 1 && less(k/2, k)){
            exch(a, k/2, k);
            k = k / 2;
        }
    }
    private void sink(int k){
        while(2*k <= N){
            int j = 2*k;
            // if right children > left, then exch with right one.
            if(j < N && less(j, j+1)){
                j++;
            }
            if(!less(k,j)){
                break;
            }
            exch(k,j);
            k = j;
        }
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }
    private void exch(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}


