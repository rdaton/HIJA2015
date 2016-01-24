package hja.practica.ultima.pocketstove;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//http://stackoverflow.com/questions/18413309/how-to-implement-a-viewpager-with-different-fragments-layouts
/**
 * Created by sergio on 24/01/2016.
 */
public  class FirstFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.first_frag, container, false);
        VentanaMatriz unaVentana=new VentanaMatriz();
        unaVentana.initDiagonal(v);
        return v;
    }

    static public  FirstFragment newInstance(String text)
    {
        FirstFragment f = new FirstFragment();
        return f;
    }
}

