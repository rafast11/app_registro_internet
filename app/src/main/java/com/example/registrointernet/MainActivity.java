package com.example.registrointernet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
EditText txnombre, txcalle, txnumero, txcolonia, txmunicipio, txestado,
    txcompania, txvelocidad,txhora, txfecha, txnumerodispositivos, txtipodispositivos, txotros;
Button btn1;
RadioButton rb5, rb10, rb15, rbmas;
CheckBox cblceluar, cblcomputadora, cbltablet, cbltelevision, cblotros;
Spinner spinner1;
private DatabaseReference Mediciones;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mediciones = FirebaseDatabase.getInstance().getReference("Mediciones");

        txnombre = (EditText)findViewById(R.id.txtnombre);
        txcalle = (EditText)findViewById(R.id.txtcalle);
        txnumero = (EditText)findViewById(R.id.txtnumero);
        txcolonia = (EditText)findViewById(R.id.txtcolonia);
        txmunicipio= (EditText)findViewById(R.id.txtmunicipio);
        txestado = (EditText)findViewById(R.id.txtestado);
        txcompania = (EditText)findViewById(R.id.txtcompania);
        txvelocidad = (EditText)findViewById(R.id.txtvelocidad);
        txhora = (EditText)findViewById(R.id.txthora);
        txfecha = (EditText)findViewById(R.id.txtfecha);
        txnumerodispositivos =(EditText)findViewById(R.id.txtnumerodedispositivos);
        txtipodispositivos = (EditText)findViewById(R.id.txttipodedispositivos);
txotros=(EditText)findViewById(R.id.txtotros);

        rb5= (RadioButton)findViewById(R.id.rbcinco);
        rb10 =(RadioButton)findViewById(R.id.rbdiez);
        rb15 = (RadioButton)findViewById(R.id.rbquince);
        rbmas = (RadioButton)findViewById(R.id.rbmas);

        cblceluar = (CheckBox)findViewById(R.id.cbcelular);
        cblcomputadora =(CheckBox)findViewById(R.id.cbcomputadora);
        cbltablet = (CheckBox)findViewById(R.id.cbtabletas);
        cbltelevision = (CheckBox)findViewById(R.id.cbtelevision);
        cblotros = (CheckBox)findViewById(R.id.cbotros);




    }

    public void registrarmedicion(View view){
    String Nombre = txnombre.getText().toString();
    String Calle = txcalle.getText().toString();
    String Numero = txnumero.getText().toString();
    String Colonia = txcolonia.getText().toString();
    String Municipio = txmunicipio.getText().toString();
    String Estado = txestado.getText().toString();
    String Compania = txcompania.getText().toString();
    String Velocidad = txvelocidad.getText().toString();
    String Hora = txhora.getText().toString();
    String Fecha = txfecha.getText().toString();
String otros= txotros.getText().toString();
String dispositivos="gg ";

//Radio Group para numero de dispositivos
        if(rb5.isChecked()){
            txnumerodispositivos.setText("0-5");
        }else if(rb10.isChecked()){
            txnumerodispositivos.setText("6-10");
        }else if(rb15.isChecked()){
            txnumerodispositivos.setText("11-15");
        }else if(rbmas.isChecked()){
            txnumerodispositivos.setText("Mas de 15");
        }

        String Numero_de_dispositivos= txnumerodispositivos.getText().toString();

//Checklist para tipo de dispositivos

        if(cblceluar.isChecked()){
            dispositivos= txtipodispositivos.getText().toString()+"Celulares";
            txtipodispositivos.setText(dispositivos);
        }else if(cblcomputadora.isChecked()){
            dispositivos= txtipodispositivos.getText().toString()+"Computadoras";
            txtipodispositivos.setText(dispositivos);

        }else if(cbltablet.isChecked()){
            dispositivos= txtipodispositivos.getText().toString()+"Tablets";
            txtipodispositivos.setText(dispositivos);

        }else if(cbltelevision.isChecked()){
            dispositivos= txtipodispositivos.getText().toString()+"Televisiones";
            txtipodispositivos.setText(dispositivos);
        }else if(cblotros.isChecked()){
            dispositivos= txtipodispositivos.getText().toString();
            txtipodispositivos.setText(dispositivos+otros);
        }


        String Tipos_de_dispositivos = txtipodispositivos.getText().toString();

//Registro de datos
    if(TextUtils.isEmpty(Nombre)){
        Toast.makeText(this,"Debe de introducir un nombre",Toast.LENGTH_SHORT).show();

    } else if(TextUtils.isEmpty(Calle)){
        Toast.makeText(this,"Debe escribir en el espacio para Calle",Toast.LENGTH_SHORT).show();
    } else if(TextUtils.isEmpty(Numero)){
        Toast.makeText(this,"Debe escribir en el espacio para Número",Toast.LENGTH_SHORT).show();

    }else if(TextUtils.isEmpty(Colonia)){
        Toast.makeText(this,"Debe escribir en el espacio para Colonia",Toast.LENGTH_SHORT).show();

    }else if (TextUtils.isEmpty(Municipio)){
        Toast.makeText(this,"Debe escribir en el espacio para Municipio",Toast.LENGTH_SHORT).show();

    }else if(TextUtils.isEmpty(Estado)){
        Toast.makeText(this,"Debe escribir en el espacio para Estado",Toast.LENGTH_SHORT).show();

    }else if(TextUtils.isEmpty(Compania)){
        Toast.makeText(this,"Debe escribir en el espacio para Compañia",Toast.LENGTH_SHORT).show();

    }else if(TextUtils.isEmpty(Velocidad)){
        Toast.makeText(this,"Debe escribir en el espacio para Velocidad",Toast.LENGTH_SHORT).show();

    }else if(TextUtils.isEmpty(Hora)){
        Toast.makeText(this,"Debe escribir en el espacio para Hora",Toast.LENGTH_SHORT).show();

    }else if(TextUtils.isEmpty(Fecha)){
        Toast.makeText(this,"Debe escribir en el espacio para Fecha",Toast.LENGTH_SHORT).show();

    }else if(TextUtils.isEmpty(Numero_de_dispositivos)){
        Toast.makeText(this,"Debe escribir en el espacio para Número de dispositivos",Toast.LENGTH_SHORT).show();

    } else if(TextUtils.isEmpty(Tipos_de_dispositivos)){
        Toast.makeText(this,"Debe escribir en el espacio para Tipos de dispositivos",Toast.LENGTH_SHORT).show();

    }
    else{

        //Radiogrup para

        //Registro
        String id =Mediciones.push().getKey();
        Clases leccion= new Clases(id,Nombre,Calle, Numero,Colonia,Municipio,Estado,Compania,Velocidad,Hora,Fecha,Numero_de_dispositivos,Tipos_de_dispositivos);
        Mediciones.child("Registros").child(id).setValue(leccion);
        Toast.makeText(this,"Registro realizado",Toast.LENGTH_SHORT).show();



//Borrar texto  después de registralo
        txnombre.setText("");
        txcalle.setText("");
        txnumero.setText("");
        txcolonia.setText("");
        txmunicipio.setText("");
        txestado.setText("");
        txcompania.setText("");
        txvelocidad.setText("");
        txhora.setText("");
        txfecha.setText("");
        txnumerodispositivos.setText("");
        txtipodispositivos.setText("");

    }

    }
    //Comprobar llenado de datos


}