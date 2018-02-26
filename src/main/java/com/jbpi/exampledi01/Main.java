package com.jbpi.exampledi01;

import com.jbpi.exampledi01.data.ApiStream;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        StreamsDownloader streamsDownloader = new StreamsDownloader();
        streamsDownloader.download(apiResponseStreams -> {

            System.out.println("Stream count: " + apiResponseStreams.getData().size());

            for (ApiStream apiStream : apiResponseStreams.getData()) {
                System.out.println(apiStream.getTitle());
            }
        });
    }
}
