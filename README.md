
## Starbucks Locator
  
Codé par :   
 - Martin Caron
 - Axelle Arnaud (surtout elle)

## Description  
  
Nous avons utilisé les données d'[OpenData](https://data.opendatasoft.com/explore/dataset/all-starbucks-locations-in-the-world%40public-us/table/)
  
## Librairies externes  
  
- GMS (Maps)
- Retrofit (Pour aller chercher la liste des starbucks depuis l'API mentionnée ci-dessus)
- Room (Pour la BDD)

##Fonctionnement général de l'app

- L'application se présente sous la forme d'une activité gérant 3 **fragments**:
	- *Liste des Starbucks* : Vous avez accès à tous les starbucks possibles depuis la liste donnée par notre API. Vous avez accès aux détails du starbucks considéré. Cliquer sur le bouton détail lancera une nouvelle **activité** qui affiche au hazard une image de Starbucks parmi un pool de 10 images disponibles, ainsi que les informations du Starbucks considéré
	- *Maps* : Vous pouvez voir où sont tous les starbucks dans notre liste, directement sur une carte 
	- *Détails de l'application* : Vous pouvez directement nous envoyer un feedback, nos addresses emails sont enregistrées ;)
- L'application peut être utilisée hors connexion grâce à sa base de données. Cette base de données est rafraichie à chaque ouverture de l'app, et peut l'être de même lors de l'appui sur le bouton dédié dans le menu (en haut à droite de l'application)
  
## Consignes  
  
[Sujet](https://docs.google.com/presentation/d/1mwu2xx7_qfCZDfsRxseC94n7oBGYfhw-9xIftaTDbzk/edit#slide=id.p97)  
  
### But du projet  
  
 - Le but du projet est de réaliser une application permettant de visualiser une série de données OpenData  
 - Les données devront être récupérées sur un serveur distant et affichées dans une liste et sur une carte  
 - Un clique sur un élément de la liste ou sur un marker de la carte permet d’accéder à un écran présentant le détail de l’élément  
 - Un écran présentera des informations générales sur les données récupérées  
  
### Exigences    
- [ ] Format des données OpenData :   
	 - Format Json  
	 - Avec un champ correspondant à l’url d’une image  
	 - Avec un champ correspondant à une position  
 - [ ] Application composée au minimum de 3 Fragment et 2 Activity  
 - [ ] Une Actionbar sera présente et permettra de rafraîchir les données récupérées et affichées
 
 ### Bonus
 
 - Amélioration de l’expérience utilisateur :
    - Clustering des markers sur la carte en fonction du niveau de zoom
    - Mise en place d’un système de recherche/filtre sur la liste affichée
 
 - Enrichissements techniques :
    - Mise en place d’une base de données locale pour afficher la liste d’élément en mode hors connexion
    - Utilisation de LiveData ou d’Observable pour la récupération de données dans la BDD
 
