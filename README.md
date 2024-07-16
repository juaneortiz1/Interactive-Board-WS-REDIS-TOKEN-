# Interactive Drawing App with WebSockets and ReactJS

## Overview

This application demonstrates real-time bidirectional communication between clients and a server using WebSockets. Clients can initiate drawing actions, and each client's strokes are differentiated from those of remote clients. This project uses Spring Boot for the backend server and ReactJS for the frontend interface.

## Features

- **Real-time Drawing:** Multiple clients can draw simultaneously with immediate updates visible to all connected clients.
- **Unique Client Strokes:** Each client's drawing actions are distinguishable through different stroke styles or colors.
- **Responsive UI:** The ReactJS frontend provides an intuitive and responsive interface for drawing and viewing.

## Technologies Used

- **Backend:** Spring Boot, WebSocket API
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
    - Manages client connections, broadcasts drawing updates to all connected clients.

2. **Frontend (ReactJS):**
    - Provides a user-friendly interface for drawing.
    - Establishes a WebSocket connection to the backend server for real-time updates.
    - Differentiates between local and remote drawing actions to maintain a consistent and responsive user experience.

### Arquitecture Diagram
![Diagrama en blanco](https://github.com/juaneortiz1/InteractiveBoardWS/assets/97971732/bdc5bcc4-abc7-4936-9c42-2a48be5cc1e3)


This project leverages ReactJS on the client-side and Spring.io on the server-side to create a real-time collaborative drawing application. Clients interact through a dynamic user interface powered by ReactJS, while P5.js manages the interactive drawing canvas. Spring.io manages WebSocket connections, facilitating seamless bidirectional communication between clients and enabling real-time updates of drawings. AWS provides scalable hosting and storage solutions, ensuring the application remains responsive and reliable even with multiple simultaneous users. Together, these technologies form a robust architecture that allows users to collaboratively draw, with distinct visualization of their own and others' contributions, enhancing the interactive and collaborative experience.


## Deployment

This application has been deployed on Amazon Web Services (AWS) and is accessible at:

[http://ec2-54-90-71-142.compute-1.amazonaws.com:8080/](http://ec2-54-90-71-142.compute-1.amazonaws.com:8080/)

## Getting Started

To run this application locally, follow these steps:

1. **Clone the repository:**
   ```
   git clone https://github.com/juaneortiz1/InteractiveBoardWS.git
   cd repository-folder
   ```

2. **Backend Setup:**
    - Navigate to the `backend` directory.
    - Build the project using Maven:
      ```
      mvn clean package
      ```
    - Run the Spring Boot application:
      ```
      java -jar target/backend.jar
      ```

   
3**Accessing the Application:**
    - Open a web browser and go to `http://localhost:8080` to view and interact with the drawing application.



