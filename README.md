# Restaurant Selector Mini Project
Mini project of Spring Boot and Angular UI 

Features:
  - Takes in a restaurant as input from the UI
  - Shows a random restaurant from all the restaurants submitted

# How to Run Both Together as Docker containers

To build and both as docker container, run the following command in a terminal window in the base directory:

  - docker-compose up --build --force-recreate

# How to Run Individually

To run the spring-boot application, run the following command in a terminal window (in the restaurant) directory:

  - mvnw spring-boot:run

To run the Angular UI, run the following command in a terminal window (in the frontend/selectorapp) directory:

  - ng serve
