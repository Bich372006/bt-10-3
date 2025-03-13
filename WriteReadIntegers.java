import java.io.*;

    public class WriteReadIntegers {
        public static void main(String[] args) {
            String filePath = "D:\\numbers.dat";

            // Ghi danh sách số nguyên vào file
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
                dos.writeInt(10);
                dos.writeInt(20);
                dos.writeInt(30);
                System.out.println("Đã ghi số nguyên vào file.");

            } catch (IOException e) {
                System.out.println("Lỗi khi ghi file: " + e.getMessage());
            }

            // Đọc số nguyên từ file
            try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
                while (dis.available() > 0) {
                    System.out.println("Số nguyên đọc được: " + dis.readInt());
                }

            } catch (IOException e) {
                System.out.println("Lỗi khi đọc file: " + e.getMessage());
            }
        }
    }


