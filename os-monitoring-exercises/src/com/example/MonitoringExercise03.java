package com.example;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Random;

public class MonitoringExercise03 {
    private static final int BUFFER_SIZE = 1024 * 1024; // 1 MB buffer
    private static final String FILE_NAME = "io_wait_test_file_";
    private static final long FILE_SIZE = 1024 * 1024 * 1024; // 1 GB file size
    private static final int THREAD_COUNT = 4; // Number of concurrent threads

    public static void main(String[] args) {
        System.out.println("Starting I/O intensive operation...");

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int fileIndex = i;
            executorService.submit(() -> {
                try {
                    performIO(fileIndex);
                } catch (IOException e) {
                    System.err.println("Error during I/O: " + e.getMessage());
                }
            });
        }

        executorService.shutdown();
    }

    private static void performIO(int fileIndex) throws IOException {
        File file = new File(FILE_NAME + fileIndex + ".dat");
        byte[] buffer = new byte[BUFFER_SIZE];
        new Random().nextBytes(buffer);

        while (true) {
            try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
                long bytesWritten = 0;
                while (bytesWritten < FILE_SIZE) {
                    raf.write(buffer);
                    bytesWritten += buffer.length;
                }
                raf.getFD().sync(); // Force write to disk without caching
            }
            // Delete and recreate the file to increase I/O pressure
            file.delete();
        }
    }
}
