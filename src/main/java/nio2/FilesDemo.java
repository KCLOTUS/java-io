package nio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Iterator;

/**
 * Files工具类的使用
 *
 * @author flytoyou
 * @version 1.0.0
 */
public class FilesDemo {

    public static void main(String[] args) throws IOException{
        //遍历根目录／下的子目录
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("/Users/flytoyou/IdeaProjects/java-io/src/main"));
        Iterator<Path> iterator = directoryStream.iterator();
        while (iterator.hasNext()){
            Path path = iterator.next();
            System.out.println(path);
        }
        //递归创建文件目录(如果目录已存在，无法重复创建)
        Path path = Files.createDirectories(Paths.get("/Users/flytoyou/IdeaProjects/java-io/src/main/resources/test1/"));
        System.out.println(path);

        //创建文件test.txt
        Path file = Files.createFile(Paths.get("/Users/flytoyou/IdeaProjects/java-io/src/main/resources/test1/test1.txt"));

        //将缓冲字符流写入文件内容
        Charset charset = Charset.forName("UTF-8");
        String text = "Hello,java NIO2";
        try{
            BufferedWriter writer = Files.newBufferedWriter(file,charset, StandardOpenOption.APPEND);
            writer.write(text);
            writer.close();
        }catch (IOException e){
            System.err.println(e);
        }

        //使用缓冲字符流读取文件内容
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(file,charset);
            String line = null;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.err.println(e);
        }finally {
            if (reader != null){
                reader.close();
            }
        }
    }

}
