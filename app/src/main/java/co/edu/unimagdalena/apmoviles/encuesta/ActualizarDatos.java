package co.edu.unimagdalena.apmoviles.encuesta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ActualizarDatos extends AppCompatActivity {

    EditText cod;
    Button actualizar, eliminar;
    RadioButton prom_sistema, prom_mecanica, prom_industrial, prom_mecatronica, c_si, c_no, i_si, i_no, s_si, s_no;
    Encuesta encuesta;
    EncuestaController encuestaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_datos);
        cod =(EditText)findViewById(R.id.edtCod4);
        actualizar = (Button)findViewById(R.id.btnActualizar);
        eliminar = (Button)findViewById(R.id.btnEliminar);
        prom_sistema = (RadioButton)findViewById(R.id.rdSistemas);
        prom_mecanica = (RadioButton)findViewById(R.id.rdMecanica);
        prom_industrial = (RadioButton)findViewById(R.id.rdIndustral);
        prom_mecatronica = (RadioButton)findViewById(R.id.rdMecatronica);
        c_si = (RadioButton)findViewById(R.id.rdCompSi1);
        c_no = (RadioButton)findViewById(R.id.rdCompNo1);
        i_si = (RadioButton)findViewById(R.id.rdIntSi1);
        i_no = (RadioButton)findViewById(R.id.rdIntNo1);
        s_si = (RadioButton)findViewById(R.id.rdTelSi1);
        s_no = (RadioButton)findViewById(R.id.rdTelNo1);
        encuestaController = new EncuestaController(this);
        final String codigoAnt = getIntent().getStringExtra("codigo");
        String codigo = getIntent().getStringExtra("codigo");
        String programa = getIntent().getStringExtra("programa");
        String pc = getIntent().getStringExtra("pc");
        String internet = getIntent().getStringExtra("internet");
        String telefono = getIntent().getStringExtra("telefono");
        cod.setText(codigo);
        if(programa.equalsIgnoreCase("sistemas")) prom_sistema.setChecked(true);
        if(programa.equalsIgnoreCase("mecanica")) prom_mecanica.setChecked(true);
        if(programa.equalsIgnoreCase("industrial")) prom_industrial.setChecked(true);
        if(programa.equalsIgnoreCase("mecatronica")) prom_mecatronica.setChecked(true);

        if(pc.equalsIgnoreCase("si")) c_si.setChecked(true);
        if(pc.equalsIgnoreCase("no")) c_no.setChecked(true);

        if(internet.equalsIgnoreCase("si")) i_si.setChecked(true);
        if(internet.equalsIgnoreCase("no")) i_no.setChecked(true);

        if(telefono.equalsIgnoreCase("si")) s_si.setChecked(true);
        if(telefono.equalsIgnoreCase("no")) s_no.setChecked(true);

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cod.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Ingrese un codigo valido", Toast.LENGTH_LONG).show();
                }else{
                    String c = cod.getText().toString(),
                            p = "sistemas",
                            pc = "si",
                            i = "si",
                            t = "si";

                    if(prom_mecanica.isChecked()){
                        p = "mecanica";
                    } else if(prom_industrial.isChecked()){
                        p = "industrial";
                    } else if (prom_mecatronica.isChecked()){
                        p = "mecatronica";
                    }
                    if (c_no.isChecked()){
                        pc = "no";
                    }
                    if (i_no.isChecked()){
                        i = "no";
                    }
                    if (s_no.isChecked()){
                        t = "no";
                    }
                    encuesta = new Encuesta(c,p,pc,i,t);
                    encuestaController.actualizarEncuesta(encuesta,codigoAnt);

                }
            }


        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cod.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Ingrese un codigo valido que eliminar", Toast.LENGTH_LONG).show();
                }else{
                    encuestaController.eliminarEncuesta(codigoAnt);
                }
            }
        });
    }
}