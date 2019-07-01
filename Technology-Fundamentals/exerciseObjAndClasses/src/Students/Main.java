package Students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader
                (new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = reader.readLine().split("\\s+");
            String firstName = data[0];
            String secondName = data[1];
            double grade = Double.parseDouble(data[2]);

            Student student = new Student(firstName, secondName, grade);

            students.add(student);

        }

        students.stream().sorted((p1,p2) -> Double.compare(p2.getGrade(), p1.getGrade()))
                .forEach(student -> {
                    System.out.println(student.toString());
                });
    }
}
