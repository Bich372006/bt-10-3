import java.io.*;

public class FileCopyExample {
    public static void main(String[] args) {
        // Đường dẫn file trực tiếp trên ổ D
        String inputFile = "D:\\input.txt";
        String outputFile = "D:\\output.txt";

        File file = new File(inputFile);
        if (!file.exists()) {
            System.out.println("Lỗi: Tệp " + inputFile + " không tồn tại! Hãy kiểm tra lại.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            System.out.println("Sao chép file thành công! Kiểm tra tại: " + outputFile);

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }
}
