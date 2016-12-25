package org.texephyr.texephyr2k16;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EntcEventsScreen extends Activity {

    ListView eventList;

    String[] title;
    String[] tagline;
    TypedArray image;
    String[] desc;
    String[] rules;
    String[] contact;

    List<RowItem> rowItems;

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entc_events_screen);

        rowItems = new ArrayList<RowItem>();
        title = getResources().getStringArray(R.array.title_entc);
        tagline = getResources().getStringArray(R.array.tagline_entc);
        image = getResources().obtainTypedArray(R.array.image_entc);
        desc = getResources().getStringArray(R.array.desc_entc);
        rules = getResources().getStringArray(R.array.rules_entc);
        contact = getResources().getStringArray(R.array.contact_entc);

        for(int i = 0; i < title.length; i++){
            RowItem rowItem = new RowItem(title[i], tagline[i], image.getResourceId(i, -i));
            rowItems.add(rowItem);
        }

        eventList = (ListView) findViewById(R.id.eventList);
        CustomAdapter adapter = new CustomAdapter(this, rowItems);
        eventList.setAdapter(adapter);

        eventList = (ListView) findViewById(R.id.eventList);
        eventList.setFastScrollEnabled(true);

        eventList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long idn) {
                dialog = new Dialog(EntcEventsScreen.this);
                dialog.setContentView(R.layout.dialog_event);
                dialog.setTitle(title[position]);
                dialog.setCancelable(true);

                TextView text_desc = (TextView) dialog.findViewById(R.id.desc);
                text_desc.setText(desc[position]);

                TextView text_rules = (TextView) dialog.findViewById(R.id.rules);
                text_rules.setText(rules[position]);

                TextView text_contact = (TextView) dialog.findViewById(R.id.contact);
                text_contact.setText(contact[position]);

                ImageView img = (ImageView) dialog.findViewById(R.id.image);
                img.setImageDrawable(image.getDrawable(position));

                dialog.show();
            }
        });
    }
}
