package projet;

import java.util.ArrayList;
import java.util.List;

public class Bavard implements MessageListener {

    private String nom;
    private String personnalite;
    private List<Bavard> amis;
    private List<Integer> messagesRecus;

    public Bavard(String nom, String personnalite) {
        this.nom = nom;
        this.personnalite = personnalite;
        this.amis = new ArrayList<>();
        this.messagesRecus = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void ajouterAmi(Bavard b) {
        amis.add(b);
    }

    public void envoyerMessage(String message) {
        MessageEvent event = new MessageEvent(message, this, 5);

        System.out.println(nom + " envoie : " + message);

        for (Bavard ami : amis) {
            MessageEvent copie = event.copie();
            copie.incrementerTransmission();
            ami.recevoirMessage(copie);
        }
    }

    public void recevoirMessage(MessageEvent event) {
        if (messagesRecus.contains(event.getId())) {
            return;
        }

        messagesRecus.add(event.getId());
        event.ajouterAuChemin(nom);

        if (personnalite.equals("positif")) {
            event.setBienveillance(event.getBienveillance() + 1);
            event.setMessage(event.getMessage().toUpperCase());
        } else if (personnalite.equals("negatif")) {
            event.setBienveillance(event.getBienveillance() - 1);
            event.setMessage(event.getMessage().toLowerCase());
        }

        System.out.println(nom + " recoit : " + event.getMessage()
                + " | personnalite : " + personnalite
                + " | bienveillance : " + event.getBienveillance()
                + " | chemin : " + event.getChemin()
                + " | transmissions : " + event.getCompteurTransmissions());

        if (event.peutEncoreSePropager()) {
            event.augmenterProfondeur();

            for (Bavard ami : amis) {
                MessageEvent copie = event.copie();
                copie.incrementerTransmission();
                ami.recevoirMessage(copie);
            }
        }
    }
}
