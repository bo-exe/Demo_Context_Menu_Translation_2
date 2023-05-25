package sg.edu.rp.c346.id22020749.democontextmenutranslation2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText;
    TextView tvTranslatedText2;
    String wordClicked = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText = findViewById(R.id.textViewTranslatedText);
        registerForContextMenu(tvTranslatedText);
        tvTranslatedText2 = findViewById(R.id.textViewTranslatedText2);
        registerForContextMenu(tvTranslatedText2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == tvTranslatedText) {
            wordClicked = "Hello";
        }
        else if(v == tvTranslatedText2) {
            wordClicked = "Bye";
        }
        // Item ID is 0 (second parameter)
        menu.add(0,0,0,"English");
        // Item ID is 1 (second parameter)
        menu.add(0,1,1,"Italian");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(wordClicked.equalsIgnoreCase("Hello")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                tvTranslatedText.setText("Hello");
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) {
                //code for action
                Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
                tvTranslatedText.setText("Ciao");
                return true; //menu item successfully handled
            }
        }

        else if(wordClicked.equalsIgnoreCase("Bye")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                tvTranslatedText2.setText("Bye");
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) {
                //code for action
                Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
                tvTranslatedText2.setText("Addio");
                return true; //menu item successfully handled
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
}