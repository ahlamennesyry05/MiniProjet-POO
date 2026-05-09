public class MessageEvent {

    private String message;
    private Bavard auteur;
    private static int compteur = 0;
    private int id;
    private int bienveillance;

    public MessageEvent(String message, Bavard auteur) {
        this.id = compteur;
        compteur++;

        this.message = message;
        this.auteur = auteur;
        this.bienveillance = 0;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public int getBienveillance() {
        return bienveillance;
    }

    public void setBienveillance(int bienveillance) {
        this.bienveillance = bienveillance;
    }
}
