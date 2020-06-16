package basics.IO;

import java.io.*;

public class DecoratedStreamReaderTest {

    public static void main(String[] args) throws IOException {
        dataTest();
    }

    public static void dataTest(){
        File file=new File("bbb.txt");
        FileOutputStream fileOutputStream=null;
        DataOutputStream dataOutputStream=null;
        try{
            fileOutputStream=new FileOutputStream(file);
            dataOutputStream=new DataOutputStream(fileOutputStream);
            dataOutputStream.writeBoolean(true);
            FileInputStream fileInputStream=new FileInputStream(file);
            DataInputStream dataInputStream=new DataInputStream(fileInputStream);
            System.out.println(dataInputStream.readBoolean());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void bufferedTest() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream=null;
        ByteArrayInputStream byteArrayInputStream=null;
        try{
            byteArrayOutputStream=new ByteArrayOutputStream();
            byteArrayOutputStream.write(123);
            System.out.println(byteArrayOutputStream.toString());

            byte[] bytes="fdsafds".getBytes();
            byteArrayInputStream=new ByteArrayInputStream(bytes);
            System.out.println((char) byteArrayInputStream.read());
        }finally {
            byteArrayOutputStream.close();
        }
        //BufferedInputStream 提供了缓冲区功能的inputstream
        File file=new File("aaa.txt");
        FileInputStream fileInputStream=new FileInputStream(file);
        BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
        InputStreamReader inputStreamReader=new InputStreamReader(bufferedInputStream);
        try{
            int read=0;
            while( (read=inputStreamReader.read())!=-1){
                System.out.println((char)read);
            }
        }finally {
            bufferedInputStream.close();
        }
    }
}
