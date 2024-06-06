import java.util.Scanner;

public class BookManagement {
   public static Book [] arrBooks = new Book[100];
   public static int currentIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        do {
            System.out.println("***********BOOK MANAGEMENT********************");
            System.out.println("1. Nhập thông tin n sách (n nhập từ bàn phím)");
            System.out.println("2. Tính lợi nhuận các sách");
            System.out.println("3. Hiển thị thông tin sách");
            System.out.println("4. Sắp xếp sách theo giá bán tăng dần");
            System.out.println("5. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("6. Tìm sách theo tên sách (tên sách nhập từ bàn phím)");
            System.out.println("7. Thống kê số lượng sách theo năm xuất bản");
            System.out.println("8. Thống kê số lượng sách theo tác giả");
            System.out.println("9. Exit ");
            System.out.println("su lua chon cua ban");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    BookManagement.inputListBooks(scanner);
                   break;
                case 2:
                    BookManagement.calInterest();
                    break;
                case 3:
                    BookManagement.displayBookList();
                    break;
                case 4:
                    BookManagement.sortExportPrice();
                    break;
                case 5:
                    BookManagement.sortInterest();
                    break;
                case 6:
                    BookManagement.searchBookName(scanner);
                    break;
                case 7:
                     BookManagement.statisticsYear(scanner);
                    break;
                case 8:
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("vui long hay lua chon tu 1-9");

            }
        }while (true);
    }
    public static void inputListBooks(Scanner scanner){
        System.out.println("nhap so luong sach can nhap thong");
        int cntOfbook = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < cntOfbook; i++) {
            System.out.println("so book thu : "+ (i+1));
            arrBooks[currentIndex] = new Book();
            arrBooks[currentIndex].inputData(scanner);
            currentIndex++;
        }
    }
//tinh loi nhuan cua sach

    public static void calInterest(){
        for (int i = 0; i < currentIndex; i++) {
            arrBooks[i].displayInterest();
        }
        System.out.println("da tinh xong loi nhuan cua danh sach book");
    }

//    hien thi thong tin sach
    public static void displayBookList(){
        for (int i = 0; i < currentIndex; i++) {
            arrBooks[i].displayBook();
        }
    }
//Sắp xếp sách theo giá bán tăng dần

    public static void  sortExportPrice(){
        for (int i = 0; i < currentIndex-1; i++) {
            for (int j = i + 1; j < currentIndex; j++) {
                if(arrBooks[i].getExportPrice() > arrBooks[j].getExportPrice()){
                    Book temp = arrBooks[i];
                    arrBooks[i] = arrBooks[j];
                    arrBooks[j] = temp;
                }
            }
        }
        System.out.println("Sắp xếp sách theo giá bán tăng dần");
    }
//    Sắp xếp sách theo lợi nhuận giảm dần

    public static void  sortInterest(){
        for (int i = 0; i < currentIndex-1; i++) {
            for (int j = i + 1; j < currentIndex; j++) {
                if(arrBooks[i].getInterest() > arrBooks[j].getInterest()){
                    Book temp = arrBooks[i];
                    arrBooks[i] = arrBooks[j];
                    arrBooks[j] = temp;
                }
            }
        }
        System.out.println("Sắp xếp sách theo lợi nhuận giảm dần");
    }
//    Tìm sách theo tên sách (tên sách nhập từ bàn phím)"

    public static void searchBookName(Scanner scanner){
        System.out.println("nhap vao ten sach can tim");
        String bookNameSearch = scanner.nextLine();
        int cntBookName = 0;
        for (int i = 0; i<currentIndex; i++){
            if(arrBooks[i].getBookName().toLowerCase().contains(bookNameSearch.toLowerCase())){
                arrBooks[i].displayBook();
                cntBookName++;
            }
        }
        System.out.println("co so sach tim thay la: " + cntBookName);
    }
//    Thống kê số lượng sách theo năm xuất bản
     public static  void statisticsYear(Scanner scanner){
         System.out.println("nhap vao so nam dau tien can thong ke");
         int fromYear = Integer.parseInt(scanner.nextLine());
         System.out.println("nhap sao so nam cuoi cung muon thong ke");
         int toYear = Integer.parseInt(scanner.nextLine());
         int cntYear = 0;
         for (int i = 0 ; i<currentIndex;i++){
             if(arrBooks[i].getYear() >= fromYear && arrBooks[i].getYear()<= toYear){
                 cntYear++;
             }
         }
         System.out.printf("Có %d book san ban từ %d đến %d\n", cntYear, fromYear, toYear);
     }
}
