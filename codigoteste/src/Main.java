import java.util.Random;
import java.util.Scanner;

public class Main {
    int numero_aposta;
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();
    public static int apostaClasica(int numeroEscolhido) {
        Random random = new Random();
        int numeroSorteado = random.nextInt(56);// A pessoa nunca vai ganhar
        int resultado;

        System.out.println("Você escolheu a aposta clássica!");
        System.out.println("Número sorteado: " + numeroSorteado);

        if (numeroEscolhido == numeroSorteado) {
            System.out.println("Parabéns, você ganhou! Valor ganho: R$10.000");
            resultado = 10000; // Valor arbitrário para representar a vitória
        } else {
            System.out.println("Não foi dessa vez, tente novamente e boa sorte.");
            System.out.println("O número sorteado foi " + numeroSorteado);
            resultado = 0; // Valor arbitrário para representar a derrota
        }

        return resultado;
    }

    public static void tigrinho(int valorAposta) {
        Random aleatorio = new Random();
        Scanner sc = new Scanner(System.in);
        int caixaCerta = aleatorio.nextInt(10);
        int escolha;
        int premio = 2 * valorAposta;
        System.out.println("[1] [2] [3]");
        System.out.println("[4] [5] [6]");
        System.out.println("[7] [8] [9]");
        System.out.println("Escolha uma caixa: ");
        escolha = sc.nextInt();
        if (escolha == caixaCerta){
            System.out.println("Parabéns, você escolheu a caixa certa");
            System.out.println("Seu prêmio "+ premio);

        }else{
            System.out.println("Você não escolheu a caixa certa, boa sorte na proxima vez");
            System.out.println("A caixa certa era: "+caixaCerta);;
        }
    }

    public static int roleta(int valorAposta, int numeroEscolhido) {
        Random aleatorio = new Random();
        Scanner sc = new Scanner(System.in);
        int n1, n2, n3;
        n1 = aleatorio.nextInt(5);
        n2 = aleatorio.nextInt(5);
        n3 = aleatorio.nextInt(5);
        int premio = 2 * valorAposta;

        System.out.println("--------------------------");
        System.out.println("|        |        |       |");
        System.out.println("|"   +n1   +"|"   +n2 +  " | "+n3+"|");
        System.out.println("|        |        |       |");
        System.out.println("--------------------------");

        int roletaSistema;

        System.out.println("Para girar a roleta, digite 1:");
        roletaSistema = sc.nextInt();

        if (roletaSistema == 1) {
            // EFEITO DE GIRAR, COMO SE TIVESSE GIRANDO A ROLETA
            n1 = (n1 + 1) % 5;
            n2 = (n2 + 1) % 5;
            n3 = (n3 + 1) % 5;
            System.out.println("Roleta girando");
            premio = 2 * valorAposta;
        }

        if (n1 == numeroEscolhido || n2 == numeroEscolhido || n3 == numeroEscolhido) {
            System.out.println("Parabéns, você venceu");
            System.out.println("Seu prêmio: " + premio);
        } else {
            System.out.println("Você perdeu, boa sorte na próxima vez");
            System.out.println("Os números sorteados foram " + n1 + ", " + n2 + ", " + n3);
            premio = 0;
        }

        return premio;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();


        System.out.println("Bem-Vindo a Glicério BET");
        System.out.println("Escolha o modo que deseja apostar:");
        System.out.println("====================================");
        System.out.println("||             Jogos              ||");
        System.out.println("||  1. Aposta Clásica             ||");
        System.out.println("||  2. Jogo do Tigrinho           ||");
        System.out.println("||  3. Roleta                     ||");
        System.out.println("====================================");
        int escolha_game = sc.nextInt();
        switch (escolha_game) {
            case 1:
                System.out.println("Insira um número para a aposta clásica: ");
                int valor = sc.nextInt();
                apostaClasica(valor);
                break;
            case 2:
                System.out.println("Você escolheu o Jogo do Tigrinho");
                System.out.println("Insira o valor da aposta: ");
                int valorAposta = sc.nextInt();
                tigrinho(valorAposta);
                break;
            case 3:
                System.out.println("Você escolheu o modo Roleta.");
                System.out.println("Insira o valor da aposta: ");
                int valorApostaRoleta = sc.nextInt();
                System.out.println("Agora insira o numero que deseja apostar: ");
                int numeroApostaRoleta = sc.nextInt();
                int resultadoRoleta = roleta(valorApostaRoleta, numeroApostaRoleta);
                System.out.println("Resultado da roleta: " + resultadoRoleta);
                break;
        }
    }
}