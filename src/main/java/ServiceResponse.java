import org.mockserver.mock.action.ExpectationResponseCallback;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

public class ServiceResponse implements ExpectationResponseCallback {
    @Override
    public HttpResponse handle(HttpRequest httpRequest) throws Exception {
        return HttpResponse.response().withBody("{\"key\" : \"value\"}");
    }
}
