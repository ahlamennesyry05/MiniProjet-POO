# Projet Java - Système de Bavard

## Description

Ce projet simule un réseau de communication entre plusieurs "bavards".
Chaque bavard peut envoyer et recevoir des messages.

Le système utilise la programmation orientée objet avec :
- des événements (MessageEvent)
- une interface (MessageListener)
- une propagation des messages entre les bavards

## Fonctionnalités

- Envoi et réception de messages entre bavards
- Propagation du message dans le réseau
- Évitement des boucles infinies grâce à un identifiant unique
- Personnalité des bavards : positif, négatif, neutre
- Modification du message selon la personnalité (bienveillance et transformation du texte)
- Affichage du chemin du message
- Compteur de transmissions
- Limitation de la propagation du message
- Interface graphique simple pour envoyer et afficher les messages
- Choix du bavard depuis l’interface graphique

## Structure du projet

- Bavard.java : gestion des bavards et communication
- MessageEvent.java : représentation du message (id, bienveillance, chemin, etc.)
- MessageListener.java : interface de réception des messages
- Main.java : test du programme en console
- InterfaceReseau.java : interface graphique

## Lancement

1. Compiler le projet
2. Exécuter :
   - `Main.java` pour test en console
   - `InterfaceReseau.java` pour interface graphique

## Exemple d'exécution

Alice envoie : Bonjour  
Bob recoit : Bonjour | personnalite : neutre | bienveillance : 0 | chemin : Alice -> Bob  
Clara recoit : bonjour | personnalite : negatif | bienveillance : -1 | chemin : Alice -> Bob -> Clara  
Alice recoit : BONJOUR | personnalite : positif | bienveillance : 0 | chemin : Alice -> Bob -> Clara -> Alice  

Cet exemple montre la propagation du message, sa modification selon la personnalité, et l’évitement des boucles infinies.

## Capture d'écran

Exemple de l’interface graphique du projet :

<img width="1919" height="943" alt="image" src="https://github.com/user-attachments/assets/7e21dd72-a45b-473f-85c0-b2d9901c9794" />


## Auteur

Projet réalisé dans le cadre d’un mini-projet en programmation orientée objet.
