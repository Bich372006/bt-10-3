import java.io.*;
import java.util.concurrent.*;

class FileChunkReader implements Callable<String> {
    private final String filePath;
    private final long start;
    private final long end;

    public FileChunkReader(String filePath, long start, long end) {
        this.filePath = filePath;
        this.start = start;
        this.end = end;
    }

    @Override
    public String call() throws Exception {
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "r")) {
            raf.seek(start);
            byte[] buffer = new byte[(int) (end - start)];
            raf.read(buffer);
            return new String(buffer);
        }
    }
}

public class MultiThreadLargeFileRead {
    public static void main(String[] args) throws Exception {
        String filePath = "D:\\largefile.txt";
        long fileSize = new File(filePath).length();
        int numThreads = 4;
        long chunkSize = fileSize / numThreads;

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        Future<String>[] results = new Future[numThreads];

        for (int i = 0; i < numThreads; i++) {
            long start = i * chunkSize;
            long end = (i == numThreads - 1) ? fileSize : (start + chunkSize);
            results[i] = executor.submit(new FileChunkReader(filePath, start, end));
        }

        for (Future<String> result : results) {
            System.out.println(result.get());
        }

        executor.shutdown();
    }
}

