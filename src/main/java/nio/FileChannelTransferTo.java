package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 使用TransferTo方法实现文件复制
 *
 * @author flytoyou
 * @version 1.0.0
 */
public class FileChannelTransferTo {

    public static void main(String[] args) throws IOException{
        FileInputStream fin = new FileInputStream("/Users/flytoyou/IdeaProjects/java-io/src/main/resources/src.txt");
        //从输入流中获取源文件src.txt的通道
        FileChannel finChannel = fin.getChannel();

        FileOutputStream fout = new FileOutputStream("/Users/flytoyou/IdeaProjects/java-io/src/main/resources/target.txt");
        //从输出流中获取目标文件target.txt的通道
        FileChannel foutChannel = fout.getChannel();

        //使用transferTo API将文件src.txt内容写入target.txt
        finChannel.transferTo(0,finChannel.size(),foutChannel);

        //关闭文件流及通道
        fin.close();
        finChannel.close();
        fout.close();
        foutChannel.close();
    }

}
