package Task1;

public class DriverT1 {
    public static void main(String[] argus){
        Book[] as = new Book[10];
        as[0] = new Book("ABC", 100);
        as[1] = new Book("Arabic", 100);
        as[2] = new Textbook("Data structures", 200, "ICS-202");
        as[3] = new Textbook("Writing practice", 300, "ENGL-101");
        as[4] = new Textbook("Algebra", 500, "MATH-101");
        as[5] = new Book("Water conservation", 200);
        as[6] = new Book("Environment", 150);
        as[7] = new Book("Teach yourself Visual C++", 300);
        as[8] = new Book("Notebook", 300);
        as[9] = new Textbook("Introduction to technology", 500, "TECH-102");
        int BooksNumber=0;
        int TextbookNumber=0;
         for(int i=0;i<as.length;i++){
             System.out.println(as[i].toString());
            if(as[i] instanceof Textbook)
                TextbookNumber++;
            else
                BooksNumber++;
         }
         System.out.println("Number of Books = "+ BooksNumber);
         System.out.println("Number of Textbooks = "+ TextbookNumber);

    }
}
