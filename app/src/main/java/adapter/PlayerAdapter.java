package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.letstravel.fragmentandrecyclerview.DetailsViewer;
import com.letstravel.fragmentandrecyclerview.R;
import com.letstravel.fragmentandrecyclerview.ui.slideshow.SlideshowFragment;
import java.util.List;
import model.PlayerModel;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>{

    SlideshowFragment context;
    List<PlayerModel> playerModelList;



    public PlayerAdapter(SlideshowFragment context, List<PlayerModel> playerModelList){
        this.context=context;
        this.playerModelList=playerModelList;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.playerview,parent,false);
        return new PlayerViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
    final PlayerModel playerModel=playerModelList.get(position);
        int image_id = playerModel.getImageId();
        final int age = playerModel.getAge();
        holder.ivImage.setImageResource(image_id);
        holder.tvName.setText(playerModel.getName().toString());
        holder.tvAge.setText(String.valueOf(age));
        holder.tvGender.setText(playerModel.getGender().toString());


        holder.ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailsViewer.class);

                final int agee = playerModel.getAge();

                intent.putExtra("name",playerModel.getName());

                intent.putExtra("image",playerModel.getImageId());

                intent.putExtra("age",String.valueOf(agee));

                intent.putExtra("gender",playerModel.getGender());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return playerModelList.size();
    }

    public class PlayerViewHolder extends RecyclerView.ViewHolder{
        ImageView ivImage;
        TextView tvName, tvGender, tvAge;
        Button btndelete;
        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.ivImage);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvGender = itemView.findViewById(R.id.tvGender);
            btndelete = itemView.findViewById(R.id.btndelete);
        }
    }
}
