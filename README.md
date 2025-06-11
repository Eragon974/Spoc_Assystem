# Spoc_Assystem

Projet SPOC 4TC en collaboration avec l'entreprise Assystem.

## Description

Cette application Java permet de gérer une architecture électrique via une interface connectée à une base de données orientée graphe (OrientDB). L’objectif est de pouvoir extraire un bilan de puissance à partir des données saisies et stockées.

## Prérequis

- **Java** (version 17 ou ultérieure recommandée)
- **OrientDB Community Edition**

## Installation & Mise en route

1. **Cloner le repository**

```bash
git clone https://github.com/Eragon974/Spoc_Assystem.git
cd Spoc_Assystem
```

2. **Télécharger OrientDB Community Edition**

   - Téléchargez la dernière version d’OrientDB Community depuis : https://orientdb.com/download/
   - Extrayez le dossier, par exemple : `orientdb-community-<version>`

3. **Démarrer le serveur OrientDB**

   - Ouvrez le dossier `orientdb-community-<version>`
   - Lancez le fichier `server.bat` (Windows) ou `server.sh` (Linux/Mac)
   - Exemple sous Windows : double-cliquez sur `server.bat`
   - Laissez le serveur tourner pendant toute l’utilisation de l’application

4. **Configurer la connexion à la base de données**

   - Vérifiez que vos paramètres de connexion à OrientDB dans l’application Java sont corrects (fichier de configuration ou variables dans le code selon votre implémentation).
   - Par défaut, OrientDB tourne sur `localhost` et le port `2424`.

5. **Compiler et lancer l’application Java**

   1. Ouvrir le dossier Spoc_Assystem via VScode
   2. Depuis ce dossier ouvrir Assystem_App/src/main et compiler Interface_app.java

## Utilisation

1. Assurez-vous que OrientDB est bien lancé.
2. Lancez l’application Java.
3. Suivez les instructions de l’interface pour saisir et gérer les données électriques.
4. (A venir) Utilisez les fonctionnalités d’extraction de bilan de puissance selon vos besoins.

## Comment utiliser notre interface
1. Cliquer sur le bouton connexion et remplir les cases avec les informations correspondantes
2. Une fois la connexion réalisée vous devriez voir les composants et équipements de la base de données.
3. Sélectionner un composant ou équipement.
4. Cliquer sur un des boutons "Supprimer","Dupliquer" ou "Modifier".
5. Pour ajouter un composant, cliquer sur "Ajouter à la BDD".
6. Cliquez sur déconnexion pour mettre fin à la session.

## Remarques

- L’application requiert qu’OrientDB soit en fonctionnement pour pouvoir accéder ou modifier les données.
- Pour toute question ou problème, consultez la documentation OrientDB fournie ou ouvrez une issue sur ce repository.
