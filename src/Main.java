import java.util.Scanner;

/**
 * Created by Pitrecki on 2016-08-18.
 */
public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TemperatureConventer conventer = new TemperatureConventer();

        System.out.println("Witaj w programie!");
        System.out.println("Wpisz wartosc temperatury podajac jej jednostke f/F dla Fahrenheit, c/C dla Celsiusz lub k/K dla Kelwin.");
        System.out.println("Po wpisaniu F; C lub K, program obliczy temperature dla wartosci 0 st.");
        System.out.println("q lub 0 wyjscie z programu.");


        boolean isQuit = false;
        while(!isQuit) {
            System.out.print("Podaj wartosc: ");
            String sInput = scanner.next();
            sInput = sInput.toLowerCase();
            switch (sInput) {
                case "0":
                    isQuit = true;
                    System.out.println("\nProgram zakonczony\n");
                    break;
                case "q":
                    isQuit = true;
                    System.out.println("\nProgram zakonczony\n");
                    break;
                default:
                    conventer.inputData(sInput);
                    break;
            }
        }

    }


}
