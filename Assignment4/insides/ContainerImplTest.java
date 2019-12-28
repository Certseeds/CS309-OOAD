package insides;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import insides.test.*;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("WeakerAccess")
public class ContainerImplTest {
    
    private Container container;
    
    @BeforeEach
    public void setup() {
        System.out.println(0);
        this.container = new ContainerImpl();
    }
    
    @Test
    public void createNewContainer() {
        System.out.println(1);
        new ContainerImpl();
    }
    
    @Test
    public void testRegister() {
        System.out.println(2);
        try {
            container.register(A.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testRegisterWithImpl() {
        System.out.println(3);
        container.register(E.class, EImpl.class);
    }
    
    @Test
    public void testRegisterNull() {
        System.out.println(4);
        assertThrows(IllegalArgumentException.class, () -> {
            container.register(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            container.register(null, null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            container.register(E.class, null);
        });
    }
    
    @Test
    public void testResolveNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            container.resolve(null);
        });
    }
    
    @Test
    public void testRegisterAbstractClassOrInterface() {
        assertThrows(IllegalArgumentException.class, () -> {
            container.register(F.class);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            container.register(E.class);
        });
    }
    
    @Test
    public void testResolveWithNoDependency() {
        try {
            container.register(A.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        A instance = container.resolve(A.class);
        assertNotNull(instance);
    }
    
    @Test
    public void testWithConstructorDependency() {
        try {
            container.register(B.class);
            container.register(C.class);
            container.register(D.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        B instance = container.resolve(B.class);
        assertNotNull(instance);
        assertNotNull(instance.getCDep());
        assertNotNull(instance.getDDep());
    }
    
    @Test
    public void testWithAnnotationDependency() {
        try {
            container.register(G.class);
            container.register(C.class);
            container.register(D.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        G instance = container.resolve(G.class);
        assertNotNull(instance);
        assertNotNull(instance.getCDep());
        assertNotNull(instance.getDDep());
    }
    
    @Test
    public void testWithDependencyNotFound() {
        try {
            container.register(B.class);
            container.register(C.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        var exception = assertThrows(ServiceNotFoundException.class, () -> {
            container.resolve(B.class);
        });
    }
    
    @Test
    public void testServiceNotFound() {
        var exception = assertThrows(ServiceNotFoundException.class, () -> {
            container.resolve(A.class);
        });
    }
    
    @Test
    public void testMixedDependencies() {
        try {
            container.register(H.class);
            container.register(C.class);
            container.register(D.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        H instance = container.resolve(H.class);
        assertNotNull(instance);
        assertNotNull(instance.getCDep());
        assertNotNull(instance.getDDep());
    }
    
    @Test
    public void testImplTypeForInterface() {
        container.register(E.class, EImpl.class);
        E instance = container.resolve(E.class);
        assertNotNull(instance);
        assertTrue(instance instanceof EImpl);
    }
    
    @Test
    public void testImplTypeForAbstractClass() {
        container.register(F.class, FEnhanced.class);
        F instance = container.resolve(F.class);
        assertNotNull(instance);
        assertTrue(instance instanceof FEnhanced);
    }
    
    @Test
    public void testDependencyImpl() {
        try {
            container.register(K.class);
            container.register(E.class, EImpl.class);
            container.register(F.class, FEnhanced.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        K instance = container.resolve(K.class);
        assertNotNull(instance);
        assertNotNull(instance.getEDep());
        assertNotNull(instance.getFDep());
        assertTrue(instance.getEDep() instanceof EImpl);
        assertTrue(instance.getFDep() instanceof FEnhanced);
    }
    
    @Test
    public void testRegisterClassWithMultipleConstructors() {
        assertThrows(IllegalArgumentException.class, () -> {
            container.register(L.class);
        });
    }
    
    @Test
    public void testFieldWithoutInject() {
        try {
            container.register(M.class);
            container.register(C.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        M instance = container.resolve(M.class);
        assertNotNull(instance);
        assertNull(instance.getCDep());
    }
}
