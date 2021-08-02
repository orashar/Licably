package com.example.android.licablyupes.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.android.licablyupes.DriverHomePage;
import com.example.android.licablyupes.R;

import java.util.List;

public class UserListAdapter extends ArrayAdapter<String> {

    boolean isbool  ;
    private final UserAdapterchat mClickHandler;

    public interface UserAdapterchat {
        void onClick(String chat , boolean islocation);
    }

    public UserListAdapter(Context context, int resource, List<String> users, DriverHomePage users1, UserAdapterchat mClickHandler) {
        super(context, resource, users);
        this.mClickHandler = mClickHandler;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_1, parent, false);
        }


        String message = getItem(position) ;
        TextView username = (TextView) listItemView.findViewById(R.id.text1);
        ImageButton chat  = (ImageButton) listItemView.findViewById(R.id.message);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isbool = false ;
                String chatWith = getItem(position);
                mClickHandler.onClick(chatWith , isbool);
            }
        });
        ImageButton location = (ImageButton) listItemView.findViewById(R.id.location);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isbool = true ;
                String chatWith = getItem(position);
                mClickHandler.onClick(chatWith , isbool);
            }
        });
        username.setText(message);
        return listItemView;
    }
}
