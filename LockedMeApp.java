import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LockedMeApp {

    private static final String ROOT_DIRECTORY = "files/"; // Root directory path for storing files

    private ArrayList<String> fileList; // List to store file names

    public LockedMeApp() {
        this.fileList = new ArrayList<>();
    }

    // Method to display welcome screen
    private void displayWelcomeScreen() {
        System.out.println("********************************************");
        System.out.println("*  Welcome to LockedMe.com - File Manager  *");
        System.out.println("*  Developer: Your Name                    *");
        System.out.println("********************************************\n");
    }

    // Method to display main menu and handle user options
    private void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. List all files");
            System.out.println("2. File operations");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    listFiles();
                    break;
                case 2:
                    displayFileOperationsMenu(scanner);
                    break;
                case 3:
                    continueRunning = false;
                    System.out.println("Thank you for using LockedMe.com. Exiting...");
                    break;
                default:
                    System.out.println("Invalid input. Please enter a valid option (1-3).");
            }
        }
        scanner.close();
    }

    // Method to list all files in ascending order
    private void listFiles() {
        if (fileList.isEmpty()) {
            System.out.println("The directory is empty.");
        } else {
            Collections.sort(fileList); // Sort files in ascending order
            System.out.println("List of files:");
            for (String file : fileList) {
                System.out.println(file);
            }
        }
    }

    // Method to display file operations menu and handle user operations
    private void displayFileOperationsMenu(Scanner scanner) {
        boolean backToMainMenu = false;

        while (!backToMainMenu) {
            System.out.println("\nFile Operations Menu:");
            System.out.println("1. Add a file");
            System.out.println("2. Delete a file");
            System.out.println("3. Search for a file");
            System.out.println("4. Back to main menu");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    addFile(scanner);
                    break;
                case 2:
                    deleteFile(scanner);
                    break;
                case 3:
                    searchFile(scanner);
                    break;
                case 4:
                    backToMainMenu = true;
                    break;
                default:
                    System.out.println("Invalid input. Please enter a valid option (1-4).");
            }
        }
    }

    // Method to add a file to the directory
    private void addFile(Scanner scanner) {
        System.out.println("Enter the file name to be added:");
        String fileName = scanner.nextLine();

        if (fileList.contains(fileName)) {
            System.out.println("File already exists.");
        } else {
            fileList.add(fileName);
            System.out.println(fileName + " added successfully.");
        }
    }

    // Method to delete a file from the directory
    private void deleteFile(Scanner scanner) {
        System.out.println("Enter the file name to be deleted:");
        String fileName = scanner.nextLine();

        if (fileList.remove(fileName)) {
            System.out.println(fileName + " deleted successfully.");
        } else {
            System.out.println("File not found: " + fileName);
        }
    }

    // Method to search for a file in the directory
    private void searchFile(Scanner scanner) {
        System.out.println("Enter the file name to be searched:");
        String fileName = scanner.nextLine();

        if (fileList.contains(fileName)) {
            System.out.println("File found: " + fileName);
        } else {
            System.out.println("File not found: " + fileName);
        }
    }

    public static void main(String[] args) {
        LockedMeApp lockedMe = new LockedMeApp();
        lockedMe.displayWelcomeScreen();
        lockedMe.displayMainMenu();
    }
}
