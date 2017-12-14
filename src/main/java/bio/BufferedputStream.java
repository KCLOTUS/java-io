package bio;

import java.io.*;

/**
 * BufferedOutputStream/BufferedInputStream
 *
 * @author flytoyou
 * @version 1.0.0
 */
public class BufferedputStream {

    public static void main(String[] args) throws Exception{
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        BufferedOutputStream bufferedOutput = null;
        BufferedInputStream bufferedInput = null;

        //定义源文件与目标文件
        File srcFile = new File("/Users/flytoyou/IdeaProjects/java-io/src/main/resources/src.txt");
        File targetFile = new File("/Users/flytoyou/IdeaProjects/java-io/src/main/resources/target.txt");

        try {
            //实例化文件输入流和文件输出流
            inputStream = new FileInputStream(srcFile);
            bufferedInput = new BufferedInputStream(inputStream);
            outputStream = new FileOutputStream(targetFile);
            bufferedOutput = new BufferedOutputStream(outputStream);

            //通过缓冲输入流读取源文件内容，并写入目标文件
            byte[] buff = new byte[1024];
            int len;
            while ((len = bufferedInput.read(buff,0,buff.length)) != -1){
                bufferedOutput.write(buff,0,len);
            }
            bufferedOutput.flush();
        }finally {
            if (inputStream != null){
                inputStream.close();
            }
            if (outputStream != null){
                outputStream.close();
            }
        }
    }

}
