package debug;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Pattern;

/**
 * @author Sebastian Rafalont 2022 by Mobile Traffic DATA Sp. z o.o.
 */
public class WeatherControl {

    public static void main(String[] args) throws Exception {

        //Disable logging
        String endResult = "";
        int endCounter = 0;
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        //Get weather info
        WebClient webClient = new WebClient();
        System.out.println("URL:" + "https://openweathermap.org/city/3088171");
        HtmlPage page = webClient.getPage("https://openweathermap.org/city/3088171");
        Thread.sleep(2000);
        for (DomNode domNode : page.getHtmlElementById("weather-widget").getOneHtmlElementByAttribute("div", "class", "section-content").getOneHtmlElementByAttribute("div", "class", "grid-container grid-4-5").getChildren()) {
            endCounter++;
            if (endCounter == 1) {
                List<String> lines = Arrays.asList(domNode.asNormalizedText().split("\\n"));
                for (String line : lines) {
                    System.out.println(lines.indexOf(line) + ":" + line);
                    if (lines.indexOf(line) == 3) {
                        endResult = line;
                    }
                }
            }
        }
        webClient.close();

        System.out.println("RESULT:" + endResult);
    }
}
