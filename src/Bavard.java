import java.util.ArrayList;
import java.util.List;

public class Bavard implements MessageListener {

    private String nom;
    private List<Bavard> amis;
    private List<Integer> messagesRecus;
    private String personnalite;

    public Bavard(String nom, String personnalite) {
        this.nom = nom;
        this.personnalite = personnalite;
        this.amis = new ArrayList<>();
        this.messagesRecus = new ArrayList<>();
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
        if (messagesRecus.contains(event.getId())) {
            return;
        }

        messagesRecus.add(event.getId());

        if (personnalite.equals("positif")) {
            System.out.println(nom + " 😊 reçoit : " + event.getMessage());
        } else if (personnalite.equals("negatif")) {
            System.out.println(nom + " 😠 reçoit : " + event.getMessage());
        } else {
            System.out.println(nom + " 😐 reçoit : " + event.getMessage());
        }

        for (Bavard ami : amis) {
            ami.recevoirMessage(event);
        }
    }
}
