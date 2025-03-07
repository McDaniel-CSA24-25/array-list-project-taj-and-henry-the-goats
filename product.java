import java.util.ArrayList;
import java.util.Scanner;
public class product {
    private String name;
    private int id;
    private int quantity;
    private double price;
    public product() {
        name = "garbage";
        id = 759337;
        quantity = 1;
        price = 0;
    }
    public product(String n, int i, int q, double p) {
        name = n;
        id = i;
        quantity = q;
        price = p;
    }
    public void setQuantity(int no) {
        quantity = no;
    }
    public boolean isSmall() {
        if (quantity < 5) {
            return true;
        }
        return false;
    }
    public void showProduct() {
        System.out.println("you have " + quantity + " " + name + " worth a total of $" + value() + ".");
        System.out.println();
    }
    public double value() {
        return (quantity * price);
    }
    public String getName() {
        return name;
    }
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<product> inventory = new ArrayList<product>();
        inventory.add(new product("frog", 38943, 100, 0.8));
        inventory.add(new product("least_weasel", 38944, 1, 100));
        inventory.add(new product());
        while (true) {
            System.out.println("Welcome, supervisor, to the warehouse. Would you like to [view inventory], or [quit]?");
            String choice1 =  keyboard.nextLine();
            if (choice1.equalsIgnoreCase("view inventory")) {
                for (product p : inventory) {
                    p.showProduct();
                }
                double totalValue = 0;
                for (product p : inventory) {
                    totalValue += p.value();
                }
                System.out.println("The total value of your inventory is: $" + totalValue);
                System.out.println("Would you like to [edit stock] or [see low stock items]?");
                String choice2 = keyboard.nextLine();
                if (choice2.equalsIgnoreCase("edit stock")) {
                    System.out.println("Enter the name of the product, followed by a space, then amount you want to set the stock to.");
                    String choice3 = keyboard.nextLine();
                    int change = Integer.parseInt(choice3.substring(choice3.indexOf(" ") + 1));
                    String name = "";
                    for (int i = 0; i < inventory.size(); i++) {
                        if (inventory.get(i).getName().equalsIgnoreCase(choice3.substring(0, choice3.indexOf(" ")))) {
                            inventory.get(i).setQuantity(change);
                            System.out.println("Quantity set!");
                        }
                    }
                } else if (choice2.equalsIgnoreCase("see low stock items")) {
                    for (product p : inventory) {
                        if (p.isSmall()) {
                            p.showProduct();
                        }
                    }
                    System.out.println();
                }

            } else if (choice1.equalsIgnoreCase("quit")){
                break;
            }

        }
        System.out.println("Bye now!");
    }
}
