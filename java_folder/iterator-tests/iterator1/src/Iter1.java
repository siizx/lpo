import java.util.ArrayList;
import java.util.Iterator;

public class Iter1 {
    public static void main(String[] args) throws Exception {

        // Creo l'array:

        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(43);
        nums.add(64);
        nums.add(89);
        nums.add(26);
        nums.add(-29);
        nums.add(1002);

        // Inizializzo l'Iterator:

        Iterator<Integer> it = nums.iterator();

        // Stampo in modo ordinato:

        System.out.println("\n");

        // / Ecco come si usa l'iterator:

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\nEnd.");

    }
}
