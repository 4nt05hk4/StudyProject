import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GroupFileStorage {
    public void saveGroupToCSV(Group gr, File filePath) {
        try (PrintWriter pw = new PrintWriter(filePath)) {

            String del = ",";
            Student[] students = gr.getStudents();
            for (int i = 0; i < students.length; i++) {
                if (students[i].getGender() == Gender.MALE) {
                    pw.println(students[i].getName() + del + students[i].getLastName() + del + "MALE" + del + students[i].getRecordID() + del + students[i].getGroupName());
                } else {
                    pw.println(students[i].getName() + del + students[i].getLastName() + del + "FEMALE" + del + students[i].getRecordID() + del + students[i].getGroupName());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
