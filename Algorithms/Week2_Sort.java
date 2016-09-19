/** How to design sort implementation which can sort different types of data?
    Client pass array of objects to sort() function, calls compareto()

    Java: interfaces
*/

/* Client */
import java.io.File;
public class FileSorter{
    public static void main(String[] args){
        File directory = new File(args[0]);
        File[] files = directory.listFiles();
        Insertion.sort(files);
        for(int i = 0; i < files.length; i++){}
            System.out.println(files[i].getName());
        }
    }
}

/* Comparable interface (built in to java)*/
public interface comparable<Type>{
    public int compareTo(Type that);
}

/* Sort implementation */
public static void sort(Comparable[] a){
    int N = a.length;
    for(int i = 0; i < N; i++){
        for(int j = i; j > 0; j--){
            if(a[j].compareTo(a[j-1]) < 0){
                exch(a, j, j-1);
            }else{
                break;
            }
        }
    }
}

/**
    compareTo() returns negative if less than, positive if greater than, 
            and returns 0 if equal. Throughs exception if not comparable
*/
/* Simplified version of java.util.Date */
/* Generic date is Date because it only compares with other dates */
public class Date implements Comparable<Date>{  
    private final int month, day, year;

    public Date(int m, int d, int y){
        month = m;
        day = d;
        year = y;
    }

    public int compareTo(Date that){
        if(this.year < that.year)   return -1;
        if(this.year > that.year)   return 1;
        if(this.month < that.month) return -1;
        if(this.month > that.month) return 1;
        if(this.day < that.day) return -1;
        if(this.day > that.day) return 1;   
        return 0;
    }
}

/** Helper functions: less() & exch()
    less(): is item v less than w?
    exch(): Swap item in array a[] at index i with one at index j.
*/
private static boolean less(Comparable v, Comparable w){
    return v.compareTo(w) < 0;
}

private static void exch(Comparable[] a, int i, int j){
    Comparable swap = a[i];
    a[i] = a[j];
    a[j] = swap;
}

/* isSorted(): test if an array is sorted */
private static boolean isSorted(Comparable[] a){
    for(int i = 1; i < a.length; i++){
        if(less(a[i], a[i-1]))   return false;
    }
    return true;
}

// Elementary Sort
/** Selection sort
    Main idea: repeatly select the smallest and put it at front.
    Two group: sorted[] and remain[].
    Initial: all entries are remain[].
    Step: find the smallest in remain[], swap with the first in remain[] and 
            makes the first of remain[] in the sorted[] group.
    That mean if you have N items, you have to do (N! - 1) in total to find smallest,
    And (N - 1) times to move items from remain[] to sorted[].

    Invariants: 
                    sorted[] are fix and in asending order;
                    No entry in remain[] are smaller than those in sorted[].

    Running time: Quadratic even if is sorted. Linear time of use exch().
*/
 public class Selection{
     public static void sort(Comparable[] a){
         int N = a.length;
         for(int i = 0; i < N; i++){
             int min = i;
             for(int j = i + 1; j < N; j++){
                 if(less(a[j],a[min])){
                     min = j;
                 }
             }
             exch(a, i, min);
         }
     }
     /* Helper functions same as above */
     private static boolean less(Comparable v, Comparable w){}
     private static void exch(Comparable a[], int i, in j){}
 }

 // Insertion sort

 /** Insertion sort
    Idea: pick one from unsorted group each, swap with left one if its smaller
            than the left one, continue doing this until it's greater than the 
            left one. Then pick anothe from unsorted until all are sorted.
    
    Invariants: 
            Entries in the sorted[] group are in ascending order.
            Entries in the remain[] are unsorted.
    Running time: 
            Random order: 1/4 * N^2 ;
            Best case(All sorted): N -1 ;
            Worse case(All in descending): 1/2 * N^2 .
 */
public class Insertion{
    public static void sort(Comparable[] a){
        int N = a.length;
        /* i goes all entries and j goes only the sorted */
        for(int i = 0; i < N; i++){
            for(int j = i; j > 0; j--){
                if(less(a[j], a[j-1])){
                    exch(a, j, j-1);
                }else{
                    break;
                }
            }
        }
    }

    /* Helper functions same as above */
     private static boolean less(Comparable v, Comparable w){}
     private static void exch(Comparable a[], int i, in j){}
}

//Shell sort

/** Shell Sort
    $ h-array: Array that partite into h sub-arrays

    $ If a array has length of 10, we can do 7-sort, 3-sort and 1-sort to 
        complete a shell sort.And a 3-sorted array is still a 7-sorted array!

    $ What increment sequence should we use  in shell sort?
        Acceptable solution: 3X+1: 1, 4, 13, 40....
        Good solution:1, 5, 19, 41, 109, 209, 505, 929, 2161, 3905.(Sedgewick)

    $ Shell sort is rather fast, easy to write, and is hardware sort prototype.
    $ Simple algorithm, average performance.

*/
public class Shell{
    public class void sort(Comparable a[]){
        int N = a.length;

        /* Create 3X+1 increment sequence */
        int h = 1;
        while(h < N/3){
            h = 3*h + 1;
        }
        /* Start h-sort */
        while(h > -1){
            /* Start Insertion Sort */
            for(int i = h; i < N; i++){
                for(int j = i; j >= h && less(a[j], a[j-h]); j -=h){
                    exch(a, j, j-h);
                }
            }
            /* Start next h-sort */
            h = h/3;
        }

    }
    /* Helper functions same as above */
     private static boolean less(Comparable v, Comparable w){}
     private static void exch(Comparable a[], int i, in j){}
}

// Shuffle: Unsorted the sorted

/** Knuth Shuffling "washing cards" 洗牌
    $ How to make a poker in random sequence?
            Generate a random index number for each card. And then sort 
            the card by its index.
    $ Drawback: requires cost of sorting time.
    $ Knuth Shuffling Algorithm: similar to insertion sort, Linear time complexity
            Difference from insertion: pick random one in the sorted array 
            and swap instead of compare one by one.
*/ 
import java.util.Random;
public class shuffleRandom{
    public static void shuffle(object[] a){
        int N = a.length;
        for(int i = 0; i < N; i++){
            /* Generate random integer between 0 and i */
            int r = Random.nextInt(i + 1);
            exch(a, i, r);
        }
    }
    /* Helper functions same as above */
     private static void exch(Comparable a[], int i, in j){}
}

// Bug in the online poker game
/** Shuffling algorthim which pick every card and swap with random card 
    $BUG 1 : never reach No.52 card, didn't shuffle the 52nd card.
    $BUG 2 : random() use 32-bit seeds, only 2^32 possibilities, but
                there could be more shuffle results.
*/
for(int i = 1; i < 52; i++){
    r = random(51) + 1;
    swap = card[r];
    card[r] = card[i];
    card[i] = swap;  
}







