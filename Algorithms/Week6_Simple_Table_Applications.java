/* Set interface */

public class SET<Key extends Comparable<Key>>{
    private class SET(){};
    public void add(Key key){};
    public boolean contains(Key key){};
    public void remove(Kye key){};
    public int size(){};
    public Interater<Key> iterator(){};
}

/** Exception filter
    # Read in a list of words from one file
    # Print out all words that are not in the list

    Example: Spell checker, browser to mark visited pages, parental controls,
            spam filter.
*/
public class BlackList{
    public static void main(String[] args){
        SET<String> set = new SET<String>();

        // read in white list
        Scanner fin = new Scanner(args[0]);
        Scanner in = new Scanner(System.in);
        while(!fin.isEmpty())
            set.add(fin.nextLine());
        //print words not in list
        while(!in.atEOS()){
            String word = in.nextLine();
            if(!set.contains(word))
                System.out.println(word);
        }
    }
}

/** Dictionary Lookup
    # CSV -- comma seperate value-----Key, value
    # Exmaple: DNS lookup
*/
public class LookupCSV{
    public static void main(string[] args){
        // process input file
        File file = new File(arg[0]);
        Scanner fin = new Scanner(file);

        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);
        // build Map
        Map<String, String> map = new Map<String, String>();
        while(in.isEmpty()){
            String line = fin.readLine();
            String[] tokens = line.split(",");
            String key = tokens[keyField];
            String val = tokens[valField];
            map.put(key, val);
        }
        // process lookups withg standard I/O
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(!map.contains(s))    System.out.println("Not found");
            else                    System.out.println(map.get(s));
        }
    }
}

