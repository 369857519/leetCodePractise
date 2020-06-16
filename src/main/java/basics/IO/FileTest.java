package basics.IO;

import java.io.*;
import java.sql.SQLOutput;
import java.util.concurrent.ExecutionException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file=new File("src/aaa.txt");
        OutputStream outputStream=null;
        try{
            outputStream=new FileOutputStream(file);
            outputStream.write(99);
            outputStream.write("\r\nfdsfds".getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                outputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        file.canExecute();
        file.canWrite();
        System.out.println(file.exists());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParent());
        //规范路径，使用一致的分割符
        System.out.println(file.getCanonicalFile());
        System.out.println(file.separator);

        File file2=new File("D:/");
        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());

        //展示当前目录的信息
        for(String str:file2.list()){
            System.out.println(str);
        }
        for(File f:file2.listFiles()){
            System.out.println(f);
        }

        File file3=new File("D:/a/b/c");
        file3.mkdir();
        file3.mkdirs();

        printFile(new File("D:/"));
    }

    public static void printFile(File file) throws IOException {
        if(file.isDirectory()&&file.canRead()){
            File[] files=file.listFiles();
            try{
                for(int i=0;i<files.length;i++){
                    if(files!=null){
                        printFile(files[i]);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }else{
            System.out.println(file.getCanonicalFile());
        }

    }
}
