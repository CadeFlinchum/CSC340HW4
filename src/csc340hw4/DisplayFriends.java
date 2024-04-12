package csc340hw4;

import java.io.*;
import java.util.*;

/**
 *
 * @author Flinchum
 */
public class DisplayFriends {

    public static void DisplayFriends() {
        try {
            File file = new File("file.txt");
            if (!file.exists()) {
                System.out.println("\nNo friends found.\n");
                return;
            }

            System.out.println("\nThe names are in the format 'id: name'\n");

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            System.out.println("");
            scanner.close();

        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
