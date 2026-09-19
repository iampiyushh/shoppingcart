
    
import java.util.Scanner;


class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class ShoppingCart {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product[] products = new Product[10];
        int size = 0;
        int choice;

        do {

            System.out.println("\n========== ONLINE SHOPPING CART ==========");
            System.out.println("1. Add Product");
            System.out.println("2. Delete Product");
            System.out.println("3. Search Product");
            System.out.println("4. Display Products");
            System.out.println("5. Sort Products");
            System.out.println("6. Exit");
            System.out.print("Enter Your Choice : ");

            choice = sc.nextInt();

            switch (choice) {


                case 1:

                    if (size == products.length) {
                        System.out.println("Product List Full!");
                        break;
                    }

                    System.out.print("Enter Product ID : ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Product Name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Product Price : ");
                    double price = sc.nextDouble();

                    products[size] = new Product(id, name, price);
                    size++;

                    System.out.println("Product Added Successfully!");
                    break;

            
                case 2:

                    System.out.print("Enter Product ID to Delete : ");
                    int deleteId = sc.nextInt();

                    boolean deleted = false;

                    for (int i = 0; i < size; i++) {

                        if (products[i].id == deleteId) {

                            for (int j = i; j < size - 1; j++) {
                                products[j] = products[j + 1];
                            }

                            products[size - 1] = null;
                            size--;

                            deleted = true;

                            System.out.println("Product Deleted Successfully!");
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Product Not Found!");
                    }

                    break;

            
                case 3:

                    System.out.print("Enter Product ID to Search : ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    
                    for (int i = 0; i < size ; i++) {
                        if (products[i].id == searchId) {
                            System.out.println("\nProduct Found size ");
                            System.out.println("ID : " + products[i].id);
                            System.out.println("Name : " + products[i].name);
                            System.out.println("Price : " + products[i].price);

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Product Not Found!");
                    }

                    break;

        
                case 4:

                    
                    if (size  == 0) {
                        System.out.println("No Products Available!");
                    } else {

                        System.out.println("\n----- Product List -----");

                        
                        for (int i = 0; i < size ; i++) {
                            System.out.println(
                                    products[i].id + "   "
                                            + products[i].name + "   Rs."
                                            + products[i].price);

                        }
                    }

                    break;

            
                case 5:

                    
                    for (int i = 0; i < size  - 1; i++) {
                        
                        for (int j = i + 1; j < size ; j++) {
                            if (products[i].price > products[j].price) {

                                Product temp = products[i];
                                products[i] = products[j];
                                products[j] = temp;
                            }
                        }
                    }

                    System.out.println("Products Sorted Successfully!");
                    break;

                case 6:
                    System.out.println("Thank You for using shooping cart system!");
                    break;

                default:
                    System.out.println("Invalid Choice!");

            }

        } while (choice != 6);

        sc.close();
    }
}
