package testclass;

import annotations.Inject;

public class G {

    @Inject
    private C cDep;
    @Inject
    private D dDep;

    public C getCDep() {
        return cDep;
    }

    public D getDDep() {
        return dDep;
    }

}

