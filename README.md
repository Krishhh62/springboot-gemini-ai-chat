# 🚀 Spring Boot + Gemini AI Chat API

## 📌 Overview

This project is a Spring Boot-based REST API that integrates with Google Gemini AI to generate intelligent responses.

## 🛠 Tech Stack

* Java
* Spring Boot
* REST APIs
* Google Gemini API

## ⚙️ Features

* AI-powered chat endpoint
* External API integration
* Clean architecture (Controller → Service)
* JSON parsing and response handling

## 🔗 API Endpoint

POST /api/chat

### Request:

```json
{
  "message": "Explain microservices"
}
```

### Response:

```json
{
  "reply": "Microservices is..."
}
```

## 🔐 Setup

1. Clone repo
2. Add environment variable:

```
GEMINI_API_KEY=your_api_key
```

3. Run application

## 💡 Future Improvements

* Add Redis caching
* Add prompt engineering
* Add conversation history
* Add RAG (FAISS)

## 👨‍💻 Author

Sai Krishna
