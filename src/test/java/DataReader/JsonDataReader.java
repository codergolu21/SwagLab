package DataReader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class JsonDataReader {

    public List<Map<String, String>> jsonToMap(String filepath) throws IOException {
// Json to string
        String jsonContent = FileUtils.readFileToString(new File((System.getProperty("user.dir") + filepath)));
        System.out.println(jsonContent);

        // String to map using jackson data bind
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, String>> map = mapper.readValue(jsonContent, new TypeReference<List<Map<String, String>>>() {});
        return map;
    }
}
