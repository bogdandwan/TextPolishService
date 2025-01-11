TextPolish API Documentation

The TextPolish API is designed to polish and enhance HTML text content. It allows users to customize the output based on specified languages and domain-specific requirements. This documentation covers the endpoint details, request/response structures, and security mechanisms implemented.

Security
This API uses an API key for authentication. The client must include the API key in the header of every request using the key name 'x-api-key'. Requests without a valid API key will receive a 401 Unauthorized response.
 Security Scheme: 
Type: apiKey
In: header 
Name: x-api-key


Endpoint: /polish
Description: Polishes and refines HTML text content based on the specified language and domain settings. The service ensures the output aligns with the desired style and structure. 
Request:
 - Method: POST
 - Headers: 
- Content-Type: application/json
 - x-api-key:  "test"
 

- Body: 
{ "language": "string", // Language code (e.g., 'en' for English) "domain": "string", // Domain for text style (e.g., 'marketing', 'legal') "content": "string" // HTML content to polish } 
Response: 
- Status Code: 200 (OK)
 - Body: 
{ "polished_content": "string", // Polished HTML content "similarity": 0.95 // Similarity score (0 to 1) }

Error Responses
- 400 Bad Request: Invalid input data. 
- 401 Unauthorized: Missing or invalid API key.
 - 500 Internal Server Error: An unexpected error occurred.
