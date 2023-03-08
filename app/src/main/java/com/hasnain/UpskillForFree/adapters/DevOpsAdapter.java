package com.hasnain.UpskillForFree.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.groupchat.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.hasnain.UpskillForFree.models.DevOpsResponse;
import com.hasnain.UpskillForFree.models.MachineLearningResponse;

public class DevOpsAdapter extends FirebaseRecyclerAdapter<DevOpsResponse,DevOpsAdapter.myViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */

    Context context;

    public DevOpsAdapter(@NonNull FirebaseRecyclerOptions<DevOpsResponse> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull DevOpsAdapter.myViewHolder holder, int position, @NonNull DevOpsResponse model) {

        holder.courseLabel.setText(model.getLabel());
        holder.courseDesc.setText(model.getCourseDesc());

        Glide.with(context).load(model.getImage()).into(holder.image);

        holder.courseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = model.getLink();
                try{
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, "Link will be added soon", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @NonNull
    @Override
    public DevOpsAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.courses_links, parent, false);
        return new DevOpsAdapter.myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView courselink,courseLabel,courseDesc;
        Button courseBtn;
        ImageView image;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            courselink = itemView.findViewById(R.id.courselink);
            courseLabel = itemView.findViewById(R.id.courseLabel);
            courseBtn = itemView.findViewById(R.id.courseBtn);
            courseDesc = itemView.findViewById(R.id.courseDesc);
            image = itemView.findViewById(R.id.image);
        }
    }
}
