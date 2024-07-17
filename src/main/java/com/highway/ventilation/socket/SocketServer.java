package com.highway.ventilation.socket;

import com.highway.ventilation.service.CommunicationFrameService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.KeyStore;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class SocketServer {

    private static final Logger logger = LoggerFactory.getLogger(SocketServer.class);

    @Value("${server.port}")
    private int port;

    @Value("${keystore.path}")
    private String keystorePath;

    @Value("${keystore.password}")
    private String keystorePassword;

    private final CommunicationFrameService frameService;
    private SSLServerSocket serverSocket;
    private ExecutorService executorService;
    private boolean running = true;

    public void startServer() {
        try {
            // Load keystore
            char[] passphrase = keystorePassword.toCharArray();
            KeyStore ks = KeyStore.getInstance("JKS");
            ks.load(new FileInputStream(keystorePath), passphrase);

            // Set up key manager factory
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(ks, passphrase);

            // Initialize SSL context
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(kmf.getKeyManagers(), null, null);

            // Create SSL server socket factory
            SSLServerSocketFactory ssf = sc.getServerSocketFactory();
            serverSocket = (SSLServerSocket) ssf.createServerSocket(port);

            executorService = Executors.newFixedThreadPool(10);
            logger.info("Server is listening on port {}", port);

            while (running) {
                try {
                    Socket socket = serverSocket.accept();
                    executorService.submit(new SocketHandler(socket, frameService));
                } catch (IOException e) {
                    if (running) {
                        logger.error("Error accepting connection", e);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Error starting server", e);
        }
    }

    public void stopServer() {
        running = false;
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException | InterruptedException e) {
            logger.error("Error stopping server", e);
        }
    }
}