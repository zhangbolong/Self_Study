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

        /* Find item on the right to swap */
        while(less(a[lo], a[--j])){
            if(j == lo) break;
        }

        /* If i and j cross then jump out the loop */
        if(i >= j) break;
        exch(a, i, j);
    }

    /* Exchange a[lo] and a[j] so that a[j] (old a[lo])is in place */
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

//Select the k-th larger/ small in array without sort the whole array.
//Just like SQL SELECT ..... TOP # / LIMIT #.
/** Quick-Select
    $ Entry a[j] is in place
    $ No larger entry to the left of j
    $ No smaller entry to the right of j

    $ Average running time: N linear.
*/
public static Comparable selectTop(Comparable[] a, int k){
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

// Duplicate Keys
/** Duplicate Keys
    $ Merge sort with duplicate keys: Always between 1/2 NlgN and NlgN compares

    $ Quick sort with duplicate keys: Goes Quadratic unless partitioning stops
            on equal keys.
    $ We want to put all items equal to the partitioning item in place
    
    $ Partition array into 3 part so that :
            1. The middle part are all equal partitioning items
            2. No larger entries to left of lt
            3. No smaller entries to right of gt
        [lo] [.........] [lt] [==========] [gt] [...........] [hi] 

    $ Randomized quicksort with 3 way partitioning reduces running time
            from NlgN -->  N in most occations.

*/

/** Dutch national flag problem [Dijistra] s-way Partitioning

       $ Let v be partitioning item a[lo]
       $ Scan i from left to right:
                1. (a[i] < v): exchange a[lt] with a[i]; i++; li++;
                2. (a[i] > v): exchange a[gt] with a[i], gt--;
                3. (a[i] == v): i++;
      [lo]  [... < V ] [lt] [V] [i] [====v====] [gt] [ > V .....] [hi]

 */

 private static void sort(Comparable[] a, int lo, int hi){
     if(hi <= lo) return;
     int lt = lo, gt = hi;
     Comparable[] v = a[lo];
     int i = lo;
     while(i < gt){
         int cmp = a[i].compareTo(v);
         if(cmp < 0){
             exch(a, lt++, i++);
         }else if(i > gt){
             exch(a, i, gt--);
         }else{
             i++;
         }

         sort(a, lo, lt - 1);
         sort(a, gt + 1, hi);
     }
 }

//System Sorts

/** Java array sort 
    $ Different method for each primitive type
    $ Has method for data types that implements Comparable
    $ Has method uses Comparator
    $ Used tuned Quicksort for primitive types; Tuned mergesort for objects
*/
String[] a;
Arrays.sort(a);
/**
    
*/
