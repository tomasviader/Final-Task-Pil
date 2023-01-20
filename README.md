"# Final-Task-Pil"

## *Statement*
An important commune of our province requests the realization of an application to facilitate the administration of its recycling centers with the participation of the community in general. The main idea is precisely to decentralize the places where one throws the garbage separated by type. A study carried out by ACME suggests that the co-participation of both the state and the general public in terms of the previous treatment of garbage will make it possible to raise awareness among citizens and reduce the amount of waste that is disposed of. It will also have a direct impact on the environment and on the cost of waste treatment.

## *CLEAN CITY*

***ZONE CONTROLLER***

**-Create Zone**
POST **http://localhost:8080/zones**

Body:

    {
      "name": "Plaza Colon",
      "street":"Avenida Colon",
      "number":1000,
      "latitude":-31.4085704,
      "longitude":-64.1981353,
      "neighborhood":"Alberdi",
      "status": true,
      "capacity": "EMPTY" 
    } 

**-Create Zone 2**
POST **http://localhost:8080/zones**

Body:

    {
    "name": "Plaza España",
    "street":"Avenida Irigoyen",
    "number":1000,
    "latitude":-31.4290925,
    "longitude":-64.18715,
    "neighborhood":"Alberdi",
    "status": true,
    "capacity": "HALFFULL"
    }

**-Modify Zone Information**
PUT **http://localhost:8080/zones/1**

Body:

    {
     "latitude":55.47920,
     "longitude":37.32733
    }

**-Get Zones**
GET **http://localhost:8080/zones**

**-Get a Zone by Id**
GET **http://localhost:8080/zones/1**

**-Get a Zone by Neighborhood**
GET **http://localhost:8080/zones/neighborhood/Alberdi**

**-Get Distance Between Zones By Id**
GET **http://localhost:8080/zones/distance/1-2**

**-Get Fastest Zone to fill by ID**
GET **http://localhost:8080/zones/fastest/1-2**

**-Delete Zone**
DELETE **http://localhost:8080/zones/1**

***REPORT CONTROLLER***

**-Create Report**
POST **http://localhost:8080/reports**

Body:

    { 
    "supervisorId": 1,
    "zoneId": 1,
    "capacity":"FULL",
    "needResorting" : true,
    "zoneState": "INACCESSIBLE",
    "complaint": "VANDALISM"
    } 


**-Modify Report**
PUT **http://localhost:8080/reports/1**

Body:

    { 
    "complaint":"UNUSED_AREA"
    }

**-Get Reports**
GET **http://localhost:8080/reports**

**-Get a Report by Id**
GET **http://localhost:8080/reports/1**

**-Delete Report**
DELETE **http://localhost:8080/reports/1**

***RECIPE CONTROLLER***

**-Create Recipe**  
POST **http://localhost:8080/recipes**

Body:

    {
    "recipeName":"Origami",
    "material" : "paper",
    "steps": "Smooth paper, fold in half, etc."
    }

**-Get Recipes**
GET **http://localhost:8080/recipe**

**-Get a Recipe by Id**
GET **http://localhost:8080/recipe/1**

**-Get a Recipe by Material**
GET **http://localhost:8080/recipe/material/paper**

**-Delete Recipe**
DELETE **http://localhost:8080/recipe/1**

***SUPERVISOR CONTROLLER***

**-Create Supervisor**  
POST **http://localhost:8080/supervisors**

Body:

    {
    "supervisorName" : "Lautaro"
    }


**-Modify Supervisor**
PUT **http://localhost:8080/supervisors/1**

Body:


    { 
    "supervisorName" : "Tomas"
    }


**-Get Supervisors**
GET **http://localhost:8080/supervisors**

**-Get a Supervisor by Id**
GET **http://localhost:8080/supervisors/1**

**-Delete Supervisor**
DELETE **http://localhost:8080/supervisors/1**
