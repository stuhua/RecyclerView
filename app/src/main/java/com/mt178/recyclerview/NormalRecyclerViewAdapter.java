package com.mt178.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/8/20.
 */
public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<NormalRecyclerViewAdapter.NomalTextViewHolder> {
    private LayoutInflater mInflater;
    private Context mContext;
    private String[] mTitles;
    private static NomalTextViewHolder.ItemClickListener mListener;


    public NormalRecyclerViewAdapter(Context context) {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        mTitles = context.getResources().getStringArray(R.array.titles);
    }

    @Override
    public NomalTextViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new NomalTextViewHolder(mInflater.inflate(R.layout.item_text, viewGroup, false));
    }


    public void onBindViewHolder(NomalTextViewHolder viewHolder, int position) {
        viewHolder.mTextView.setText(mTitles[position]);
    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.length;
    }

    public static class NomalTextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTextView;

        public NomalTextViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text_view);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.setItemClickListener(v,getPosition());
            }
        }

        public interface ItemClickListener {
            void setItemClickListener(View view,int positon);
        }
    }

    public void setOnItemClick(NomalTextViewHolder.ItemClickListener Listener) {
        mListener = Listener;
    }
}
