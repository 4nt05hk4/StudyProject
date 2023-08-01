import java.util.Scanner;

public class StudentConsoleReader {
    public static Student consoleReader () {
        Scanner scan = new Scanner(System.in);
        Student student = new Student();
        System.out.println("Please set the student's name:");
        student.setName(scan.nextLine());
        System.out.println("Please set the student's last name:");
        student.setLastName(scan.nextLine());
        System.out.println("Please set the student's gender 0-MALE 1-FEMALE:");
        if (scan.nextInt() == 0) {
            student.setGender(Gender.MALE);
        } else if (scan.nextInt() == 1) {
            student.setGender(Gender.FEMALE);
        } else System.out.println("Incorrect format");
        System.out.println("Please set the student's record ID:");
        student.setRecordID(scan.nextInt());
        System.out.println("Please set the student's group name:");
        scan.nextLine();
        student.setGroupName(scan.nextLine());
        return student;
    }
}
