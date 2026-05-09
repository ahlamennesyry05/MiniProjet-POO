public class Main {

    public static void main(String[] args) {

        Bavard alice = new Bavard("Alice", "positif");
        Bavard bob = new Bavard("Bob", "neutre");
        Bavard clara = new Bavard("Clara", "negatif");
        Bavard david = new Bavard("David", "positif");

        alice.ajouterAmi(bob);
        bob.ajouterAmi(clara);
        clara.ajouterAmi(alice);
        clara.ajouterAmi(david);

        alice.envoyerMessage("Bonjour tout le monde !");
    }
}
