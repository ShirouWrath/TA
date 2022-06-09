package shiro.streaming;

import debug.CanvasTest;
import shiro.streaming.system.Processor;
import shiro.streaming.system.TestX;
import shiro.streaming.system.WeatherProcessor;

import java.awt.*;
import java.util.ArrayList;

public class Layout {

    private static ArrayList<Processor> processors;

    public static void main(String[] args) {
        //Initialize Main App
        initProcessors();
        //Show ui after (locking the main thread)
        CanvasTest.launch();
    }

    private static void initProcessors() {
        processors = new ArrayList<>();
//        processors.add(new WeatherProcessor().prime(10));
//        processors.add(new TestX().prime(5));
        //Start all processors
        for (Processor p: processors) {
            p.start();
        }
    }

}
