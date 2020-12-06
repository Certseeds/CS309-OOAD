package testclass;

import annotations.Inject;

public class H {
    @Inject
    private C cDep;
    private D dDep;

    @Inject
    public H(D dDep) {
        this.dDep = dDep;
    }

    public C getCDep() {
        return cDep;
    }

    public D getDDep() {
        return dDep;
    }


}
