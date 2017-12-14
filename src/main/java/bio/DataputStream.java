package bio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * DataOutputStream/DataInputStream
 *
 * @author flytoyou
 * @version 1.0.0
 */
public class DataputStream {

    public static void main(String[] args) throws Exception{
        String fileName = "/Users/flytoyou/IdeaProjects/java-io/src/main/resources/data.txt";

        //将java原生数据类型通过DataOutputStream写入文件
        FileOutputStream fout = new FileOutputStream(fileName);
        DataOutputStream dos = new DataOutputStream(fout);

        dos.writeInt(2017);
        dos.writeUTF("你好，java Blocking I/O !");
        dos.writeBoolean(true);

        dos.close();
        fout.close();

        //使用DataInputStream从文件中按照写入顺序读取java原生类型数据
        FileInputStream fin = new FileInputStream(fileName);
        DataInputStream dis = new DataInputStream(fin);

        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());
        System.out.println(dis.readBoolean());

        dis.close();
        fin.close();
    }

}
