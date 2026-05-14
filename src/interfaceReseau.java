package projet;

import javax.swing.*;
import java.awt.*;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class InterfaceReseau extends JFrame {

    private JTextField champMessage;
    private JTextField champNomBavard;
    private JTextArea zoneAffichage;

    private JButton boutonEnvoyer;
    private JButton boutonAjouterBavard;
    private JButton boutonAjouterAmi;

    private JComboBox<String> choixBavard;
    private JComboBox<String> choixPersonnalite;
    private JComboBox<String> choixSource;
    private JComboBox<String> choixAmi;

    private Map<String, Bavard> bavards;

    public InterfaceReseau() {
        setTitle("Reseau de Bavards");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        bavards = new HashMap<>();

        champMessage = new JTextField();
        champNomBavard = new JTextField(10);

        boutonEnvoyer = new JButton("Envoyer");
        boutonAjouterBavard = new JButton("Ajouter bavard");
        boutonAjouterAmi = new JButton("Ajouter ami");

        zoneAffichage = new JTextArea();
        zoneAffichage.setEditable(false);

        choixBavard = new JComboBox<>();
        choixPersonnalite = new JComboBox<>();
        choixPersonnalite.addItem("positif");
        choixPersonnalite.addItem("neutre");
        choixPersonnalite.addItem("negatif");

        choixSource = new JComboBox<>();
        choixAmi = new JComboBox<>();

        JPanel haut = new JPanel(new BorderLayout());
        haut.add(choixBavard, BorderLayout.WEST);
        haut.add(champMessage, BorderLayout.CENTER);
        haut.add(boutonEnvoyer, BorderLayout.EAST);

        JPanel bas = new JPanel();
        bas.add(new JLabel("Nom :"));
        bas.add(champNomBavard);
        bas.add(choixPersonnalite);
        bas.add(boutonAjouterBavard);
        bas.add(new JLabel("Source :"));
        bas.add(choixSource);
        bas.add(new JLabel("Ami :"));
        bas.add(choixAmi);
        bas.add(boutonAjouterAmi);

        add(haut, BorderLayout.NORTH);
        add(new JScrollPane(zoneAffichage), BorderLayout.CENTER);
        add(bas, BorderLayout.SOUTH);

        redirigerConsoleVersInterface();

        ajouterBavardInitial("Alice", "positif");
        ajouterBavardInitial("Bob", "neutre");
        ajouterBavardInitial("Clara", "negatif");
        ajouterBavardInitial("David", "positif");

        bavards.get("Alice").ajouterAmi(bavards.get("Bob"));
        bavards.get("Bob").ajouterAmi(bavards.get("Clara"));
        bavards.get("Clara").ajouterAmi(bavards.get("Alice"));
        bavards.get("Clara").ajouterAmi(bavards.get("David"));

        boutonEnvoyer.addActionListener(e -> {
            String message = champMessage.getText();
            String nomBavard = (String) choixBavard.getSelectedItem();

            if (!message.isEmpty() && nomBavard != null) {
                bavards.get(nomBavard).envoyerMessage(message);
                champMessage.setText("");
                System.out.println();
            }
        });

        boutonAjouterBavard.addActionListener(e -> {
            String nom = champNomBavard.getText();
            String personnalite = (String) choixPersonnalite.getSelectedItem();

            if (!nom.isEmpty() && !bavards.containsKey(nom)) {
                ajouterBavardInitial(nom, personnalite);
                champNomBavard.setText("");
                System.out.println("Bavard ajoute : " + nom + " (" + personnalite + ")");
            }
        });

        boutonAjouterAmi.addActionListener(e -> {
            String source = (String) choixSource.getSelectedItem();
            String ami = (String) choixAmi.getSelectedItem();

            if (source != null && ami != null && !source.equals(ami)) {
                bavards.get(source).ajouterAmi(bavards.get(ami));
                System.out.println(source + " ajoute " + ami + " comme ami");
            }
        });
    }

    private void ajouterBavardInitial(String nom, String personnalite) {
        Bavard bavard = new Bavard(nom, personnalite);
        bavards.put(nom, bavard);

        choixBavard.addItem(nom);
        choixSource.addItem(nom);
        choixAmi.addItem(nom);
    }

    private void redirigerConsoleVersInterface() {
        PrintStream printStream = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                zoneAffichage.append(String.valueOf((char) b));
            }
        });

        System.setOut(printStream);
    }

    public static void main(String[] args) {
        InterfaceReseau fenetre = new InterfaceReseau();
        fenetre.setVisible(true);
    }
}
