import java.io.*;

    public class WriteToFile {
        public static void main(String[] args) {
            String filePath = "D:\\output.txt";

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                 FileWriter writer = new FileWriter(filePath)) {

                System.out.println("Nhập nội dung (gõ 'exit' để dừng):");
                String line;
                while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                    writer.write(line + "\n");
                }

                System.out.println("Đã lưu vào file: " + filePath);

            } catch
            (IOException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }


