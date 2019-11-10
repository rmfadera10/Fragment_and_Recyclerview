package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.letstravel.fragmentandrecyclerview.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import model.PlayerModel;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>{

    Context pcontext;
    List<PlayerModel> playerModelList;



    public PlayerAdapter(Context context, List<PlayerModel> playerModelList){
        this.pcontext=context;
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
    PlayerModel playerModel=playerModelList.get(position);
    holder.circleImageView.setImageResource(playerModel.getImageId());
    holder.txtName.setText(playerModel.getName());
    holder.txtPhoneNo.setText(playerModel.getPhoneNo());
    }

    @Override
    public int getItemCount() {
        return playerModelList.size();
    }

    public class PlayerViewHolder extends RecyclerView.ViewHolder{
        CircleImageView circleImageView;
        TextView txtName,txtPhoneNo;
        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);

            circleImageView=itemView.findViewById(R.id.circularImg);
            txtName=itemView.findViewById(R.id.txtName);
            txtPhoneNo=itemView.findViewById(R.id.txtPhoneNo);
        }
    }
}
