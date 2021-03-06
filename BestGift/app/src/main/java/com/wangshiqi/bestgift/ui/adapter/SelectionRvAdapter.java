package com.wangshiqi.bestgift.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.wangshiqi.bestgift.R;
import com.wangshiqi.bestgift.model.bean.SelectionRvBean;
import com.wangshiqi.bestgift.utils.ScreenSizeUtil;
import com.wangshiqi.bestgift.utils.SelectionOnRvItemClick;

import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * 首页-精选页面-横向Rv适配器
 */
public class SelectionRvAdapter extends RecyclerView.Adapter<SelectionRvAdapter.SelectionRvViewHolder> {
    private Context context;
    private List<SelectionRvBean.DataBean.SecondaryBannersBean> datas;
    private SelectionOnRvItemClick selectionOnRvItemClick;

    public void setSelectionOnRvItemClick(SelectionOnRvItemClick selectionOnRvItemClick) {
        this.selectionOnRvItemClick = selectionOnRvItemClick;
    }

    public SelectionRvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<SelectionRvBean.DataBean.SecondaryBannersBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public SelectionRvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_selection_rv, parent, false);
        SelectionRvViewHolder holder = new SelectionRvViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final SelectionRvViewHolder holder, final int position) {
        final SelectionRvBean.DataBean.SecondaryBannersBean bean = datas.get(position);
        Picasso.with(context).load(bean.getImage_url()).resize(ScreenSizeUtil.getScreenWidth(context) / 5, ScreenSizeUtil.getScreenHeight(context) / 8).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectionOnRvItemClick != null) {
                    int p = holder.getLayoutPosition();
                    selectionOnRvItemClick.onRvItemClickListener(p, bean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas != null && datas.size() > 0 ? datas.size() : 0;
    }


    class SelectionRvViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        public SelectionRvViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_select_iv);
        }
    }
}
