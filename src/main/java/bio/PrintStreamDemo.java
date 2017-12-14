package bio;

import java.io.File;
import java.io.PrintStream;

/**
 * PrintStreamDemo
 *
 * @author flytoyou
 * @version 1.0.0
 */
public class PrintStreamDemo {

    public static void main(String[] args) throws Exception{
        File file = new File("");
        PrintStream printStream = new PrintStream(file);

        //将内容写入文件
        printStream.println("你好，java Blocking I/O !");
        printStream.close();
    }

}
