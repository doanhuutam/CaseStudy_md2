package Thi_md2;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        ManagerDanhBa managerDanhBa=new ManagerDanhBa();
        managerDanhBa.read();
        while (true){
            System.out.println("---chương trình quản lý danh bạ");
            System.out.println("chọn chức năng để tiếp tục");
            System.out.println("1.xem danh sách");
            System.out.println("2.thêm mới");
            System.out.println("3.cập nhật");
            System.out.println("4.xoá");
            System.out.println("5.tìm kiếm");
            System.out.println("6.đọc từ file");
            System.out.println("7.ghi vào file");
            System.out.println("8.thoát");
            int choice=0;
            try {
                choice=Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("chọn chức năng bằng số");
            }
            switch (choice){
                case 1:
                    managerDanhBa.show();
                    break;
                case 2:
                    managerDanhBa.add();
                    managerDanhBa.write();
                    break;
                case 3:
                    System.out.println("nhập số điệm thoại cần sửa");
                    String name=scanner.nextLine();
                    managerDanhBa.edit(name);
                    break;
                case 4:
                    managerDanhBa.remove();
                    break;
                case 5:
                    managerDanhBa.seach();
                    break;
                case 6:
                    managerDanhBa.read();
                    break;
                case 7:
                    managerDanhBa.write();
                    break;
                case 8:
                    return;
            }
        }
    }
}
