package net.simplifiedlearning.volleymysqlexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Belal on 10/18/2017.
 */

public class TogelAdapter extends RecyclerView.Adapter<TogelAdapter.TogelViewHolder> {


    private Context mCtx;
    private List<Togel> togelList;

    public TogelAdapter(Context mCtx, List<Togel> togeltList) {
        this.mCtx = mCtx;
        this.togelList = togeltList;
    }

    @Override
    public TogelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.togel_list, null);
        return new TogelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TogelViewHolder holder, int position) {
        Togel togel = togelList.get(position);

        holder.imageView.setText(togel.getPeriod());
        holder.textViewTitle.setText(togel.getDay());
        holder.textViewShortDesc.setText(togel.getDate());
        holder.textViewRating.setText(String.valueOf(togel.getNumber()));

    }

    @Override
    public int getItemCount() {
        return togelList.size();
    }

    class TogelViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating,  imageView;

        public TogelViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
