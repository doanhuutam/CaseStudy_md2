package Thi_md2;

public class DanhBa {
    private String name;
    private String phone;
    private String adders;
    private String email;
    private String facebook;

    public DanhBa() {
    }

    public DanhBa(String name, String phone, String adders, String email, String facebook) {
        this.name = name;
        this.phone = phone;
        this.adders = adders;
        this.email = email;
        this.facebook = facebook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdders() {
        return adders;
    }

    public void setAdders(String adders) {
        this.adders = adders;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    @Override
    public String toString() {
        return "DanhBa{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", adders='" + adders + '\'' +
                ", email='" + email + '\'' +
                ", facebook='" + facebook + '\'' +
                '}';
    }
    public String show(){
        return name+","+phone+","+adders+","+email+","+facebook;
    }
}
