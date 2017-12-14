package nio;

import java.nio.CharBuffer;

/**
 * BufferAPI
 *
 * @author flytoyou
 * @version 1.0.0
 */
public class BufferAPI {

    public static void main(String[] args){
        String content = "你好，java Non-Blocking I/O !";
        CharBuffer buffer = CharBuffer.allocate(50);
        //将字符串内容写入Buffer
        for (int i = 0;i < content.length();i++){
            buffer.put(content.charAt(i));
        }
        //反转Buffer，准备读取Buffer内容
        buffer.flip();
        //读取Buffer中的内容
        while (buffer.hasRemaining()){
            System.out.print(buffer.get());
        }

        //倒回读取之前，准备再次读取
        buffer.rewind();
        System.out.println();

        //读取Buffer中的数据
        while (buffer.hasRemaining()){
            System.out.print(buffer.get());
        }
        System.out.println();

        //清空Buffer,复位position，Buffer可以再次复用
        buffer.clear();
        buffer.put("你").put("好").put("!");
        buffer.flip();

        //在次读取Buffer中的数据
        while (buffer.hasRemaining()){
            System.out.print(buffer.get());
        }
    }

}
