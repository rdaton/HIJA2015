package hja.practica.ultima.pocketstove;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class VentanaPrincipal extends AppCompatActivity {

    public static tControlador unControlador=new tControlador();
    private Spinner spposicion, spdecision, sptipo;
    TextView editText;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ventana_principal);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
       /* fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        })*/

        // http://androideity.com/2011/08/27/controles-de-seleccion-en-android-spinner/
        spposicion = (Spinner) findViewById(R.id.comboPosicion);
        ArrayAdapter  adapter = ArrayAdapter.createFromResource(this,R.array.array_posiciones,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spposicion.setAdapter(adapter);

        spdecision = (Spinner) findViewById(R.id.comboDecision);
        ArrayAdapter  adapterDecision = ArrayAdapter.createFromResource(this,R.array.array_decision,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spdecision.setAdapter(adapterDecision);

        sptipo = (Spinner) findViewById(R.id.comboTipo);
        ArrayAdapter  adapterTipo = ArrayAdapter.createFromResource(this,R.array.array_tipo,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sptipo.setAdapter(adapterTipo);



        /*sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/

    }



    public void mostrarEvaluador(View view)
    {
        Intent intent  = new Intent(this, VentanaMatriz.class);
        startActivity(intent);

    }

    public void parsear(View view)
    {
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();

        unControlador.parseaEntrada(message);

        return;
    }

    public void recuperarEstados (View view) {

        int  pos, decision, tipo;
        String mensaje ="";

        decision  = spdecision.getSelectedItemPosition();
        pos = spposicion.getSelectedItemPosition();
        tipo = sptipo.getSelectedItemPosition();

        if (unControlador.evaluar(pos,decision,tipo)){

             mensaje = "bien";

        }
        else {
                mensaje ="mal";
        }
        editText = (TextView) findViewById(R.id.labelMensajeEva);
        editText.setText(mensaje);
    }
}
