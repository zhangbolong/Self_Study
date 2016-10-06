// 2-3 Search Trees

/** 2-3 Search Tree
    $ Idea: allow 1 or 2 keys per node
    $ 2-node: one key, two children
    $ 3-node: two keys, three children

    $ Perfect balance: every path From root to null links has same length.
    $ Symmetric order: Inorder traversal yields keys in ascending order.

    $ Search: Compare search key against keys in node
            Find interval containing search key
            Follow associated link(recursively)
    $ Insert:
            1. Insert into a 2-node at bottom
                    Search for key, as usual, repalce 2-node with 3-node
            2. Insert into a 3-node at bottom
                    Add new key to 3 node to create temp 4-node, then move 
                        middle key in 4 node into parent.
            3. Repeat step 2 up the tree, as necessary, if reach the root 
                    and it becomes a 4-node, split it into three 2-nodes:
                    take middle one to the new root and L and R become the
                    L and R children of the new root.
    $ Tree height:  
                Worst case: lgN
                Best case: 0.631lgN
    ~~~~~~~~~~~~HAHAHAHAHAHAHAHAHAHAHA~~~~~~~~~~~~~~
    $ Implementation: hardly possible(EXCUSE ME???) HAHAHAHAHAHAHAHAHAHAHA

*/

/*---------------------------------------------------------------------------*/

//Red-Black BSTs
/** Red-Black BSTs
    $ idea: represent 2-3 tree as BST 
            Use "internal" left leaning links as "glue" for 3 nodes
    
    $ A BST such that:
            No nodes has two red links connected to it.
            Every path from root to null link has the same number of 
                black links.
            Red links lean left.
    
    $ Search is the same as BST(but runs faster since more balance)

    $ basic plan: Maintain 1-1 correspondence with 2-3 tree by applying
            elementary red-black BST operation.

    $ Height of tree is <= 2lgN in the worst case
    $ Performance: all actions(search, insert, delete) is C*lgN
*/

private static final boolean RED = true;
private static final boolean BLACK = false;

private class Node {
    Key key;
    Value val;
    Node left, right;
    boolean color;
}

private boolean isRed(Node x){
    if(x == null) return false;
    return x.color == RED;
}

/* Left rotation: 
    Turn a right leaning red link to left leaning.
    A(BC(DE)) ---> C(A(BD)E)    
*/
private Node rotateLeft(Node h){
    assert isRed(h.right);
    Node x = h.right;
    h.right = x.left;
    x.left = h;
    x.color = h.color;
    h.color = RED;
    return x;
}
/* Right rotation: 
    Turn a left leaning red link to right leaning.
*/
private Node rotateRight(Node h){
    assert isRed(h.left);
    Node x = h.left;
    h.left = x.right;
    x.right = h;
    x.color = h.color;
    h.color = RED;
    return x;
}
public Val get(Key key){
    Node x = root;
    while (x != null){
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x = x.left;
        else if(cmp >0) x = x.right;
        else return x.val
    }
    return null;
}

/* Color flip: 
    re-color to split a (temp) 4-node
*/
private void flipColors(Node h){
    assert !isRed(h);
    assert isRed(h.left) && isRed(h.right); 
    h.color = RED;
    h.left.color = BLACK;
    h.right.color = BLACK;
}

/* Insert   
    $ Insert into a tree with 1 node:
        If goes left, then just add red link to left;
        If goes right, add red link to right and rotateLeft()
    $ Insert into a 2-node at the bottom:
        Do standard BST insert, color new link red;
        If new red link is a right link, rotate left.
    $ Insert into a tree with 2 nodes:
        Larger: attach new node with red link and flipColors
        Smaller: attach new node with red link, rotate right and flipColor
        Between: attach new node with red link, (rotateLeft), rotateRight,
                and then flipColor. 
    $ Insert a 3-node at the bottom:
        Do standard BST insert, color new link red. Rotate to balance the 
            4 node(if needed), flipColors to pass red link up one level,
            rotate to make lean left(if needed). Repeat 
*/

/** Implementation
    $ Same Code handles all cases.
        L-black-R-red ----> rotateLeft
        L-red-R-black ----> rotateRight
        Both children red ----> flipo color.

*/

private Node put(Node h, Key key, Value val){
    // If no node in the tree
    if(h ==null) return new Node(key,val,RED);
    int cmp = key.compareTo(h.key);
    if(cmp < 0) h.left = put(h.left, key, val);
    else if(cmp > 0) h.right = put(h.right, key, val);
    else(h.val = val); // If already have key, update the value

    if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
    if(isRed(h.left) && !isRed(h.right)) h = rotateRight(h);
    if(isRed(h.right) && isRed(h.left)) flipColors(h);
}

// B-Trees

/** B-Trees
    
*/