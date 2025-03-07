import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static boolean quit = false;
    public static void homeMenu(ArrayList<Book> i, Scanner k) {
        System.out.print("You are home. Here is your inventory: ");
        for (Book book : i) {
            System.out.print(book.getTitle() + ". ");
        }
        System.out.println("To view a book, enter its name, to sleep, enter [sleep]");
        String choice4 = k.nextLine();
        if (!choice4.equalsIgnoreCase("sleep")) {
            for (Book book : i) {
                if (book.getTitle().equalsIgnoreCase(choice4)) {
                    book.displayBook();
                }
            }
            System.out.println("That was quite an eventful day, and you're quite tired, let's go to sleep.");
        }
    }

    public static void libraryMenu(int t, ArrayList<Book> p, ArrayList<Book> l, Scanner k) {
        System.out.println("The librarian greets you, their smile warming.");
        while (true) {
            System.out.print("Here are the available books: ");
            for (Book book : l) {
                System.out.print(book.getTitle() + ". ");
            }
            System.out.println();
            System.out.println(". Would you like to [check out a book], [return a book], or [go home]?");
            String choice2 = k.nextLine();
            if (choice2.equals("check out a book")) {
                System.out.println("Please tell me which book you would lke to check out.");
                String choice3 = k.nextLine();
                for (int i = 0; i < l.size(); i++) {
                    if (choice3.equalsIgnoreCase(l.get(i).getTitle())) {
                        p.add(l.get(i));
                        l.remove(i);
                        p.getLast().setAvailable(false, t);
                    }
                }
                System.out.println(p.getLast().getTitle() + " was checked out!");
                System.out.println("Closing time! Let's go home.");
                break;
            } else if (choice2.equals("go home")) {
                System.out.println("Okay, let's go home.");
                break;
            } else if (choice2.equals("return a book")) {
                System.out.println("Here is your inventory, specify the book you would like to return.");
                for (Book book : p) {
                    System.out.print(book.getTitle() + " ");
                }
                String choice5 = k.nextLine();
                boolean triedToReturnCuriousGeorge = false;
                for (Book book : p) {
                    if (!book.getTitle().equalsIgnoreCase("Curious George") && book.getTitle().equalsIgnoreCase(choice5)) {
                        System.out.println("Returned!");
                        book.setAvailable(true, t);
                        l.add(book);
                        p.remove(book);
                        break;
                    } else if (book.getTitle().equals("Curious George")) {
                        System.out.println("As you try to return your most prized possession, a feeling of nausea overcomes you.");
                        System.out.println("You find yourself mysteriously at home, without memory of what happened. In your hand, is that book.");
                        triedToReturnCuriousGeorge = true;
                        break;
                    }
                }
                if (triedToReturnCuriousGeorge) {
                    break;
                }
            }
        }
    }
        public static void main(String[] args){
            Scanner keyboard = new Scanner(System.in);
            int time = 0;
            ArrayList<Book> library = new ArrayList<Book>();
            ArrayList<Book> player = new ArrayList<Book>();
            library.add(new Book("The Hobbit", "J.R.R Tolkien"));
            library.add(new Book("Who Is Lebron James?", "Crystal Hubbard"));
            library.add(new Book("BUBU choi voi lua","nhieu tac gia"));
            library.add(new Book("Winning Ugly: Mental Warfare in Tennis--Lessons from a Master", "Brad Gilbert"));
            library.add(new Book("Why Z-A is bad", "Taj Siharath"));
            library.add(new Book("Henry's guide to Fortnite", "Henry Luu"));
            player.add(new Book());
            while (!quit) {
                time++;
                System.out.println("Wake up, or quit?");
                String choice0 = keyboard.nextLine();
                if (choice0.equalsIgnoreCase("quit")) {
                    System.out.println("Bye nice person.");
                    break;
                }
                System.out.println("You wake to find yourself on day " + time + ". Would you like to [go to the library], or [stay home]?");
                String choice1 = keyboard.nextLine();
                if (choice1.equalsIgnoreCase("go to the library")) {
                    libraryMenu(time, player, library, keyboard);
                    homeMenu(player, keyboard);
                } else if (choice1.equalsIgnoreCase("stay home")) {
                    homeMenu(player, keyboard);
                }
            }
        }
    }

