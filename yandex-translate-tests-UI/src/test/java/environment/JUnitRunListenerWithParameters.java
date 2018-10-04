package environment;

import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import org.junit.runners.parameterized.BlockJUnit4ClassRunnerWithParameters;
import org.junit.runners.parameterized.TestWithParameters;

public class JUnitRunListenerWithParameters extends BlockJUnit4ClassRunnerWithParameters {

    private final Object[] parameters;

    private WebDriverListener webDriverListener;

    public JUnitRunListenerWithParameters(TestWithParameters test) throws InitializationError {
        super(test);
        this.parameters = test.getParameters().toArray(new Object[test.getParameters().size()]);
        webDriverListener = new WebDriverListener();
    }

    public void run(final RunNotifier notifier) {
        notifier.addListener(webDriverListener);
        super.run(notifier);
    }


}
