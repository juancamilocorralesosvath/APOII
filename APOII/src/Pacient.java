public class Pacient {

    // --------------------------
    // constants
    //------------------

    public final static int MALE = 1;
    public final static int FEMALE = 2;

    // ---------------------------------------
    // ATTRIBUTES
    //----------------------------------------

    private int code;
    private String name;
    private String hospital;
    private String info;
    private int sex;
    private Pacient next;

    public Pacient(int code, String name, String hospital, String info, int sex, Pacient next) {
        this.code = code;
        this.name = name;
        this.hospital = hospital;
        this.info = info;
        this.sex = sex;
        this.next = next;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    String getHospital() {
        return hospital;
    }

    public int getSex() {
        return sex;
    }

    public String getInfo() {
        return info;
    }

    public Pacient getNext() {
        return this.next;
    }

    // this method receives a Pacient parameter
    // which alters the next item changing it for another.
    // now it will point to the pacient that comes as a parameter.
    public void changeNext(Pacient pacient) {
        next = pacient;
    }

    // Like doing a hop.
    // it must not be the last in the list (but here they don't do the verification...)

    public void disconnectNext() {
        next = next.next;
    }

    // this method changes the reference to the next object in the structure.
    // now, the next patiente will be the one that comes as a parameter.
    //
    public void insertAfter(Pacient pacient) {
        pacient.next = next;
        next = pacient;
    }

    public static void main(String[] args) {

    }
}
