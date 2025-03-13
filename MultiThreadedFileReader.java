
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

    public class MultiThreadedFileReader {
        private static final int THREAD_COUNT = 4; // Số luồng đọc file

        public static void main(String[] args) {
            String filePath = "largefile.txt"; // Đường dẫn file cần đọc
            long fileSize = FileUtils.getFileSize(filePath);
            long chunkSize = fileSize / THREAD_COUNT;

            ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

            for (int i = 0; i < THREAD_COUNT; i++) {
                long start = i * chunkSize;
                long end = (i == THREAD_COUNT - 1) ? fileSize : start + chunkSize;
                executor.execute(new FileReaderTask(filePath, start, end, i + 1));
            }

            executor.shutdown();
        }
    }


