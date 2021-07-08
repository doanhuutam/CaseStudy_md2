package CaseStudy_md2;

public class Officer {
    private String Name;
    private String Status;
    private int Age;
    private String Gender;
    private double salary;

    public Officer() {
    }

    public Officer(String name, String status, int age, String gender, double salary) {
        Name = name;
        Status = status;
        Age = age;
        Gender = gender;
        this.salary = salary;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Officer{" +
                "Name='" + Name + '\'' +
                ", Status='" + Status + '\'' +
                ", Age=" + Age +
                ", Gender='" + Gender + '\'' +
                ", salary=" + salary +
                '}';
    }
    public String sho(){
        return Name+","+Status+","+Age+","+Gender+","+salary;
    }
}

