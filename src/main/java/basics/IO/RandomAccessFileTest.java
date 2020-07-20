package basics.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    private static final int BLOCK_SIZE =1024;

    public static void main(String[] args) {
        File file=new File("baidu.html");
        long length=file.length();
        int blockSize=BLOCK_SIZE;
        int size=(int) Math.ceil(length*1.0/blockSize);
        System.out.println("要被切成多少个快");
        int beginPos=0;
        int actualSize=0;
        for(int i=0;i<size;i++){
            beginPos=i*blockSize;
            if(i==size-1){
                actualSize=(int)length;
            }else{
                actualSize=blockSize;
                length-=actualSize;
            }
            System.out.println("index: "+i+" beginPos:"+beginPos+" readSize"+actualSize);
            readSplit(beginPos,actualSize);
        }
    }

    public static void readSplit(int beginPos,int actualSize){
        File file=new File("baidu.html");
        try(RandomAccessFile randomAccessFile=new RandomAccessFile(file,"r")) {
            int length=0;
            randomAccessFile.seek(beginPos);
            byte[] bytes=new byte[1024];
            while((length=randomAccessFile.read(bytes))!=-1){
                if(actualSize>length) {
                    System.out.println(new String(bytes, 0, length));
                }else {
                    System.out.println(new String(bytes,0 ,actualSize));
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
