import Optimal.OptimalContainer;

public class Main {

    static OptimalContainer program;

    public static void main (String[] args) {
        Scanner user = new Scanner(System.in); // Scans console for user input
        System.out.println("What file would you like to import from?");
        String fileName = user.nextLine();
        program = new OptimalContainer(fileName);
        optimal.run();
    }
}