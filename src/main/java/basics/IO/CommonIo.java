package basics.IO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.EmptyFileFilter;

import java.io.File;

public class CommonIo {

    public static void main(String[] args) {
        long length= FileUtils.sizeOf(new File("baidu.html"));
        System.out.println(FileUtils.listFiles(new File("c:"), EmptyFileFilter.NOT_EMPTY,null));
    }
}
