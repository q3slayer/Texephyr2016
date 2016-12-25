package org.texephyr.texephyr2k16;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class EventsScreen extends TabActivity implements TabHost.OnTabChangeListener {

    TabHost tabHost;
    Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_screen);

        res = getResources();
        tabHost = getTabHost();
        TabHost.TabSpec computerEventsTab;
        TabHost.TabSpec mechanicalEventsTab;
        TabHost.TabSpec itEventsTab;
        TabHost.TabSpec entcEventsTab;

        tabHost.setOnTabChangedListener(this);

        computerEventsTab = tabHost.newTabSpec("ComputerEventsTab")
                .setIndicator("", getResources()
                .getDrawable(R.drawable.computericon)).setContent(new Intent().setClass(this, ComputerEventsScreen.class));
        tabHost.addTab(computerEventsTab);

        mechanicalEventsTab = tabHost.newTabSpec("MechanicalEventsTab")
                .setIndicator("", getResources()
                        .getDrawable(R.drawable.mechanicalicon)).setContent(new Intent().setClass(this, MechanicalEventsScreen.class));
        tabHost.addTab(mechanicalEventsTab);

        itEventsTab = tabHost.newTabSpec("ItEventsTab")
                .setIndicator("", getResources()
                        .getDrawable(R.drawable.iticon)).setContent(new Intent().setClass(this, ItEventsScreen.class));
        tabHost.addTab(itEventsTab);

        entcEventsTab = tabHost.newTabSpec("ENTCEventsTab")
                .setIndicator("", getResources()
                        .getDrawable(R.drawable.entcicon)).setContent(new Intent().setClass(this, EntcEventsScreen.class));
        tabHost.addTab(entcEventsTab);

        for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
        {
            tabHost.getTabWidget().getChildAt(i).setBackgroundDrawable(this.getResources().getDrawable(R.drawable.tab_default));

        }
        tabHost.setCurrentTab(0);
        tabHost.getTabWidget().getChildAt(0).setBackgroundDrawable(this.getResources().getDrawable(R.drawable.tab_active));

    }

    @Override
    public void onTabChanged(String tabId) {

        for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
        {
            tabHost.getTabWidget().getChildAt(i).setBackgroundDrawable(this.getResources().getDrawable(R.drawable.tab_default));
        }

        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundDrawable(this.getResources().getDrawable(R.drawable.tab_active));

    }
}
