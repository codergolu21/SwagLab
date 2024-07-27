package DataReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String args[]) throws IOException {

        JsonDataReader js = new JsonDataReader();
        List<Map<String, String>> input = js.jsonToMap("/src/Data/LoginUser.json");
        System.out.println(input.get(0));
        System.out.println(input.get(1));

    }
}
