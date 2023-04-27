package com.example.appalfandega;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ImageView myImage;
    TextView myText;

    // Animação
    Animation visivel, invisivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImage = findViewById(R.id.imageView);
        myText = findViewById(R.id.textView);

        // Para deixar somente o espaço ocupado da imagem no xml, mas invisível
        myImage.setVisibility(View.INVISIBLE);

        // Inicializa a animação
        visivel = new AlphaAnimation(0,1);
        invisivel = new AlphaAnimation(1,0);

        // Duração do tempo de animação
        visivel.setDuration(1000);
        invisivel.setDuration(1000);
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

        myImage.startAnimation(visivel);

        // Classe Timer para disparar uma ação que irá sumir com a seta.
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                myImage.startAnimation(invisivel);
            }
        }, 2000);
    }
}
