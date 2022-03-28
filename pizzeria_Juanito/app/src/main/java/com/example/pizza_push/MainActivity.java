package com.example.pizza_push;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

//declaro las variables
public class MainActivity extends AppCompatActivity {
private RadioButton personal;
private RadioButton grande;
private RadioButton gigante;
private CheckBox peperoni;
private CheckBox jamon;
    private CheckBox carne;
    private CheckBox piña;
    private CheckBox aceitunas;
    private CheckBox quesos;
    private CheckBox hongas;
   private ImageButton pinguino;
   private ImageButton clean;
   private EditText tuname;
   int cash= 0;
   private String nombre;
   private String pizzasmall;
   int toppings= 0;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //los mando a llamar
        personal=findViewById(R.id.radio_personal);
        grande=findViewById(R.id.radio_grande);
        gigante= findViewById(R.id.radio_gigante);

        peperoni=findViewById(R.id.checkpepe);
        jamon=findViewById(R.id.checkjamon);
        carne=findViewById(R.id.checkcarne);
        piña=findViewById(R.id.checkpina);
        aceitunas=findViewById(R.id.checkacei);
        quesos=findViewById(R.id.checkchess);
        hongas=findViewById(R.id.checkhongas);

        pinguino=findViewById(R.id.imgb_clupenguin);
        clean=findViewById(R.id.imgb_limpie);

        tuname= findViewById(R.id.edt_name);

        pinguino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calcular();
            }
        });
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

public void calcular(){
    // Tamanio de pizza
    if (personal.isChecked()==true){
        pizzasmall="pizza personal";
        cash=cash+5;
    }
    if (grande.isChecked()==true){
        pizzasmall="pizza grande";
        cash=cash+7;
    }
    if (gigante.isChecked()==true){
        pizzasmall="pizza gigante";
        cash=cash+11;
    }
// ingredientes
    if (peperoni.isChecked()==true){
        toppings=toppings+1;
        cash=cash+2;
    }
    if (jamon.isChecked()==true){
        toppings=toppings+1;
        cash=cash+2;
    }
    if (carne.isChecked()==true){
        toppings=toppings+1;
        cash=cash+2;
    }
    if (piña.isChecked()==true){
        toppings=toppings+1;
        cash=cash+2;
    }
    if (aceitunas.isChecked()==true){
        toppings=toppings+1;
        cash=cash+2;
    }
    if (quesos.isChecked()==true){
        toppings=toppings+1;
        cash=cash+2;
    }
    if (hongas.isChecked()==true){
        toppings= toppings+1;
        cash=cash+2;
    }
    if(personal.isChecked()==false&&grande.isChecked()==false&&gigante.isChecked()==false){
        Toast.makeText(MainActivity.this, "selecciona el tamaño de tu pizza", Toast.LENGTH_SHORT).show();
        cash=0;
    }

    else if (tuname.getText().toString().equals("")){
        Toast.makeText(MainActivity.this, "ingrese su nombre", Toast.LENGTH_SHORT).show();
        cash=0;



    }
    else if (peperoni.isChecked()==false&&jamon.isChecked()==false&&carne.isChecked()==false&&piña.isChecked()==false&&aceitunas.isChecked()==false&&quesos.isChecked()==false&&hongas.isChecked()==false){

        Toast.makeText(MainActivity.this, "selecciona por lo menos un ingrediente", Toast.LENGTH_SHORT).show();


    }

    else {
        nombre=tuname.getText().toString();
        Intent precios = new Intent(getApplicationContext(), Mainresultado.class);
        Bundle datos = new Bundle();
        datos.putString("nombre",nombre);
        datos.putString("tamanio",pizzasmall);
        datos.putInt("ingredientes",toppings);
        datos.putInt("precios",cash);
        precios.putExtras(datos);
        startActivity(precios);
        cash=0;
    }
}

}
