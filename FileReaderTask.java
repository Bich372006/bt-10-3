import java.io.RandomAccessFile;

public class FileReaderTask implements Runnable {
    private String filePath;
    private long start;
    private long end;
    private int threadId;

    public FileReaderTask(String filePath, long start, long end, int threadId) {
        this.filePath = filePath;
        this.start = start;
        this.end = end;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
            file.seek(start); // Nhảy đến vị trí bắt đầu

            byte[] buffer = new byte[(int) (end - start)];
            file.read(buffer);

            // Giả sử chỉ in ra kích thước dữ liệu đọc được
            System.out.println("Thread " + threadId + " đọc xong " + buffer.length + " bytes");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

