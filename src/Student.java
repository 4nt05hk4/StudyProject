import java.util.Objects;

public class Student extends Human {
    private int recordID;
    private String groupName;

    public Student(String name, String lastName, Gender gender, int recordID, String groupName) {
        super(name, lastName, gender);
        this.recordID = recordID;
        this.groupName = groupName;
    }

    public Student() {
    }

    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Student {" + "name " + getName() + ", lastName " + getLastName() + ", gender " + getGender() +
                ", recordID: " + recordID + ", groupName: " + groupName + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return recordID == student.recordID && Objects.equals(groupName, student.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), recordID, groupName);
    }
}
