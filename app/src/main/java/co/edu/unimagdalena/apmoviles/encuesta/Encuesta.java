package co.edu.unimagdalena.apmoviles.encuesta;

public class Encuesta {
    private String codigo;
    private String programa;
    private String pc;
    private String intrnet;
    private String telefono;

    public Encuesta(String codigo, String programa, String pc, String internet, String telefono) {
        this.codigo = codigo;
        this.programa = programa;
        this.pc = pc;
        this.intrnet = internet;
        this.telefono = telefono;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getPrograma() {
        return programa;
    }

    public String getPc() {
        return pc;
    }

    public String getIntrnet() {
        return intrnet;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public void setIntrnet(String intrnet) {
        this.intrnet = intrnet;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Encuesta{" +
                "codigo='" + codigo + '\'' +
                ", programa='" + programa + '\'' +
                ", pc='" + pc + '\'' +
                ", intrnet='" + intrnet + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
