package seattlesbest.angtaasapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

/**
 * Created by Ana on 11/13/2017.
 */

public class ViewAllFlashcardAdapter
        extends RecyclerView.Adapter<ViewAllFlashcardAdapter.FlashcardViewHolder> {

    ArrayList<Flashcard> flashCardList;

    public ViewAllFlashcardAdapter(ArrayList<Flashcard> flashCardList) {
        this.flashCardList = flashCardList;
    }

    @Override
    public FlashcardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_listflashcard, parent, false);

        return new FlashcardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FlashcardViewHolder viewHolder, int position) {
        Flashcard currentCard = flashCardList.get(position);
        String filWord = currentCard.get_filWord();
        byte[] outImage = currentCard.get_fcImage();
        ByteArrayInputStream imageStream = new ByteArrayInputStream(outImage);
        Bitmap theImage = BitmapFactory.decodeStream(imageStream);


        viewHolder.tvVafFil.setText(filWord);
        viewHolder.ivVafImage.setImageBitmap(theImage);

        viewHolder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(view.getContext(), ViewFlashcard.class);
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return flashCardList.size();
    }


    public class FlashcardViewHolder extends RecyclerView.ViewHolder{

        TextView tvVafFil;
        ImageView ivVafImage;

        View container;

        public FlashcardViewHolder(View itemView) {
            super(itemView);
            tvVafFil = (TextView) itemView.findViewById(R.id.tv_vafFil);
            ivVafImage = itemView.findViewById(R.id.iv_vafImage);
            container = itemView.findViewById(R.id.item_listflashcard);
        }
    }
}


