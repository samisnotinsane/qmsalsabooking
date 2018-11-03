# QM Salsa Booking
[![Build Status](https://travis-ci.org/samisnotinsane/qmsalsabooking.svg?branch=master)](https://travis-ci.org/samisnotinsane/qmsalsabooking)

[![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](https://forthebadge.com)

A web application for both salsa society committee and members. 

### Features:
 * View available classes
 * Book to attend classes
 * Admin panel to monitor class attendance, etc.
 
### Installation:

Using the home directory is recommended but not mandatory. Then clone the repo.

````
cd ~/
git clone https://github.com/samisnotinsane/qmsalsabooking.git
````
For stable build, switch to master branch:
````
git checkout master
````
Alternatively, to install the cutting edge version:
````
git checkout dev
````
Now build the jar using Maven:
````
mvn clean install
````
This will take a moment and produce a lot of output, finishing with `````[INFO] BUILD SUCCESS`````.

Start the application using the following command:
````
java -Dserver.port=8080 $JAVA_OPTS -jar target/qmsalsabooking-0.0.1-SNAPSHOT.jar
````
Now simply open up your favorite web browser and navigate to ````localhost:8080````.

You should now be greeted with the welcome page.
The system presently supports two different logins which you may use for signing in:

````
email: user
password: user


email: admin
password: password
````
To exit the application, switch back to the terminal and press ````Ctrl+C````.

#### Warning!
Exiting the application will cause all lessons and attendees to be erased!
