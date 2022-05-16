package template;

import java.util.HashMap;

public class SlickLauncher {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("123", "1231321");
        map.put("456", "1111");
        map.entrySet().stream().forEach(System.out::println);
    }
}
