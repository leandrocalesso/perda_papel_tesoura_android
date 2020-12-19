package com.udemy.pedrapapeloutesouraprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imagem_jagada_robo;
    private TextView  text_ganhou_perdeu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagem_jagada_robo = findViewById( R.id.imagem_jogada_robo );
        text_ganhou_perdeu = findViewById( R.id.text_pergeu_ganhou );
    }

    public void vai_ser_jogada_robo( View view )
    {
        // Figura sorteada.
        int    sorteada    = sorteia_imagem();

        String tag_clicada = ( String ) view.getTag();
        String tag_sorteada= "";

        String jogo_perdeu = "Você perdeu :)";
        String jogo_ganhou = "Você ganhou :)";
        String jogo_empatou= "Você empatou :)";

        if ( sorteada == 1 ) {
            imagem_jagada_robo.setImageResource(R.drawable.pedra);
            tag_sorteada = "pedra";
        }
        else if ( sorteada == 2 ) {
            imagem_jagada_robo.setImageResource(R.drawable.papel);
            tag_sorteada = "papel";
        }
        else if ( sorteada == 3 ) {
            imagem_jagada_robo.setImageResource(R.drawable.tesoura);
            tag_sorteada = "tesoura";
        }

        if ( tag_clicada.equals( tag_sorteada) )
            text_ganhou_perdeu.setText( jogo_empatou );

        else if ( tag_clicada.equals( "pedra" ) && tag_sorteada.equals( "papel" )  )
        {
            text_ganhou_perdeu.setText( jogo_perdeu );
        }
        else if ( tag_clicada.equals( "pedra" ) && tag_sorteada.equals( "tesoura" )  )
        {
            text_ganhou_perdeu.setText( jogo_ganhou );
        }
        //--------------------------------------------------------
        else if ( tag_clicada.equals( "papel" ) && tag_sorteada.equals( "pedra" )  )
        {
            text_ganhou_perdeu.setText( jogo_ganhou );
        }
        else if ( tag_clicada.equals( "papel" ) && tag_sorteada.equals( "tesoura" )  )
        {
            text_ganhou_perdeu.setText( jogo_perdeu );
        }
        else if ( tag_clicada.equals( "papel" ) && tag_sorteada.equals( "papel" )  )
        {
            text_ganhou_perdeu.setText( jogo_ganhou );
        }
        //--------------------------------------------------------
        else if ( tag_clicada.equals( "tesoura" ) && tag_sorteada.equals( "papel" )  )
        {
            text_ganhou_perdeu.setText( jogo_ganhou );
        }
        else if ( tag_clicada.equals( "tesoura" ) && tag_sorteada.equals( "pedra" )  )
        {
            text_ganhou_perdeu.setText( jogo_perdeu );
        }
        else if ( tag_clicada.equals( "tesoura" ) && tag_sorteada.equals( "tesoura" )  )
        {
            text_ganhou_perdeu.setText( jogo_empatou );
        }

    }

    int sorteia_imagem()
    {
        Random random   = new Random();
        int    sorteado = random.nextInt( 3) + 1;
        return sorteado;
    }
}