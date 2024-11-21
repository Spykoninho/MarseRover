import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Saisissez la largeur maximale de la map -5");
        Scanner scanner = new Scanner(System.in);
        int maxL = scanner.nextInt();
        Planete planete = new Planete(maxL);
        String input = "";
        do {
            input = scanner.nextLine();
            planete.moveRover(input);
            planete.displayPlanete();
        }while(!input.equals("q"));
    }
}
