# VTU API Project

## Table of Contents
- [Introduction](#introduction)
- [Requirements](#requirements)
- [Setupt](#setupt)
- [Authentication and Using the VTU API](#authentication-and-using-the-vtu-api)
- [API Endpoints](#api-endpoints)
- [License](#license)

## Introduction
This project integrates with the Airtime VTU API, allowing users to purchase airtime through a RESTful interface. It is built with Spring Boot and follows best practices for security and API design.

## Requirements
- Java 11 or higher
- Maven
- Spring Boot
- Your preferred IDE (e.g., IntelliJ IDEA, Eclipse)

## Setup and Running the Project

1. **Clone the Repository**
   ```bash
   git clone  https://github.com/richardjim/vtuApi_test.git
   cd vtu_api

  ** Authentication and Using the VTU API

   
  ``` Configure Environment Variables Create an .env file in the root directory and add your API keys and other configuration variables:
  API_KEY=api_key

   
API Endpoints
Authentication Endpoints
Register
URL: /api/v1/auth/register
Method: POST
Request Body:
json
Copy code
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "password": "your_password"
}
Response:
json
Copy code
{
  "token": "jwt_token"
}
Authenticate
URL: /api/v1/auth/authenticate
Method: POST
Request Body:
json
{
  "email": "john.doe@example.com",
  "password": "your_password"
}
Response:
json
{
  "token": "jwt_token"
}
VTU Purchase Endpoint
Purchase Airtime
URL: /api/v1/purchase
Method: POST
Request Body:
json
Copy code
{
  "phoneNumber": "08012345678",
  "amount": 100
}
Response:
json
Copy code
{
  "message": "Airtime purchased successfully",
  "transactionId": "123456789"
}
