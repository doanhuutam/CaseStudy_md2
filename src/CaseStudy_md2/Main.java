package CaseStudy_md2;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ManagerUser.menu1();
    }

    public static void menu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        ManagerOfficer ahi = new ManagerOfficer();
        ahi.readFile();
        while (true) {
            System.out.println("<--------<MENU>-------->");
            System.out.println("1.<-thêm nhân viên->");
            System.out.println("2.<--tìm kiếm nhân viên-->");
            System.out.println("3.<---kiểm tra trạng thái nhân viên--->");
            System.out.println("4.<----sửa thông tin nhân viên---->");
            System.out.println("5.<-----thay đổi trạng thái nhân viên----->");
            System.out.println("6.<------thông tin tài khoản------>");
            System.out.println("7.test chức năng");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("nhập lại");
            }
            switch (choice) {
                case 1:
                    System.out.println("1.<-thêm nhân viên full_time->");
                    System.out.println("2.--<thêm nhân viên pass_time>--");
                    int choice2 = 0;
                    try {
                        choice2 = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("nhập lại");
                    }
                        switch (choice2) {
                            case 1:
                                ahi.add("Full-time");
                                ahi.writeFile();
                                ahi.show();

                                break;
                            case 2:
                                ahi.add("Part-Time");
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
                            System.out.println("bạn muốn hiển thị lương nhân viên không");
                            System.out.println("1.có");
                            System.out.println("2.không");
                            int choi = Integer.parseInt(scanner.nextLine());
                            switch (choi) {
                                case 1:
                                    ahi.Slary();
                                    break;
                                case 2:
                                    break;
                            }
                            break;
                        case 4:
                            System.out.println("<----bạn muốn đổi thông tin nhân viên hay xoá nhân viên---->");
                            System.out.println("1.<-tôi muốn thay đổi thông tin->");
                            System.out.println("2.<--tôi muốn xoá nhân viên-->");
                            int choice4 = Integer.parseInt(scanner.nextLine());
                            switch (choice4) {
                                case 1:
                                    System.out.println("<---nhập tên nhân viên muốn sửa--->");
                                    String name = scanner.nextLine();
                                    ahi.update(name);
                                    ahi.show();
                                    break;
                                case 2:
                                    ahi.delete();
                                    ahi.show();
                                    break;
                            }
                            break;
                        case 5:
                            ahi.updatestatus();
                            ahi.show();
                            System.out.println("<------bạn có muốn hiển thị danh sách nhân viên theo trạng thái----->");
                            System.out.println("1.<-có->");
                            System.out.println("2.<--không-->");
                            int choice3 = Integer.parseInt(scanner.nextLine());
                            switch (choice3) {
                                case 1:
                                    ahi.Status_md();
                                    break;
                                case 2:
                                    break;
                            }
                            break;
                        case 6:
                            ManagerUser.showuser();
                            System.out.println("bạn có muốn đâng xuất khỏi chương trình không");
                            System.out.println("1.<-có->");
                            System.out.println("2.<--không-->");
                            int choice5 = Integer.parseInt(scanner.nextLine());
                            switch (choice5) {
                                case 1:
                                    ManagerUser.menu1();
                                    break;
                                case 2:
                                    break;
                            }
                            break;

                    }
            }
        }
    }
