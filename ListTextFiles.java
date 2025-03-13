import java.io.File;

    public class ListTextFiles {
        public static void main(String[] args) {
            File folder = new File("D:\\"); // Thư mục cần quét
            File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

            if (files != null && files.length > 0) {
                System.out.println("Các file .txt trong thư mục D:");
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("Không có file .txt nào trong thư mục.");
            }
        }
    }


