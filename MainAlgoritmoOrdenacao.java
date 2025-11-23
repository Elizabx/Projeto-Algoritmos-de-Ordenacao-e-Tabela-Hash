package ed2.projeto.algoritmosordenacao;

import java.util.Arrays;
import java.util.Scanner;

public class MainAlgoritmoOrdenacao  {
    public static void main(String[] args) {
        int[] vetorOriginal = { 45, 12, 88, 5, 23, 7, 60, 1 };

        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        InterfaceAlgoritmoOrdenacao[] algoritmos = {
                new BubbleSort(),
                new SelectionSort(),
                new InsertionSort(),
                new MergeSort(),
                new QuickSort()
        };

        while (opcao != 0) {

            System.out.println("Menu de Algoritmos de Ordenação");

            for (int i = 0; i < algoritmos.length; i++) {
                System.out.printf(" %d. %s\n", (i + 1), algoritmos[i].toString());
            }

            System.out.println("0. Sair");
            System.out.println("Escolha um algoritmo: ");

            if (sc.hasNextInt()){
                opcao = sc.nextInt();
            } else {
                System.out.println("\nOpção inválida. Digite um número.");
                sc.next();
                continue;
            }

            if(opcao > 0 && opcao <= algoritmos.length){

                int[] vetorParaOrdenar = Arrays.copyOf(vetorOriginal, vetorOriginal.length);

                InterfaceAlgoritmoOrdenacao algoritimoEscolhido = algoritmos[opcao - 1];

                System.out.printf("Algoritimo Escolhido: **%s**\n", algoritimoEscolhido.toString());

                System.out.println("Vetor de Entrada: ");
                Utils.imprimirVetor(vetorOriginal);
                System.out.println();

                long tempoInicial = System.nanoTime();
                algoritimoEscolhido.ordenarVetor(vetorParaOrdenar);
                long tempoFinal = System.nanoTime();

                System.out.println("Vetor de Saída: ");
                Utils.imprimirVetor(vetorParaOrdenar);
                System.out.println();

                long tempoExecucaoMs = (tempoFinal - tempoInicial) / 1_000_000;
                System.out.printf("Tempo de Execução: %d ms\n",  tempoExecucaoMs);
            } else if (opcao == 0) {

                System.out.println("\nSaindo do programa. Até mais!");
            } else {

                System.out.println("\nOpção inválida. Por favor, escolha uma opção entre 0 e " + algoritmos.length + ".");
            }
        }

        sc.close();
    }
}