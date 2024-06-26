package seedu.bookbuddy.book;

public class BookMain {
    protected String title;
    protected boolean isRead;
    protected String dateTimeRead;
    protected String label;
    protected String genre;
    protected int rating;
    protected String summary;
    protected String author;

    /**
     * Creates a new Book with the specified title.
     *
     * @param title The title of the book.
     */
    public BookMain(String title) {
        this.title = title; // Description of the book
        this.isRead = false; //Completion status of the book (True: Read, False: Unread)
        this.dateTimeRead = "";
        this.label = "";
        this.genre = "";
        this.rating = 0; // Initialized to 0
        this.summary = "";
        this.author = "";
    }

    //@@author joshuahoky
    /**
     * Additional BookMain constructor for reading in books from text file.
     *
     * @param title The title of the book.
     * @param status Whether the book is read or unread.
     * @param label The label assigned to the book.
     * @param genre The genre of the book.
     * @param rating  The rating assigned to the book.
     * @param summary The summary of the book.
     * @param dateTimeRead The date and time in which the book is read (if is it read).
     * @param lineNumber The line in which the book is in the text file.
     * @param author The author of the book.
     */
    public BookMain(String title, int status, String label, String genre, int rating, String summary,
                    String dateTimeRead, int lineNumber, String author) {
        if (rating < 0 || rating > 5 || status < 0 || status > 1) {
            throw new IllegalArgumentException("Unable to load book data from line " + lineNumber +
                    " in books.txt as data is corrupted.");
        }

        this.title = title;
        this.isRead = status == 1;
        this.dateTimeRead = dateTimeRead;
        this.label = label;
        this.genre = genre;
        this.summary = summary;
        this.rating = rating;
        this.author = author;
    }

    @Override
    public String toString() {
        String statusMark = Read.getRead(this) ? "R" : "U"; // Mark with 'R' if read and 'U' if unread
        return "[" + statusMark + "] " + this.title;
    }

    /**
     * Method to convert details to the correct string format for writing.
     *
     * @return The string with the details of the book to be written to the text file.
     */
    public String saveFormat() {
        String status = isRead ? "1" : "0";
        String dateTimeRead = (this.dateTimeRead.isEmpty()) ? "" : this.dateTimeRead;
        String label = (this.label.isEmpty()) ? "" : this.label;
        String genre = (this.genre.isEmpty()) ? "" : this.genre;
        String summary = (this.summary.isEmpty()) ? "" : this.summary;
        String author = (this.author.isEmpty()) ? "" : this.author;
        return this.title + " | " + author + " | " + status + " | " + dateTimeRead + " | " + label
                + " | " + genre + " | " + summary + " | " + this.rating;
    }
}
