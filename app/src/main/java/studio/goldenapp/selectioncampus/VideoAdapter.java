package studio.goldenapp.selectioncampus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    List<YoutubeVideo> youtubeVideoList;


    public VideoAdapter() {
    }

    public VideoAdapter(List<YoutubeVideo> youtubeVideoList) {
        this.youtubeVideoList = youtubeVideoList;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_video,parent,false);

        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {

        holder.videoWeb.loadData( youtubeVideoList.get(position).getVideoUrl(),"text/html" ,"utf-8");
    }

    @Override
    public int getItemCount() {
        return youtubeVideoList.size();
    }

    public  class VideoViewHolder extends RecyclerView.ViewHolder{

        WebView videoWeb;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

            videoWeb = (WebView)itemView.findViewById(R.id.webVideoView);

            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient(){

            });
        }
    }
}
