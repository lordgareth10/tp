package seedu.bookbuddy;

import exceptions.InvalidCommandArgumentException;
import exceptions.UnsupportedCommandException;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.parser.ParserMain;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;
import java.util.logging.Handler;

import static java.util.logging.Logger.getLogger;

public class BookBuddy {
    public static final Logger LOGGER = getLogger(BookBuddy.class.getName());
    public static final String EXIT_COMMAND = "bye";
    private static BookList books = new BookList();
    static FileStorage filestorage = new FileStorage(books);
    static {
        try {
            LOGGER.setUseParentHandlers(false);
            // Remove all the default handlers
            Handler[] handlers = LOGGER.getHandlers();
            for (Handler handler : handlers) {
                LOGGER.removeHandler(handler);
            }
            // Add our file handler
            FileHandler fileHandler = new FileHandler("BookBuddy.log", true); // Append to the existing file
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.INFO);
        } catch (SecurityException | IOException e) {
            LOGGER.log(Level.SEVERE, "FileHandler can not be initialized", e);
        }
    }

    public static void main(String[] args) throws IOException {
        LOGGER.log(Level.INFO, "BookBuddy application started.");
        Ui.printWelcome();
        assert books != null : "BookList not created";
        getUserInput(books);
        LOGGER.log(Level.INFO, "BookBuddy application is shutting down.");
    }

    public static void getUserInput(BookList books) throws IOException {
        Scanner input = new Scanner(System.in);
        LOGGER.log(Level.INFO, "Starting to get user input.");

        while (true) {
            String userInput = input.nextLine().trim();
            if (userInput.isEmpty()) {
                // If the input is empty, do not call parseCommand and just prompt for input again.
                continue;
            } else if (userInput.equals(EXIT_COMMAND)) {
                exitSystem(books, filestorage);
            }
            assert !userInput.isEmpty() : "User input should not be empty at this point";
            LOGGER.log(Level.FINE, "Processing user input: {0}", userInput);
            try {
                ParserMain.parseCommand(userInput, books);
            } catch (UnsupportedCommandException e) {
                LOGGER.log(Level.WARNING, "Unsupported command: {0}", userInput);
                System.out.println(e.getMessage());
            } catch (InvalidCommandArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) { // Generic catch block for any other exceptions
                LOGGER.log(Level.SEVERE, "An unexpected error occurred: {0}", e.getMessage());
                System.out.println("An unexpected error occurred. Please contact support.");
            }
        }
    }
    //@@author joshuahoky
    private static void exitSystem(BookList books, FileStorage filestorage) throws IOException {
        filestorage.saveData(books);
        Ui.printExitMessage();
        System.exit(0);
    }

    //@@author


    public static void performExit() throws IOException {
        exitSystem(books, filestorage);
    }
}
