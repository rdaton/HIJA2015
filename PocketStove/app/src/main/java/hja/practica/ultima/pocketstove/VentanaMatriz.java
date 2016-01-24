package hja.practica.ultima.pocketstove;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AbsListView;
import android.widget.GridLayout;
import android.widget.TabHost;
import android.widget.TextView;

import static android.widget.GridLayout.spec;


//http://stackoverflow.com/questions/18413309/how-to-implement-a-viewpager-with-different-fragments-layouts
public class VentanaMatriz extends AppCompatActivity {

    static int pestania=0;





    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_matriz);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabMatriz);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pestania=mViewPager.getCurrentItem();
                initDiagonal(view);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ventana_matriz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_ventana_matriz, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    void marcarCelda(int i,int j,View view)
    {
        VentanaPrincipal.unControlador.matrizBool[i][j]=!VentanaPrincipal.unControlador.matrizBool[i][j];
        VentanaPrincipal.unControlador.calculaPorcentaje();
        initDiagonal(view);

       // TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

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
                gv=(GridLayout) findViewById(R.id.tablaOffsuited);
                break;
            case 2:
                gv=(GridLayout) findViewById(R.id.tablaSuited);
                break;
        }

       // GridLayout.LayoutParams params = new GridLayout.LayoutParams(spec(filas), spec(columnas));
       // gv.setLayoutParams(params);
        for (int i=0;i<(filas*columnas);i++) {
            TextView tv = new TextView(view.getContext());
            tv.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);
            //tv.setText("");
            gv.addView(tv);
        }

    }

    public  void initDiagonal (View view) {

      //  int index = mViewPager.getCurrentItem();
      //  View view=mViewPager.getChildAt(index);

       // MyAdapter adapter = ((MyAdapter)mViewPager.getAdapter());
       // MyFragment fragment = adapter.getFragment(index);

        //GridLayout grid = (GridLayout) f.getActivity().findViewById(R.id.tablaDiagonal);

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
            GridLayout grid = (GridLayout) findViewById(R.id.tablaOffsuited);
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
                    container.setTextSize(20);
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
            GridLayout grid = (GridLayout) findViewById(R.id.tablaSuited);
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
                    container.setTextSize(20);
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

    }
    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

           switch (position)
           {
               case 0:  return FirstFragment.newInstance("pestania1");
               break;
               default:

           };
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "DIAGONAL";
                case 1:
                    return "OFFSUITED";
                case 2:
                    return "SUITED";
            }
            return null;
        }
    }
}
