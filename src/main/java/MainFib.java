public class MainFib {
    public static void main(String[] args) {

     //Affiche un menu en boucle avec les options demandeés

         while (true) {

            int tache = Fibonacci_Sequence.choixMenu();
            if (tache == 4) {
                System.out.println("Fin, merci d'avoir utilisé notre programme");
                break;
            }
             Fibonacci_Sequence.calculSequenceFibonacci(tache);
        }
    }
}
