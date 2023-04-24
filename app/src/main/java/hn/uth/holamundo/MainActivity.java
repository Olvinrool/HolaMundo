package hn.uth.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.DecimalFormat;

import hn.uth.holamundo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {



    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();


       setContentView(view);


        binding.btnmas.setOnClickListener(c ->{
            Integer cantidad= Integer.parseInt(binding.etcantidad.getText().toString());
         if(cantidad >= 0){
             cantidad++;
         }
            binding.etcantidad.setText(String.valueOf(cantidad));
            dividirCuenta();
        });



        binding.btnmenos.setOnClickListener(c ->{
            Integer cantidad= Integer.parseInt(binding.etcantidad.getText().toString());
            if(cantidad > 0){
                cantidad--;
            }
            binding.etcantidad.setText(String.valueOf(cantidad));
            dividirCuenta();
        });



        binding.btnCalcular.setOnClickListener(c ->{
            dividirCuenta();


        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Ciclo de vida en ejecucion, ON START", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "Ciclo de vida en ejecucion, ON STOP", Toast.LENGTH_LONG).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "Ciclo de vida en ejecucion, ON DESTROY", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Toast.makeText(this, "Ciclo de vida en ejecucion, ON PAUSE", Toast.LENGTH_LONG).show();
        super.onPause();

    }

    @Override
    protected void onResume() {
               super.onResume();
        Toast.makeText(this, "Ciclo de vida en ejecucion, ON RESUME", Toast.LENGTH_LONG).show();
    }

    private void dividirCuenta() {
        Double monto= Double.parseDouble(binding.ettotal.getText().toString());
        Integer cantidad= Integer.parseInt(binding.etcantidad.getText().toString());


        if (monto == null || monto <= 0){
            Toast.makeText(this, getString(R.string.error_monto_invalido), Toast.LENGTH_SHORT).show();
        } else if(cantidad == null || cantidad <= 0){
            Toast.makeText(this, getString(R.string.error_peronas_invalido), Toast.LENGTH_SHORT).show();
        }else {

            Double resultado = monto / cantidad;
            DecimalFormat formato = new DecimalFormat("#,##0.0");
            String montoTexto = getString(R.string.label_monto_dividido, formato.format(resultado));

            binding.tvResultado.setText(montoTexto);

        }
    }
}