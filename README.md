<h1>JoinItAPI</h1>

<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About the Project](#about-the-project)
  * [Built With](#built-with)
  * [Functionalities](#functionalities)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [WWW](#www)
* [Frontend](#frontend)

<!-- ABOUT THE PROJECT -->
## About The Project
This project is backend part of a bigger project: Job board for IT industry. It was written in Java with Spring Boot and uses Azure SQL as a database.

### Built With
* Java
* Spring Boot
* Hibernate
* JPA
* Swagger
* Azure SQL Database and Azure App Service.

### Functionalities
This API is responsible for functionalities such as:
* Managing company accounts
  * Creating new company accounts
  * Getting information about company
  * Edititng account information
  * Deleting company account
* Managing postings
  * Companies users are able to create new postings
  * Companies users can also edit or completely delete their postings
  * Companies users can get the list of all their postings
  * Everyone can get the list of all postings
  * Everyone can search for specific postings by:
    * Category
    * Requirement
    * Localization
* Sending Emails
  * When someone applies for a job, API sends an email with PDF attachment to applying person and suitale company
<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple steps:

### Prerequisites
* IDE
* Browser

### Installation


#### For Local
1. Clone the repo
```sh
git clone https://github.com/ProjektyGrupowe/JoinItAPI.git
```

<!-- USAGE EXAMPLES -->
## Usage
For usage examples please refer to the [Live Documentation in API](https://joinitwebsite.azurewebsites.net/swagger-ui/)

## WWW
* API: https://joinitwebsite.azurewebsites.net/

## Frontend
* Github: https://github.com/ProjektyGrupowe/JoinIT-UI
* WWW: https://joinitui.azurewebsites.net/
