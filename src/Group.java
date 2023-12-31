import java.util.Arrays;
import java.util.Objects;

public class Group {
    private String groupName;
    private final Student[] students;

    public Group() {
        students = new Student[10];
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void addStudent (Student student) throws GroupOverflowException {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                System.out.println(student + " was successfully added");
                return;
            }
        }
        throw new GroupOverflowException("This group is full");
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (Student student : students) {
            if (student != null) {
                if (Objects.equals(lastName, student.getLastName())) {
                    return student;
                }
            }
        }
        throw new StudentNotFoundException("Student not found");
    }

    public boolean removeStudentByID(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (id == students[i].getRecordID()) {
                    students[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public Student[] sortStudentsByLastName() {
        Arrays.sort(this.students, new StudentLastNameComparator());
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                System.out.println(students[i].toString());
            }
        }
        return students;
    }

    public boolean ifGroupHasClone (Student student) {
        for (int i = 0; i < this.students.length; i++) {
            if (student.equals(this.students[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(groupName, group.groupName) && Arrays.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(groupName);
        result = 31 * result + Arrays.hashCode(students);
        return result;
    }
}
