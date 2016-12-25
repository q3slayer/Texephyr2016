package org.texephyr.texephyr2k16;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends Activity {

    Button aboutButton;
    Button eventsButton;
    Button contactButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        aboutButton = (Button) findViewById(R.id.aboutButton);
        eventsButton = (Button) findViewById(R.id.eventsButton);
        contactButton = (Button) findViewById(R.id.contactButton);

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, AboutScreen.class);
                startActivity(intent);
            }
        });

        eventsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, EventsScreen.class);
                startActivity(intent);
            }
        });

        contactButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, ContactScreen.class);
                startActivity(intent);
            }
        });
    }
}
