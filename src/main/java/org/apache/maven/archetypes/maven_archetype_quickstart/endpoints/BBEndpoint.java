package org.apache.maven.archetypes.maven_archetype_quickstart.endpoints;

import java.io.IOException;
import java.util.logging.Level;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;


import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import org.apache.maven.archetypes.maven_archetype_quickstart.redis.BBApplicationContextAware;
import org.apache.maven.archetypes.maven_archetype_quickstart.repositories.TicketRepository;
import org.springframework.stereotype.Component;
@Component
@ServerEndpoint("/bbService")

public class BBEndpoint {
    private boolean accepted = false;
    private static final Logger logger = Logger.getLogger(BBEndpoint.class.getName());
    /* Queue for all open WebSocket sessions */
    static Queue<Session> queue = new ConcurrentLinkedQueue<>();
    private Session ownSession = null;
    TicketRepository ticketRepo =
            (TicketRepository)
                    BBApplicationContextAware.getApplicationContext().getBean("ticketRepository");

    /* Call this method to send a message to all clients */
    public void send(String msg) {
        try {
            /* Send updates to all open WebSocket sessions */
            for (Session session : queue) {

                if (!session.equals(this.ownSession)) {
                    session.getBasicRemote().sendText(msg);
                }
                logger.log(Level.INFO, "Sent: {0}", msg);
            }
        } catch (IOException e) {
            logger.log(Level.INFO, e.toString());
        }
    }
    @OnMessage
    public void processPoint(String message, Session session) {
        if (accepted) {
            this.send(message);
        } else {
            if (!accepted && ticketRepo.checkTicket(message)) {
                accepted = true;
            }else{
                try {
                    ownSession.close();
                } catch (IOException ex) {
                    Logger.getLogger(BBEndpoint.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    @OnOpen
    public void openConnection(Session session) {
        /* Register this connection in the queue */
        queue.add(session);
        ownSession = session;
        logger.log(Level.INFO, "Connection opened.");
        try {
            session.getBasicRemote().sendText("Connection established.");
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
    @OnClose
    public void closedConnection(Session session) {
        /* Remove this connection from the queue */
        queue.remove(session);
        logger.log(Level.INFO, "Connection closed.");
    }
    @OnError
    public void error(Session session, Throwable t) {
        /* Remove this connection from the queue */
        queue.remove(session);
        logger.log(Level.INFO, t.toString());
        logger.log(Level.INFO, "Connection error.");
    }





}

