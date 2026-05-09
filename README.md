# Projet Java - Système de Bavard

## Description

Ce projet simule un réseau de communication entre plusieurs "bavards".
Chaque bavard peut envoyer et recevoir des messages.

Le système utilise la programmation orientée objet avec :
- des événements (MessageEvent)
- une interface (MessageListener)
- une propagation des messages entre les bavards

## Fonctionnalités

- Envoi de messages entre bavards
- Réception de messages
- Transmission du message dans le réseau
- Évitement des boucles infinies grâce à un identifiant unique
- Personnalité des bavards (positif, négatif, neutre)
- Modification du message selon la personnalité (bienveillance)

## Structure du projet

- Bavard.java : gestion des utilisateurs et communication
- MessageEvent.java : représentation du message avec identifiant
- MessageListener.java : interface de réception
- Main.java : test du programme

## Lancement

1. Compiler le projet
2. Exécuter la classe Main

## Auteur

Projet réalisé dans le cadre d'un mini-projet en programmation orientée objet.
## Exemple d'exécution

Alice envoie : Bonjour tout le monde !
Bob 😐 reçoit : Bonjour tout le monde !
Clara 😠 reçoit : Bonjour tout le monde !
Alice 😊 reçoit : Bonjour tout le monde !

Cet exemple montre que le message se propage dans le réseau et que la boucle infinie est évitée.
## Capture d'écran
<img width="1919" height="956" alt="image" src="https://github.com/user-attachments/assets/368bcc0b-c500-4a81-ada4-bd9c3072f055" />
