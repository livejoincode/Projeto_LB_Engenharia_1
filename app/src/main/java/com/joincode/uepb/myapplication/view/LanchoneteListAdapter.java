package com.joincode.uepb.myapplication.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import com.joincode.uepb.myapplication.R;
import com.joincode.uepb.myapplication.entitys.Lanchonete;

public class LanchoneteListAdapter extends RecyclerView.Adapter<LanchoneteListAdapter.LanchoneteViewHolder> implements View.OnLongClickListener{

    private final LayoutInflater lInflater;
    private List<Lanchonete> lanchonetes; // cache das lanchonetes

    private OnItemClickListener mListener;

    //pesquisar sobre o click longo para propiciar em excluir lanchonete ou atualizar
    @Override
    public boolean onLongClick(View view) {
        return false;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

   public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
   }


    class LanchoneteViewHolder extends RecyclerView.ViewHolder {
        private final TextView LanchoneteItemView;

        private LanchoneteViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            LanchoneteItemView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }

                    }
                }
            });

        }
    }


    public LanchoneteListAdapter(Context context) {
        lInflater = LayoutInflater.from(context);
    }

    @Override
    public LanchoneteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = lInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new LanchoneteViewHolder(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(LanchoneteViewHolder holder, int position) {
        if (lanchonetes != null) {
            Lanchonete current = lanchonetes.get(position);
            holder.LanchoneteItemView.setText(current.getLanchonete());

        } else {
            // Covers the case of data not being ready yet.
            holder.LanchoneteItemView.setText("Nenhuma Lanchonete");
        }

    }

    void setWords(List<Lanchonete> lanchos){
        lanchonetes = lanchos;
        notifyDataSetChanged();
    }

    // getItemCount () é chamado muitas vezes e, quando é chamado pela primeira vez,
    // A lista de lanchonetes ainda não é vazia (significa inicialmente, é nulo e não podemos retornar null, mas sim 0).
    @Override
    public int getItemCount() {
        if (lanchonetes != null)
            return lanchonetes.size();
        else return 0;
    }
}
