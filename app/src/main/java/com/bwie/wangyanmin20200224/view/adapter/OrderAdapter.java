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
 *@Time:15:03
 *@Description:
 * */
public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private List<OrderBean.ResultBean> list;

    public OrderAdapter(List<OrderBean.ResultBean> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);


        return new OrderViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
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

    class OrderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_hua)
        ImageView imgHua;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.img_good)
        ImageView imgGood;
        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
