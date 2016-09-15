/** Quick Find
    Code implementation for Quick-Find
    # Run-time:  init     union     Find
                 N        N         1
    # Defect: union cost too much, union N times cost N^2
                array access.
*/

public class QuickFindUF{

    private int[] id;

    /* Set id of each obj to itself */
    public class QuickFindUF(int N){
        id = new int[N];

        
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    /* Check whether p and q are in the same compnent */
    public boolean connected(int p , int q){
        return id[p] == id[q]; 
    }

    /* Change all entries with id[p] to id[q] */
    public void union(int p, int q){
        int pid = id[p];
        int qid = id[q];
        for(int i = 0; i < id.length; i++){
            if(id[i] == pid ){
                id[i] = qid;
            }
        }    
    }
}

/** Quick Union
    # Tree view: root of i is id[id[id[.......]]]
    
    # Find algorithm is same to QuickFind

    # Union algorithm: To merge compnent containing p and q,
        set the id of p's root to the id of q's root.

    # Trees too tall: hard to find if connnected

    # Demo
            num     0 1 2 3 4 5 6 7 8 9 
            id      0 1 2 3 4 5 6 7 8 9

        union(4,3)
            num     0 1 2 3 4 5 6 7 8 9 
            id      0 1 2 3 3 5 6 7 8 9
        union(3,8)
            num     0 1 2 3 4 5 6 7 8 9 
            id      0 1 2 8 3 5 6 7 8 9
        union(6,5)
            num     0 1 2 3 4 5 6 7 8 9 
            id      0 1 2 8 3 5 5 7 8 9
        union(9,4)
            num     0 1 2 3 4 5 6 7 8 9 
            id      0 1 2 8 3 5 5 7 8 8
        union(2,1)
            num     0 1 2 3 4 5 6 7 8 9 
            id      0 1 1 8 3 5 5 7 8 8
        connected(8,9) == true
        connected(5,4) == false
        union(5,0)
            num     0 1 2 3 4 5 6 7 8 9 
            id      0 1 1 8 3 0 5 7 8 8
        union(7,2)
            num     0 1 2 3 4 5 6 7 8 9 
            id      0 1 1 8 3 0 5 1 8 8
        union(6,1)
            num     0 1 2 3 4 5 6 7 8 9 
            id      1 1 1 8 3 0 5 1 8 8
        union(7,3)
            num     0 1 2 3 4 5 6 7 8 9 
            id      1 8 1 8 3 0 5 1 8 8
        
*/ 

public class QuickUnionUF extends QuickFindUF {
    private int[] id;

    /* Set id of each obj to itself */
    public QuickUnionUF(int N){
        id = new int[N];

        for(int i =0; i < N; i++){
            id[i] = i;
        }
    }

    /* Chase parent pointers until reach root */
    public int root(int i){
        while(i != id[i]){
            i = id[i];
        }
        return i;
    }

    /* Check if p and q have same root*/
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    /* Change the root of p to the root of q */
    public void union(int p, int q){
        int pRoot = root(p);
        int qRoot = root(q);
        id[pRoot] = qRoot;
    }
} 

/** Quick Union Improvements: weight 
    # Modify Quick-Union to avoid tall Trees.
      Keep track of size of each tree(num of obj).
      Balance by linking root of smaller tree to larger tree.

    # Data structure: same as quick-union but mantain extra arry
            sz[i] to count the number of obj in the tree root at
            i.
    # Find: Same as quick-union find   
            return root[p] == root[q];

    # Union: Modified

*/

public class QuickUnionImproveUF extends QuickUnionUF {

    public void union(int p, int q){
        int pRoot = root(p);
        int qRoot = root(q);

        if(pRoot == qRoot){
            return;
        }
        if(sz[pRoot] < sz[qRoot]){
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else{
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

    }
}

/** Quick Union Improvements: Path compression

    # From the leaf of the tree find any node, connect it to the root,
            and connect its parent to the root until it touches root.

    # Root: Modified
*/

public class QuickUnionImprove2UF extends QuickUnionImproveUF{
    public int root(int i){
        while(i != id[i]){
            /* Mod below: assign the id of parent's parent to current id*/
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
}

/**
    Percolation  
*/
