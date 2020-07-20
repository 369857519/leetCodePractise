package basics.IO.inputoutputstream;

import java.io.*;

public class ReaderStreamTest {
    public static void main(String[] args) throws IOException {
//        writeTest();
//        readTest();
    }

    /**
     *
     */

    /***
     * FileWriter 处理字符
     * OutputStream 处理字节
     * OutputStreamReader
     *  可以接受一个OutputStream，写成对应的字符，字符直接写的效率高于每字节写一次
     */
    public static void writeTest(){
        FileWriter writer=null;
        try{
            writer=new FileWriter(new File("aaa.txt"));
            String test="312321321\n";
            String lalala="fdlslfds哈哈\n";
            writer.write(test);
            writer.write(lalala);
            //这里用flush和close都可以写道硬盘中
            //  输出流中具有缓冲区的话，就应该flush
            //  关闭之前用一下flush
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /***
     * InputStream处理流
     * Reader处理流并读成字符
     * InputStreamReader
     *  可以将一个流转成字符，同时规定字符编码
     * @throws IOException
     */

    public static void readTest() throws IOException {
        /***
         *  输入输出流，用于处理字节，用于处理图片传输、视频流传输等
         */
        //字节流InputStream、OutputStream
        //字符流Reader、Writer(本质上还是字符流，逻辑约定)

        InputStream inputStream=null;
        try{
            //读取一个字节
            inputStream=new FileInputStream("aaa.txt");
            int charCache=0;
            while((charCache=inputStream.read())!=-1){
                System.out.println((char)charCache);
            }
            //使用缓冲区
            byte[] buffer=new byte[2048];
            int bufferCache=0;
            while((bufferCache=inputStream.read(buffer))!=-1){
                System.out.println(new String(buffer,6,bufferCache));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                //ultimate -a 一个进程最多打开1024个IO流，如果不关闭，很快就卡死了
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /***
         *  用于字符处理
         */
        //按照字符来处理
        //man utf8可以看到。中文可能占1-5个字节
        //stream字节无法正常的读取中文，所以使用reader
        Reader reader=null;
        try{
            reader=new FileReader("aaa.txt");
            int read=0;
//            System.out.println((char)reader.read());
            while ((read=reader.read())!=-1){
                System.out.println((char)read);
            }

            char[] chars=new char[1000];
            reader=new FileReader("aaa.txt");
            while ((read=reader.read(chars))!=-1){
                System.out.println(new String(chars,0,read));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

        /**
         * 流转字符 InputStreamReader
         * InputStream代表流
         * Reader代表字符
         */
        File file=new File("aaa.txt");
        FileInputStream fileInputStream=null;
        InputStreamReader inputStreamReader=null;
        try{
            fileInputStream=new FileInputStream(file);
            inputStreamReader=new InputStreamReader(fileInputStream);
            char[] chars=new char[1024];
            int length=inputStreamReader.read(chars);
            System.out.println(new String(chars,0,length));
        }catch (Exception e){

        }finally {
            inputStreamReader.close();
        }
    }

}
