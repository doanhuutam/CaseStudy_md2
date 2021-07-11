package CaseStudy_md2;

public class BossOfficer extends Officer{
    public BossOfficer(String name, String status, int age, String gender, double salary) {
        super(name, status, age, gender, salary);
    }

    public BossOfficer() {
    }

    @Override
    public String toString() {
        return "BossOfficer{}";
    }
}
