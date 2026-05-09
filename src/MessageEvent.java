
public class MessageEvent {

    private static int compteurId = 0;

    private int id;
    private String message;
    private Bavard auteur;
    private int bienveillance;
    private String chemin;
    private int compteurTransmissions;
    private int profondeur;
    private int profondeurMax;

    public MessageEvent(String message, Bavard auteur, int profondeurMax) {
        this.id = compteurId;
        compteurId++;

        this.message = message;
        this.auteur = auteur;
        this.bienveillance = 0;
        this.chemin = auteur.getNom();
        this.compteurTransmissions = 0;
        this.profondeur = 0;
        this.profondeurMax = profondeurMax;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Bavard getAuteur() {
        return auteur;
    }

    public int getBienveillance() {
        return bienveillance;
    }

    public void setBienveillance(int bienveillance) {
        this.bienveillance = bienveillance;
    }

    public String getChemin() {
        return chemin;
    }

    public void ajouterAuChemin(String nomBavard) {
        chemin = chemin + " -> " + nomBavard;
    }

    public int getCompteurTransmissions() {
        return compteurTransmissions;
    }

    public void incrementerTransmission() {
        compteurTransmissions++;
    }

    public boolean peutEncoreSePropager() {
        return profondeur < profondeurMax;
    }

    public void augmenterProfondeur() {
        profondeur++;
    }
}
