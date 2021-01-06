package others.io;

import java.io.File;
import java.nio.file.Path;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/12/19 16:48
 * @description：
 * @modified By：
 * @version: $
 */
public class FileAttribute {
    public static void main(String[] args) {
        File file =new File("D:/PS");
        Path path=file.toPath();
        System.out.println(path.getParent().resolve("nihao"));
        for(File s:file.listFiles()){
            System.out.println(s.getName());
        }
    }
}
