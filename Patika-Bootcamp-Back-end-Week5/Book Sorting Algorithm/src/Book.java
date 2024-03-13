public class Book implements Comparable{
    private String bookName;
    private int bookPageNumber;
    private String author;
    private String publicationDate;

    public Book(String bookName, int bookPageNumber, String author, String publicationDate){
        this.bookName = bookName;
        this.bookPageNumber = bookPageNumber;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookPageNumber() {
        return bookPageNumber;
    }

    public void setBookPageNumber(int bookPageNumber) {
        this.bookPageNumber = bookPageNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publicationDate;
    }

    public void setPublishDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
