package CaseStudy_md2;

public class OfficerFulltime extends Officer{
    public OfficerFulltime() {
    }

    public OfficerFulltime(String name, String Status,int age, String gender, double salary) {
        super(name,Status,age, gender, salary);
    }

    @Override
    public String toString() {
        return "OfficerFulltime{}"+super.toString();
    }
}
