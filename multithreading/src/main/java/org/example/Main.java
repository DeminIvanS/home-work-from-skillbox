package org.example;

import java.io.File;

public class Main {
    private static int newWidth = 300;

    private static int countThreads = Runtime.getRuntime().availableProcessors();
    private static int createCountThreads = 0;

    public static void main(String[] args) {
        String srcFolder = "E:\\Эээээксперименты\\подопытные";
        String dstFolder = "E:\\Эээээксперименты\\результат";

        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();
        int imagePerThreading = (int) Math.ceil((double) files.length / countThreads);
        File[] files1[] = new File[countThreads][countThreads];
        if (files.length <= 3) {
            ImageResizer resizer = new ImageResizer(files, newWidth, dstFolder);
            new Thread(resizer).start();
        }
        if (files.length > 3 && files.length <= countThreads / 2) {
            files1[0] = new File[files.length / 2];
            System.arraycopy(files, 0, files1[0], 0, files.length / 2);
            ImageResizer resizer = new ImageResizer(files1[0], newWidth, dstFolder);
            new Thread(resizer).start();
            files1[1] = new File[files.length - files1[0].length];
            System.arraycopy(files, 0, files1[1], 0, (files.length - files1[0].length));
            ImageResizer resizer1 = new ImageResizer(files1[1], newWidth, dstFolder);
            new Thread(resizer1).start();
        } else {

            int totalLength = 0;
            for (int i = 1; i <= countThreads; i++) {
                int j = 1;
                if (files.length - ((countThreads - (i - 1)) * imagePerThreading) > 0 && totalLength > 0) {
                    files1[j] = new File[imagePerThreading * j];
                    System.arraycopy(files, totalLength, files1[j], 0, files.length - totalLength);
                    ImageResizer resizer = new ImageResizer(files1[j], newWidth, dstFolder);
                    new Thread(resizer).start();
                    break;

                } else if (files.length > ((countThreads - (i - 1)) * imagePerThreading)) {
                    createCountThreads = countThreads - (i - 1);
                    for (; j <= createCountThreads; j++) {
                        files1[j - 1] = new File[imagePerThreading * i];
                        System.arraycopy(files, (j - 1) * imagePerThreading, files1[j - 1], 0, imagePerThreading);
                        ImageResizer resizer = new ImageResizer(files1[j - 1], newWidth, dstFolder);
                        new Thread(resizer).start();
                        totalLength = totalLength + imagePerThreading;
                    }
                }
            }
        }
        System.out.println(createCountThreads);
    }
}