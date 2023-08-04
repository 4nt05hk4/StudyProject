import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Group group1 = new Group();
        Student student = new Student("Anton", "Fomenko", Gender.MALE, 1, "group1");
        Student student1 = new Student("Dmitriy", "Sternenko", Gender.MALE, 2, "group1");
        Student student2 = new Student("Oksana", "Frolova", Gender.FEMALE, 3, "group1");
        Student student3 = new Student("Albert", "Vasnetsov", Gender.MALE, 4, "group1");
        Student student4 = new Student("Diana", "Konovalenko", Gender.FEMALE, 5, "group1");
        Student student5 = new Student("Anatoliy", "Popovich", Gender.MALE, 6, "group1");
        Student student6 = new Student("Irina", "Zaytseva", Gender.FEMALE, 7, "group1");
        Student student7 = new Student("Jane", "Watson", Gender.MALE, 8, "group1");
        Student student8 = new Student("Alex", "Sidorov", Gender.MALE, 9, "group1");
        Student student9 = new Student("Igor", "Petrov", Gender.MALE, 10, "group1");
        Student student10 = new Student("Egor", "Shapovalov", Gender.MALE, 11, "group1");

        Student[] students = new Student[] {student, student1, student2, student3, student4, student5,
                                            student6, student7, student8, student9, student10};

        try {
            for(int i = 0; i < students.length; i++) {
                group1.addStudent(students[i]);
            }
        } catch (GroupOverflowException e) {
            e.printStackTrace();
        }

        System.out.println();
        try {
            System.out.println(group1.searchStudentByLastName("Frolova"));
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(group1.searchStudentByLastName("Pavlov"));
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println(group1.removeStudentByID(11));

        System.out.println();
        group1.sortStudentsByLastName(group1.getStudents());

//        Group group2 = new Group();
//        try {
//            group2.addStudent(StudentConsoleReader.consoleReader());
//        } catch (GroupOverflowException e) {
//            e.printStackTrace();
//        }

        GroupFileStorage gfs = new GroupFileStorage();
        File file = new File("");
        gfs.saveGroupToCSV(group1, file);

    }
}