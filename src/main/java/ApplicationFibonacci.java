import java.util.Scanner;

public class ApplicationFibonacci {

    public static void main(String[] args) {

     //Affiche un menu en boucle avec les options demandeés

         while (true) {
            Scanner scan = new Scanner(System.in);
            int tache = choixMenu();
            if (tache == 4) {
                System.out.println("Fin, merci d'avoir utilisé notre programme");
                break;
            }
            calculSequenceFibonacci(tache);
        }
    }

    /**
     * @retourne un entier qui est le choix de l'utilisateur
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
                System.out.println("Résultat de la comparaison des temps d'execution de chaque méthode pour le nombre " + nbChiffres + " de chiffres ");
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
     * @param nbChiffres le nombre de termes dans la séquence Fibonacci
     * @return un tableau d'entiers, la suite Fibonacci
     */

    public static int[] fibonacciBoucle(int nbChiffres) {

        int[] sequenceBoucle = new int[nbChiffres]; //index n+1 chiffres
        sequenceBoucle[0] = 0;
        sequenceBoucle[1] = 1;
        for (int i = 2; i <nbChiffres; i++) { //va justque 9
            sequenceBoucle[i] = sequenceBoucle[i - 1] + sequenceBoucle[i - 2];
        }
        return sequenceBoucle;
    }

    /**Calcule et retourne les chiffres de la séquence Fibonacci de maniere récursve
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

    /**affiche les chiffres d'une séquance d'entiers
     * @param sequence représente le tableau d'entiers à afficher
     */
    //Méthode pour afficher les séquences
    public static void afficherSequence(int[] sequence) {
        for (int i = 0;i < sequence.length;i++) {
        System.out.print(sequence[i]+ " ");
        }
      }

    /** Calcul du temps d'execution en nanosecondes pour chaque méthode
     * @param nbChiffres : le nombre de termes pour lequel la vitesse de temps d'exécution de la séquence est calculée
     */

     //Méthode pour calculer lde temps d'éxecution pour chaque méthode (boucle ou récursif et comparer les résulats.)

    public static void calculTempsExecution(int nbChiffres) {
        System.out.println("Temps d'execution pour la mméthode avec boucle pour " + nbChiffres + " chiffres :");
        long startTime = System.nanoTime();
        fibonacciBoucle(nbChiffres);
        long endTime = System.nanoTime();
        long tempsExec = endTime - startTime;
        System.out.println("le temps d'execution pour la méthode boucle est de :\n " + tempsExec);

        System.out.println("----------------------------------------------------------------------------------------");

        long startTime1 = System.nanoTime();
        fibonacciMethodeRecursive(nbChiffres);
        long endTime1 = System.nanoTime();
        long tempsExec1 = endTime1 - startTime1;
        System.out.println("Temps d'execution avec la méthode récursive pour " + nbChiffres + " chiffres : ");
        System.out.println(tempsExec1);
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