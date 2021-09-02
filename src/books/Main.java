package books;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    static List<Book> books = new ArrayList<>(); //Collection of books
    static Map<Author, List<Book>> authors = new HashMap<>();
    static Map<Genre, List<Book>> genres = new HashMap<>();

    private static void catalog(Book book) {
        books.add(book);
        recordAuthor(book);
        recordGenre(book);
    }

    private static void recordAuthor(Book book) {
        recordSomething(authors, book, Book::getAuthor);
    }

    private static void recordGenre(Book book) {
        recordSomething(genres, book, Book::getGenre);
    }

    private static <ATTRIBUTE> void recordSomething(Map<ATTRIBUTE, List<Book>> index, Book book, Function<Book, ATTRIBUTE> getter) {
        final ATTRIBUTE attr = getter.apply(book);
        if (index.containsKey(attr)) {
            final List<Book> booksForAttribute = index.get(attr);
            booksForAttribute.add(book);
        } else {
            index.put(attr, initializeBookList(book));
        }
    }

    private static List<Book> initializeBookList(Book newBook) {
        List<Book> newList = new ArrayList<>();
        newList.add(newBook);
        return newList;
    }

    private static void centerText(String text) {
        final String columnString = System.getenv().getOrDefault("COLUMNS", "80");
        int columns = Integer.parseInt(columnString);
        centerText(text, columns);
    }

    private static void centerText(String text, int columns) {
        long indent = Math.round((columns - text.length()) / 2.0);
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        System.out.println(text);
    }

    public static void main(String[] args) {
        String name; //User Name
        Scanner input = new Scanner(System.in);
        String addABook; //Control method for book adding
        int totalGenreCount = 0;
        int totalBookCount = 0;
//        centerText("foo");
//        centerText("much text, way lots of text, a whole lotta text");
//        centerText("*");


        centerText("*********************");
        centerText("My Current Collection Of Books:");
        System.out.print("\nHello. Please enter your name: ");
        name = input.nextLine();
        System.out.println("Hello " + name);

        do {
            Book book = new Book();

            System.out.print(name + ", please enter the title of the book you would like to add to your library: ");
            book.setTitle(input.nextLine());

            System.out.print(name + ", please enter the author of " + book.getTitle() + ": ");
            book.setAuthor(new Author(input.nextLine()));

            System.out.print(name + ", please enter the genre of " + book.getTitle() + ": ");
            book.setGenre(new Genre(input.nextLine()));

            System.out.print(name + ", please enter an image for " + book.getTitle() + ": ");
            book.setImage(input.nextLine());

            System.out.print(name + ", please enter an overview for " + book.getTitle() + ": ");
            book.setOverview(input.nextLine());

            catalog(book);

            System.out.println("Would you like to add another book? yes or no");
            addABook = input.nextLine();

            totalBookCount++;

        } while (addABook.equals("yes"));

        input.close();

        System.out.println("\nThank you for providing this information. Your reading material has now been added to your library.");
        System.out.println("\n" + name + ", your library includes the following reading materials:  " + authorCount() + " authors, " + books.size() + " titles, " + books.size() + " overviews," + " and " + books.size() + " book images:");

        for (Genre genre : genres.keySet()) {
            //System.out.println("\nYou have " + genreCount() + "the following books that are of genre type: " + genre);
            System.out.println("\nYou have the following books that are of genre type " + genre + ": ");
            final List<Book> booksInGenre = genres.get(genre);

            totalGenreCount = 0; //Resets total Genre count to 0 after each genre has been iterated through.

            for (Book bookOfTypeGenre : booksInGenre) {
                System.out.println("\t" + bookOfTypeGenre.getTitle() + " by " + bookOfTypeGenre.getAuthor());
                if (bookOfTypeGenre.getTitle() != null) {

                    totalGenreCount++;

                }
                System.out.println("For a total of " + totalGenreCount + " " + genre + " book(s)!");
            }
        }
        System.out.println("\nFor a total of " + genreCount() + " genre(s)");
        // System.out.println(genreCount());

        for (Book book : books) {
            //System.out.println(book.getGenre());

            System.out.println("\nGenre:  " + book.getGenre() + " -  Title:  " + book.getTitle() + "  Author:  " + book.getAuthor() + " Image:  " + book.getImage());

        }
        System.out.println(name + "," + " you now have a total of " + totalBookCount + " books in your library!");
    }

    private static int authorCount() {
        //int numberOfAuthors = 0;
        return authors.size();
//        Set<Author> authors = new HashSet<>();
//        for (Book book : books) {
//            if (!authors.contains(book.getAuthor())) {
//                authors.add(book.getAuthor());
//            }
//        }
//        return authors.size();
    }

    private static int genreCount() {
        return genres.size();
//        ArrayList<Genre> genres = new ArrayList<>();
//        ArrayList<Integer> count = new ArrayList<>();
//
//        int temp = 0;
//        for (int countGenre = 0; countGenre < books.size(); countGenre++) {
//            temp = 0;
//            for (Book book : books) {
//
//                if (!genres.contains(book.getGenre())) {
//                    genres.add(book.getGenre());
//                    temp = temp + 1;
//
//                } else if (genres.contains(book.getGenre())) {
//                    temp = temp + 1;
//                }
//            }
//            count.add(temp);
//            System.out.println("\n" + genres.get(genres.size() - 1).getGenreName() + ": " + temp);
//        }
//        return temp;
    }
}


