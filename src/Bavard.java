import java.util.ArrayList;
import java.util.List;

public class Bavard {

    private String nom;
    private List<Bavard> amis;

    public Bavard(String nom) {
        this.nom = nom;
        this.amis = new ArrayList<>();
    }

    public void ajouterAmi(Bavard b) {
        amis.add(b);
    }

    public void envoyerMessage(String message) {
        System.out.println(nom + " envoie : " + message);
        for (Bavard ami : amis) {
            ami.recevoirMessage(message);
        }
    }

    public void recevoirMessage(String message) {
        System.out.println(nom + " reçoit : " + message);
    }
}
