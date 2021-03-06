package CaseStudy_md2;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerOfficer {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Officer> list = new ArrayList<>();
int count=0;

    public void add(String type) {
        Officer officer;
        if (type.equals("Part-Time")) {
            officer = creat(type);
        } else {
            officer = creat(type);
        }
        list.add(officer);
        count++;
        System.out.println("đang quản lý" +" "+count+" "+"nhân viên");
    }

//    public void addOfficer_PassTime() {
//        Officer officer = creat();
//        System.out.println("nhập số giờ làm của nhân viên passtime");
//        double WorkTime = Double.parseDouble(scanner.nextLine());
//        list.add(officer);
//    }

    public Officer creat(String type) {
        String Name;
        while (true) {
            System.out.println("nhập tên nhân viên");
            Name = scanner.nextLine();
            if (Name != "") {
                break;
            } else {
                System.out.println("hãy điền đầy đủ trường tên");
            }
        }

        Integer age;
        while (true) {
            try {
                System.out.println("nhập tuổi nhân viên");
                age = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e){
                System.out.println("tuổi phải là số");
            }
        }
        String Gender;
            while (true){
                try {
                    System.out.println("nhập giới tính nhân viên:nam/nữ");
                    Gender = scanner.nextLine();
                    if (GenderNum.validate(Gender)){
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("chỉ chấp nhận 2 giới tính");
                }

            }
        String Status;
            while (true) {
                try {
                    System.out.println("nhập trạng thái nhân viên:true/false");
                    Status = scanner.nextLine();
                    if (GenderNum.valida(Status)) {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("nhân viên chỉ có 2 trạng thái");
                }
            }

        Double salary;
        while (true){
            try {
                System.out.println("nhập lương cứng nhân viên");
                salary = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("lương phải là số");
            }

        }

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
            if (list.get(i).getName().equals(name)){
                System.out.println(list.get(i).toString()+""+"đang ở vị trí thứ "+i);
            }
//            Officer officer = list.get(i);
//            if (officer.getName().equals(name)) {
//                list.remove(officer);
//            }
        }
        System.out.println("nhập vị trí nhân viên muốn xoá");
        int index=Integer.parseInt(scanner.nextLine());
        Officer officer=list.get(index);
        if (officer.getName().equals(name)){
            list.remove(officer);
        }
        try {
            writeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                System.out.println(list.get(i).toString() + " " +"đang ở vị trí thứ"+ i);
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
            System.out.println("");
        }
    }

    public void Seach() {
        System.out.println("nhập nhân viên bạn muốn tìm kiếm");
        String Name = scanner.nextLine();
        for (Officer gg : list) {
            if (gg.getName().contains(Name)) {
                System.out.println("nhân viên cần tìm kiếm:::" + gg);
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

    File ahihi = new File("ahihi.csv");
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    String tieude = "tên,trạng thái,tuổi ,giới tính,lương";

    public void writeFile() throws IOException {
        try {
            FileWriter fileWriter = new FileWriter(ahihi);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(tieude);
            for (Officer gg : list) {
                bufferedWriter.newLine();
                bufferedWriter.write(gg.sho());
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readFile() {
        try {
            FileReader fileReader = new FileReader(ahihi);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(",");
                if (arr.length ==5) {
                    list.add(new OfficerFulltime(arr[0], arr[1], Integer.parseInt(arr[2]), arr[3], Double.parseDouble(arr[4])));
                } else {
                    list.add(new OfficerPasstime(arr[0], arr[1], Integer.parseInt(arr[2]), arr[3], Double.parseDouble(arr[4]),Double.parseDouble(arr[5])));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Status_md() {
        System.out.println("nhân viên đang đi làm là");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStatus().equals("true")) {

                System.out.println(list.get(i).getName());
            }else {
                System.out.println("không có nhân viên trên");
            }
        }
        System.out.println("nhân viên đã nghỉ làm là");
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getStatus().equals("true")) {
                System.out.println(list.get(i).getName());
            }
        }
    }
    public void Slary(){
        System.out.println("lương nhân viên pass time là:");
        for (int i=0;i<list.size();i++){
            if (list.get(i) instanceof OfficerPasstime){
                System.out.println("tên nhân viên "+list.get(i).getName() + " " + "có tiền lương là"+ ((OfficerPasstime) list.get(i)).getTotalSalary());
            }
        }
        System.out.println("lương nhân viên full time là:");
        for (int i=0;i<list.size();i++){
            if (list.get(i) instanceof OfficerFulltime){
                System.out.println("tên nhân viên"+list.get(i).getName() + " " + "có tiền lương là"+ ((OfficerFulltime) list.get(i)).getSalary());
            }
        }

    }

}
