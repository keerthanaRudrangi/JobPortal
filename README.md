# JobPortal – Job Application & Recruitment Management System

## About the Project

JobPortal is a backend application developed using **Java and Spring Boot** for managing job applications and recruitment-related activities.

The application provides REST APIs for candidates and recruiters. Candidates can create their profiles, view available jobs and apply for suitable positions. Recruiters can create job postings and manage applications received from candidates.

This project was developed as a practical project to understand **Spring Boot, REST API development, Spring Data JPA, Hibernate and MySQL**.

## Features

### Candidate

* Register a candidate
* Create and update candidate profile details
* View available job opportunities
* Apply for a job
* Track application status

### Recruiter

* Register a recruiter
* Post job opportunities
* View applications received for jobs
* Update application status

### Job Management

* Create job postings
* View available jobs
* Store job details such as company, role, location, experience, job type, CTC and required skills

### Application Management

* Create job applications
* Store application date and location
* Track application status
* Update application status

## Technologies Used

* **Java 17**
* **Spring Boot 3.5.3**
* **Spring Data JPA**
* **Hibernate**
* **MySQL**
* **REST APIs**
* **Maven**
* **Postman**
* **Git & GitHub**
* **Eclipse IDE**

## Project Structure

```text
JobPortal
├── src
│   └── main
│       ├── java
│       └── resources
├── pom.xml
├── .gitignore
└── application-example.properties
```

## Database

The project uses **MySQL** as the database.

The application stores information related to candidates, recruiters, jobs and job applications.

Database credentials are maintained in the local `application.properties` file and are not committed to this repository.

An `application-example.properties` file is included with placeholder values for configuration reference.

## API Testing

The REST APIs were tested using **Postman**.

The following operations were tested during development:

* Candidate registration and retrieval
* Recruiter registration
* Job creation and retrieval
* Applying for jobs
* Viewing applications
* Updating application status
* Request validation

## Running the Project

1. Clone the repository.
2. Import the project as a Maven project in Eclipse or another Java IDE.
3. Create a MySQL database.
4. Configure the database details in your local `application.properties`.
5. Update the Maven project and download the required dependencies.
6. Run the Spring Boot application.
7. Use Postman to test the REST APIs.

## Note

This project is a learning and portfolio project developed to gain practical experience in **Java backend development and Spring Boot REST API development**.

## Developer

**Keerthana Rudrangi**

Java | Spring Boot | MySQL | REST APIs
