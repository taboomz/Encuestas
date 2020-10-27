package co.edu.unimagdalena.apmoviles.encuesta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText codigo;
    Button guardar, listado;
    RadioButton prom_sistema, prom_mecanica, prom_industrial, prom_mecatronica, c_si, c_no, i_si, i_no, s_si, s_no;
    ArrayList<RadioButton> listaRadio = new ArrayList<>();
    EncuestaController encuestaController;
    Encuesta encuesta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        codigo =(EditText)findViewById(R.id.edtCod);
        listado = (Button)findViewById(R.id.btnListado);
        guardar = (Button)findViewById(R.id.btnGuardar);
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
        listaRadio.add(prom_sistema);
        listaRadio.add(prom_mecanica);
        listaRadio.add(prom_industrial);
        listaRadio.add(prom_mecatronica);
        listaRadio.add(c_si);
        listaRadio.add(c_no);
        listaRadio.add(i_si);
        listaRadio.add(i_no);
        listaRadio.add(s_si);
        listaRadio.add(s_no);
        encuestaController = new EncuestaController(this);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(codigo.getText().toString()) || !isCheck()){
                    Toast.makeText(getApplicationContext(),"Los datos no pueden ser vacíos", Toast.LENGTH_LONG).show();
                }else{
                    String c = codigo.getText().toString(),
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
                    if (encuestaController.buscarEncuesta(c)){
                        Toast.makeText(getApplicationContext(),"Estudiante ya esta registrado", Toast.LENGTH_LONG).show();
                    }else{
                        encuestaController.agregarEncuesta(encuesta);
                    }

                }
            }
        });

        listado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ListadoActivity.class);
                startActivity(i);
            }
        });

    }

    private boolean isCheck() {
        int cont = 0;
        for (RadioButton r: listaRadio) {
            if (r.isChecked()){
                cont++;
            }
        }
        if(cont == 4) return true;

        return false;
    }

    public void logout(View view) {
        SessionManagement sessionManagement = new SessionManagement(MainActivity.this);
        sessionManagement.removeSession();
        moveToLogin();
    }

    private void moveToLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}