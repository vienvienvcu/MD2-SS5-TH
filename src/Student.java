import java.util.Scanner;

public class Student {
//    1. Fields/ attr/Properties
    private  String studentId;
    private String studentName;
    private int age;
    private boolean sex;
    private String address;
    private String phone;

    public Student(){

    }
    public Student(String studentId, String studentName, int age, boolean sex, String address, String phone){
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void inputData(Scanner scanner){
//      1. nhap ma sinh vien gom 5 ki tu bat dau la SV, ko trung lap
        this.studentId = inputStudentId(scanner);
//      2. Nhập tên sinh viên: Phải có từ 6 đến 50 ký t
        this.studentName  =inputStudentName(scanner);
//      3. Tuổi sinh viên phải có giá trị lớn hơn hoặc bằng 18
        this.age = inputAge(scanner);
//      4. gioi tinh chi nhan true va fale
        this.sex = inputSex(scanner);
//      5. dia chi: ko dc rong;
        this.address = inputAddress(scanner);
//      6. dien thoai : gom 10 ki tu bat dau la ki tu 0;
        this.phone = inputPhone(scanner);

    }

    public String inputStudentId(Scanner scanner) {
        System.out.println("Enter student ID");
        do {
            String studentId = scanner.nextLine();
            if (studentId.length()==5){
                if (studentId.startsWith("SV")){
                    boolean isExist = false;// chua ton tai
                    for (int i=0;i<StudentManagement.currentIndex;i++){
                        if (StudentManagement.arrStudents[i].getStudentId().equals(studentId)){
                            isExist = true;
                            break;
                        }
                    }
                    if (isExist){
                        System.out.println("ma sinh vien da toan tai");
                    }else {
                        return studentId;
                    }
               }else{
                    System.err.println("ma sinh vien phai bat dau = SV");
                }
            }else {
                System.err.println("ma sv phai co 5 ki tu, vui long nhap lai");
            }
        }while (true);

    }
    public String inputStudentName(Scanner scanner){
        System.out.println("nhap ten sinh vien");
        do {
            String studentName = scanner.nextLine();
            if (studentName.length()>6 && studentName.length()<=50){
                return studentName;
            }else {
                System.err.println("ten phai co 6 den 60 ki tu");
            }
        }while (true);
    }
    public int inputAge (Scanner scanner){
        System.out.println("nhap tuoi cua sinh vien");
        do {
            int age = Integer.parseInt(scanner.nextLine());
            if( age >=18) {
                return age;
            }else {
                System.err.println("tuoi cua sv phai tren 18 tuoi");
            }
        }while (true);
    }
    public boolean inputSex(Scanner scanner){
        System.out.println("nhap vao gioi tinh");
        do {
           String sex = scanner.nextLine();
           if (sex.equals("true")||sex.equals("false")){
               return Boolean.parseBoolean(sex);
           }else{
               System.err.println("gioi tinh chi nhap true/false, vui long nhap lai");
           }
        }while (true);
    }

    public String inputAddress(Scanner scanner){
        System.out.println("nhap vao dia chi cua ban");
        do {
            String address = scanner.nextLine();
            if (address.trim().length() == 0){
                System.err.println("dia chi khong duoc de rong, vui long nhap lai");
            }else {
                return address;
            }
        }while (true);
    }

    public String inputPhone(Scanner scanner) {
        System.out.println("Nhập vào số điện thoại của sinh viên:");
        do {
            String phone = scanner.nextLine();
            if (phone.charAt(0) == '0') {
                if (phone.length() == 10) {
                    boolean isExist = false;
                    for (int i = 0; i < StudentManagement.currentIndex; i++) {
                        if (StudentManagement.arrStudents[i].getPhone().equals(phone)) {
                            isExist = true;
                            break;
                        }
                    }

                    if (isExist) {
                        System.err.println("Số điện thoại đã được đăng ký, vui lòng nhập lại");
                    } else {
                        return phone;
                    }
                } else {
                    System.err.println("Số điện thoại có 10 ký tự, vui lòng nhập lại");
                }
            } else {
                System.err.println("Số điện thoại phải bắt đầu là 0, vui lòng nhập lại");
            }
        } while (true);
    }

    public void displayData() {
        System.out.printf("Mã SV: %s - Tên SV: %s - Tuổi: %d - Giới tính: %s\n",
                this.studentId, this.studentName, this.age, this.sex ? "Nam" : "Nữ");
        System.out.printf("Địa chỉ: %s - Số điện thoại: %s\n", this.address, this.phone);
    }


}
