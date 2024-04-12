package csc340hw4;

import java.util.*;

/**
 *
 * @author Flinchum
 */
public class CSC340HW4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AddFriend create = new AddFriend();
        DisplayFriends read = new DisplayFriends();
        UpdateFriend update = new UpdateFriend();
        DeleteFriend delete = new DeleteFriend();

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("What would you like to do?\n1 for create, 2 for read, 3 for update, 4 for delete, and q to quit:");

            String choiceStr = input.nextLine();

            if (choiceStr.equalsIgnoreCase("q")) {
                break; // Quit the loop if 'q' is entered
            }

            // Check if the input is numeric
            if (choiceStr.matches("\\d+")) {
                int choice = Integer.parseInt(choiceStr);

                switch (choice) {
                    case 1:
                        create.AddFriend();
                        break;
                    case 2:
                        read.DisplayFriends();
                        break;
                    case 3:
                        update.UpdateFriend();
                        break;
                    case 4:
                        delete.DeleteFriend();
                        break;
                    default:
                        System.out.println("\nInvalid choice. Please try again.\n");
                        break;
                }
            } else {
                System.out.println("\nInvalid input. Please enter a number or 'q' to quit.\n");
            }
        }

        input.close();
    }
}
