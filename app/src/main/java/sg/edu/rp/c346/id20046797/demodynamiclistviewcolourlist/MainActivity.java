package sg.edu.rp.c346.id20046797.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement, etPosition;
    Button btnAdd, btnRmv, btnUpd;
    ListView lvColour;

    ArrayList<String> alColours = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etPosition = findViewById(R.id.editTextPos);

        btnAdd = findViewById(R.id.buttonAddItem);
        btnRmv = findViewById(R.id.buttonRemoveItem);
        btnUpd = findViewById(R.id.buttonUpdateItem);

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
                int iposition;

                if(!(etElement.getText().toString().isEmpty())) {
                    addItem = etElement.getText().toString();
                    cBoolean = true;
                }

                if(etPosition.getText().toString().isEmpty()) {
                    iposition = alColours.size();
                    Toast.makeText(MainActivity.this, "Position number was not specified, assuming Last Position.", Toast.LENGTH_SHORT).show();
                } else {
                    iposition = Integer.parseInt(etPosition.getText().toString());
                }

                if (cBoolean) {
                    alColours.add(iposition, addItem);
                    aaColour.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Colour not Specified, nothing was added.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRmv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int iposition = 0;
                Boolean cBoolean = false;

                if(!(etPosition.getText().toString().isEmpty())) {
                    iposition = Integer.parseInt(etPosition.getText().toString());
                    cBoolean = true;
                }

                if (iposition >= alColours.size()) { // Does not allow the user enter to big of a number (larger than the size of the Index)
                    Toast.makeText(MainActivity.this, "Index is too large.", Toast.LENGTH_SHORT).show();
                    cBoolean = false;
                }

                if (cBoolean) {
                    Toast.makeText(MainActivity.this, "You have deleted the item: " + alColours.get(iposition), Toast.LENGTH_SHORT).show();
                    alColours.remove(iposition);
                    aaColour.notifyDataSetChanged();
                }
            }
        });

        btnUpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean cBoolean = false;
                String addItem = "";
                int iposition = 0;

                if(!(etElement.getText().toString().isEmpty())) {
                    addItem = etElement.getText().toString();
                    cBoolean = true;
                }

                if(!(etPosition.getText().toString().isEmpty())) {
                    iposition = Integer.parseInt(etPosition.getText().toString());
                    cBoolean = true;
                }

                if (iposition >= alColours.size()) { // Does not allow the user enter to big of a number (larger than the size of the Index)
                    Toast.makeText(MainActivity.this, "Index is too large.", Toast.LENGTH_SHORT).show();
                    cBoolean = false;
                }

                if (cBoolean) {
                    Toast.makeText(MainActivity.this, "Replacing Item: " + alColours.get(iposition) + " With: " + addItem, Toast.LENGTH_SHORT).show();
                    alColours.set(iposition, addItem);
                    aaColour.notifyDataSetChanged();
                }
            }
        });


        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = alColours.get(position);
                Toast.makeText(MainActivity.this, "You have selected the Colour " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

