package co.edu.unimagdalena.apmoviles.encuesta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class ListadoActivity extends AppCompatActivity {

    ListView listado;
    EncuestaController encuestaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        listado = (ListView)findViewById(R.id.listListado);
        encuestaController = new EncuestaController(this);
        Cursor c = encuestaController.allEncuestas2();
        EncuestaCursorAdapter ecursor = new EncuestaCursorAdapter(this, c, false);
        listado.setAdapter(ecursor);
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView cod = view.findViewById(R.id.txtCodigo);
                TextView prg = view.findViewById(R.id.txtPrograma);
                TextView pc = view.findViewById(R.id.txtPc);
                TextView inter = view.findViewById(R.id.txtInternet);
                TextView tel = view.findViewById(R.id.txtTelefono);
                /*Toast.makeText(getApplicationContext(),cod.getText().toString(),Toast.LENGTH_LONG).show();*/
                String codigo = cod.getText().toString();
                String programa = prg.getText().toString();
                String  pC = pc.getText().toString();
                String internet = inter.getText().toString();
                String telefono = tel.getText().toString();
                actualizaDatos(view, codigo, programa, pC, internet, telefono);
            }
        });
    }

    private void actualizaDatos(View view, String codigo, String programa, String pC, String internet, String telefono) {
        Intent i = new Intent(this, ActualizarDatos.class);
        i.putExtra("codigo", codigo);
        i.putExtra("programa", programa);
        i.putExtra("pc", pC);
        i.putExtra("internet", internet);
        i.putExtra("telefono", telefono);
        startActivity(i);
    }
}