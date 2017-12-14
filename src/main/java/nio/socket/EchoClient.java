package nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * SocketServer客户端
 *
 * @author flytoyou
 * @version 1.0.0
 */
public class EchoClient {

    public static void main(String[] args){
        ByteBuffer helloBuffer = ByteBuffer.wrap("你 好，java Blocking I/O".getBytes());
        CharBuffer charBuffer;
        Charset charset = Charset.defaultCharset();
        CharsetDecoder decoder = charset.newDecoder();

        try{
            //创建客户端socketChannel
            SocketChannel socketChannel = SocketChannel.open();
            //如果socketChannel创建成功
            if (socketChannel.isOpen()){
                //设置为阻塞模式
                socketChannel.configureBlocking(true);
                //设置网络传输参数
                socketChannel.setOption(StandardSocketOptions.SO_RCVBUF,128 * 1024);
                socketChannel.setOption(StandardSocketOptions.SO_SNDBUF,128 * 1024);
                socketChannel.setOption(StandardSocketOptions.SO_KEEPALIVE,true);
                socketChannel.setOption(StandardSocketOptions.SO_LINGER,5);
                //连接到服务器
                socketChannel.connect(new InetSocketAddress("127.0.0.1",8085));
                //如果成功连接服务端
                if (socketChannel.isConnected()){
                    //向服务端发送数据
                    socketChannel.write(helloBuffer);
                    //创建接收服务端返回数据ByteBuffer
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    while (socketChannel.read(buffer) != -1){
                        buffer.flip();
                        charBuffer = decoder.decode(buffer);
                        System.out.println(charBuffer.toString());
                        if (buffer.hasRemaining()){
                            buffer.compact();
                        }else {
                            buffer.clear();
                        }
                    }
                }else {
                    throw new RuntimeException("connection cannot be established!");
                }
                //关闭连接
                socketChannel.close();
            }else {
                throw new RuntimeException("bio.socket channel cannot be opened!");
            }
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }

}
