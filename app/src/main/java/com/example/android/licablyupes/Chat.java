package com.example.android.licablyupes;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.HashMap;
import java.util.Map;

public class Chat extends AppCompatActivity {
    LinearLayout layout;
    ImageView sendButton;
    EditText messageArea;
    ScrollView scrollView;
    Firebase reference1, reference2;
    NotificationManager mNotificationManager ;
    int NOTIFICATION_ID = 1 ;
    private static final String WATER_REMINDER_NOTIFICATION_CHANNEL_ID = "reminder_notification_channel";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        layout = (LinearLayout) findViewById(R.id.layout1);
        sendButton = (ImageView) findViewById(R.id.sendButton);
        messageArea = (EditText) findViewById(R.id.messageArea);
        scrollView = (ScrollView) findViewById(R.id.scrollView);

        Firebase.setAndroidContext(this);
        reference1 = new Firebase("https://my-chat-fe751.firebaseio.com/" + UserDetails.username + "_" + UserDetails.chatWith);
        reference2 = new Firebase("https://my-chat-fe751.firebaseio.com/" +
                "" + UserDetails.chatWith + "_" + UserDetails.username);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = messageArea.getText().toString();

                if (!messageText.equals("")) {
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("message", messageText);
                    map.put("user", UserDetails.username);
                    reference1.push().setValue(map);
                    reference2.push().setValue(map);
                }
            }
        });

        reference1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Map map = dataSnapshot.getValue(Map.class);
                String message = map.get("message").toString();
                String userName = map.get("user").toString();



                if (userName.equals(UserDetails.username)) {
                    addMessageBox("You:-\n" + message, 1);
                } else {
                    addMessageBox(UserDetails.chatWith + ":-\n" + message, 2);
                    Notification(message);
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    public void addMessageBox(String message, int type) {
        TextView textView = new TextView(Chat.this);
        textView.setText(message);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 0, 0, 10);
        textView.setLayoutParams(lp);

        if (type == 1) {
            textView.setBackgroundResource(R.drawable.rounded_corner1);
        } else {
            textView.setBackgroundResource(R.drawable.rounded_corner2);
        }

        layout.addView(textView);
        scrollView.fullScroll(View.FOCUS_DOWN);
    }

    private static final int WATER_REMINDER_NOTIFICATION_ID = 1138;
 public  void  Notification (String message){

     mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

         NotificationChannel mChannel = new NotificationChannel(
             WATER_REMINDER_NOTIFICATION_CHANNEL_ID,
          "primary",
             NotificationManager.IMPORTANCE_HIGH);
     mNotificationManager.createNotificationChannel(mChannel);
     NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this,WATER_REMINDER_NOTIFICATION_CHANNEL_ID)

             .setSmallIcon(R.drawable.message)
             .setContentTitle("New Message from " + UserDetails.chatWith)
             .setContentText(message)
             .setOnlyAlertOnce(true)
             .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
     mBuilder.setAutoCancel(true);
     mBuilder.setLocalOnly(false);


     mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());

 }
}


}