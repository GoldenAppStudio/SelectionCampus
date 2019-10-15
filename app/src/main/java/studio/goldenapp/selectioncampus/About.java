package studio.goldenapp.selectioncampus;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;

public class About extends AppCompatActivity {

    private TextView mTextView;
    private FirebaseDatabase mfirebaseDB = FirebaseDatabase.getInstance();
    final DatabaseReference mRef = mfirebaseDB.getReference("About");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mTextView = findViewById(R.id.text_about);


        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String Contact = String.valueOf(dataSnapshot.getValue());
                if(!TextUtils.isEmpty(Contact)){
                    mTextView.setText(Contact);
                } else {
                    mTextView.setText("No new notification");
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
