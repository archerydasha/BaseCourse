import com.google.inject.Inject;

/**
 * Created by dshcherbyna on 26.02.14.
 */
public class ParseJsonAction extends Action {

    @Inject
    public ParseJsonAction() {
        eventType = FIMEventType.JSONEVENT;
//        this.service = service;
    }

    public void yield() {
        System.out.println("ParseJsonAction was instantiated");
    }
}
