import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GroupFileStorage {
    public static void saveGroupToCSV(Group gr, String destinationFolder) {
        File file = new File(destinationFolder);
        try (PrintWriter pw = new PrintWriter(file)) {
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

    public static Group loadGroupFromCSV(File file) {
        Group group = new Group();
        group.setGroupName(file.getName().substring(0, file.getName().lastIndexOf(".")));
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] studentData = line.split(",");

                if (studentData.length == 5) {
                    String name = studentData[0];
                    String lastName = studentData[1];
                    Gender gender = Gender.valueOf(studentData[2].toUpperCase());
                    int recordID = Integer.parseInt(studentData[3]);
                    String groupName = studentData[4];

                    Student student = new Student(name, lastName, gender, recordID, groupName);
                    group.addStudent(student);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error while converting number: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error while reading student gender: " + e.getMessage());
        } catch (GroupOverflowException e) {
            System.out.println("This group is full: " + e.getMessage());
        }

        return group;
    }

    public static File findFileByGroupName(String groupName, File workFolder) {
        if (!workFolder.isDirectory()) {
            throw new IllegalArgumentException("workFolder should be a directory.");
        }

        File[] files = workFolder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    File findFile = findFileByGroupName(groupName, file);
                    if (findFile != null) {
                        System.out.println("Found file: " + findFile.getAbsolutePath());
                        return findFile;
                    }
                } else if (file.getName().equals(groupName)) {
                    System.out.println("Found file: " + file.getAbsolutePath());
                    return file;
                }
            }
        }

        System.out.println("File with group name '" + groupName + "' not found in the given folder.");
        return null;
    }
}
