import java.util.Scanner;

public class MainFib {
    public static void main(String[] args) {

     //Affiche un menu en boucle avec les options demandeés

         while (true) {

            int tache = choixMenu();
            if (tache == 4) {
                System.out.println("Fin, merci d'avoir utilisé notre programme");
                break;
            }
            calculSequenceFibonacci(tache);
        }
    }

    /**
     * @return
     */
     //méthode pour retourner la tâche choisie
        public static int choixMenu() {
        Scanner scan = new Scanner(System.in);
        int tache;
        System.out.println(" Calculs de la séquence Fibonacci et tests de la vitesse d'éxecution : \n");
        System.out.println("Menu\n");
        System.out.println("1. Caclul de la séquence Fibonacci avec une boucle");
        System.out.println("2. Calcul de la séquence Fibonacci avec la méthode récursive");
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

    public static void calculSequenceFibonacci(int tache) {
        Scanner scan = new Scanner(System.in);
        System.out.println("entrer le nombre de termes voulus dans ls séquence : ");
        int nbChiffres = scan.nextInt();
        switch (tache) {

            case 1:
                System.out.println("Sequence Fibonacci calculée pour " + nbChiffres + " chiffres avec l'utilisation d'une boucle : ");
                int[] sequenceBoucle = Fibonacci_Sequence.fibonacciBoucle(nbChiffres);
                Fibonacci_Sequence.afficherSequence(sequenceBoucle);
                Fibonacci_Sequence.pauseToContinue(scan);
                scan.nextLine();
                System.out.println("\n");
                break;

            case 2:
                System.out.println("Séquence Fibonacci calculée pour " + nbChiffres + " chiffres avec la méthode recursive : ");
                int[] sequenceRecursive = Fibonacci_Sequence.fibonacciMethodeRecursive(nbChiffres);
                Fibonacci_Sequence.afficherSequence(sequenceRecursive);
                System.out.println("\n");
                Fibonacci_Sequence.pauseToContinue(scan);
                scan.nextLine();
                break;

            case 3:
                System.out.println("Résultat de la comparaison des temps d'execution de chaque méthode pour le nombre " + nbChiffres + " de chiffres ");
                Fibonacci_Sequence.calculTempsExecution(nbChiffres);
                System.out.println("\n");
                Fibonacci_Sequence.pauseToContinue(scan);
                scan.nextLine();
                break;

            default:
                System.out.println("Valeur invalide entrée");
                break;
        }
    }
}
