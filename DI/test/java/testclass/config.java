package testclass;

import annotations.Inject;
import annotations.Value;

public class config {
    @Inject
    A a;
    @Inject
    B b;
    @Inject
    C c;
    @Inject
    D d;
    @Inject
    E e;
    @Inject
    F f;
    @Inject
    G g;
    @Inject
    H h;
    @Inject
    J j;
    @Inject
    K k;
    @Inject
    L l;
    @Inject
    M m;
    @Value("config.short")
    short shor;
    @Value("config.byte")
    byte byt;
    @Value("config.string")
    String str;
    @Value("config.double")
    double doubl;
    @Value("config.float")
    float floa;
    @Value("config.char")
    char cha;
    @Value("config.int")
    int in;
    @Value("config.long")
    long lon;
    @Value("config.boolean")
    boolean boolea;
    @Value("config.short")
    Short shor2;
    @Value("config.byte")
    Byte byt2;
    @Value("config.double")
    Double doubl2;
    @Value("config.float")
    Float floa2;
    @Value("config.char")
    Character cha2;
    @Value("config.int")
    Integer in2;
    @Value("config.long")
    Long lon2;
    @Value("config.boolean")
    Boolean boolea2;
    @Value("config.field.str")
    String field_str;
    @Value("config.field.list")
    String[] field_list;
    @Value("config.list.integer")
    Integer[] list_integer;
    @Value("config.list.integer")
    int[] list_integer2;
    @Value(value = "config.list.double.delimiter", delimiter = "!!")
    double[] list_double_delimiter;
    @Value(value = "config.list.double.delimiter", delimiter = "!!")
    Double[] list_double_delimiter2;
    @Value("config.list.string")
    String[] list_string;
    @Value("config.list.boolean")
    Boolean[] list_boolean;
    @Value("config.list.boolean")
    boolean[] list_boolean2;
    @Value("config.list.byte")
    Byte[] List_byte;
    @Value("config.list.byte")
    byte[] List_byte2;
    @Value("config.list.float")
    Float[] list_float;
    @Value("config.list.float")
    float[] list_float2;
    @Value("config.list.long")
    Long[] list_long;
    @Value("config.list.long")
    long[] list_long2;
    @Value("config.list.short")
    Short[] list_short;
    @Value("config.list.short")
    short[] list_short2;
    @Value("config.list.char")
    Character[] list_char;
    @Value("config.list.char")
    char[] list_char2;
    @Value("config.setter.double")
    Double double3;
    @Value("config.setter.double")
    double double4;
    String constructor_str;
    @Value("config.field.int")
    int field_int;

    public config() {
    }

    @Inject
    public config(@Value("config.constructor.str") String str, E e) {
        this.e = e;
        this.constructor_str = str;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    public C getC() {
        return c;
    }

    public D getD() {
        return d;
    }

    public E getE() {
        return e;
    }

    public F getF() {
        return f;
    }

    public G getG() {
        return g;
    }

    public H getH() {
        return h;
    }

    public J getJ() {
        return j;
    }

    public K getK() {
        return k;
    }

    public L getL() {
        return l;
    }

    public M getM() {
        return m;
    }

    public short getShor() {
        return shor;
    }

    public byte getByt() {
        return byt;
    }

    public String getStr() {
        return str;
    }

    public double getDoubl() {
        return doubl;
    }

    public float getFloa() {
        return floa;
    }

    public char getCha() {
        return cha;
    }

    public int getIn() {
        return in;
    }

    public long getLon() {
        return lon;
    }

    public boolean isBoolea() {
        return boolea;
    }

    public Short getShor2() {
        return shor2;
    }

    public Byte getByt2() {
        return byt2;
    }

    public Double getDoubl2() {
        return doubl2;
    }

    public Float getFloa2() {
        return floa2;
    }

    public Character getCha2() {
        return cha2;
    }

    public Integer getIn2() {
        return in2;
    }

    public Long getLon2() {
        return lon2;
    }

    public boolean getBoolea() {
        return boolea;
    }

    public Boolean getBoolea2() {
        return boolea2;
    }

    public String getField_str() {
        return field_str;
    }

    public String[] getField_list() {
        return field_list;
    }

    public Integer[] getList_integer() {
        return list_integer;
    }

    public int[] getList_integer2() {
        return list_integer2;
    }

    public double[] getList_double_delimiter() {
        return list_double_delimiter;
    }

    public Double[] getList_double_delimiter2() {
        return list_double_delimiter2;
    }

    public String[] getList_string() {
        return list_string;
    }

    public Boolean[] getList_boolean() {
        return list_boolean;
    }

    public boolean[] getList_boolean2() {
        return list_boolean2;
    }

    public Byte[] getList_byte() {
        return List_byte;
    }

    public byte[] getList_byte2() {
        return List_byte2;
    }

    public Float[] getList_float() {
        return list_float;
    }

    public float[] getList_float2() {
        return list_float2;
    }

    public Long[] getList_long() {
        return list_long;
    }

    public long[] getList_long2() {
        return list_long2;
    }

    public Short[] getList_short() {
        return list_short;
    }

    public short[] getList_short2() {
        return list_short2;
    }

    public Character[] getList_char() {
        return list_char;
    }

    public char[] getList_char2() {
        return list_char2;
    }

    public Double getDouble3() {
        return double3;
    }

    public void setDouble3(Double double3) {
        this.double3 = double3;
    }

    public double getDouble4() {
        return double4;
    }

    public void setDouble4(double double4) {
        this.double4 = double4;
    }

    public String getConstructor_str() {
        return constructor_str;
    }

    public int getField_int() {
        return field_int;
    }
}
