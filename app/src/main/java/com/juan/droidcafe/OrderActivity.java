package com.juan.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.juan.droidcafe.extra.MESSAGE";
   public String mOrderMessage;
   TextView txt_producto;
   ImageView imagen_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_order);
       txt_producto = findViewById(R.id.txt_producto);
       imagen_2 = findViewById(R.id.image_2);
       Intent intent = getIntent();
       mOrderMessage = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
       txt_producto.setText(mOrderMessage);

       //mostrar la imagen del producto pedido con in if
        if(mOrderMessage.equals(getString(R.string.donut_order_message))){
            //ha pedido un donut

            imagen_2.setImageResource(R.drawable.donut_circle);
        }else if(mOrderMessage.equals(getString(R.string.ice_cream_order_message))){

            imagen_2.setImageResource(R.drawable.icecream_circle);
        }else if(mOrderMessage.equals(getString(R.string.froyo_order_message))){
            imagen_2.setImageResource(R.drawable.froyo_circle);
        }


    }


    public void displayToast(String message) { // displayToast no sirve para hacer referencia hacia los 3 donas froyo ice cran
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked? Está ahora marcado el botón?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked. Compruebe en qué botón de opción se hizo clic.
        switch (view.getId()) {
            case R.id.radioBtn_uno:
                if (checked)
                    // Same day service. Servicio el mismo día
                    displayToast("Servisio de entrega el mismo dia");
                break;
            case R.id.radioBtn_dos:
                if (checked)
                    // Next day delivery. Entrega al día siguiente
                    displayToast("Entrega al siguiente dia");
                break;
            case R.id.radioBtn_tres:
                if (checked)
                    // Pick up, Recoger
                    displayToast("Recoger en tienda");
                break;
            default:
                // Do nothing.
                break;
        }
    }




}


