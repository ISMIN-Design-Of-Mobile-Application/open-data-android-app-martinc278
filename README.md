
# Starbucks Locator
  
Coded by :   
 - Martin Caron
 - Axelle Arnaud

## Bird's eye overview

- Our app acts as a Starbucks locator. From a distant server, via an API, it fetches, saves et displays the starbucks available through the API
- We used the [OpenData data](https://data.opendatasoft.com/explore/dataset/all-starbucks-locations-in-the-world%40public-us/table/)

## App overview

- This app feature two **activites** and 3 **fragments**
	- *Starbucks List*: List all the Starbucks stores that were fetched from the Opendata API. Details are provided for every Starbucks Store, through the launch of a new **activity** which displays the information of the selected Starbucks Store and randomly displays an Starbucks Store image from a pool of ten presaved images (our API did not have any image to fetch).
	- *Maps*: Look at all the starbucks, straight from a map
	- *App Details*: Please send us a feedback on how you like the app, email addresses are already set ;)
	
- Action bar: features a database refreshment mecanism. The data is fetched to a distant server using the Opendata API. The received data is coded through a JSON format. Raw data includes location (longtide, latitude), city and address.
- App can be used offline, thanks to a database that saves the Starbucks data. The database is refreshed on app opening, provided the device has got access to the Internet. The databse can also be refreshed manually through a dedicated button in the action bar. 

***Disclaimer*** : The app features a limited amount of Strabucks Stores. It comes from the fact the API has only a limited number of those... Don't be surprised if you don't find your favorite Starbucks Store in Grenoble... ;) 

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
 
