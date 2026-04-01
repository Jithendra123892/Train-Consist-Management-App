public class GoodsBogie {

    String type;   // e.g. Cylindrical, Rectangular, Open, Box
    String cargo;  // e.g. Petroleum, Coal, Grain, Cement

    public GoodsBogie(String type, String cargo) {
        this.type  = type;
        this.cargo = cargo;
    }

    public String getType()  { return type; }
    public String getCargo() { return cargo; }

    @Override
    public String toString() {
        return "GoodsBogie [Type: " + type + ", Cargo: " + cargo + "]";
    }
}