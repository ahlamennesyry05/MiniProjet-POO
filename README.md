# Projet Java - Système de Bavard

## Description

Ce projet consiste à implémenter un système de communication entre objets en Java, simulant un réseau de "bavards". Chaque bavard peut envoyer, recevoir et retransmettre des messages à ses amis, en respectant des règles de propagation.

Le projet repose sur les principes de la programmation orientée objet et utilise un modèle événementiel pour gérer la circulation des messages dans le réseau.

---

## Fonctionnalités

- Création d’un réseau de bavards interconnectés
- Envoi et réception de messages entre objets
- Propagation des messages dans le réseau d’amis
- Évitement des boucles infinies grâce à un identifiant unique par message
- Utilisation d’une copie du message à chaque transmission pour garantir l’indépendance des chemins de propagation
- Personnalité des bavards (positif, négatif, neutre) influençant :
  - la bienveillance du message
  - le contenu du message (majuscules/minuscules)
- Suivi du chemin du message (historique des bavards traversés)
- Comptage du nombre de transmissions
- Limitation de la propagation grâce à une profondeur maximale
- Utilisation d’une interface (`MessageListener`) pour standardiser la réception des messages
- Implémentation d’un modèle événementiel avec `MessageEvent` héritant de `EventObject`
- Interface graphique permettant :
  - l’envoi de messages
  - le choix du bavard émetteur
  - l’ajout dynamique de bavards
  - la création de relations d’amitié entre bavards

---

## Structure du projet

- **Bavard.java**  
  Gère les utilisateurs du réseau, leurs relations et la propagation des messages.

- **MessageEvent.java**  
  Représente un message avec ses caractéristiques (identifiant, contenu, bienveillance, chemin, etc.) et implémente un mécanisme de copie.

- **MessageListener.java**  
  Interface définissant la méthode de réception des messages.

- **Main.java**  
  Permet de tester le fonctionnement du système en console.

- **InterfaceReseau.java**  
  Fournit une interface graphique pour interagir avec le réseau de bavards de manière dynamique.

---

## Lancement

1. Compiler le projet
2. Exécuter :
   - `Main.java` pour un test en console
   - `InterfaceReseau.java` pour utiliser l’interface graphique

---

## Exemple d'exécution

Alice envoie : Bonjour tout le monde !
Bob recoit : Bonjour tout le monde ! | personnalite : neutre | bienveillance : 0 | chemin : Alice -> Bob | transmissions : 1
Clara recoit : bonjour tout le monde ! | personnalite : negatif | bienveillance : -1 | chemin : Alice -> Bob -> Clara | transmissions : 2
Alice recoit : BONJOUR TOUT LE MONDE ! | personnalite : positif | bienveillance : 0 | chemin : Alice -> Bob -> Clara -> Alice | transmissions : 3


Cet exemple illustre la propagation du message, sa modification en fonction des personnalités, ainsi que le mécanisme d’évitement des boucles infinies.

---

## Capture d'écran

Exemple de l’interface graphique du projet :

<img width="1919" height="956" alt="image" src="https://github.com/user-attachments/assets/f29631d9-33bb-4b4a-815d-879b887c2625" />


---

## Auteur

Ahlam Ennesyry — Étudiante en école d'ingénieurs
