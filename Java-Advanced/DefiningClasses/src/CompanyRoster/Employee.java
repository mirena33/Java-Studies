package CompanyRoster;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String email;
    private int age;

    public Employee(String name, double salary, String position){
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.email = "n/a";
        this.age = -1;
    }

    public Employee() {
    }


    public void setAge(int age){
        this.age = age;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
