package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用FileChannel的read与writer方法实现文件的复制
 *
 * @author flytoyou
 * @version 1.0.0
 */
public class FileChannelRW {

    public static void main(String[] args) throws IOException{

        FileInputStream fin = new FileInputStream("/Users/flytoyou/IdeaProjects/java-io/src/main/resources/src.txt");
        //从输入流中获取源文件src.txt的通道
        FileChannel finChannel = fin.getChannel();

        FileOutputStream fout = new FileOutputStream("/Users/flytoyou/IdeaProjects/java-io/src/main/resources/target.txt");
        //从输出流中获取目标文件target.txt的通道
        FileChannel foutChannel = fout.getChannel();

        //文件读取内容Buffer
        ByteBuffer buf = ByteBuffer.allocate(1024);
        int bytesRead = finChannel.read(buf);
        //一次性可能读不完，所以需要循环读取
        while (bytesRead != -1){
            //翻转Buffer,为下面的读取做准备
            buf.flip();
            while (buf.hasRemaining()){
                //将读取的内容写入target.txt
                foutChannel.write(buf);
            }
            //复位Buffer,以便再次复用Buffer
            buf.clear();
            bytesRead = finChannel.read(buf);
        }

        //关闭文件流及通道
        fin.close();
        finChannel.close();
        fout.close();
        foutChannel.close();
    }

}
