package nio.socket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * SocketServer服务端业务处理类
 *
 * @author flytoyou
 * @version 1.0.0
 */
public class EchoHandler implements Runnable {

    private SocketChannel socketChannel;

    private ByteBuffer buffer = ByteBuffer.allocate(1024);

    public EchoHandler(SocketChannel socketChannel){
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        try{
            //读取客户端传输的数据，并原样写入返回给客户端
            while (socketChannel.read(buffer) != -1){
                buffer.flip();
                socketChannel.write(buffer);
                if (buffer.hasRemaining()){
                    buffer.compact();
                }else {
                    buffer.clear();
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

}
