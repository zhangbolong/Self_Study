// Merge Sort

/** Merge sort 
    $ basic plan:
        Divide array into two parts, recursively sort each part 
        and merge two parts.
    
*/
private static void merge(Comparable[] a, comparable[] aux, 
    int lo, int mid, int hi){
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, int hi);

        /* Copy Original array into auxilary array */
        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for(int k=lo; k <= hi;k++){
            // If left array is exhausted, pass he right to a[]
            if(i > mid){
                a[k] = aux[j++]; 
            }else if(j < hi){ // If right exhausted, pass let to a[]
                a[k] = aux[i++];
            }else if(less(aux[j], aux[i])){
                a[k] = aux[j++];
            }else{
                a[k] = aux[i++];
            }
        }
        assert isSorted(a, lo, hi);
}

// Assertions

/** Enable and disable java assertions 
    $java -ea MyProgram
    $java -ea MyProgram
*/

/** Merge Sort implementation
    $ Running time : N * log N
    $ Need extra space for aux[]

*/

public class Merge{
    private static void merge(){}

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if(hi <= lo ) return;
        int mid = lo + (hi -lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, aux, 0, a.length -1); 
    }
}

/** Improvements to Merge Sort
    $ When handle a small array, we can use a insertion sort 
        to avoid memory use.
    $ Stop if array is already sorted

*/
public class MergeImprove extends Merge{
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        // If array size less than CUTOFF, use insertion sort.
        if(hi <= lo + CUTOFF - 1){
            Insertion.sort(a, lo, hi);
            return;
        }
        int mid = lo + (hi -lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid, hi);
        if(!less(a[mid + 1], a[mid])) return; // Stop if sorted
        merge(a, aux, lo, mid, hi);
    }
}  

// Bottom-up merge sort
/**
    $ Basic plan:
        First go over array, merge subarray of size 1(each entry)
        Repeat for subarrays of size 2, 4, 8, 16....
*/
public class MergeBU extends public class MergeImprove{
    public static void sort(Comparable[] a){
        int N = a.length;
        aux = new Comparable[N];
        for(int sz = 1; sz < N, sz = sz + sz){
            for(int lo = 0; lo < N -sz; lo += sz + sz){
                merge(a, lo, lo + sz -1, Math.min(lo + sz +sz -1, N -1));
            }
        }
    }
}

// Sorting Complexity

/**
    $ Cost model: # of compares
    $ Upper Bound: N logN for merge sort
    $ Lower Bound: Any compare based sorting algorithms must use at least
            lg(N!) ~ Nlg(N) compares in the worse case.
    $ Optimal algorithm = merge sort.
    $ Mergesort is optimal with # of compares, but not optimal with respect 
            to memory space useage.
*/

// Comparators: sort with different topics

/** JAVA Comparators
    $ To support comparators in sort implementations:
        1. Use Object instead of Comparable
        2. Pass Comparator to sort() and less() and use it in less()
*/
/* Insertion sort using a comparator */
public class InsertWithComparator{
    public static void sort(Object[] a, Comparator comparator){
        int N = a.length;
        for(int i = 0; i < N; i++){
            for(int j = i; j > 0 && less(comparator, a[j], a[j - 1]); j--){
                exch(a[j], a[j -1]);
            }
        }
    }

    private static boolean less(Comparator c, Object v, Object w){
        return c.compare(v,w) < 0;
    }

    private static void exch(Object[] a; int i, int j){
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}

// Stability 
/**

    $ A stable sort preseves the relative order of items with equal keys.
        Exmaple: if sort by last name the student number will in acsending 
                    order for the same last name students.
    $ Insertion and Mergesort are stable.
    $ Selection, Shellsort and Quicksort are not stable.
*/

