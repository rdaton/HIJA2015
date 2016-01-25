package hja.practica.ultima.pocketstove;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import hja.practica.ultima.pocketstove.R;
public class VentanaMatriz extends AppCompatActivity {
    static int pestania=0;
    Spinner spCartas=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_matriz);

        final SeekBar unSlide=(SeekBar) findViewById(R.id.unSlider);
        unSlide.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
           public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
                /*int i = seekBar.getProgress();
                int a = multiplos5(i);
                VentanaPrincipal.unControlador.porcentajeBaker(a);*/
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
                /*int i = seekBar.getProgress();
                int a = multiplos5(i);
                VentanaPrincipal.unControlador.porcentajeBaker(a);*/
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                int i = seekBar.getProgress();
                int a = multiplos5(i);
                VentanaPrincipal.unControlador.porcentajeBaker(a);
            }
        } );


                spCartas = (Spinner) findViewById(R.id.comboTipoCarta);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.array_selector,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCartas.setAdapter(adapter);



    }
    void marcarCelda(int i,int j,View view)
    {
        VentanaPrincipal.unControlador.matrizBool[i][j]=!VentanaPrincipal.unControlador.matrizBool[i][j];
        VentanaPrincipal.unControlador.calculaPorcentaje();
        initDiagonal(view);
    }
    void crearGrid(int filas, int columnas,int tipo,View view)
    {
        GridLayout gv=null;

        switch(tipo)
        {
            case 0:
                gv=(GridLayout) findViewById(R.id.tablaDiagonal);
                break;
            case 1:
                gv=(GridLayout) findViewById(R.id.tablaDiagonal);
                break;
            case 2:
                gv=(GridLayout) findViewById(R.id.tablaDiagonal);
                break;
        }

        // GridLayout.LayoutParams params = new GridLayout.LayoutParams(spec(filas), spec(columnas));
        // gv.setLayoutParams(params);
        gv.removeAllViews();
        for (int i=0;i<(filas*columnas);i++) {
            TextView tv = new TextView(view.getContext());
            tv.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);
            //tv.setText("");
            gv.addView(tv);
        }

    }

    public int cambiarPestania()
    {
        int r=spCartas.getSelectedItemPosition();
        return r;
    }
    public  void initDiagonal (View view) {
        //  int index = mViewPager.getCurrentItem();
        //  View view=mViewPager.getChildAt(index);

        // MyAdapter adapter = ((MyAdapter)mViewPager.getAdapter());
        // MyFragment fragment = adapter.getFragment(index);

        //GridLayout grid = (GridLayout) f.getActivity().findViewById(R.id.tablaDiagonal);
        VentanaMatriz.pestania=cambiarPestania();
        int numeroElementos = tRango.enumRango.toArrayChar().length;


        if (VentanaMatriz.pestania==0)
        {

            GridLayout grid = (GridLayout) findViewById(R.id.tablaDiagonal);
            crearGrid(13,1,VentanaMatriz.pestania,view);

            for (int i = 0; i < numeroElementos; i++) {
                TextView container = (TextView) grid.getChildAt(i);
                String unString=container.getText().toString();
                final int r = i;
                int fila = i % numeroElementos;
                int columna = fila;

                container.setText(VentanaPrincipal.unControlador.matrizRangos[fila][columna]);
                container.setTextSize(20);
                if (VentanaPrincipal.unControlador.matrizBool[r][r])
                    container.setTextColor(Color.RED);
                else
                    container.setTextColor(Color.BLACK);

                container.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        marcarCelda(r, r, view);

                        // jLabel1.setText(String.valueOf(VentanaPrincipal._unControlador.porcentajeManual));
                    }
                });
            }
        }
        //Offsuited
        else if (VentanaMatriz.pestania==1)
        {
            GridLayout grid = (GridLayout) findViewById(R.id.tablaDiagonal);
            crearGrid(13,13,VentanaMatriz.pestania,view);

            for (int i = 0; i < numeroElementos*numeroElementos; i++) {
                TextView container = (TextView) grid.getChildAt(i);
                String unString=container.getText().toString();

                int fila = i % numeroElementos;
                int columna = i / numeroElementos;

                final int a = fila;
                final int b = columna;
                if (VentanaPrincipal.unControlador.esIzquierda(fila,columna)) {
                    container.setText(VentanaPrincipal.unControlador.matrizRangos[fila][columna]);
                    container.setTextSize(14);
                    if (VentanaPrincipal.unControlador.matrizBool[a][b])
                        container.setTextColor(Color.RED);
                    else
                        container.setTextColor(Color.BLACK);

                    container.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            marcarCelda(a, b, view);

                            // jLabel1.setText(String.valueOf(VentanaPrincipal._unControlador.porcentajeManual));
                        }
                    });
                }
            }
        }
        //Suited
        else if (VentanaMatriz.pestania==2)
        {
            GridLayout grid = (GridLayout) findViewById(R.id.tablaDiagonal);
            crearGrid(13,13,VentanaMatriz.pestania,view);

            for (int i = 0; i < numeroElementos*numeroElementos; i++) {
                TextView container = (TextView) grid.getChildAt(i);
                //   String unString = container.getText().toString();

                int fila = i % numeroElementos;
                int columna = i / numeroElementos;

                final int t = fila;
                final int j = columna;

                if (!VentanaPrincipal.unControlador.esIzquierda(fila, columna)
                        &&!VentanaPrincipal.unControlador.esDiagonal(fila, columna)) {
                    container.setText(VentanaPrincipal.unControlador.matrizRangos[fila][columna]);
                    container.setTextSize(14);
                    if (VentanaPrincipal.unControlador.matrizBool[t][j])
                        container.setTextColor(Color.RED);
                    else
                        container.setTextColor(Color.BLACK);

                    container.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            marcarCelda(t, j, view);

                            // jLabel1.setText(String.valueOf(VentanaPrincipal._unControlador.porcentajeManual));
                        }
                    });
                }
            }
        }
        TextView unLabel = (TextView) findViewById(R.id.labelPorcentaje);
        Double porc=VentanaPrincipal.unControlador.porcentajeManual;
        unLabel.setText(String.format("%.5f", porc).toString());
    }

    public int multiplos5 (int porcentaje) {
        if (porcentaje>=100) return 100;

        boolean fallo = false;

        int i = 0;

        while (!fallo && i <= 20) {
            fallo = (porcentaje <= (i * 5));
            i++;
        }

            return (i - 2) * 5;
    }
/*
    public void ponerPorcentaje(View view)
    {
        SeekBar unSlider = (SeekBar) findViewById(R.id.unSlider);
        unSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int i = seekBar.getProgress();
                int a = multiplos5(i);
                VentanaPrincipal.unControlador.porcentajeBaker(a);
            }
        });


    }*/
}

