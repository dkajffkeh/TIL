package me.patrick.laboratory.testextension;

import me.patrick.laboratory.customtag.CustomTestAnnotation;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;

public class FindSlowTestExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private long THRESHOLD;

    public FindSlowTestExtension(long THRESHOLD) {
        this.THRESHOLD = THRESHOLD;
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        String testClassName = context.getRequiredTestClass().getName();
        Method requiredTestMethod = context.getRequiredTestMethod();
        ExtensionContext.Store store = context.getStore(ExtensionContext.Namespace.create(testClassName, requiredTestMethod.getName()));
        store.put("START_TIME", System.currentTimeMillis());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        String testClassName = context.getRequiredTestClass().getName();
        Method requiredTestMethod = context.getRequiredTestMethod();
        CustomTestAnnotation annotation = requiredTestMethod.getAnnotation(CustomTestAnnotation.class);

        ExtensionContext.Store store = context.getStore(ExtensionContext.Namespace.create(testClassName, requiredTestMethod.getName()));
        long start_time = store.remove("START_TIME", long.class);
        long duration = System.currentTimeMillis() - start_time;
        if(duration > THRESHOLD){
            System.out.printf("please consider mark method [%s] with @SlowTest. \n", requiredTestMethod.getName());
        }

    }

}
