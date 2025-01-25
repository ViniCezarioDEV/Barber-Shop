
# Barber Shop 
This simple project, simule a barber shop system.


## Table of contents  
- [Database Phase](#database)  
    - [Database concept model](#modelDB)
    - [Database SQL file](#DBSQL)
- [Backend Phase](#backend)
    - [Model Java Classes](#bem)
    - [Schedule](#besp)
    - [Security](#bes)
- [Frontend Phase](#frontend)
    - [Test Index file](#fetf)


<h2 id="database">Database Phase</h2>  

<h3 id="modelDB">Creating the concept model for database</h3>

On this phase, I created a conceptional model for database using [DRAW.IO](https://draw.io/). And you can see this model on image below.

![database model png](Database/DB_Design.png)


<h3 id="DBSQL">Creating the SQL file</h3>

At this phase, I created the SQL file, using the concept model as a basis to create the database.

- [Click here to see SQL file](https://github.com/ViniCezarioDEV/Barber-Shop/blob/main/Database/Database.sql)


<h2 id="backend">Backend Phase</h2>

<h3 id="bem">Models Java classes</h3>

At this phase, I created all (for now) necessary Java classes for models.
    
- [Click here to see all Model Java Classes](https://github.com/ViniCezarioDEV/Barber-Shop/tree/main/Backend/barbershop/src/main/java/solutionscorp/barbershop/Models)

<h3 id="besp">Schedule</h3>

At this phase, I created and adjust Model, Controller, Repository, Service and DTO files of Schedule.

- [Schedule Model file](https://github.com/ViniCezarioDEV/Barber-Shop/blob/main/Backend/barbershop/src/main/java/solutionscorp/barbershop/Models/Schedule.java)
- [Schedule Controller file](https://github.com/ViniCezarioDEV/Barber-Shop/blob/main/Backend/barbershop/src/main/java/solutionscorp/barbershop/Controllers/ScheduleController.java)
- [Schedule Repository file](https://github.com/ViniCezarioDEV/Barber-Shop/blob/main/Backend/barbershop/src/main/java/solutionscorp/barbershop/Repository/ScheduleRepository.java)
- [Schedule Service file](https://github.com/ViniCezarioDEV/Barber-Shop/blob/main/Backend/barbershop/src/main/java/solutionscorp/barbershop/Services/ScheduleService.java)
- [Schedule DTO file](https://github.com/ViniCezarioDEV/Barber-Shop/blob/main/Backend/barbershop/src/main/java/solutionscorp/barbershop/DTO/ScheduleDTO.java)

<h3 id="bes">Security</h3>

(01/23/2025) - MM/DD/YYYY<br>
At this point, I created a security file. But i disabled all security to test freely all schedules endpoints

- [Security file](https://github.com/ViniCezarioDEV/Barber-Shop/blob/main/Backend/barbershop/src/main/java/solutionscorp/barbershop/Security/SecurityConfig.java)


<h2 id="frontend">Frontend Phase</h2>

<h3 id="fetf">Test Index file</h3>

(01/23/2025) - MM/DD/YYYY<br>
At this phase, I created a simple Index.html file, to test Schedule endpoints.

- [Click here to see Index file](https://github.com/ViniCezarioDEV/Barber-Shop/blob/main/Frontend/Test/index.html)