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





