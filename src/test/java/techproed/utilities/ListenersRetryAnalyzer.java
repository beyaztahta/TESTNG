package techproed.utilities;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
public class ListenersRetryAnalyzer implements IAnnotationTransformer {
    //    Bu sinifin amaci, TUM FAILE TEST CASELERI BIR KEZ DAHA automaik olarak xml file ile run etmek.
    // bu sinif ListenersRetry sinfifni xml de kullanabilmek icin olusturuldu.

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
//        Bu sinif ListenersRetry util classina baglidir
        annotation.setRetryAnalyzer(ListenersRetry.class);
    }
}