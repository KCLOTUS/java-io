package bio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * FileOutputStream/FileInputStream
 *
 * @author flytoyou
 * @version 1.0.0
 */
public class FileputStream {

    public static void main(String[] args) throws Exception{
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        //定义源文件与目标文件
        File srcFile = new File("/Users/flytoyou/IdeaProjects/java-io/src/main/resources/src.txt");
        File targetFile = new File("/Users/flytoyou/IdeaProjects/java-io/src/main/resources/target.txt");

        try {
            //实例化文件输入流和文件输出流
            inputStream = new FileInputStream(srcFile);
            outputStream = new FileOutputStream(targetFile);

            //通过文件输入流读取源文件内容，并写入目标文件
            int len;
            while ((len = inputStream.read()) != -1){
                outputStream.write(len);
            }
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
