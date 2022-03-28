package com.example.pizza_push;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Mainresultado extends AppCompatActivity {
private TextView result1,result2,result3,result4;
private ImageButton volver;
String d1,d2;
int d3,d4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainresultado);

     result1 = findViewById(R.id.txt_mostrar2);
        result2 = findViewById(R.id.txt_mostrar3);
        result3 = findViewById(R.id.txt_mostrar4);
        result4 = findViewById(R.id.txt_mostrar5);

     volver = findViewById(R.id.imgb_regresar2);
     Bundle datos = getIntent().getExtras();
        d1 = datos.getString("nombre");
        d2 = datos.getString("tamanio");
        d3 = datos.getInt("ingredientes");
        d4 = datos.getInt("precios");

        result1.setText("Cliente " + d1);
        result2.setText("Tu tipo de pizza es "+ d2);
        result3.setText("El numero de ingredientes que escogiste fueron "+ d3);
        result4.setText("El total a pagar es $ "+ d4);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}