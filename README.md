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

   Authentication and Using the VTU API
Authenticating
To authenticate, use the /api/v1/auth/register endpoint to register a new user or /api/v1/auth/authenticate to log in and receive a JWT token.

Using the VTU API
Once authenticated, you can use the provided JWT token to make requests to the VTU API. The token should be included in the Authorization header as follows:

http
Copy code
Authorization: Bearer <your_jwt_token>
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
  "token": "your_jwt_token"
}
Authenticate

URL: /api/v1/auth/authenticate
Method: POST
Request Body:
json
Copy code
{
  "email": "john.doe@example.com",
  "password": "your_password"
}
Response:
json
Copy code
{
  "token": "your_jwt_token"
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
License
This project is licensed under the MIT License. See the LICENSE file for details.

markdown
Copy code

### How to Use This Template

1. **Fill in Your Details**: Replace `your_username`, `your_api_key`, and other placeholders with your actual information.
2. **Additional Information**: If there are additional configurations, dependencies, or setup steps needed, include them in the relevant sections.
3. **Test the Endpoints**: Ensure that the endpoints and request/response formats are accurate and tested against your actual API.
4. **License**: Include a LICENSE file if your project is open source.

### Adding the `README.md` to Your Repository

1. **Create the README File**:
   ```bash
   touch README.md
