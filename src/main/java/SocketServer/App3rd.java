package SocketServer;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class App3rd {

    private static final Logger logger = Logger.getLogger(App3rd.class);

    private static final int PORT_NUMBER = 4432;

    public static void main(String[] args) throws IOException{
        logger.info(":::                                                :::");
        logger.info(":::       Socket Application  Process Start        :::");
        logger.info(":::                                                :::");

        try(ServerSocket server = new ServerSocket(PORT_NUMBER)){
            while (true){
                Socket connection = server.accept();
                Thread task = new SocketThreadServer(connection);
                task.start();
            }
        }catch (IOException e){
            logger.error(e);
        }
    }
}
