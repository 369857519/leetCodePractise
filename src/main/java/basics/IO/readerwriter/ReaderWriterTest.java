package basics.IO.readerwriter;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.io.*;
import java.net.URL;

public class ReaderWriterTest {
    public static void main(String[] args) {

        //char reader writer
        char[] chars = new char[1024];
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        charArrayWriter.write('b');
        chars = charArrayWriter.toCharArray();
        CharArrayReader charArrayReader = new CharArrayReader(chars);
        try {
            char c = (char) charArrayReader.read();
            System.out.println(c);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //bufferedReaderWriter

        BufferedReader reader=null;
        try{
            reader=new BufferedReader(new FileReader("aaa.txt"));
            String read=null;
            while((read=reader.readLine())!=null){
                System.out.println(read.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        BufferedWriter bufferedWriter=null;
        try{
            bufferedWriter=new BufferedWriter(
                    new FileWriter("kkk.txt"));
            bufferedWriter.append("fdasfdsafdsa");
            bufferedWriter.newLine();
            bufferedWriter.write("hahaha");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


//        try(InputStreamReader inputStreamReader=new InputStreamReader(System.in);
//            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(System.out);
//            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
//            BufferedWriter bufferedWriter1q=new BufferedWriter(outputStreamWriter)){
//            String str="";
//            while(!str.equals("exit")){
//                str=bufferedReader.readLine();
//                bufferedWriter1q.write(str);
//                bufferedWriter1q.flush();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try(
                BufferedReader urlReader=new BufferedReader(
                new InputStreamReader(new URL("http://www.baidu.com").openStream()));
                BufferedWriter urlWriter=new BufferedWriter
                        (new OutputStreamWriter(new FileOutputStream("baidu.html")))
        ){
            String msg=null;
            while((msg=urlReader.readLine())!=null){
                urlWriter.write(msg);
                urlWriter.newLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //print line


        try(PrintStream printStream=new PrintStream(System.out);) {
            printStream.write("fdsafdsafdsa".getBytes());
            printStream.println(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
