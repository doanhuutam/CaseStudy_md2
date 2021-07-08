package CaseStudy_md2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class ManagerUser {
    static ArrayList<User> list = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static User tem;
    public static User gettem(){
        return tem;
    }

    public static void menu1() throws IOException {
        System.out.println("1.đăng nhập tài khoản");
        System.out.println("2.đăng ký tài khoản");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                signUp();
                break;
        }
    }

    private static void login() throws IOException {
        while (true) {
            System.out.println("nhập tên đăng nhập");
            String UserName = scanner.nextLine();
            System.out.println("nhập mật khẩu");
            String passwork = scanner.nextLine();
            read();
            for (User gg : list) {
                if (gg.getUserName().equalsIgnoreCase(UserName) && gg.getPasswork().equalsIgnoreCase(passwork)) {
                    System.out.println("---welcom---" + UserName);
                    tem=gg;
                    Main.menu();
                    return;
                } else {
                    System.out.println("thông tin mật khẩu hoặc tài khoản không đúng");
                }
            }

        }
    }


    private static void signUp() throws IOException {
        while (true) {
            System.out.println("nhập tên đăng ký");
            String name = scanner.nextLine();
            System.out.println("nhập mật khẩu đăng ký");
            String pass = scanner.nextLine();
            read();
            for (User gg : list) {
                if (gg.getUserName().equals(name)) {
                    System.err.println("tài khoản đã tồn tại");
                    break;
                }
            }
            System.out.println("đăng ký thành công");
            list.add(new User(name, pass));
            write();
            break;
        }
        login();
    }

    static File dongoc = new File("src/dongoc.csv");
    static String tieudeu = "tai khoan,mat khau";

    public static void write() {
        try {
            FileWriter fileWriter = new FileWriter("src/dongoc.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(tieudeu);
            for (User gg : list) {
                bufferedWriter.newLine();
                bufferedWriter.write(gg.shoe());
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read() {
        try {
            FileReader fileReader = new FileReader("src/dongoc.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(",");
                list.add(new User(arr[0], arr[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void showuser(){
        System.out.println(ManagerUser.gettem().shoe());
    }

}
