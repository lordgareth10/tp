package seedu.bookbuddy;

import seedu.bookbuddy.book.BookMain;
import seedu.bookbuddy.book.Title;
import seedu.bookbuddy.booklist.BookList;

import java.util.ArrayList;
//@@ liuzehui03
public class Ui {
    public static void printWelcome() {
        printLine();
        System.out.println("Hello from");
        System.out.println("BookBuddy!");
        System.out.println("How can I help you today?");
        printShortLine();
    }
    public static void printLine() {
        System.out.println("___________________________________");
    }
    public static void printShortLine() {
        System.out.println("_____________");
    }
    public static void printExitMessage() {
        System.out.println("Thank you for using BookBuddy! Hope to see you again keke :)");
    }

    public static void addBookMessage(String title) {
        printShortLine();
        System.out.println("okii added [" + title + "] to the list.");
        System.out.println("remember to read it soon....");
        printShortLine();
    }
    public static void labelBookMessage(String title, String label) {
        printShortLine();
        System.out.println("okii labeled [" + title + "] as [" + label + "]");
        printShortLine();
    }
    public static void summaryBookMessage(String title, String summary) {
        printShortLine();
        System.out.println("okii you have written: [" + summary + "] for the book: [" + title + "]");
        printShortLine();
    }
    public static void authorBookMessage(String title, String author) {
        printShortLine();
        System.out.println("okii you have have set: [" + author + "] as the author for the book: [" + title + "]");
        printShortLine();
    }
    public static void setGenreBookMessage(String title, String genre) {
        printShortLine();
        System.out.println("okii categorised [" + title + "] as [" + genre + "]");
        printShortLine();
    }
    public static void exitCommandMessage() {
        System.out.println("okii exitting the command now");
    }
    public static void setRatingBookMessage(String title, int rating) {
        System.out.println("okii set rating for [" + title + "] as [" + rating +"]");
    }
    public static void removeBookMessage(int index, BookList books) {
        System.out.println("alright.. i've removed " + Title.getTitle(books.getBook(index)) + " from the list.");
    }
    public static void helpMessage() {
        System.out.println("Here's a list of commands to get you started!!");
        System.out.println("add [BOOK_TITLE] -> to add new books to the list");
        System.out.println("remove [BOOK_INDEX] -> to remove a book from the list");
        System.out.println("remove-genre [GENRE_INDEX] -> to remove a genre from the genre list");
        System.out.println("list -> to show whole list of added books");
        System.out.println("mark [BOOK_INDEX] -> to mark book as read [R]");
        System.out.println("unmark [BOOK_INDEX] -> to mark book as unread [U]");
        System.out.println("list-by-date -> to print out all books sorted in descending order of date read");
        System.out.println("list-genre - > to print out all genres");
        System.out.println("(basic) set-genre [BOOK_INDEX] -> to set a genre for a book");
        System.out.println("(advanced) set-genre [BOOK_INDEX] [GENRE] -> to set a genre for a book");
        System.out.println("remove-genre -> to remove a specific genre from the list");
        System.out.println("set-author [BOOK_INDEX] [BOOK_AUTHOR] -> to set an author for a book");
        System.out.println("label [BOOK_INDEX] [LABEL] -> to set a label for a book");
        System.out.println("give-summary [BOOK_INDEX] [BOOK_SUMMARY] -> to give a book a summary");
        System.out.println("rate [BOOK_INDEX] [BOOK_RATING] -> to rate a book from 1-5");
        System.out.println("list-rated -> to sort books by rating in descending order");
        System.out.println("display [BOOK_INDEX] -> to view more details about a book");
        System.out.println("find-title [KEYWORD] -> to find books with keyword in their title");
        System.out.println("(basic) find-genre -> to find books under specified genre");
        System.out.println("(advanced) find-genre [GENRE] -> to find books under specified genre");
        System.out.println("find-read -> to find list of books that are read");
        System.out.println("find-unread -> to find list of books that are unread");
        System.out.println("find-label [KEYWORD] -> to find list of books that stored under a certain label");
        System.out.println("find-rate [RATING] -> to find list of books with specified rating");
        System.out.println("find-author [AUTHOR] -> to find list of books written by specific author");
        System.out.println("bye -> to exit BookBuddy software");
    }

