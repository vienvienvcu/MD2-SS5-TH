import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;

    public Book(){
    }
    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author, float interest, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.interest = interest;
        this.year = year;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public void inputData(Scanner scanner){
//        1. Mã sách, không được trùng lặp (Duy nhất)
         this.bookId = inputBookId(scanner);
//        2. Tên sách, không được trùng lặp, gồm 4 ký tự, bắt đầu là ký tự B
        this.bookName = inputBookName(scanner);
//        3. Giá nhập của sách có giá trị lớn hơn 0
        this.importPrice = inputBookPrice(scanner);
//        4. Giá xuất của sách, có giá trị lớn hơn ít nhất 30% so với giá nhật
        this.exportPrice = inputBookExportPrice(scanner);
//        5. Tác giả, có từ 6-50 ký tự
        this.author = inputBookAuthor(scanner);
//        6.  Lợi nhuận sách tính theo công thức interest = exportPrice – importPrice
//        7.Năm xuất bản, ít nhất xuất bản sau năm 2000;
        this.year = inputBookYear(scanner);

    }
    public String inputBookId(Scanner scanner){
        System.out.println("enter book id");
       do {
          String bookId = scanner.nextLine();
           boolean isExit = false; // KO TON TAI
           for (int i = 0; i< BookManagement.currentIndex; i++){
             if (BookManagement.arrBooks[i].getBookId().equals(bookId)){
                      isExit = true;
                      break;
             }
         }
           if(isExit){
               System.err.println("book id da ton tai, vui long nhap lai");
           }else {
               return bookId;
           }
       }while (true);
    }
    public String inputBookName(Scanner scanner){
        System.out.println("enter book name");
        do {
            String bookName = scanner.nextLine();
            if (bookName.length() >= 4 ){
                if (bookName.charAt(0) == 'B'){
                    boolean isExit = false;
                    for (int i = 0; i< BookManagement.currentIndex; i++){
                        if (BookManagement.arrBooks[i].getBookName().equals(bookName)){
                            isExit = true;
                            break;
                        }
                    }
                    if (isExit){
                        System.err.println("book name da ton tai, vui long");
                    }else {
                        return bookName;
                    }
                }else {
                    System.err.println("book name phai co tu dau tien la B, vui long nhap lai");
                }
            }else {
                System.err.println("book name phai co 4 ki tu tro len");
            }
        }while (true);
    }
    public float inputBookPrice(Scanner scanner){
        System.out.println("enter book price");
        do {
            float importPrice = Float.parseFloat(scanner.nextLine());
            if (importPrice > 0){
                return importPrice;
            }else {
                System.err.println("book price phai co gia tri duong, vui long");
            }
        }while (true);
    }
    public float inputBookExportPrice(Scanner scanner){
        System.out.println("enter book export price");
        do {
            float exportPrice = Float.parseFloat(scanner.nextLine());

            if(exportPrice > this.importPrice* 1.3){
                return exportPrice;
            }else {
                System.err.println("gia xuat phai lon hon gia nhap 30%");
            }
        }while (true);
    }
   public String inputBookAuthor(Scanner scanner){
        System.out.println("enter book author");
        do {
         String author = scanner.nextLine();
         if (author.length() >= 6 && author.length() < 50){
             return author;
         }else {
             System.err.println("ten tac gia phai co ki tu tren 6 ki tu va nho hon 50 ki tu");
         }
        }while (true);
   }
   public int inputBookYear(Scanner scanner){
        System.out.println("enter book year");
        do {
         int year = Integer.parseInt(scanner.nextLine());
         if (year>=2000){
             return year;
         }else {
             System.err.println("Năm xuất bản, ít nhất xuất bản sau năm 2000;");
         }
        }while (true);
   }

   public void displayInterest(){
        this.interest = (this.exportPrice - this.importPrice);
   }

   public void displayBook(){
       System.out.println("book id: " + this.bookId);
       System.out.println("book name: " + this.bookName);
       System.out.println("book author: " + this.author);
       System.out.println("book year: " + this.year);
       System.out.println("book price: " + this.importPrice);
       System.out.println("book export price: " + this.exportPrice);
       System.out.println("book interest: " + this.interest);
   }

}
