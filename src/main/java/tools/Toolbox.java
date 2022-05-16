package tools;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class Toolbox {

    public static String getHTMLContent(String url) throws Exception{
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        InputStream inputStream = connection.getInputStream();
        String text = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
        return text;
    }

    public static void writeDown(String input, String url) throws Exception{
        BufferedWriter writer = new BufferedWriter(new FileWriter(url));
        writer.write(input);
    }
}
