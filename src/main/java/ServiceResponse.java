import com.opencsv.CSVReaderBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.mockserver.mock.action.ExpectationResponseCallback;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import io.vavr.collection.Array;

import java.io.FileReader;
import java.util.Map;


public class ServiceResponse implements ExpectationResponseCallback {
    @Override
    public HttpResponse handle(HttpRequest httpRequest) throws Exception {
        try (var csvReader = new CSVReaderBuilder(new FileReader("src/main/resources/data.csv")).build()) {
            var records = csvReader.readAll();
            String[] keys = records.get(0);
            var jsonArray = new JSONArray(
                    records.stream()
                            .skip(1)
                            .map(v -> new JSONObject(Map.of(keys[0], v[0],
                                    keys[1], v[1],
                                    keys[2], v[2],
                                    keys[3], v[3])))
                            .toList()
            );
            return HttpResponse.response().withBody(String.valueOf(jsonArray));
        }
    }
}
