import java.util.Scanner;

public class BargamentoElrichVan {
    static String[][] accounts = new String[3][2];
    static int userCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Bargs Login System ---");
            System.out.println("1. Mo lag in");
            System.out.println("2. Tapos mo rigistir");
            System.out.println("0. Then mo hawa sa system");
            System.out.print("Pamili diha baday: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    register(scanner);
                    break;
                case 0:
                    System.out.println("Pahawaay sa program...");
                    break;
                default:
                    System.out.println("Taka raka di na mao bogo.");
            }

        } while (choice != 0);

        scanner.close();
    }

    static void register(Scanner scanner) {
        if (userCount >= accounts.length) {
            System.out.println("Nalimit na ang pag himog account.");
            return;
        }

        System.out.print("Pagbutang ug Username: ");
        String user = scanner.nextLine();
        System.out.print("Pagbutang ug Password: ");
        String pass = scanner.nextLine();
        System.out.print("I-konperm imo password ug sure na: ");
        String confirm = scanner.nextLine();

        if (!pass.equals(confirm)) {
            System.out.println("Di parehas imong password bano.");
            return;
        }

        accounts[userCount][0] = user;
        accounts[userCount][1] = pass;
        userCount++;

        System.out.println("Sumaksis pag register nimo dong, " + user + "!");
    }

    static void login(Scanner scanner) {
        System.out.print("Butang imong Username: ");
        String user = scanner.nextLine();
        System.out.print("Butang imong Password: ");
        String pass = scanner.nextLine();

        for (int i = 0; i < userCount; i++) {
            if (accounts[i][0].equals(user) && accounts[i][1].equals(pass)) {
                System.out.println("Hello boss, " + user + "!");
                return;
            }
        }

        System.out.println("Na lag in failed man dong! Di mao imong username ug password.");
    }
}