public class Book {
    private boolean isAvailable;
    private final String title;
    private final String author;
    public int timeCheckedOut;
    public Book() {
        isAvailable = false;
        title = "Curious George";
        author = "H. A. Rey and Margret Rey";
        timeCheckedOut = 0;
    }
    public Book(String t, String a) {
        isAvailable = false;
        title = t;
        author = a;
        timeCheckedOut = 0;
    }
    public void setAvailable(boolean available, int currentTime) {
        isAvailable = available;
        timeCheckedOut = currentTime;
    }
    public String getTitle() {
        return title;
    }
    public void displayBook() {
        System.out.println("You're looking at " + title);
        System.out.println("It was written by " + author);
        if (!isAvailable) {
            System.out.println("It was checked out on day " + timeCheckedOut);
        } else {
            System.out.println("It's available for checkout!");
        }
    }
}
