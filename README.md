# Interactive-Board-WS-REDIS-TOKEN

## Overview

This application demonstrates real-time bidirectional communication between clients and a server using WebSockets. Clients can initiate drawing actions, and each client's strokes are differentiated from those of remote clients. This project uses Spring Boot for the backend server and ReactJS for the frontend interface. Redis is used to improve session management and persist the state of the application.

## Features

- **Real-time Drawing:** Multiple clients can draw simultaneously with immediate updates visible to all connected clients.
- **Unique Client Strokes:** Each client's drawing actions are distinguishable through different stroke styles or colors.
- **Responsive UI:** The ReactJS frontend provides an intuitive and responsive interface for drawing and viewing.
- **Session Management:** Uses Redis for session persistence to ensure a stateless solution.

## Technologies Used

- **Backend:** Spring Boot, WebSocket API, Redis
- **Frontend:** ReactJS, WebSocket client
- **Communication Protocol:** WebSocket for real-time bidirectional communication
- **Build Tools:** Maven (for backend), npm (for frontend dependencies)

## Screenshots

![image](https://github.com/juaneortiz1/InteractiveBoardWS/assets/97971732/162254a4-8354-4cf8-b106-440f8ca2d34f)
![image](https://github.com/juaneortiz1/InteractiveBoardWS/assets/97971732/b1b81589-855f-420f-b9dc-865927884a14)

## Architecture

The architecture of the application involves two main components:

1. **Backend (Spring Boot):**
    - Uses WebSocket API for handling real-time communication between clients.
    - Manages client connections and broadcasts drawing updates to all connected clients.
    - Configures Redis for session persistence, ensuring a stateless application.
    - Provides RESTful web services for additional functionality like ticket generation and validation.

2. **Frontend (ReactJS):**
    - Provides a user-friendly interface for drawing.
    - Establishes a WebSocket connection to the backend server for real-time updates.
    - Differentiates between local and remote drawing actions to maintain a consistent and responsive user experience.

### Architecture Diagram

![Diagrama en blanco](https://github.com/juaneortiz1/InteractiveBoardWS/assets/97971732/bdc5bcc4-abc7-4936-9c42-2a48be5cc1e3)

This project leverages ReactJS on the client-side and Spring.io on the server-side to create a real-time collaborative drawing application. Clients interact through a dynamic user interface powered by ReactJS, while P5.js manages the interactive drawing canvas. Spring.io manages WebSocket connections, facilitating seamless bidirectional communication between clients and enabling real-time updates of drawings. Redis is used to persist session data, ensuring the application remains stateless and scalable. AWS provides scalable hosting and storage solutions, ensuring the application remains responsive and reliable even with multiple simultaneous users. Together, these technologies form a robust architecture that allows users to collaboratively draw, with distinct visualization of their own and others' contributions, enhancing the interactive and collaborative experience.

## Redis Integration

To enhance session management and state persistence, Redis has been integrated into the backend of the application. Redis is configured to store session data, which ensures that the application is stateless and can scale efficiently. By using Redis, the application can maintain session data across multiple instances, improving reliability and performance.

## Web Services

The backend also provides several RESTful web services to support additional functionalities such as ticket generation and validation. These services facilitate secure interactions between the client and the server, ensuring that only authenticated users can perform certain actions. The use of RESTful web services complements the WebSocket-based real-time communication by providing a robust and scalable architecture for the application.

## Deployment

This application has been deployed on Amazon Web Services (AWS) and is accessible at:

[http://ec2-54-90-71-142.compute-1.amazonaws.com:8080/](http://ec2-54-90-71-142.compute-1.amazonaws.com:8080/)

## Getting Started

To run this application locally, follow these steps:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/juaneortiz1/InteractiveBoardWS.git
   cd repository-folder
   ```

2. **Backend Setup:**
    - Navigate to the `backend` directory.
    - Build the project using Maven:
      ```bash
      mvn clean package
      ```
    - Run the Spring Boot application:
      ```bash
      java -jar target/backend.jar
      ```

3. **Frontend Setup:**
    - Navigate to the `frontend` directory.
    - Install dependencies:
      ```bash
      npm install
      ```
    - Start the React application:
      ```bash
      npm start
      ```

4. **Accessing the Application:**
    - Open a web browser and go to `http://localhost:8080` to view and interact with the drawing application.