    public static void printBookFound(ArrayList<BookMain> bookTitles){
        for (int i = 0; i < bookTitles.size(); i++) {
            System.out.println(i + 1 + ". " + bookTitles.get(i));
        }
    }
    public static void printNoBookFound(){
        System.out.println("no such books added...");
    }
    public static void printGenresFound(ArrayList<BookMain> bookGenres){
        for (int i = 0; i < bookGenres.size(); i++) {
            System.out.println(i + 1 + ". " + bookGenres.get(i));
        }
    }
    public static void printNoGenresFound(){
        System.out.println("no such books added under this genre");
    }
    public static void printReadFound(ArrayList<BookMain> bookRead){
        printLine();
        System.out.println("Read books: ");
        for (int i = 0; i < bookRead.size(); i++) {
            System.out.println(i + 1 + ". " + bookRead.get(i));
        }
        System.out.println("gd job! hope u enjoyed these books ");
        printShortLine();
    }
    public static void printNoReadFound(){
        System.out.println("no read books found...");
        System.out.println("do rmb to start reading soon!");
    }
    public static void printUnreadFound(ArrayList<BookMain> bookUnread){
        printLine();
        System.out.println("Unread books: ");
        for (int i = 0; i < bookUnread.size(); i++) {
            System.out.println(i + 1 + ". " + bookUnread.get(i));
        }
        System.out.println("do rmb to read these books soon!");
        printShortLine();
    }
    public static void printNoUnreadFound(){
        System.out.println("no unread books found!");
        System.out.println("you've read everything on the list!! amazing :)");
    }
    public static void printLabelFound(ArrayList<BookMain> bookLabel) {
        for (int i = 0; i < bookLabel.size(); i++) {
            System.out.println(i + 1 + ". " + bookLabel.get(i));
        }
    }
    public static void printNoLabelFound(){
        System.out.println("oops there are no books stored under this label...");
    }

    public static void printNoAuthorFound(){
        System.out.println("oops there are no books written by this author...");
    }
    public static void printRateFound(ArrayList<BookMain> bookRate) {
        for (int i = 0; i < bookRate.size(); i++) {
            System.out.println(i + 1 + ". " + bookRate.get(i));
        }
    }
    public static void printNoRateFound() {
        System.out.println("oops there are no books stored under this rating...");
    }

    public static void printRateAlreadySetWarning() {
        System.out.println("Hey.. you have already given this book this rating man");
    }

    public static void printLabelAlreadySetWarning() {
        System.out.println("Hey.. you have already given this book this label man");
    }

    public static void printAuthorAlreadySet(String title, String author) {
        System.out.println("oops " + title + " already has " + author + " as its author...");
    }

    public static void printDuplicateBookWarning(String title) {
        System.out.println("Woah ive added " + title + " for you but there is another book with the" +
                " same name in the list," + " if its a different book with " +
                "the same name but by a different author " +
                "please use `set-author` " + "to assign an author!"); }

    public static void printDuplicateAuthorWarning(String title, String author) {
        System.out.println("Wait !!! " + title + " by: " + author + " is already in the list, " +
                "you can use `remove` or `set-author` to remove that book or change the author..."); }

    public static void printAuthorFound(ArrayList<BookMain> bookAuthor) {
        for (int i = 0; i < bookAuthor.size(); i++) {
            System.out.println(i + 1 + ". " + bookAuthor.get(i));
        }
    }
    public static void printSingleIndentation() {
        System.out.print("----");
    }
    public static void printDoubleIndentation() {
        System.out.print("--------");
    }
    public static void printGenreRemovedMessage(String genre) {
        System.out.println("okii [" + genre + "] removed from the genre list!");
        printLine();
    }
}
