package Threading;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Program: Multithreaded Downloads
 * Programmer: Harsha Kuchampudi
 * Date: May 19, 2015
 *
 * Description: Sample Application of Utilizing Multiple Threads
 */

public class Download_Multithreading {

    public static void main(String []args){

        ExecutorService service = Executors.newFixedThreadPool(10);

        String[] downloadLinksArray = {
                "http://releases.ubuntu.com/14.04.2/ubuntu-14.04.2-desktop-amd64.iso",
                "http://releases.ubuntu.com/14.10/ubuntu-14.10-desktop-amd64.iso",
                "http://releases.ubuntu.com/15.04/ubuntu-15.04-desktop-amd64.iso",
                "http://asdfadsfasdfasdfafdsfasdfa.com"
        };

        for (int i = 0; i < downloadLinksArray.length; i++) {

            String url = downloadLinksArray[i];
            Runnable worker = new MyRunnable(url, "download" + i + ".iso");
            service.execute(worker);
        }

        service.shutdown();

        // Wait until all threads are finish
        while (!service.isTerminated()) {

        }

        System.out.println("\nFinished all threads");

    }

    public static class MyRunnable implements Runnable{

        private String downloadURL;
        private String outputFileName;

        MyRunnable(String URL, String outputFileName){
            this.downloadURL = URL;
            this.outputFileName = outputFileName;
        }

        @Override
        public void run(){

            System.out.println("Downloading From: " + downloadURL);

            try {
                downloadFile(downloadURL, outputFileName);
                System.out.println("Successfully Downloaded From: " + downloadURL);
            } catch (IOException e) {

                System.out.println("Could Not Download From: " + downloadURL);
            }

        }

    }

    public static void downloadFile(String url, String outputName) throws IOException {

        URL website = new URL(url);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream(outputName);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

    }

}
