import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Client {

    public static void main(String[] args) throws IOException {
        log.info("making REST call");
        var client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        var request = new Request.Builder().url("http://localhost:100/test_path").build();
        var response = client.newCall(request).execute();
        log.info("Response from mock server");
        log.info(response.body().string());
    }
}
