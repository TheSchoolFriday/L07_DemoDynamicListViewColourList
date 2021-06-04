package sg.edu.rp.c346.id20046797.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement, etPosition;
    Button btnAdd;
    ListView lvColour;

    ArrayList<String> alColours = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etPosition = findViewById(R.id.editTextPos);

        btnAdd = findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listViewColour);

        alColours.add("Red");
        alColours.add("Orange");
        ArrayAdapter aaColour = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean cBoolean = false;
                String addItem = "";
                int Number;

                if(!(etElement.getText().toString().isEmpty())) {
                    addItem = etElement.getText().toString();
                    cBoolean = true;
                }

                if(etPosition.getText().toString().isEmpty()) {
                    Number = alColours.size();
                    Toast.makeText(MainActivity.this, "Position number was not specified, assuming Last Position.", Toast.LENGTH_SHORT).show();
                } else {
                    Number = Integer.parseInt(etPosition.getText().toString());
                }

                if (cBoolean) {
                    alColours.add(Number, addItem);
                    aaColour.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Colour not Specified, nothing was added.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

