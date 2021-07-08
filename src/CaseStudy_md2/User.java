package CaseStudy_md2;

public class User {
    private String userName;
    private String passwork;

    public User() {
    }

    public User(String userName, String passwork) {
        this.userName = userName;
        this.passwork = passwork;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswork() {
        return passwork;
    }

    public void setPasswork(String passwork) {
        this.passwork = passwork;
    }
    public String shoe(){
        return userName+","+passwork;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passwork='" + passwork + '\'' +
                '}';
    }
}
