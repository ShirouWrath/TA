package shiro.streaming;

import shiro.streaming.system.Processor;
import shiro.streaming.system.TestX;
import shiro.streaming.system.WeatherProcessor;

import java.util.ArrayList;

public class Layout {

    private static ArrayList<Processor> processors;

    public static void main(String[] args) {
        //Initialize Main App
        initProcessors();
    }

    private static void initProcessors() {
        processors = new ArrayList<>();
        processors.add(new WeatherProcessor().prime(10));
        processors.add(new TestX().prime(5));
        //Start all processors
        for (Processor p: processors) {
            p.start();
        }
    }

}
