package Thi_md2;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerDanhBa {
    ArrayList<DanhBa> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    DanhBa danhBa;

    public DanhBa creat() {
        String name;
        while (true) {
            System.out.println("nhập tên");
            name = scanner.nextLine();
            if (name != "") {
                break;
            } else {
                System.out.println("hãy điền đầy đủ trường tên");
            }
        }
        String phone;
        while (true) {
            System.out.println("nhập số điện thoại");
            phone = scanner.nextLine();
            if (phone != "") {
                break;
            } else {
                System.out.println("hãy điền đầy đủ trường tên");
            }
        }
        String adeers;
        while (true) {


            System.out.println("nhập địa chỉ");
            adeers = scanner.nextLine();
            if (adeers != "") {
                break;
            } else {
                System.out.println("hãy điền đầy đủ trường tên");
            }
        }
        String email;
        while (true) {


            System.out.println("nhập email");
            email = scanner.nextLine();
            if (email != "") {
                break;
            } else {
                System.out.println("hãy điền đầy đủ trường tên");
            }
        }
        String facebook;
        while (true) {

            System.out.println("nhập facebook");
            facebook = scanner.nextLine();
            if (facebook!= "") {
                break;
            } else {
                System.out.println("hãy điền đầy đủ trường tên");
            }
        }
        DanhBa danhba = new DanhBa(name, phone, adeers, email, facebook);
        return danhba;
    }

    public void add() {
        DanhBa danhBa = creat();
        list.add(danhBa);


    }

    public void edit(String phone) {
        for (int i=0;i<list.size();i++){
            if (list.get(i).getPhone().equals(phone)){
                System.out.println(list.get(i).toString()+" "+"đang ở vị trí thứ"+i);
            }else {
                System.out.println("số điện thoại trên không năm trong danh sách");
            }
        }
        System.out.println("nhập vị trí muốn sửa");
        int index=Integer.parseInt(scanner.nextLine());
        DanhBa danhBa =creat();
        list.set(index ,danhBa);

    }

    public void remove() {
        try {

            System.out.println("nhập số điện thoại muốn xoá");
            String phone = scanner.nextLine();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getPhone().equals(phone)) {
                    System.out.println(list.get(i).toString() + "" + "đang ở vị trí thứ " + i);
                }
            }
            System.out.println("nhập vị trí số điện  muốn xoá");
            int index = Integer.parseInt(scanner.nextLine());
            if (danhBa.getPhone().equals(index)) {
                list.remove(danhBa);
            }
            try {
                write();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }


    public void show() {
        for (DanhBa gg : list) {
            System.out.println(gg);
        }
    }

    public void seach() {
        System.out.println("nhập tên nhân viên tìm kiếm");
        String name = scanner.nextLine();
        for (DanhBa gg : list) {
            if (gg.getName().contains(name)) {
                System.out.println("nhân viên cần tìm là:" + gg);

            } else {
                System.out.println("không có nhân viên trên");
            }
        }
    }

    File ahii = new File("ahii.csv");
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    String tieude = "tên,số điện thoại, địa chỉ,email,facebook";

    public void write() throws IOException {
        try {
            FileWriter fileWriter = new FileWriter(ahii);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(tieude);
            for (DanhBa gg : list) {
                bufferedWriter.newLine();
                bufferedWriter.write(gg.show());
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read() {
        try {
            FileReader fileReader = new FileReader(ahii);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null){
                String[] arr = line.split(",");
                list.add(new DanhBa(arr[0], arr[1], arr[2], arr[3], arr[4]));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
