package CaseStudy_md2;

public class OfficerPasstime extends Officer{
    private Double Worktime;
    private double totalSalary;

    public OfficerPasstime() {
    }

    public OfficerPasstime(String name, String status, int age, String gender, double salary, Double worktime) {
        super(name, status, age, gender, salary);
        Worktime = worktime;
    }



    public Double getWorktime() {
        return Worktime;
    }

    public void setWorktime(Double worktime) {
        Worktime = worktime;
    }
    public double getTotalSalary(){
        return getSalary()*Worktime;
    }

    @Override
    public String toString() {
        return "OfficerPasstime{" +
                "Name='" + getName() + '\'' +
                ", Status='" + getStatus() + '\'' +
                ", Age=" + getAge() +
                ", Gender='" + getGender() + '\'' +
                ", salary=" + getSalary() +'\''+
                ",Worktime=" + Worktime +
                '}';
    }

    public String sho(){
        return getName()+","+getStatus()+","+getAge()+","+getGender()+","+getSalary()+","+getWorktime();
    }
}
