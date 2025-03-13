import java.io.RandomAccessFile;

public class FileUtils {
    public static long getFileSize(String filePath) {
        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
            return file.length();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}


