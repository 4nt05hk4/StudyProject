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
}
