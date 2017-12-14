package bio;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterDemo {

    public static void main(String[] args) throws IOException{
        File file = new File("/Users/flytoyou/IdeaProjects/java-io/src/main/resources/target.txt");

        PrintWriter pw = new PrintWriter(file);
        //将内容格式化输出到文件target.txt
        pw.format("你好，%s %s %s","java", "Blocking"," I/O!");
        pw.flush();
        pw.close();
    }

}
