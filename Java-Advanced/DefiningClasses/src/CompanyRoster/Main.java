package CompanyRoster;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Department> departments = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String departmentName = tokens[3];

            Employee emp = new Employee(name, salary, position);

            if (tokens.length == 5) {
                if (Character.isDigit(tokens[4].charAt(0))) {

                    emp.setAge(Integer.parseInt(tokens[4]));

                } else {
                    emp.setEmail(tokens[4]);
                }
            } else if (tokens.length == 6) {

                emp.setEmail(tokens[4]);
                emp.setAge(Integer.parseInt(tokens[5]));
            }

            if (!departments.containsKey(departmentName)) {
                departments.put(departmentName, new Department());
            }

            departments.get(departmentName).addEmployee(emp);
        }

        Map.Entry<String, Department> highestAvgSalary = departments
                .entrySet()
                .stream()
                .sorted((f, s) -> {
                    return Double.compare(s.getValue().getAverageSalary(), f.getValue().getAverageSalary());
                })
                .findFirst()
                .get();


        System.out.println("Highest Average Salary: " + highestAvgSalary.getKey());

        highestAvgSalary
                .getValue()
                .getEmployees()
                .stream()
                .sorted((f, s) -> Double.compare(s.getSalary(), f.getSalary()))
                .forEach(employee -> {
            System.out.println(String.format("%s %.2f %s %d",
                    employee.getName(),
                    employee.getSalary(),
                    employee.getEmail(),
                    employee.getAge()));
        });
    }
}
