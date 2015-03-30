package br.edu.ifce.engcomp.psi.bookboard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.edu.ifce.engcomp.psi.model.Book;
import br.edu.ifce.engcomp.psi.util.ImageUtil;

/**
 * Created by FAMÍLIA on 29/03/2015.
 */
public class LibraryAdapter extends BaseAdapter {

    private Context context;
    private List<Book> bookList;

    public LibraryAdapter(Context context, List<Book> bookList){
        this.context = context;
        this.bookList = bookList;
    }

    @Override
    public int getCount() {
        return bookList.size();
    }

    @Override
    public Object getItem(int position) {
        return bookList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listitem,parent,false);
        }

        TextView title = (TextView)convertView.findViewById(R.id.textView1);
        TextView author = (TextView)convertView.findViewById(R.id.textView2);

        Book book = bookList.get(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView1);
        //Bitmap bitmap =  ImageUtil.changeSizeImage(book.getImage(), imageView.getWidth(), imageView.getHeight());
        Bitmap bitmap = BitmapFactory.decodeByteArray(book.getImage(),0,book.getImage().length);
        imageView.setImageBitmap(bitmap);

        title.setText(book.getTitle());
        author.setText(book.getAuthor());

        return convertView;
    }
}
