package com.bwie.wangyanmin20200224.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.wangyanmin20200224.R;
import com.bwie.wangyanmin20200224.model.bean.OrderBean;
import com.bwie.wangyanmin20200224.util.NetUtil;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *@auther:王彦敏
 *@Date: 2020/2/24
 *@Time:14:41
 *@Description:
 * */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private List<OrderBean.ResultBean> list;

    public HomeAdapter(List<OrderBean.ResultBean> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, parent, false);


        return new HomeViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        OrderBean.ResultBean resultBean = list.get(position);
        holder.tvName.setText(resultBean.getNickName());
        holder.tvTime.setText(resultBean.getHandselTime()+"");
        NetUtil.getInstance().getPhoto(resultBean.getGiftPic(),holder.imgGood);
        NetUtil.getInstance().getPhoto(resultBean.getHeadPic(),holder.imgHua);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_good)
        ImageView imgGood;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.img_hua)
        ImageView imgHua;
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
