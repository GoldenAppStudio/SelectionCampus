package studio.goldenapp.selectioncampus;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class three extends Fragment {



    public three() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_three, container, false);

        //final Intent intent = new Intent(getActivity(), Notifications.class);
        final Button button_y =  rootView.findViewById(R.id.button_youtube);

        button_y.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.youtube.com/channel/UCtTbDSiIf7Ii11ovV04LFQw/videos"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        final Intent intent = new Intent(getActivity(), Notifications.class);
        final Button button_notifications = rootView.findViewById(R.id.button_notification);
        button_notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        return rootView;

    }

}
