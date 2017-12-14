package nio.NIOSocket;

/**
 * BufferAPI
 *
 * @author flytoyou
 * @version 1.0.0
 */
public class NIOEchoServer {

    public static void main(String[] args){
        int port = 8080;

        NIOEchServerHandler server = new NIOEchServerHandler(port);
        new Thread(server).start();
    }

}
