package com.example.android.notepad;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ClipboardManager;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NotesCursorAdapter extends SimpleCursorAdapter { ;

    private Context mContext;

    public NotesCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c, from, to);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        Cursor cursor = (Cursor) getItem(position);
        int collaction = cursor.getInt(cursor.getColumnIndexOrThrow(NotePad.Notes.COLUMN_NAME_COLLACTION));
        int unfold = cursor.getInt(cursor.getColumnIndexOrThrow(NotePad.Notes.COLUMN_NAME_UNFOLD));
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.button);
        ImageButton button1 = (ImageButton) view.findViewById(R.id.button3);
        if (collaction == 1) {
            imageButton.setImageResource(R.drawable.baseline_star_rate_white_24dp);
        } else {
            imageButton.setImageResource(R.drawable.baseline_star_border_white_24dp);
        }

        TextView textView = (TextView) view.findViewById(R.id.text3);
        if (unfold == 1) {
            button1.setImageResource(R.drawable.baseline_keyboard_arrow_right_white_24dp);
            textView.setVisibility(View.GONE);
        } else {
            button1.setImageResource(R.drawable.baseline_keyboard_arrow_down_white_24dp);
            textView.setVisibility(View.VISIBLE);
        }
        return view;
    }
}