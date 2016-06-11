package Sample;

import java.util.Comparator;

public class Compare implements Comparator<Person> {
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
