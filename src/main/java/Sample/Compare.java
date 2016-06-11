package Sample;

import java.util.Comparator;

/**
 * Created by Haigus on 05.06.2016.
 */

public class Compare implements Comparator<Person> {
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
