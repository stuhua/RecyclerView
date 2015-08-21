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

    /**
     * 构造函数
     *
     * @param context 上下文
     * @param titles  String[] 相当于ArrayList
     */
    public NormalRecyclerViewAdapter(Context context, String[] titles) {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.mTitles = titles;
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
                mListener.onItemClick(v, getPosition());
            }
        }

        /**
         * 接口  用于点击Item
         */
        public interface ItemClickListener {
            void onItemClick(View view, int positon);
        }
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
                mListener.onItemClick(v, getPosition());
            }
        }

        /**
         * 接口  用于点击Item
         */
        public interface ItemClickListener {
            void onItemClick(View view, int positon);
        }
    }

    /**
     * 给外部提供的方法
     *
     * @param Listener 匿名内部类，自定义实现里面的方法
     */
    public void setOnItemClick(NomalTextViewHolder.ItemClickListener Listener) {
        mListener = Listener;
    }
}
