package CaseStudy_md2;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        ManagerOfficer ahi=new ManagerOfficer();
        ahi.readFile();
        while (true){
            System.out.println("tuỳ chọn dành cho bạn");
            System.out.println("1.thêm nhân viên");
            System.out.println("2.tìm kiếm nhân viên");
            System.out.println("3.kiểm tra trạng thái nhân viên");
            System.out.println("4.sửa thông tin nhân viên");
            System.out.println("5.thay đổi trạng thái nhân viên");
            System.out.println("6.thông tin tài khoản");
            int choice=Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("1.thêm nhân viên full_time");
                    System.out.println("2.thêm nhân viên pass_time");
                    int choice2=Integer.parseInt(scanner.nextLine());
                    switch (choice2){
                        case 1:
                            ahi.addOfficer_FullTime("Full-time");
                            ahi.writeFile();
                            ahi.show();

                            break;
                        case 2:
                            ahi.addOfficer_FullTime("Part-Time");
                            ahi.writeFile();
                            ahi.show();
                            break;
                    }
                    break;
                case 2:
                    ahi.Seach();
                    break;
                case 3:
                    ahi.Status();
                    break;
                case 4:
                    System.out.println("nhập nhân viên mà bạn muốn thay đổi thông tin");
                    String name=scanner.nextLine();
                    ahi.update(name);
                    ahi.show();
                    break;
                case 5:
                    ahi.updatestatus();
                    ahi.show();
                break;
            }
        }
    }
}
