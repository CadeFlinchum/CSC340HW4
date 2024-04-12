package csc340hw4;

import java.io.*;
import java.util.*;

class AddFriend {

    private static int idCounter = 1;

    public static void AddFriend() {

        try {
            Scanner input = new Scanner(System.in);
            System.out.println("\nYou have picked create. Please enter a name to be created:");
            String name = input.nextLine();

            File file = new File("file.txt");

            // Initialize ID counter
            int idCounter = 1;

            // Check if the file already exists
            if (file.exists()) {
                // Read the file to find the highest existing ID
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    int id = Integer.parseInt(parts[0].trim());
                    if (id >= idCounter) {
                        idCounter = id + 1; // Increment ID counter
                    }
                }
                reader.close();
            }

            // Append the name with the calculated ID to the file with a newline character
            FileWriter writer = new FileWriter(file, true); // true for appending
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(idCounter + ": " + name + "\n");
            bufferWriter.close();

            System.out.println("\nName '" + name + "' added with ID " + idCounter + " to the file.\n");

        } catch (IOException | NumberFormatException ioe) {
            System.out.println(ioe);
        }
    }
}
