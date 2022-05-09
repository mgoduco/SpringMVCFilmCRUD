# SpringMVCFilmCRUD
### Description

This application implements a full web-based C.R.U.D. functionality, using Spring MVC and the DAO pattern. It pulls data from a SQL database of films and actors to allow the user to search through several elements of the database on the web page. The user can enter a Film's ID and see the details of the film in a web page and when a film's details are displayed, its actors and categories are also listed. If the film is not found, they see an appropriate message. The user can also choose to add a new film. They can enter all the properties of the film. When a user retrieves a film, they have the option of deleting it. If they delete the film, it is removed from the database. When a user retrieves a film, they have the option of editing it. If they choose this, all the film's current properties are displayed in a form, allowing them to change any property except the film's ID. When they submit the form, that film's record is updated in the database. If the update fails, the user is informed of this. Finally the user can search for films by keyword/pattern in title or description. From the resulting list of films, the user can choose to update or delete a record. This application is run locally on a tomcat server.



### Technologies Used
- Java
- Spring MVC
- MySQL
- Gradle
- Git and Github
- JDBC
- DAO


### Lessons Learned

This was the first group project which highlighted the need for communication between group members to prevent git merge conflicts and to maximize efficiency in writing our code. This application utilized a lot of newly introduced material for us to work with including the DAO design pattern and JSP's which the project help to solidify our knowledge of. One of the most difficult parts of this project was setting up the @Requestmapping classes correctly and getting them properly mapped between JSP's. This being both a front end and back end project also provided a great opportunity to troubleshoot in stages starting in the back end, and using sys.outs in places to help troubleshoot mapping issues.