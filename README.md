
# Starbucks Locator
  
Coded by :   
 - Martin Caron
 - Axelle Arnaud

## Bird's eye overview

- Our app acts as a Starbucks locator. From a distant server, via an API, it fetches, saves et displays the starbucks available through the API
- We used the [OpenData data](https://data.opendatasoft.com/explore/dataset/all-starbucks-locations-in-the-world%40public-us/table/)

## Fonctionnement général de l'app

- L'application se présente sous la forme d'une **activité** principale gérant 3 **fragments**:
	- *Liste des Starbucks* : Vous avez accès à tous les starbucks possibles depuis la liste donnée par notre API. Vous avez accès aux détails du starbucks considéré. Cliquer sur le bouton détail lancera une nouvelle **activité** qui affiche au hazard une image de Starbucks parmi un pool de 10 images disponibles (en effet, notre API ne permettait pas de recevoir une image, seulement des données de localisation, etc...), ainsi que les informations du Starbucks considéré
	- *Maps* : Vous pouvez voir où sont tous les starbucks dans notre liste, directement sur une carte 
	- *Détails de l'application* : Vous pouvez directement nous envoyer un feedback, nos adresses emails sont enregistrées ;)
- Le menu en haut à droite de l'applicaiton possède un mécanisme de rafraichissement de la base de données. Ces données sont cherchées sur l'API opendata mentionnée ci-dessus. Ces données sont récupérées sous la forme d'un fichier JSON. Sont récupérées les informations de la ville, adresse et position (latitude, longitude). 
- L'application peut être utilisée hors connexion grâce à sa base de données. Cette base de données est rafraichie à chaque ouverture de l'app, et peut l'être de même lors de l'appui sur le bouton dédié dans le menu (en haut à droite de l'application)

## External Librairies/Dependencies  
  
- GMS (Maps)
- Retrofit (Fetches the Starbucks data form the API)
- Room (Database Management)
  
## Project Recquirements
  
[Recquirements](https://docs.google.com/presentation/d/1mwu2xx7_qfCZDfsRxseC94n7oBGYfhw-9xIftaTDbzk/edit#slide=id.p97)  
  
### Purpose of the project  
  
 - The goal of the project is to create an application to visualize a series of OpenData data
 - The data will have to be retrieved from a remote server and displayed in a list and on a map  
 - Clicking on an item in the list or on a marker on the map gives access to a screen showing the details of the item
 - A screen will present general information about the recovered data
  
### Bird's eye overview of the recquirements    
- [ ] OpenData data format :   
	 - Json Format  
	 - Field matching the url an image URL
	 - Field matching a position  
 - [ ] 3 fragments and 2 activities minimum app
 - [ ] Actionbar at the top of the app with data refreshment feature 
 
 ### Bonus
 
 - Improved user experience:
    - Clustering of markers on the map according to the zoom level
    - Setting up a search/filter system on the displayed list
 
 - Technical improvment:
    - Setting up a local database to display the item list in offline mode
    - Using LiveData or Observable for data recovery in the database
 
