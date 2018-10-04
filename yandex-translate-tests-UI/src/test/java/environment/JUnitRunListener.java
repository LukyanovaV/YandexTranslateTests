package environment;


import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class JUnitRunListener extends BlockJUnit4ClassRunner {

    private WebDriverListener webDriverListener;

    public JUnitRunListener(Class<?> klass) throws InitializationError {
        super(klass);
        webDriverListener = new WebDriverListener();
    }

    public void run(final RunNotifier notifier) {
        notifier.addListener(webDriverListener);
        super.run(notifier);
    }

}
