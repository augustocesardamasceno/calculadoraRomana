import java.util.Scanner;

public class CalculadoraRomanaApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual formato você quer converter? " +
                "\nDigite 1 para converter de inteiro para romano; " +
                "\nDigite 2 para converter de romano para inteiro" +
                "\nInsira sua escolha abaixo: ");

        int escolha = scanner.nextInt();
        if (escolha == 1){
            System.out.print("Digite um número inteiro (entre 1 e 3999): ");
            int numero = scanner.nextInt();
            String romano = Refatorador.realRomano(numero);
            System.out.println("Em algarismos romanos, " + numero + " é: " + romano);
        } else if (escolha == 2) {
            System.out.print("Insira o algarismo romano que deseja converter: ");
            scanner.nextLine();
            String algarismo = scanner.nextLine();
            int numero = Refatorador.romanoReal(algarismo);
            System.out.println("Em números reais, " + algarismo + " é: " + numero);
        }

        scanner.close();
    }



}
