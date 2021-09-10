package Lab1.Task1;

public class Textbook extends Book{
    private String course;
    public Textbook(String title,int pages,String course){
    super(title,pages);
        this.course = course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public String getCourse() {
        return course;
    }
    @Override
    public String toString() {
        return "Text Book: "+ getTitle() +", "+getCourse()+", # Pages = "+getPages()+", Course = "+ getCourse();
    }

}
