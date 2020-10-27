package co.edu.unimagdalena.apmoviles.encuesta;

public class DefBD {
    public static final String nombreDb = "Encuesta_Univercidad";
    public static final String tabla_encuesta = "encuesta";
    public static final String col_codigo = "codigo";
    public static final String col_programa = "programa";
    public static final String col_pc = "computador";
    public static final String col_internet = "internet";
    public static final String col_telefono = "telefono";

    public static final String create_tabla_encuesta ="CREATE TABLE IF NOT EXISTS " + DefBD.tabla_encuesta + " ( " +
            DefBD.col_codigo + " text primary key, " +
            DefBD.col_programa + " text, " +
            DefBD.col_pc + " text, " +
            DefBD.col_internet + " text, " +
            DefBD.col_telefono + " text" + ");";

}
