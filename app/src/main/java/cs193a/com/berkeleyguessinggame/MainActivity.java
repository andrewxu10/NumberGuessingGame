package cs193a.com.berkeleyguessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int num1;
    private int num2;
    private int point = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pickNumbers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void pickNumbers() {
        Button rbutton = (Button) findViewById(R.id.rightButton);
        Button lbutton = (Button) findViewById(R.id.leftButton);
        Random randy = new Random();
        num1 = randy.nextInt(10);
        num2 = randy.nextInt(10);
        while (num1 == num2) {
            num1 = randy.nextInt(10);
            num2 = randy.nextInt(10);
        }
        lbutton.setText(String.valueOf(num1));
        rbutton.setText(String.valueOf(num2));
    }

    public void leftButtonClick(View view) {

        //runs when the left button gets clicked
        if ( num1 > num2 ) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            point++;
        } else {
            Toast.makeText(this, "You are stupid", Toast.LENGTH_SHORT).show();
            point--;
        }
        TextView pointsView = (TextView) findViewById(R.id.pointsView);
        pointsView.setText("Points: " + point);

        pickNumbers();

        if(point == 5){
            Toast.makeText(this, "You have been admitted to Berkeley", Toast.LENGTH_SHORT).show();
        }


    }

    public void rightButtonClick(View view) {

        //runs when the left button gets clicked
        if ( num2 > num1 ) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            point++;
        } else {
            Toast.makeText(this, "You are stupid", Toast.LENGTH_SHORT).show();
            point--;
        }
        TextView pointsView = (TextView) findViewById(R.id.pointsView);
        pointsView.setText("Points: " + point);

        pickNumbers();

        if(point == 5){
            Toast.makeText(this, "You have been admitted to Berkeley", Toast.LENGTH_SHORT).show();
        }

    }
}
