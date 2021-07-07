package CaseStudy_md2;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerOfficer {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Officer> list = new ArrayList<>();

    public void addOfficer_FullTime(String type) {
        Officer officer;
        if (type.equals("Part-Time")) {
            officer = creat(type);
        } else {
            officer = creat(type);
        }
        list.add(officer);
    }

//    public void addOfficer_PassTime() {
//        Officer officer = creat();
//        System.out.println("nhập số giờ làm của nhân viên passtime");
//        double WorkTime = Double.parseDouble(scanner.nextLine());
//        list.add(officer);
//    }

    public Officer creat(String type) {
        System.out.println("nhập tên nhân viên");
        String Name = scanner.nextLine();
        System.out.println("nhập tuổi nhân viên");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập giới tính nhân viên");
        String Gender = scanner.nextLine();
        System.out.println("nhập trạng thái nhân viên");
        String Status = scanner.nextLine();
        System.out.println("nhập lương cứng nhân viên");
        double salary = Double.parseDouble(scanner.nextLine());
        if (type.equals("Part-Time")) {
            System.out.println("nhập số giờ làm của nhân viên passtime");
            double WorkTime = Double.parseDouble(scanner.nextLine());
            Officer officer = new OfficerPasstime(Name, Status, age, Gender, salary, WorkTime);
            return officer;
        } else {
            Officer officer = new OfficerFulltime(Name, Status, age, Gender, salary);
            return officer;
        }

    }

    public void delete() {
        System.out.println("nhập tên nhân viên muốn xoá");
        String name = scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {
            Officer officer = list.get(i);
            if (officer.getName().equals(name)) {
                list.remove(officer);
                System.out.println(list);
            }
        }
    }

    public void update(String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                System.out.println(list.get(i).toString() + " " + i);
            }
        }
        System.out.println("nhập vị trí của nhân viên thay đổi");
        int index = Integer.parseInt(scanner.nextLine());
        Officer officer;
        if (list.get(index) instanceof OfficerPasstime) {
            officer = creat("Part-Time");
        } else {
            officer = creat("Full-Time");
        }
        list.set(index, officer);
    }

    public void show() {
        for (Officer ahihi : list) {
            System.out.println(ahihi);
        }
    }

    public void Seach() {
        System.out.println("nhập nhân viên bạn muốn");
        String Name = scanner.nextLine();
        for (Officer gg : list) {
            if (gg.getName().equals(Name)) {
                System.out.println("nhân viên đã" + gg);
            }

        }
    }

    public void Status() {
        System.out.println("nhập tên nhân viên bạn muốn kiểm tra");
        String name = scanner.nextLine();
        for (Officer hh : list) {
            if (hh.getName().equals(name)) {
                System.out.println(hh.getStatus());
            }

        }
    }

    public void updatestatus() {
        System.out.println("bạn muốn cập nhật tình trạng của nhân viên nào");
        String name = scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                System.out.println("Sửa trạng thái thành");
                    list.get(i).setStatus(scanner.nextLine());
                }
            }
        }
        File ahihi=new File("ahihi.csv");
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    String tieude="tên,trạng thái,tuổi ,giới tính,lương";

    public void writeFile() throws IOException {
        try {
            FileWriter fileWriter=new FileWriter(ahihi);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            bufferedWriter.write(tieude);
            for (Officer gg:list) {
                bufferedWriter.newLine();
                bufferedWriter.write(gg.show());
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void readFile(){
        try {
            FileReader fileReader=new FileReader(ahihi);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line=bufferedReader.readLine();
            while ((line=bufferedReader.readLine())!=null){
                String[] arr=line.split(",");
                list.add(new Officer(arr[0],arr[1],Integer.parseInt(arr[2]),arr[3],Double.parseDouble(arr[4])));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
