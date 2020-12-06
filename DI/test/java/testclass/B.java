package testclass;

import annotations.Inject;

public class B {

    private C cDep;
    private D dDep;

    @Inject
    public B(C cDep, D dDep) {

        this.cDep = cDep;
        this.dDep = dDep;
    }

    public C getCDep() {
        return cDep;
    }

    public D getDDep() {
        return dDep;
    }
}
