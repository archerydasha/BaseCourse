import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;

import java.util.Set;

/**
 * Created by dshcherbyna on 26.02.14.
 */
public class StartPoint {
    static private Injector injector;
    static private Set<Action> actions;

    public static void main(String[] args) {
        injector = Guice.createInjector(new ActionModule());
        actions = injector.getInstance(Key.get(new TypeLiteral<Set<Action>>() {
        }));

        findNeededAction(FIMEventType.JSONEVENT);
        findNeededAction(FIMEventType.XMLEVENT);
    }

    private static void findNeededAction(FIMEventType eventType) {
        for (Action action : actions) {
            if (action.getEventType() == eventType) {
                action.yield();
            }
        }
    }

}
