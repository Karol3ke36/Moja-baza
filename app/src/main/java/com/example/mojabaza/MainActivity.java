package com.example.mojabaza;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    BMWDataBase bmwDataBase;
    Button guzik;
    ListView lista;
    EditText model, typ, rokprod, moc;
    ArrayAdapter<BMW> arrayAdapter;
    List<BMW> modele;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bmwDataBase = Room.databaseBuilder(
                getApplicationContext(),
                BMWDataBase.class,
                "salon_db"
        ).allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();
        guzik = findViewById(R.id.guzik);
        lista = findViewById(R.id.lista);
        model = findViewById(R.id.model);
        moc = findViewById(R.id.moc);
        typ = findViewById(R.id.typ);
        rokprod = findViewById(R.id.rokprod);

        listView = findViewById(R.id.lista);
        modele = bmwDataBase.zwrocAutaDAO().zwrocWszystkieAutaZBazy();
        arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, modele);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {
                bmwDataBase.zwrocAutaDAO().usunZBazy(arrayAdapter.getItem(i));
                modele.remove(i);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });

        guzik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BMW bmw = new BMW(model.getText().toString(),typ.getText().toString(),Integer.parseInt(rokprod.getText().toString()),Integer.parseInt(moc.getText().toString()));
                bmwDataBase.zwrocAutaDAO().wstawDoBazy(bmw);
                modele.add(bmw);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}