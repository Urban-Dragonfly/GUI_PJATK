package pl.pjatk.s36691.gui.zad56;

public class Book {
    private String author;
    private String title;
    private double price;
    private String coverFileName;

    public Book(String author, String title, double price, String coverFileName) {
        this.author = author;
        this.title = title;
        this.price = price;
        this.coverFileName = coverFileName;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public double getPrice() {
        return price;
    }
    public String getCoverFileName() {
        return coverFileName;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setCoverFileName(String coverFileName) {
        this.coverFileName = coverFileName;
    }
}
