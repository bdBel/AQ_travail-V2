import java.util.InputMismatchException;
import java.util.Scanner;

public class SequenceFibonacci{

    /**
     * @return
     */
    //méthode pour retourner la tâche choisie
    public static int choixMenu() {
        Scanner scan = new Scanner(System.in);
        int tache = -1;
        while (tache < 1 || tache > 4) {
            try {
                System.out.println("Calculs de la séquence Fibonacci et tests de la vitesse d'exécution : \n");
                System.out.println("Menu\n");
                System.out.println("1. Calcul de la séquence Fibonacci avec une boucle");
                System.out.println("2. Calcul de la séquence Fibonacci avec la méthode récursive");
                System.out.println("3. Calcul du Temps d'exécution avec chaque méthode");
                System.out.println("4. Quitter\n ");
                System.out.println("Faites votre choix.");
                tache = scan.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entre 1 et 4.");
                scan.next(); // Retire l'entrée invalide
            }
        }
        return tache;
    }

//methode switch pour executer la tâche choisie

    public static void calculSequenceFibonacci(int tache) {
        Scanner scan = new Scanner(System.in);
        int nbChiffres = -1;
        while (nbChiffres < 0) {
            try {
                System.out.println("Entrer le nombre de termes voulus dans la séquence : ");
                nbChiffres = scan.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier positif.");
                scan.next(); // Retire l'entrée invalide
            }
        }

        switch (tache) {

            case 1:
                System.out.println("Sequence Fibonacci calculée pour " + nbChiffres + " chiffres avec l'utilisation d'une boucle : ");
                int[] sequenceBoucle = fibonacciBoucle(nbChiffres);
                afficherSequence(sequenceBoucle);
                pauseToContinue(scan);
                scan.nextLine();
                System.out.println("\n");
                break;

            case 2:
                System.out.println("Séquence Fibonacci calculée pour " + nbChiffres + " chiffres avec la méthode recursive : ");
                int[] sequenceRecursive = fibonacciMethodeRecursive(nbChiffres);
                afficherSequence(sequenceRecursive);
                System.out.println("\n");
                pauseToContinue(scan);
                scan.nextLine();
                break;

            case 3:
                System.out.println("Résultat de la comparaison des temps d'execution de chaque méthode pour le nombre " + nbChiffres);
                calculTempsExecution(nbChiffres);
                System.out.println("\n");
                pauseToContinue(scan);
                scan.nextLine();
                break;

            default:
                System.out.println("Valeur invalide entrée");
                break;
        }
    }

    /**
     * @param nbChiffres
     * @return
     */

    public static int[] fibonacciBoucle(int nbChiffres) {

        int[] sequenceBoucle = new int[nbChiffres]; //index n+1 chiffres
        sequenceBoucle[0] = 0;
        sequenceBoucle[1] = 1;
        for (int i = 2; i < nbChiffres; i++) { //va justque 9
            sequenceBoucle[i] = sequenceBoucle[i - 1] + sequenceBoucle[i - 2];
        }
        return sequenceBoucle;
    }

    /**
     * Calcule et retourne les chiffres de la séquence Fibonacci de maniere récursve
     *
     * @param nbChiffres,indique le nombre de chiffres à générer
     * @return : retourne un tableau d'entiers qui contient les chiffres de la séquence Fibonacci calculée
     */
//Les méthodes pour calculer la séquence Fibonacci
    public static int[] fibonacciMethodeRecursive(int nbChiffres) {
        int[] sequence = new int[nbChiffres]; // Create an array to store the sequence
        for (int i = 0; i < nbChiffres; i++) {
            sequence[i] = getFiboRecursif(i);
        }
        return sequence;
    }

    public static int getFiboRecursif(int nbChiffres) {
        if (nbChiffres == 0) {
            return 0;
        } else if (nbChiffres == 1) {
            return 1;
        } else {
            return getFiboRecursif(nbChiffres - 1) + getFiboRecursif(nbChiffres - 2);
        }
    }

    /**
     * affiche les chiffres d'une séquance d'entiers
     *
     * @param sequence représente le tableau d'entiers à afficher
     */
//Méthode pour afficher les séquences
    public static void afficherSequence(int[] sequence) {
        for (int i = 0; i < sequence.length; i++) {
            System.out.print(sequence[i] + " ");
        }
    }

    /**
     * Calcul du temps d'execution en nanosecondes pour chaque méthode
     *
     * @param nbChiffres : le nombre de termes pour lequel la vitesse de temps d'exécution de la séquence est calculée
     */

//Méthode pour calculer lde temps d'éxecution pour chaque méthode (boucle ou récursif et comparer les résulats.)
    public static void calculTempsExecution(int nbChiffres) {
        long startTime = System.nanoTime();
        fibonacciBoucle(nbChiffres);
        long endTime = System.nanoTime();
        long tempsExec = endTime - startTime;
        System.out.println("le temps d'execution pour le nombre " + nbChiffres + " avec la méthode BOUCLE est de :\n " + tempsExec + " nanosecondes.");

        System.out.println("----------------------------------------------------------------------------------------");

        long startTime1 = System.nanoTime();
        fibonacciMethodeRecursive(nbChiffres);
        long endTime1 = System.nanoTime();
        long tempsExec1 = endTime1 - startTime1;
        System.out.println("le temps d'execution pour le nombre " + nbChiffres + " avec la méthode RÉCURSIVE est de :\n " + tempsExec1 + " nanosecondes.");
        if (tempsExec - tempsExec1 > 0) {
            System.out.println("Meilleure performance pour la méthode récursive ! ");
        } else {
            System.out.println("Meilleure performance pour la méthode en boucle ! ");
        }
    }

    /* Affiche un message indiquant à  l'utilisateur d'appuyer sur Entrée
     * pour Continuer
     * @param scan: Le scanner permet de lire le choix utilisateur.
     */

//faire une pausse après l'affichage du résultat

    public static void pauseToContinue(Scanner scan) {
        System.out.println("\nAppuyez sur Entrée pour continuer...");
        scan.nextLine(); // Wait for Enter key press
    }
}

