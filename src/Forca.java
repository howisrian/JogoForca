import java.util.Random;
import java.util.Scanner;

public class Forca {
    private static final String[] PALAVRAS = {"JAVA", "PROGRAMACAO", "DESENVOLVIMENTO", "COMPUTADOR", "GITHUB"};

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String palavra = PALAVRAS[random.nextInt(PALAVRAS.length)];
        char[] palavraOculta = new char[palavra.length()];
        for (int i = 0; i < palavraOculta.length; i++) {
            palavraOculta[i] = '_';
        }

        int tentativas = 6;
        boolean acertou = false;

        System.out.println("Bem-vindo ao Jogo da Forca!");
        System.out.println("Adivinhe a palavra:");

        while (tentativas > 0 && !acertou) {
            System.out.println("Palavra: " + String.valueOf(palavraOculta));
            System.out.println("Tentativas restantes: " + tentativas);
            System.out.print("Digite uma letra: ");
            char letra = scanner.nextLine().toUpperCase().charAt(0);

            boolean acertouLetra = false;
            for (int i = 0; i < palavra.length(); i++) {
                if (palavra.charAt(i) == letra) {
                    palavraOculta[i] = letra;
                    acertouLetra = true;
                }
            }

            if (!acertouLetra) {
                tentativas--;
                System.out.println("Letra não encontrada. Tente novamente.");
            }

            if (String.valueOf(palavraOculta).equals(palavra)) {
                acertou = true;
            }
        }

        if (acertou) {
            System.out.println("Parabéns, você ganhou! A palavra era: " + palavra);
        } else {
            System.out.println("Game Over! A palavra correta era: " + palavra);
        }

        scanner.close();
    }
}
