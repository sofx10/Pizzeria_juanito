package com.example.pizza_push;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class Mainmostrar extends AppCompatActivity {
private TextView mostrare,res2,res3,res4;
private ImageButton back;
String nombresitos,tamañitos;
int ingredientitos,preciositos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
       mostrare = findViewById(R.id.resp);
       back=findViewById(R.id.imgb_regresar);
       res2 = findViewById(R.id.resp2);
       res3 = findViewById(R.id.resp3);
       res4 = findViewById(R.id.resp4);

        Bundle datos = getIntent().getExtras();
         nombresitos = datos.getString("nombre");
         tamañitos = datos.getString("tamanio");
        ingredientitos = datos.getInt("ingredientes");
         preciositos = datos.getInt("precios");
        mostrare.setText(" " + nombresitos);
        res2.setText(" " + tamañitos);
        res3.setText(" " + ingredientitos);
        res4.setText(" " + preciositos);



    }
}


