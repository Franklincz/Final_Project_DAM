package com.example.final_project_dam.IU;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.final_project_dam.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText user ;
    EditText pass;
    Button btnIngresar;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        user= findViewById(R.id.textuser);
        pass=findViewById(R.id.pass);
        btnIngresar = findViewById(R.id.buttonIngresar);




        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String correo = user.getText().toString();
                String clave= pass.getText().toString();


                mAuth.getInstance().signInWithEmailAndPassword(correo ,clave).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){

                        Toast.makeText(MainActivity.this, "Autenticacion correcta", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this , MainActivity.class);
                        startActivity(intent);



                        }
                    else{


                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();


                    }


                    }
                });






            }
        });

























/* para  seleccionar tipo de usuario   a traves del spinner
    Spinner spinner = (Spinner) findViewById(R.id.spinner1);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
            R.array.lista_cambio , android.R.layout.simple_list_item_1);
    adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
    spinner.setAdapter(adapter);











*/





















    }




    /*public void inSecActivity(View view){ // evento boton ingresar
        if(valida()==true) {

            startActivity(new Intent(getApplicationContext(), secondActivity.class));
            Toast toast = Toast.makeText(this,"Has presionado el boton ingresar", Toast.LENGTH_SHORT);
            TextView v = (TextView) toast.getView().findViewById(android.R.id.message); v.setTextColor(Color.GREEN); v.setBackgroundResource(R.color.colorPrimary);
            toast.show();


        }

*/






    }








  /*  public boolean valida(){
                boolean val=false;
                if(user.toString().isEmpty()){
                         Toast.makeText(MainActivity.this, "NO ingreso user", Toast.LENGTH_SHORT).show();
                }else{
                        if(pass.getText().toString().isEmpty()){

                        Toast.makeText(MainActivity.this, "falta password", Toast.LENGTH_SHORT).show();
                     }else{
                        val=true;

                         }
                   }
                return val;
    }






*/




















//}