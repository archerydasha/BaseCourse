/**
 * Created by dshcherbyna on 26.02.14.
 */

import com.google.inject.Inject;

public class ParseXMLAction extends Action{

    @Inject
    public ParseXMLAction(){
        eventType = FIMEventType.XMLEVENT;
//        this.service = service;
    }

    @Override
    void yield() {
        System.out.println("ParseXMLAction was instantiated");
    }
}
