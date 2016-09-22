// Quick Sort

/** Quick Sort
    $ Basic plan: 
        1. Shuffle the array
        2. Partition so that for some j, entry a[j] is in place, no larger 
                entry left to a[j] and no smaller entry greater than a[j]
        3. Sort each piece recursively

    $ Partitioning in place : don't need extra memory space
    $ Shuffle is needed for performance guarantee
    $ Best case : NlgN
    $ Worst case : Sorted array, 1/2*N^2
    $ Average : 1.39 NlgN
    $ Faster than mergesort since need less data movement

*/

/* Quick Sort Partition Method */
private static int partititon(Comparable[] a, int lo, int hi){
    int i = lo, j = hi + 1;
    while(true){
        /* Find item on the left to swap */
        while(less(a[++i], a[lo])){
            if(i == hi) break;
        }

        /* Find item on the left to swap */
        while(less(a[lo], a[--j])){
            if(j == lo) break;
        }

        /* If i and j cross then jump out the loop */
        if(i >= j) break;
        exch(a, i, j);
    }

    /* Exchange a[lo] and a[j] so that a[j] is in place */
    exch(a, lo, j); 
    /* Returned the elemen which is already in place */
    return j;
}

/* Implementation of QuickSort based on partition() */
public class Quick{
    private static int partition(Comparable[] a, int lo, int hi){
        // See class above
    }

    public static void sort(Comparable[] a){
        Random.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }
}

/** Quick sort Improvement 
    $ Too much over heads for tiny subarays
    $ Cutoff to insertion sort for around 10 items
*/

public class QuickImprove extends Quick{
    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo + CUTOFF -1){
            Insertion.sort(a, lo, hi);
            return;
        }
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }
    
}

//Selection ind the k-th larger/ small in array without sort the whole array.
/** Quick-Select
    $ Entry a[j] is in place
    $ No larger entry to the left of j
    $ No smaller entry to the right of j

    $ Average running time: N linear.
*/
public static Comparable select(Comparable[] a, int k){
    Random.shuffle(a);
    int lo = 0, hi = a.length - 1;
    while( hi > lo){
        int j = partition(a, lo, hi);
        if(j < k){
            lo = j + 1;
        }else if(j > k){
            hi = j - 1;
        }else{
            return a[k];
        }
        return a[k];
    }
}

//Duplicate Keys
/**

*/