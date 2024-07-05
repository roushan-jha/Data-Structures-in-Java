import java.util.HashSet;
import java.util.Iterator;

public class Hashset {
    public static void main(String[] args) {
        // Set<Integer> set = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();

        //Insert - add
        set.add(3);
        set.add(5);
        set.add(8);
        set.add(2);

        System.out.println(set);

        //Search - contains
        if(set.contains(2)) {
            System.out.println("Contains Two");
        }

        //Delete - remove
        set.remove(2);
        System.out.println("Deleted 2 from Set");

        Iterator<Integer> it = set.iterator();

        while (it.hasNext()) {
            System.out.print(it.next()+" ");
        }
        System.out.println();
        System.out.println("Size: " +set.size());

    }
}
