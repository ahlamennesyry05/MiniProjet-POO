

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.io.PrintStream;

public class InterfaceReseau extends JFrame {

    private JTextField champMessage;
    private JTextArea zoneAffichage;
    private JButton boutonEnvoyer;
    private JComboBox<String> choixBavard;

    private Bavard alice;
    private Bavard bob;
    private Bavard clara;
    private Bavard david;

    public InterfaceReseau() {

        setTitle("Reseau de Bavards");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        champMessage = new JTextField();
        boutonEnvoyer = new JButton("Envoyer");
        zoneAffichage = new JTextArea();
        zoneAffichage.setEditable(false);

        choixBavard = new JComboBox<>();
        choixBavard.addItem("Alice");
        choixBavard.addItem("Bob");
        choixBavard.addItem("Clara");
        choixBavard.addItem("David");

        JPanel haut = new JPanel(new BorderLayout());
        haut.add(choixBavard, BorderLayout.WEST);
        haut.add(champMessage, BorderLayout.CENTER);
        haut.add(boutonEnvoyer, BorderLayout.EAST);

        add(haut, BorderLayout.NORTH);
        add(new JScrollPane(zoneAffichage), BorderLayout.CENTER);

        PrintStream printStream = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                zoneAffichage.append(String.valueOf((char) b));
            }
        });

        System.setOut(printStream);

        alice = new Bavard("Alice", "positif");
        bob = new Bavard("Bob", "neutre");
        clara = new Bavard("Clara", "negatif");
        david = new Bavard("David", "positif");

        alice.ajouterAmi(bob);
        bob.ajouterAmi(clara);
        clara.ajouterAmi(alice);
        clara.ajouterAmi(david);

        boutonEnvoyer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = champMessage.getText();

                if (!message.isEmpty()) {
                    String bavardChoisi = (String) choixBavard.getSelectedItem();

                    if (bavardChoisi.equals("Alice")) {
                        alice.envoyerMessage(message);
                    } else if (bavardChoisi.equals("Bob")) {
                        bob.envoyerMessage(message);
                    } else if (bavardChoisi.equals("Clara")) {
                        clara.envoyerMessage(message);
                    } else if (bavardChoisi.equals("David")) {
                        david.envoyerMessage(message);
                    }

                    champMessage.setText("");
                    System.out.println();
                }
            }
        });
    }

    public static void main(String[] args) {
        InterfaceReseau fenetre = new InterfaceReseau();
        fenetre.setVisible(true);
    }
}
