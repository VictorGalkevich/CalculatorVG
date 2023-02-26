public class Token {
    private Character ch;
    private Double value;

    public Token() {}

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Character getCh() {
        return ch;
    }

    public void setCh(Character ch) {
        this.ch = ch;
    }
}
