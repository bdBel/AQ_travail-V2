import java.util.Scanner;

public class Fibonacci_Sequence {
    public static void main(String[] args) {
     //Afficher un menu en boucle avec les options demandeés
        while (true) {
            Scanner scan = new Scanner(System.in);
            int tache = choixMenu();
            if (tache == 4) {
                System.out.println("Fin, merci d'avoir utilisé notre programme");
                break;
            }
            CalculSequencefibonacci(tache);
        }
    }
     //méthode pour retourner la tâche choisie
    public static int choixMenu() {

        Scanner scan = new Scanner(System.in);
        int tache;
        System.out.println(" Calculs de la séquence Fibonacci et tests de la vitesse d'éxecution : \n");
        System.out.println("Menu\n");
        System.out.println("1. Caclul de la séquence Fibonacci avec une boucle");
        System.out.println("2. Calclu de la séquence Fibonacci avec la tache récursive");
        System.out.println("3. Calcul du Temps d'execution avec chaque méthode");
        System.out.println("4. Quitter\n ");
        System.out.println("Faites votre choix.");

        tache = scan.nextInt();
        if (tache < 1 || tache > 4) {
            System.out.println("Option invalide, choisir l'item");
        }
        return tache;
    }

   //methode switch pour executer la tâche choisie

    public static void CalculSequencefibonacci(int tache) {
        Scanner scan = new Scanner(System.in);
        System.out.println("entrer le nombre de chiffres voulus dans ls séquence : ");
        int n = scan.nextInt();
        switch (tache) {

            case 1:
                System.out.println("Sequence Fibonacci calculée pour " + n + " chiffres avec l'utilisation d'une boucle : ");
                int[] sequenceBoucle = fibonacciBoucle(n);
                afficherSequence(sequenceBoucle);
                pauseToContinue(scan);
                scan.nextLine();
                System.out.println("\n");


                break;
            case 2:
                System.out.println("Séquence Fibonacci calculée pour " + n + " chiffres avec la méthode recursive : ");
                int[] sequenceRecursive = fibonacciMethodeRecursive(n);
                afficherSequence(sequenceRecursive);
                System.out.println("\n");
                pauseToContinue(scan);
                scan.nextLine();

                break;
            case 3:
                System.out.println("Résultat de la comparaison des temps d'execution de chaque méthode pour le nombre " + n + " de chiffres ");
                CalculTempsExecution(n);
                System.out.println("\n");
                pauseToContinue(scan);
                scan.nextLine();

                break;

            default:
                System.out.println("Valeur invalide entrée");
                break;
        }
    }

    public static int[] fibonacciBoucle(int n) {

        int[] sequenceBoucle = new int[n]; //index n+1 chiffres
        sequenceBoucle[0] = 0;
        sequenceBoucle[1] = 1;
        for (int i = 2; i <n; i++) { //va justque 9
            sequenceBoucle[i] = sequenceBoucle[i - 1] + sequenceBoucle[i - 2];
        }
        return sequenceBoucle;
    }
    //Les méthodes pour calculer la séquence Fibonacci
    public static int[] fibonacciMethodeRecursive(int n) {
        int[] sequence = new int[n]; // Create an array to store the sequence
        for (int i = 0; i < n; i++) {
            sequence[i] = getFiboRecursif(i);
        }
        return sequence;
    }
    public static int getFiboRecursif(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return getFiboRecursif(n - 1) + getFiboRecursif(n - 2);
        }
    }
    //Méthode pour afficher les séquences
    public static void afficherSequence(int[] sequence) {
        for (int i = 0;i < sequence.length;i++) {
        System.out.print(sequence[i]+ " ");
        }
      }
     //Méthode pour calculer lde temps d'éxecution pour chaque méthode (boucle ou récursif et comparer les résulats.)
    public static void CalculTempsExecution(int n) {
        System.out.println("temps d'execution pour la mméthode avec boudle pour " + n + " chiffres :");
        long startTime = System.nanoTime();
        fibonacciBoucle(n);
        long endTime = System.nanoTime();
        long tempsExec = endTime - startTime;
        System.out.println("le temps d'execution pour la méthode boucle est de :\n " + tempsExec);
        long startTime1 = System.nanoTime();
        fibonacciMethodeRecursive(n);
        long endTime1 = System.nanoTime();
        long tempsExec1 = endTime1 - startTime1;
        System.out.println("temps d'execution pour la méthode récursive pour " + n + " chiffres : ");
        System.out.println(tempsExec1);
        if (tempsExec - tempsExec1 > 0) {
            System.out.println("Meilleure performance pour la méthode récursive ! ");
        } else {
            System.out.println("Meilleure performance pour la méthode en boucle ! ");
        }
    }
   //faire une pausse après l'affichage du résultat
    public static void pauseToContinue(Scanner scan) {
        System.out.println("\nAppuyez sur Entrée pour continuer...");
        scan.nextLine(); // Wait for Enter key press
    }
}