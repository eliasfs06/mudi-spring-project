# mudi Spring Project

mudi is a Spring-based web application that serves as an order placement platform. It enables users to request products they want to buy, and other users who have access to those products can take the orders. In essence, it functions as a product ordering system. This project was developed as the final project for a Spring course.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [How to Run](#how-to-run)
- [Database Setup](#database-setup)

## Introduction

mudi provides a platform for seamless order placement and fulfillment. Users can request products they want to buy, and other users who can access these products can take up the orders and purchase the products on their behalf.

## Features

- User registration and authentication system.
- Product listing and order placement functionality.
- Order fulfillment by users with access to the requested products.

## Technologies Used

- Spring Boot
- Spring MVC
- Spring Security
- Spring Data
- Thymeleaf
- Bootstrap
- PostgreSQL
- Maven

## How to Run

To run mudi on your local machine, follow these steps

1. Clone this repository to your local machine

2. Navigate to the project directory

3. Configure a PostgreSQL (or your preferred database) connection in the `application.properties` file

4. Build the application using Maven
   
6. Run the application using Spring Boot

7. The application will be accessible at `http://localhost:8080`.

## Database Setup

Before running the application, set up a PostgreSQL database and configure its connection details in the `application.properties` file.

