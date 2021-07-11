package CaseStudy_md2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerBoss {
    public static void menu2() throws IOException {
        while (true) {
            ManagerOfficer managerOfficer=new ManagerOfficer();
            Scanner scanner = new Scanner(System.in);
            System.out.println("1.hiển thị danh sách nhân viên");
            System.out.println("2.hiển thị mức lương của nhân viên");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("nhập lại");
            }
            switch (choice) {
                case 1:
                    managerOfficer.show();
                    break;
                case 2:
                   managerOfficer.Slary();
                    break;

                case 3:
                    System.exit(0);
            }
        }
    }

//    Scanner scanner = new Scanner(System.in);
//    ArrayList<Officer> list = new ArrayList<>();
//    public void show() {
//        for (Officer ahihi : list) {
//            System.out.println(ahihi);
//            System.out.println("");
//        }
//    }
//    public void Seach() {
//        System.out.println("nhập nhân viên bạn muốn tìm kiếm");
//        String Name = scanner.nextLine();
//        for (Officer gg : list) {
//            if (gg.getName().contains(Name)) {
//                System.out.println("nhân viên cần tìm kiếm:::" + gg);
//            }
//
//        }
//    }
}
