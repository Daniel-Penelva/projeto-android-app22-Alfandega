package com.example.appalfandega;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView myImage;
    TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImage = findViewById(R.id.imageView);
        myText = findViewById(R.id.textView);

        // Para deixar somente o espaço ocupado da imagem no xml, mas invisível
        myImage.setVisibility(View.INVISIBLE);
    }

    public void eventClick(View view){

        // Sorteando a direção aleatóriamente
        if(Math.random() < 0.5){
            // Para deixar visível a imagem
            myImage.setVisibility(View.VISIBLE);
            myText.setText("Siga para a direita!");
            myImage.setScaleX(-1f);
        }else{
            myImage.setVisibility(View.VISIBLE);
            myText.setText("Siga para a esquerda!");
            myImage.setScaleX(1f);
        }
    }
}
