package bio;

import java.io.*;

/**
 * OutputStreamWrite／InputStreamReader
 *
 * @author flytoyou
 * @version 1.0.0
 */
public class PutStreamRW {

    public static void main(String[] args) throws IOException{
        //创建文件字节输入流
        FileInputStream inputStream = new FileInputStream("/Users/flytoyou/IdeaProjects/java-io/src/main/resources/src.txt");
        //利用桥梁InputStreamReader将文件字节流输入inputStream转换为字符输入流
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
        //利用BufferedReader包装字符输入流inputStreamReader提高性能
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        //创建文件字节输出流
        FileOutputStream outputStream = new FileOutputStream("/Users/flytoyou/IdeaProjects/java-io/src/main/resources/target.txt");
        //利用桥梁OutputStreamWrite将文件字节输出流outputStream转换为字符输出流
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        //BufferedWriter包装字符输出流outputStreamWriter提高性能
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        //将文件src.txt文本内容写入target.txt
        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        outputStream.close();
        inputStreamReader.close();
        inputStream.close();
    }

}
