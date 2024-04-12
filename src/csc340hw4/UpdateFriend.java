package csc340hw4;

import java.io.*;
import java.util.*;

class UpdateFriend {

    public static void UpdateFriend() {

        try {
            Scanner input = new Scanner(System.in);
            System.out.println("\nEnter the ID of the friend you want to update:");
            int id = Integer.parseInt(input.nextLine());

            File file = new File("file.txt");
            if (!file.exists()) {
                System.out.println("\nNo friends found.\n");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith(id + ": ")) {
                    found = true;
                    System.out.println("\nEnter the new name for ID " + id + ":");
                    String newName = input.nextLine();
                    content.append(id).append(": ").append(newName).append("\n");
                } else {
                    content.append(line).append("\n");
                }
            }
            reader.close();

            if (!found) {
                System.out.println("\nFriend with ID " + id + " not found.\n");
                return;
            }

            FileWriter writer = new FileWriter(file);
            writer.write(content.toString());
            writer.close();

            System.out.println("\nFriend with ID " + id + " updated successfully.\n");

        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        }
    }
}
