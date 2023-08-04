import java.util.Comparator;

public class StudentLastNameComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Student student1 = (Student)o1;
        Student student2 = (Student)o2;
        
        if (student1 == null && student2 == null) {
            return 0; // оба студента null, считаем их равными
        } else if (student1 == null) {
            return 1; // student1 null, считаем student1 > student2
        } else if (student2 == null) {
            return -1; // student2 null, считаем student1 < student2
        }

        return student1.getLastName().compareTo(student2.getLastName());
    }
}
