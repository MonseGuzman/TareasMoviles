package com.monse.andrea.practica5;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private ToggleButton EmpezarButton;
    private Spinner ParesSpinner;
    private TableRow Fila1TableRow, Fila2TableRow, Fila3TableRow, Fila4TableRow;
    private ImageButton PrimeraImageButton, SegundoImageButton, TerceraImageButton, CuartaImageButton, QuintoImageButton, SextoImageButton,
            SeptimoImageButton, OctavoImageButton, NovenoImageButton, DecimoImageButton, OnceImageButton, DoceImageButton;
    private TextView IncorrectoTextView, CorrectaTextView;

    ArrayList<Integer> numeros = new ArrayList<>();
    ArrayList<ClaseMemoria> memoria = new ArrayList<>();

    int pares, calcular = 0;
    int correcto = 0;
    int incorrecto = 0;
    boolean ban = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();
        llenarSpinner();

        EmpezarButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked)
                {
                    pares = Integer.valueOf(ParesSpinner.getSelectedItem().toString());

                    switch (pares)
                    {
                        case 6:
                            //que agregue 6
                            Fila1TableRow.setVisibility(View.VISIBLE);
                            Fila2TableRow.setVisibility(View.VISIBLE);

                            llenar();

                            break;
                        case 12:
                            //que agregue 12
                            Fila1TableRow.setVisibility(View.VISIBLE);
                            Fila2TableRow.setVisibility(View.VISIBLE);
                            Fila3TableRow.setVisibility(View.VISIBLE);
                            Fila4TableRow.setVisibility(View.VISIBLE);

                            break;
                    }
                    llenar();
                    ParesSpinner.setEnabled(false);
                    CorrectaTextView.setText("Correctas: 0");
                    IncorrectoTextView.setText("Incorrectas: 0");
                }
                else
                    limpiar();
            }
        });
    }

    private void inicializar()
    {
        EmpezarButton = (ToggleButton)findViewById(R.id.EmpezarButton);
        ParesSpinner = (Spinner)findViewById(R.id.ParesSpinner);
        IncorrectoTextView = (TextView) findViewById(R.id.IncorrectoTextView);
        CorrectaTextView = (TextView)findViewById(R.id.CorrectaTextView);

        Fila1TableRow = (TableRow)findViewById(R.id.Fila1TableRow);
        Fila2TableRow = (TableRow)findViewById(R.id.Fila2TableRow);
        Fila3TableRow = (TableRow)findViewById(R.id.Fila3TableRow);
        Fila4TableRow = (TableRow)findViewById(R.id.Fila4TableRow);

        PrimeraImageButton = (ImageButton)findViewById(R.id.PrimeraImageButton);
        SegundoImageButton = (ImageButton)findViewById(R.id.SegundoImageButton);
        TerceraImageButton = (ImageButton)findViewById(R.id.TerceraImageButton);
        CuartaImageButton = (ImageButton)findViewById(R.id.CuartaImageButton);
        QuintoImageButton = (ImageButton)findViewById(R.id.QuintoImageButton);
        SextoImageButton = (ImageButton)findViewById(R.id.SextoImageButton);

        SeptimoImageButton = (ImageButton)findViewById(R.id.SeptimoImageButton);
        OctavoImageButton = (ImageButton)findViewById(R.id.OctavoImageButton);
        NovenoImageButton = (ImageButton)findViewById(R.id.NovenoImageButton);
        DecimoImageButton = (ImageButton)findViewById(R.id.DecimoImageButton);
        OnceImageButton = (ImageButton)findViewById(R.id.OnceImageButton);
        DoceImageButton = (ImageButton)findViewById(R.id.DoceImageButton);
    }

    private void llenarSpinner()
    {
        String[] pares = new String[]{"6", "12"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, pares);
        ParesSpinner.setAdapter(adapter);
    }

    private void limpiar()
    {
        Fila1TableRow.setVisibility(View.INVISIBLE);
        Fila2TableRow.setVisibility(View.INVISIBLE);
        Fila3TableRow.setVisibility(View.INVISIBLE);
        Fila4TableRow.setVisibility(View.INVISIBLE);

        ParesSpinner.setEnabled(true);
        CorrectaTextView.setText("Correctas: 0");
        IncorrectoTextView.setText("Incorrectas: 0");

        colocarImagenes(0, PrimeraImageButton);
        colocarImagenes(0, SegundoImageButton);
        colocarImagenes(0, TerceraImageButton);
        colocarImagenes(0, CuartaImageButton);
        colocarImagenes(0, QuintoImageButton);
        colocarImagenes(0, SextoImageButton);

        colocarImagenes(0, SeptimoImageButton);
        colocarImagenes(0, OctavoImageButton);
        colocarImagenes(0, NovenoImageButton);
        colocarImagenes(0, DecimoImageButton);
        colocarImagenes(0, OnceImageButton);
        colocarImagenes(0, DoceImageButton);

        PrimeraImageButton.setClickable(true);
        SegundoImageButton.setClickable(true);
        TerceraImageButton.setClickable(true);
        CuartaImageButton.setClickable(true);
        QuintoImageButton.setClickable(true);
        SextoImageButton.setClickable(true);

        SeptimoImageButton.setClickable(true);
        OctavoImageButton.setClickable(true);
        NovenoImageButton.setClickable(true);
        DecimoImageButton.setClickable(true);
        OnceImageButton.setClickable(true);
        DoceImageButton.setClickable(true);

        numeros.clear();

        correcto = 0;
        incorrecto = 0;
        ban = false;
    }

    private void llenar()
    {
        int cont = 0, cont2 = 0, cont3 = 0, cont4 = 0, cont5 = 0, cont6 = 0;
        int numero;

        calcular = (pares / 2) + 1;

        while(numeros.size() < pares)
        {
            //12 - 6
            //6 - 3
            numero = (int) (Math.random() * (1 - calcular) + calcular);

            switch (numero)
            {
                case 1:
                    if (cont < 2)
                    {
                        numeros.add(numero);
                        cont++;
                        Log.d("ah", String.valueOf(numero));
                    }
                    break;
                case 2:
                    if (cont2 < 2) {
                        numeros.add(numero);
                        cont2++;
                        Log.d("ah", String.valueOf(numero));
                    }
                    break;
                case 3:
                    if (cont3 < 2) {
                        numeros.add(numero);
                        cont3++;
                        Log.d("ah", String.valueOf(numero));
                    }
                    break;
                case 4:
                    if (cont4 < 2) {
                        numeros.add(numero);
                        cont4++;
                        Log.d("ah", String.valueOf(numero));
                    }
                    break;
                case 5:
                    if (cont5 < 2) {
                        numeros.add(numero);
                        cont5++;
                        Log.d("ah", String.valueOf(numero));
                    }
                    break;
                case 6:
                    if (cont6 < 2) {
                        numeros.add(numero);
                        cont6++;
                        Log.d("ah", String.valueOf(numero));
                    }
                    break;
            }
        }
    }

    private void colocarImagenes(int posicion, ImageButton alguno)
    {
        switch (posicion)
        {
            case 1:
                alguno.setImageDrawable(getResources().getDrawable(R.drawable.ic_volcan, getTheme()));
                alguno.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                break;
            case 2:
                alguno.setImageDrawable(getResources().getDrawable(R.drawable.ic_bosque, getTheme()));
                alguno.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                break;
            case 3:
                alguno.setImageDrawable(getResources().getDrawable(R.drawable.ic_cascada, getTheme()));
                alguno.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                break;
            case 4:
                alguno.setImageDrawable(getResources().getDrawable(R.drawable.ic_desierto, getTheme()));
                alguno.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                break;
            case 5:
                alguno.setImageDrawable(getResources().getDrawable(R.drawable.ic_mar, getTheme()));
                alguno.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                break;
            case 6:
                alguno.setImageDrawable(getResources().getDrawable(R.drawable.ic_ciudad, getTheme()));
                alguno.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                break;
            default:
                alguno.setImageDrawable(getResources().getDrawable(R.drawable.ic_pregunta, getTheme()));
                alguno.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    private void comprobarPares(int posicion, ImageButton alguno)
    {
        if(memoria.size() == 0) //no hay nada
        {
            colocarImagenes(posicion, alguno);
            memoria.add(new ClaseMemoria(alguno, posicion));
        }
        else /*if(memoria.size() == 1)*/
        {
            memoria.add(new ClaseMemoria(alguno, posicion));

            if(memoria.get(0).getPar() == posicion)
            {
                correcto++;
                colocarImagenes(posicion, alguno);

                CorrectaTextView.setText("Correctas: " + correcto);
                ban = true;

                alguno.setClickable(false);
                memoria.get(0).getBoton().setClickable(false);
            }
            else
            {
                incorrecto++;
                colocarImagenes(posicion, alguno);
                ban = false;
                IncorrectoTextView.setText("Incorrectas: " + incorrecto);
            }

        }
    }

    private void mensaje()
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(R.string.felicidades);
        alert.setIcon(R.drawable.ic_informacion);
        alert.setMessage("Trata de mejorar esto: Incorrectas " + incorrecto);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.setCancelable(false);
        alert.show();
    }

    @Override
    public void onClick(View v)
    {
        if(memoria.size() == 2)
        {
            if(!ban)
            {
                colocarImagenes(0, memoria.get(0).getBoton());
                colocarImagenes(0, memoria.get(1).getBoton());
                memoria.clear();
            }
            else
                memoria.clear();
        }

        switch (v.getId())
        {
            case R.id.PrimeraImageButton:
                comprobarPares(numeros.get(0), PrimeraImageButton);
                break;
            case R.id.SegundoImageButton:
                comprobarPares(numeros.get(1), SegundoImageButton);
                break;
            case R.id.TerceraImageButton:
                comprobarPares(numeros.get(2), TerceraImageButton);
                break;
            case R.id.CuartaImageButton:
                comprobarPares(numeros.get(3), CuartaImageButton);
                break;
            case R.id.QuintoImageButton:
                comprobarPares(numeros.get(4), QuintoImageButton);
                break;
            case R.id.SextoImageButton:
                comprobarPares(numeros.get(5), SextoImageButton);
                break;
            case R.id.SeptimoImageButton:
                comprobarPares(numeros.get(6), SeptimoImageButton);
                break;
            case R.id.OctavoImageButton:
                comprobarPares(numeros.get(7), OctavoImageButton);
                break;
            case R.id.NovenoImageButton:
                comprobarPares(numeros.get(8), NovenoImageButton);
                break;
            case R.id.DecimoImageButton:
                comprobarPares(numeros.get(9), DecimoImageButton);
                break;
            case R.id.OnceImageButton:
                comprobarPares(numeros.get(10), OnceImageButton);
                break;
            case R.id.DoceImageButton:
                comprobarPares(numeros.get(11), DoceImageButton);
                break;
        }

        if(correcto == (calcular-1))
            mensaje();

    }

}
