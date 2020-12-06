import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import testclass.A;
import testclass.B;
import testclass.D;
import testclass.E;
import testclass.EImpl;
import testclass.F;
import testclass.FEnhanced;
import testclass.G;
import testclass.H;
import testclass.J;
import testclass.JImpl;
import testclass.K;
import testclass.L;
import testclass.M;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BeanFactoryLocalJudge {

    private static BeanFactory beanFactory;

    @BeforeAll
    static void setup() {
        beanFactory = new BeanFactoryImpl();
        beanFactory.loadInjectProperties(new File("DI/inject.properties"));
        beanFactory.loadValueProperties(new File("DI/value.properties"));
    }

    @Test
    public void testResolveWithNoDependency() {
        A instance = beanFactory.createInstance(A.class);
        assertNotNull(instance);
    }

    @Test
    public void testWithConstructorDependency() {
        B instance = beanFactory.createInstance(B.class);
        assertNotNull(instance);
        assertNotNull(instance.getCDep());
        assertNotNull(instance.getDDep());
    }

    @Test
    public void testWithAnnotationDependency() {
        G instance = beanFactory.createInstance(G.class);
        assertNotNull(instance);
        assertNotNull(instance.getCDep());
        assertNotNull(instance.getDDep());
    }

    @Test
    public void testMixedDependencies() {
        H instance = beanFactory.createInstance(H.class);
        assertNotNull(instance);
        assertNotNull(instance.getCDep());
        assertNotNull(instance.getDDep());
    }

    @Test
    public void testImplTypeForInterface() {
        E instance = beanFactory.createInstance(E.class);
        assertNotNull(instance);
        assertTrue(instance instanceof EImpl);
    }

    @Test
    public void testImplTypeForAbstractClass() {
        F instance = beanFactory.createInstance(F.class);
        assertNotNull(instance);
        assertTrue(instance instanceof FEnhanced);
    }

    @Test
    public void testDependencyImpl() {
        K instance = beanFactory.createInstance(K.class);
        assertNotNull(instance);
        assertNotNull(instance.getEDep());
        assertNotNull(instance.getFDep());
        assertTrue(instance.getEDep() instanceof EImpl);
        assertTrue(instance.getFDep() instanceof FEnhanced);
    }

    @Test
    public void testConstructorInject() {
        L instance = beanFactory.createInstance(L.class);
        assertNotNull(instance);
        assertNotNull(instance.getBDep());
        assertTrue(instance.isBool());
    }

    @Test
    public void testFieldWithValue() {
        D instance = beanFactory.createInstance(D.class);
        assertEquals(10, instance.getVal());
    }

    @Test
    public void testPrimitiveArrayValues() {
        J instance = beanFactory.createInstance(J.class);
        assertNotNull(instance);
        assertTrue(instance instanceof JImpl);
        assertArrayEquals(new boolean[]{true, false, false, true}, instance.getBools());
    }

    @Test
    public void testWrappedPrimitiveArrayValues() {
        J instance = beanFactory.createInstance(J.class);
        assertNotNull(instance);
        assertTrue(instance instanceof JImpl);
        assertArrayEquals(new Integer[]{2, 3, 5, 7, 11}, instance.getIntegers());
    }

    @Test
    public void testStringArrayValues() {
        J instance = beanFactory.createInstance(J.class);
        assertNotNull(instance);
        assertTrue(instance instanceof JImpl);
    }

    @Test
    public void testM() {
        M instance = beanFactory.createInstance(M.class);
        assertNotNull(instance);
        assertTrue(instance.isbool());
        assertFalse(instance.isBool());
    }
}
