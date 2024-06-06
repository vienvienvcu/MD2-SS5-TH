import java.util.Scanner;

public class StudentManagement {
//    mang luu cac doi tuong sv dang quan ly

   public static Student [] arrStudents = new Student[100];

//   index de luu chi so cua tung phan tu trong mang

   public static int currentIndex = 0;

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      do {
         System.out.println("*************STUDENT MANAGEMENT*****************************");
         System.out.println("1. danh sanh sinh vien");
         System.out.println("2. them moi sinh vien");
         System.out.println("3. cap nhat sinh vien moi");
         System.out.println("4. xoa sinh vien");
         System.out.println("5. tim sinh vien theo ten sinh vien");
         System.out.println("6. thong ke sinh vien theo khoang tuoi");
         System.out.println("7. sap xep sinh vien theo khoang tuoi");
         System.out.println("8. exit");
         System.out.println("lua chon cua ban:\n");
         int choice = Integer.parseInt(scanner.nextLine());
         switch (choice) {
            case 1:
               StudentManagement.displayListStudent();
               break;
            case 2:
               StudentManagement.inputListStudents(scanner);
               break;
            case 3:
               StudentManagement.inputUpdateStudent(scanner);
               break;
            case 4:
               StudentManagement.deleteStudents(scanner);
               break;
            case 5:
               StudentManagement.searchStudentByName(scanner);
               break;
            case 6:
               StudentManagement.statiticStudent(scanner);
               break;
            case 7:
               StudentManagement.softStudentsByAge();
               break;
            case 8:
               System.exit(0);
            default:
               System.out.println("invalid choice, please try again");
         }
      }while (true);
   }
   public static void displayListStudent() {
      for (int i = 0; i < currentIndex; i++) {
         arrStudents[i].displayData();
      }
   }

   public static void inputListStudents(Scanner scanner) {
      System.out.println("so luong sinh vien can nhap ");
      int cntOfStudent = Integer.parseInt(scanner.nextLine());
      for (int i = 0; i < cntOfStudent; i++)
      {
         System.out.println("sinh vien lan thu" + (i+1));
         arrStudents[i] = new Student();
         arrStudents[i].inputData(scanner);
         currentIndex++;
      }
   }
   public static void inputUpdateStudent(Scanner scanner) {
      System.out.println("nhap vao ma sinh vien can cap nhat");
      String studentId = scanner.nextLine();
      int updateId = getIndexById(studentId);
      if(updateId >= 0){
         boolean isExist = true;
         do{
            System.out.println("1. cap nhat ten sv");
            System.out.println("2. cap nhat tuoi sinh vien");
            System.out.println("3. cap nhat gioi tinh sinh vien");
            System.out.println("4. cap nhat dia chi sinh vien");
            System.out.println("5. cap nhat gioi so dien thoai sinh vien");
            System.out.println("6. exit");
            System.out.println("lua chon cua ban: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
               case 1:
                  arrStudents[updateId].setStudentName(scanner.nextLine());
                  break;
               case 2:
                  arrStudents[updateId].setAge(Integer.parseInt(scanner.nextLine()));
                  break;
               case 3:
                  arrStudents[updateId].setSex(Boolean.parseBoolean(scanner.nextLine()));
                  break;
               case 4:
                  arrStudents[updateId].setAddress(scanner.nextLine());
                  break;
               case 5:
                  arrStudents[updateId].setPhone(scanner.nextLine());
                  break;
               default:
                  isExist =false;
            }
         }while (isExist);
      }else {
         System.out.println(" ma sinh vien da ton tai");
      }

   }

   public static int getIndexById( String studentId) {
      for (int i = 0; i<currentIndex; i++){
        if (arrStudents[i].getStudentId().equals(studentId)){
           return i;
        }
      }
      return -1;
   }
  public static void searchStudentByName(Scanner scanner) {
     System.out.println("nhap vao ten sinh vien can tim");
     String studentNameSearch = scanner.nextLine();
     int cntStudents = 0;
     System.out.println("cac sinh vien tim thays");
     for (int i = 0; i < currentIndex; i++) {
        if (arrStudents[i].getStudentName().toLowerCase().contains(studentNameSearch.toLowerCase())) {
           arrStudents[i].displayData();
           cntStudents++;
        }
     }
     System.out.printf("Có %d sinh viên được tìm thấy\n", cntStudents);
  }
  public static void deleteStudents(Scanner scanner) {
     System.out.println("nhap vao ma sinh vien can xoa");
     String studentId = scanner.nextLine();
     int indexDelete = getIndexById(studentId);
     if (indexDelete>=0){
        for (int i = indexDelete; i<currentIndex; i++){
           arrStudents[i]= arrStudents[i+1];
        }
        currentIndex--;
     }else {
        System.err.println("Mã sinh viên không tồn tại");
     }
  }

public static void statiticStudent(Scanner scanner){
   System.out.println("nhap vao tuoi bat dau");
   int fromAge = Integer.parseInt(scanner.nextLine());
   System.out.println("nhap vao tuoi ket thuc");
   int toAge = Integer.parseInt(scanner.nextLine());
   int cntStudents = 0;
   for (int i = 0;i<currentIndex; i++){
      if (arrStudents[i].getAge()>= fromAge && arrStudents[i].getAge()<=toAge){
         cntStudents++;
      }
   }
   System.out.printf("Có %d sinh viên có tuổi từ %d đến %d\n", cntStudents, fromAge, toAge);
}
public static void softStudentsByAge(){
      for (int i = 0; i<currentIndex-1; i++){
         for (int j = i+1; j<currentIndex; j++){
            if (arrStudents[i].getAge()>arrStudents[j].getAge()){
               Student temp = arrStudents[i];
               arrStudents[i] = arrStudents[j];
               arrStudents[j] =temp;
            }
         }
      }
   System.out.println("Đã sắp xếp xong sinh viên theo tuổi tăng dần");
}
}
