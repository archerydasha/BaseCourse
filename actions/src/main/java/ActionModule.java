import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

/**
 * Created by dshcherbyna on 26.02.14.
 */
public class ActionModule extends AbstractModule {
    @Override
    protected void configure() {
        Multibinder<Action> multibinder = Multibinder.newSetBinder(binder(), Action.class);
        multibinder.addBinding().to(ParseJsonAction.class);
        multibinder.addBinding().to(ParseXMLAction.class);
    }
}
