package bio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRW {

    public static void main(String[] args) throws IOException{
        FileReader fr = new FileReader("/Users/flytoyou/IdeaProjects/java-io/src/main/resources/src.txt");
        FileWriter fw = new FileWriter("/Users/flytoyou/IdeaProjects/java-io/src/main/resources/target.txt");
        int len;
        while ((len = fr.read()) != -1){
            fw.write(len);
        }
        fw.close();
        fr.close();
    }

}
