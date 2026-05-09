import java.util.ArrayList;
import java.util.List;

public class Bavard implements MessageListener {

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
        MessageEvent event = new MessageEvent(message, this);

        System.out.println(nom + " envoie : " + message);

        for (Bavard ami : amis) {
            ami.recevoirMessage(event);
        }
    }

    public void recevoirMessage(MessageEvent event) {
        System.out.println(nom + " reçoit : " + event.getMessage());
    }
}
