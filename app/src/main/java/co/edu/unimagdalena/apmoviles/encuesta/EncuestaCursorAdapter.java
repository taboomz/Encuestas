package co.edu.unimagdalena.apmoviles.encuesta;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class EncuestaCursorAdapter extends CursorAdapter {
    private int contador = 0;
    public EncuestaCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.fila_encuesta, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView cod = view.findViewById(R.id.txtCodigo);
        TextView prg = view.findViewById(R.id.txtPrograma);
        TextView pc = view.findViewById(R.id.txtPc);
        TextView inter = view.findViewById(R.id.txtInternet);
        TextView tel = view.findViewById(R.id.txtTelefono);
        TextView encuestado = view.findViewById(R.id.txtNumEncuestados);
        String codigo = cursor.getString(0);
        String programa = cursor.getString(1);
        String  pC = cursor.getString(2);
        String internet = cursor.getString(3);
        String telefono = cursor.getString(4);

        encuestado.setText("Encuestado " + String.valueOf(contador + 1));
        cod.setText(codigo);
        pc.setText(pC);
        prg.setText(programa);
        inter.setText(internet);
        tel.setText(telefono);
        contador++;
    }
}
