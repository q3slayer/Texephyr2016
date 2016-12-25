package org.texephyr.texephyr2k16;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Context context;
    List<RowItem> rowItems;

    public CustomAdapter(Context context, List<RowItem> rowItems){
        this.context = context;
        this.rowItems = rowItems;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }

    private class ViewHolder{
        TextView title;
        TextView tagline;
        ImageView image;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.event_row, null);
            holder = new ViewHolder();

            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.tagline = (TextView) convertView.findViewById(R.id.tagline);
            holder.image = (ImageView) convertView.findViewById(R.id.image);

            RowItem row_pos = rowItems.get(position);

            holder.title.setText(row_pos.getTitle());
            holder.tagline.setText(row_pos.gettagline());
            holder.image.setImageResource(row_pos.getImage());

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
}
