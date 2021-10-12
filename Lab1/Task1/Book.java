package Task1;

public class Book {
    protected  String title;
    protected int pages;
    public Book(String title,int pages){
        this.title = title;
        this.pages = pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getPages() {
        return pages;
    }
    public String getTitle() {
        return title;
    }
    @Override
    public String toString() {
        return "Book: "+title+", # Pages = "+pages;
    }
}
