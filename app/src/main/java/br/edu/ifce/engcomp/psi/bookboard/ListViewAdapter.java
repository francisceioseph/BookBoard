package br.edu.ifce.engcomp.psi.bookboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by francisco on 13/01/15.
 */
public class ListViewAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<ItemListView> itens;

    public ListViewAdapter(Context context, List<ItemListView> itens) {
        this.inflater = LayoutInflater.from(context);
        this.itens = itens;
    }

    @Override
    public int getCount() {
        return this.itens.size();
    }

    @Override
    public Object getItem(int position) {
        return this.itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemSuport itemHolder;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.fragment_navigation_listview_item, null);
            itemHolder = new ItemSuport();
            itemHolder.textView = ((TextView) convertView.findViewById(R.id.navigationMenuItemTextView));
            itemHolder.imageView = ((ImageView) convertView.findViewById(R.id.navigationMenuItemImageView));
            convertView.setTag(itemHolder);
        }
        else{
            itemHolder = (ItemSuport) convertView.getTag();
        }

        ItemListView item  = itens.get(position);
        itemHolder.textView.setText(item.getTexto());
        itemHolder.imageView.setImageResource(item.getIconeRid());

        return convertView;
    }

    private class ItemSuport {
        ImageView imageView;
        TextView textView;
    }
}
