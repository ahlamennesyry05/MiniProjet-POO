package projet;

public class Main {

    public static void main(String[] args) {

        Bavard alice = new Bavard("Alice", "positif");
        Bavard bob = new Bavard("Bob", "neutre");
        Bavard clara = new Bavard("Clara", "negatif");

        alice.ajouterAmi(bob);
        bob.ajouterAmi(clara);
        clara.ajouterAmi(alice);

        alice.envoyerMessage("Bonjour tout le monde !");
    }
}
