package test.java.testclass;


import main.java.annotations.Inject;

public class G {

    public C getCDep() {
        return cDep;
    }

    public D getDDep() {
        return dDep;
    }

    @Inject
    private C cDep;

    @Inject
    private D dDep;

}

