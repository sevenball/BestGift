package com.wangshiqi.bestgift.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wangshiqi.bestgift.R;
import com.wangshiqi.bestgift.model.bean.ColomnBean;

import java.util.List;

/**
 * Created by dllo on 16/9/18.
 */
public class ColomnRvAdapter extends RecyclerView.Adapter<ColomnRvAdapter.CategoryStrategyViewHolder> {
    private static final int TYPE_ITEM = 1, TYPE_FOOT = 2;
    private Context context;
    private List<ColomnBean.DataBean.ColumnsBean> datas;

    public ColomnRvAdapter(Context context) {
        this.context = context;
    }


    public void setDatas(List<ColomnBean.DataBean.ColumnsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        int type = TYPE_ITEM;
        if (position == getItemCount() - 1) {
            type = TYPE_FOOT;
        }
        return type;
    }

    @Override
    public CategoryStrategyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case TYPE_ITEM:
                view = LayoutInflater.from(context).inflate(R.layout.item_colomn_rv, parent, false);
                break;
            case TYPE_FOOT:
                view = LayoutInflater.from(context).inflate(R.layout.item_foot_view, parent, false);
                break;
        }

        return new CategoryStrategyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryStrategyViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TYPE_ITEM:
                ColomnBean.DataBean.ColumnsBean bean = datas.get(position);
                Picasso.with(context).load(bean.getBanner_image_url()).into(holder.imageView);
                holder.titileTv.setText(bean.getTitle());
                if (bean.getSubtitle() != null) {
                    holder.subTitleTv.setText(bean.getSubtitle());
                } else {
                    holder.subTitleTv.setText("");
                }
                holder.authorTv.setText(bean.getAuthor());
                break;
            case TYPE_FOOT:
                holder.footTv.setText("点击查看更多");
                break;
        }

    }

    @Override
    public int getItemCount() {
        return datas != null && datas.size() > 0 ? datas.size() : 0;
    }

    class CategoryStrategyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView titileTv, authorTv, subTitleTv, footTv;

        public CategoryStrategyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_strategy_iv);
            titileTv = (TextView) itemView.findViewById(R.id.item_strategy_title_tv);
            subTitleTv = (TextView) itemView.findViewById(R.id.item_strategy_subTitle_tv);
            authorTv = (TextView) itemView.findViewById(R.id.item_strategy_author_tv);
            footTv = (TextView) itemView.findViewById(R.id.foot_tv);
        }
    }
}
