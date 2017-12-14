package nio.NIOSocket;

/**
 * BufferAPI
 *
 * @author flytoyou
 * @version 1.0.0
 */
public class NIOEchoClient {

    public static void main(String[] args){
        int port = 8080;
        new Thread(new NIOClientHandler("127.0.0.1",port)).start();
    }

}
