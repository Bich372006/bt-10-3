
    import java.io.*;

    class CountLines {
        public static void main(String[] args) {
            String filePath = "D:\\input.txt";
            int lineCount = 0;

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                while (br.readLine() != null) {
                    lineCount++;
                }
                System.out.println("Số dòng trong file: " + lineCount);

            } catch (IOException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }


