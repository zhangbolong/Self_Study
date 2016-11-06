//Hash Tables

/** Hash functions 
    # Java class inherit a method hashcode(), returns a 32 bit int.

    Requirement: if x == y, then hashcode(x) == hashcode(y)
    Optional:    if x != y, then hashcode(x) != hashcode(y)


*/

/* Implenetations for different types */
public final class Integer{
    private final int value;
    ...
    public int hassCode(){
        return value;
    }
}

public final class Double{
    private final double value;
    ...
    public int hashCode(){
        long bits = doubleToLongBits(value);
        return (int) (bits ^ (bits >>> 32));
    }
}

public final clas Boolean{
    private final boolean value;
    ...
    public int hashCode(){
        if (value) return 1231;
        else       return 1237;
    }
}

/** String hashcode
    # Treat string of length L as L-digit, base 31 number

    # Performance optimization:
            Cache the hash value in an instance variable.
            Return cached value.
*/
public final class string{
    private int hash = 0;   //cache of hash code
    private final char[] s;
    ...
    public int hashCode(){
        int h = hash;           // return cached value
        if(h != 0) return h;
        for(int i = 0; i < length(); i++)
            h = s[i] + (31 * h);
        hash = h;       // store cache of hash code
        return h;
    }
}

/** HashCode design
    # Combine each significant field using the 31x + y rule
    # If field is a primitive type, use wrapper type hashCode().
    # If field is null, use 0.
    # If field is a reference type, use hashCode().
    # If field is an array, apply to each entry.
*/