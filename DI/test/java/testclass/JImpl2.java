package testclass;

import annotations.Inject;
import annotations.Value;

public class JImpl2 implements J {
    private E eDep;

    private boolean[] bools;

    @Value(value = "j.integers", delimiter = "-")
    private Integer[] integers;

    private String[] strings;

    public JImpl2(E eDep) {

    }

    @Inject
    public JImpl2(E eDep, @Value("j.bools") boolean[] bools) {
        this.eDep = eDep;
        this.bools = bools;
    }


    @Override
    public E getEDep() {
        return eDep;
    }

    @Override
    public boolean[] getBools() {
        return bools;
    }

    @Override
    public Integer[] getIntegers() {
        return integers;
    }

    @Override
    public String[] getStrings() {
        return strings;
    }
}
