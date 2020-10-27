package co.edu.unimagdalena.apmoviles.encuesta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class EncuestaController {
    private BaseDatos db;
    private Context c;

    public EncuestaController(Context c) {
        this.db = new BaseDatos(c,1);
        this.c = c;
    }

    public void agregarEncuesta(Encuesta e){
        try {
            SQLiteDatabase sql = db.getWritableDatabase();
            ContentValues valores = new ContentValues();
            valores.put(DefBD.col_codigo, e.getCodigo());
            valores.put(DefBD.col_programa, e.getPrograma());
            valores.put(DefBD.col_pc, e.getPc());
            valores.put(DefBD.col_internet, e.getIntrnet());
            valores.put(DefBD.col_telefono, e.getTelefono());
            long id = sql.insert(DefBD.tabla_encuesta, null, valores);
            Toast.makeText(c, "Encuesta registrada", Toast.LENGTH_LONG).show();
            sql.close();
        }
        catch(Exception ex){
            Toast.makeText(c, "Error al agregar encuesta" + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public boolean buscarEncuesta(String codigo){
        String args[] = new String[] {codigo};
        String col[] = new String[] {DefBD.col_codigo,DefBD.col_programa};
        SQLiteDatabase sql = db.getReadableDatabase();
        Cursor c = sql.query(DefBD.tabla_encuesta,null,"codigo=?",args,null,null,null);
        if (c.getCount() > 0){
            db.close();
            return true;
        }
        else{
            db.close();
            return false;
        }
    }

    public void eliminarEncuesta(String codAnt){
        SQLiteDatabase sql = db.getWritableDatabase();
        int cant = sql.delete(DefBD.tabla_encuesta, "codigo=" + codAnt,null);
        sql.close();
        sql.close();
        if (cant == 1) {
            Toast.makeText(c, "Encuesta eliminada", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(c, "Error al eliminar encuesta", Toast.LENGTH_LONG).show();
        }
    }

    public void actualizarEncuesta(Encuesta e, String codAnt){
        SQLiteDatabase sql = db.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(DefBD.col_codigo, e.getCodigo());
        valores.put(DefBD.col_programa, e.getPrograma());
        valores.put(DefBD.col_pc, e.getPc());
        valores.put(DefBD.col_internet, e.getIntrnet());
        valores.put(DefBD.col_telefono, e.getTelefono());

        int cant = sql.update(DefBD.tabla_encuesta,valores,"codigo=" + codAnt,null);
        sql.close();
        if (cant == 1) {
            Toast.makeText(c, "Datos actualizados", Toast.LENGTH_LONG).show();
        }
    }

    public Cursor allEncuestas(){
        try{
            SQLiteDatabase sql = db.getReadableDatabase();
            Cursor c = sql.query(DefBD.tabla_encuesta,null,null,null,null,null,null);
            return c;
        }
        catch (Exception ex){
            Toast.makeText(c, "Error al consultar Encuestas " + ex.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public Cursor allEncuestas2(){
        try{
            SQLiteDatabase sql = db.getReadableDatabase();
            Cursor cur = sql.rawQuery("select codigo as _id , programa, computador, internet, telefono from encuesta", null);
            return cur;
        }
        catch (Exception ex){
            Toast.makeText(c, "Error al consultar Encuestas " + ex.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }
    }
}
