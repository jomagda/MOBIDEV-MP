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

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizStackHolder> {

    ArrayList<FlashcardStack> data;

    public QuizAdapter(ArrayList<FlashcardStack> data){
        this.data = data;
    }

    @Override
    public QuizStackHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //create the view for each item on the list
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quiz, parent, false);
        return new QuizStackHolder(v);
    }

    @Override
    public void onBindViewHolder(QuizStackHolder holder, int position) {

        String[] colors = {"#D3D3D3", "#696969"};
        String color = colors[position%2];
        holder.lyQuiz.setBackgroundColor(Color.parseColor(color));

        //we place data on each on the list
        FlashcardStack currentFlashcardStack = data.get(position);
        holder.tvQuiz.setText(currentFlashcardStack.getName());
        holder.ivQuiz.setImageResource(currentFlashcardStack.getIcon());

        // pass data
        holder.lyQuiz.setTag(currentFlashcardStack);

        holder.lyQuiz.setOnClickListener(new View.OnClickListener() {
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

    public class QuizStackHolder extends RecyclerView.ViewHolder{

        TextView tvQuiz;
        ImageView ivQuiz;
        LinearLayout lyQuiz;

        public QuizStackHolder(View itemView) {
            super(itemView);
            //itemView is the view inflated from OnCreateViewHolder
            tvQuiz = itemView.findViewById(R.id.tv_quiz);
            ivQuiz = itemView.findViewById(R.id.iv_quiz);
            lyQuiz = itemView.findViewById(R.id.ly_quiz);
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