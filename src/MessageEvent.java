public class MessageEvent {

    private String message;
    private Bavard auteur;
    private static int compteur = 0;
    private int id;

    public MessageEvent(String message, Bavard auteur) {
         this.id = compteur;
         compteur++;

        this.message = message;
        this.auteur = auteur;

    }
}