//package books;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        String name; //User Name
//        Scanner input = new Scanner(System.in);
//        String addABook; //Control method for book adding
//        ArrayList<Book> books = new ArrayList<>(); //Collection of books
//
//        System.out.println("                                                                                          *********************                      ");
//        System.out.println("                                                                                              Library Books:                       ");
//        System.out.print("\nHello. Please enter your name: ");
//        name = input.nextLine();
//        System.out.println("Hello " + name);
//
//        do {
//            Book book = new Book();
//
//            System.out.print(name + ", please enter the title of the book you would like to add to your library: ");
//            book.setTitle(input.nextLine());
//
//            System.out.print(name + ", please enter the author of " + book.getTitle() + ": ");
//            book.setAuthor(new Author(input.nextLine()));
//
//            System.out.print(name + ", please enter the genre of " + book.getTitle() + ": ");
//            book.setGenre(new Genre(input.nextLine()));
//
//            System.out.print(name + ", please enter an image for " + book.getTitle() + ": ");
//            book.setImage(input.nextLine());
//
//            System.out.println(name + ", please enter an overview for " + book.getTitle() + ": ");
//            book.setOverview(input.nextLine());
//
//            books.add(book);
//
//            System.out.println("Would you like to add another book? yes or no");
//            addABook = input.nextLine();
//
//        } while (addABook.equals("yes"));
//
//        input.close();
//
//        System.out.println("\nThank you for providing this information. Your reading material has now been added to your library.");
//        System.out.println("\nYour library includes the following reading materials:  " + authorCount(books) + " authors, " + books.size() + " titles, " + books.size() + " overviews," + " and " + books.size() + " book images:");
//
//        System.out.println("\nYou have the following books that are of genre type:");
////        System.out.println(genreCount(books));
//
//        for (Book book : books) {
//            System.out.println(book.getGenre().getGenreName());
//            System.out.println("\nGenre:  " + book.getGenre().getGenreName() + " -  Title:  " + book.getTitle() + "  Author:  " + book.getAuthor().getAuthorName() + " Image:  " + book.getImage());
//        }
//    }
//
////    private static int authorCount(ArrayList<Book> books) {
////        int numberOfAuthors = 0;
////        ArrayList<Author> authors = new ArrayList<>();
////        for (Book book : books) {
////            if (!books.contains(book.getAuthor())) {
////                authors.add(book.getAuthor());
////                numberOfAuthors++;
////            }
////        }
////        return numberOfAuthors;
////    }
//
//
////private static int authorCount(ArrayList<Book> books) {
////    int numberOfAuthors = 0;
////    ArrayList<Author> authors = new ArrayList<>();
////    for (Book book : books) {
////        if (!authors.contains(book.getAuthor())) {
////            authors.add(book.getAuthor());
////            numberOfAuthors++;
////        }
////    }
////    return numberOfAuthors;
////}
//
//    public static int AuthorCount() {
//        HashMap<String, String> authors = new HashMap<>();
//        String authors1;
//
//
//    }
//
//
//
//
//
////    private static int genreCount(ArrayList<Book> books) {
////        ArrayList<Genre> genres = new ArrayList<>();
////        ArrayList<Integer> count = new ArrayList<>();
////
////        int temp = 0;
////        for (int countGenre = 0; countGenre < books.size(); countGenre++) {
////            temp = 0;
////            for (Book book : books) {
////
////                if (!genres.contains(book.getGenre())) {
////                    genres.add(book.getGenre());
////                    temp = temp + 1;
////
////                } else if (genres.contains(book.getGenre())) {
////                    temp = temp + 1;
////                }
////            }
////            count.add(temp);
////            System.out.println("\n" + genres.get(genres.size() - 1).getGenreName() + ": " + temp);
////        }
////        return temp;
////    }
//}
//
//
