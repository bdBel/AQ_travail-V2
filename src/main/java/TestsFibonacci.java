public class TestsFibonacci {

    public static void main(String[] args) {

     //Affiche un menu en boucle avec les options demandeés

         while (true) {

            int tache = SequenceFibonacci.choixMenu();
            if (tache == 4) {
                System.out.println("Fin, merci d'avoir utilisé notre programme");
                break;
            }
             SequenceFibonacci.calculSequenceFibonacci(tache);
        }
    }
}
