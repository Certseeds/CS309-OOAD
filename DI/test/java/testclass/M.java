package testclass;

import annotations.Inject;
import annotations.Value;

public class M {

    private B bDep;

    @Value("m.boolvalue")
    private boolean bool;
    @Value("m.Boolvalue")
    private Boolean Bool;

    public M() {

    }

    @Inject
    public M(B bDep, @Value("l.val") boolean bool) {
        this.bDep = bDep;
        this.bool = bool;
    }

    public B getBDep() {
        return bDep;
    }

    public boolean isbool() {
        return bool;
    }

    public boolean isBool() {
        return Bool;
    }
}
