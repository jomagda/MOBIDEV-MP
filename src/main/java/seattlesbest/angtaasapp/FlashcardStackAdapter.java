package seattlesbest.angtaasapp;

/**
 * Created by Dalag, Magdaraog, Raymundo on 11/10/2017.
 */

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class FlashcardStackAdapter extends RecyclerView.Adapter<FlashcardStackAdapter.FlashcardStackHolder> {

    ArrayList<FlashcardStack> data;

    public FlashcardStackAdapter(ArrayList<FlashcardStack> data){
        this.data = data;
    }

    @Override
    public FlashcardStackHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //create the view for each item on the list
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flashcardstack, parent, false);
        return new FlashcardStackHolder(v);
    }

    @Override
    public void onBindViewHolder(FlashcardStackHolder holder, int position) {

        String[] colors = {"#D3D3D3", "#696969"};
        String color = colors[position%2];
        holder.lyFlashcardStack.setBackgroundColor(Color.parseColor(color));

        //we place data on each on the list
        FlashcardStack currentFlashcardStack = data.get(position);
        holder.tvFlashcardStack.setText(currentFlashcardStack.getName());
        holder.ivFlashcardStack.setImageResource(currentFlashcardStack.getIcon());

        // pass data
        holder.lyFlashcardStack.setTag(currentFlashcardStack);

        holder.lyFlashcardStack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FlashcardStack f = (FlashcardStack) view.getTag();
                Log.i("adapter", "You have selected the" + f.getName() + "stack");

                onItemClickListener.onItemClick(f);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class FlashcardStackHolder extends RecyclerView.ViewHolder{

        TextView tvFlashcardStack;
        ImageView ivFlashcardStack;
        LinearLayout lyFlashcardStack;

        public FlashcardStackHolder(View itemView) {
            super(itemView);
            //itemView is the view inflated from OnCreateViewHolder
            tvFlashcardStack = itemView.findViewById(R.id.tv_flashcardStack);
            ivFlashcardStack = itemView.findViewById(R.id.iv_flashcardStack);
            lyFlashcardStack = itemView.findViewById(R.id.ly_flashcardStack);
        }
    }

    public interface OnItemClickListener{
        public void onItemClick(FlashcardStack f);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
}