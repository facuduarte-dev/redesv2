import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la red a escanear: ");
        String redIngresada = sc.nextLine();

        EscanerRed escaner = new EscanerRed(redIngresada);

        sc.close();

    }
}