public class GetBookDetail {
    //This attribute contains book unique ID
    private String bookID;

    public GetBookDetail(String bookID, String title, String author, String publisher) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    //This attribute contains book unique ID
    private String title;
    //This attribute contains author name
    private String author;
    //This attribute contains publisher name
    private String publisher;
    //This attribute contains total page in the book

    public String getBookID() {
        return bookID;
    }
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


}