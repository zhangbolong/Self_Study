// 1 d range search
/** 1 d range search
    # One dimensional search
    Range search: Find all keys between k1 and k2
    Range count: Number of the keys between k1 and k2

    # Applications: Database queries
*/

/** 
        Unordered Array implementation --- linear time of search and count
        Ordered Array --- logN for search and insert but linear for insert
        Goal --- insert, search and count all logN


*/
public int size(Key lo, Key hi){
    if(contains(hi))    return rank(hi) - rank(lo) + 1;
    else                return rank(hi) - rank(lo);
}

/** 1- dimension Range search
    # Find all keys between k1 and k2
            # Recursively find all keys in left subtree
            # Check key in current node 
            # recuisively find all keys in right subtree 
*/

// Line segment intersection

/**  Line segment intersection
    # N^2 time ----  Check all pairs of line segments for intersection
    # Orthogonal line segment intersection - 正交线段交叉
*/

/**  Sweep-line algorithm
    # Sweep vertical line from left to right.
            # x-coordinates define events 
            # h - segments: insert y-coordinates into BST
            # h - segments: remove y-coordinates from BST
            # v - segments: range seach for interval of y-endpoint
        Ruuning time: NlogN
*/

//kd trees
/** kd trees
    # Geometric interpretation.
        ・Keys are point in the plane.
        ・Find/count points in a given h-v rectangle
    
    # 2d Orthogonal range serach: Grid implementation
        ・Divide space into M-by-M grid of squares.
        ・Create list of points contained in each square.
        ・Use 2d array to directly index relevant square.
        ・Insert: add (x, y) to list for corresponding square.
        ・Range search: examine only squares that intersect 2d range query.
    # Rules to Choose M : M = sqrt(N)
    # But this algorithm is slow when all point clusted in the same grid
*/

/** Space Partitioning trees
    # 2-d tree construction: Recursively Partition plane into two half planes
        ~ level 1, 3, 5, 7 ... of the tree: horizontal line
        ~ level 2 ,4, 6, 8, ... : vertical lines

    # Running time: logN. (Worst case: sqrt(N))

    # Nearest Neighbor search
*/

/** Flocking boids [Craig Reynolds, 1986]
    # Boids. Three simple rules lead to complex emergent flocking behavior:
        ・Collision avoidance: point away from k nearest boids.
        ・Flock centering: point towards the center of mass of k nearest boids.
        ・Velocity matching: update velocity to the average of k nearest boids.
*/

/** Kd tree
    # Recursively partition k-dimensional space into 2 halfspaces
*/

/** 1 dimention interval search API
     
*/
public class IntervalST<Key extends Comparable<Key>, Value>{
    private class IntervalST(){}
    public void put(Key lo, Key hi, Value val){}
    public Value get(Key lo, Key hi){}
    public void delete(Key lo, Key hi){}
    public Iterable<Value> intersects(Key lo, Key hi){}
}

/**
    #Create BST, where each node stores an interval ( lo, hi ).
        ・Use left endpoint as BST key.
        ・Store max endpoint in subtree rooted at node.
    # To search for any one interval that intersects query interval ( lo, hi ) :
        ・If interval in node intersects query interval, return it.
        ・Else if left subtree is null, go right.
        ・Else if max endpoint in left subtree is less than lo, go right.
        ・Else go left.
    # To insert an interval ( lo, hi ) :
        ・Insert into BST, using lo as the key.
        ・Update max in each node on search path.
    
*/