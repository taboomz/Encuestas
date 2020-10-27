package co.edu.unimagdalena.apmoviles.encuesta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText usuario, contraseña;
    Button inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuario = (EditText)findViewById(R.id.edtCorreo);
        contraseña = (EditText)findViewById(R.id.edtContraseña);
        inicio = (Button) findViewById(R.id.btnLogin);

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(usuario.getText().toString())){
                    if(!TextUtils.isEmpty(contraseña.getText().toString())){
                        login(view);
                    }else{
                        contraseña.setError("Ingrese una contraseña valida");
                    }

                }else{
                    usuario.setError("Ingrese un correo valido");
                }
            }
        });
    }

    protected void onStart(){
        super.onStart();
        checkSession();
    }

    private void checkSession() {
        SessionManagement sessionManagement = new SessionManagement(LoginActivity.this);
        String idUsuario = sessionManagement.getSession();
        if(!idUsuario.isEmpty()){
            irAactividadActivity();
        }


    }

    public void login(View view) {
        String us = usuario.getText().toString();
        String c = contraseña.getText().toString();
        Usuario usuario = new Usuario(us, c);
        SessionManagement sessionManagement = new SessionManagement(LoginActivity.this);
        sessionManagement.savedSession(usuario);
        irAactividadActivity();
    }

    private void irAactividadActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}