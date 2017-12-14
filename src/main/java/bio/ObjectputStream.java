package bio;

import model.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ObjectOutputStream/ObjectInputStream
 *
 * @author flytoyou
 * @version 1.0.0
 */
public class ObjectputStream {

    public static void main(String[] args) throws Exception{
        User user = new User();
        user.setName("flytoyou");
        user.setEmail("fty@gmail.com");

        //将User对象序列化到文件
        FileOutputStream fout = new FileOutputStream("/Users/flytoyou/IdeaProjects/java-io/src/main/resources/user.txt");
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(user);
        oout.close();
        fout.close();

        //从user.txt文件中反序列化得到User对象
        FileInputStream fin = new FileInputStream("/Users/flytoyou/IdeaProjects/java-io/src/main/resources/user.txt");
        ObjectInputStream oin = new ObjectInputStream(fin);
        User fuser = (User) oin.readObject();
        System.out.println("name:" + fuser.getName());
        System.out.println("email:" + fuser.getEmail());
    }

}
