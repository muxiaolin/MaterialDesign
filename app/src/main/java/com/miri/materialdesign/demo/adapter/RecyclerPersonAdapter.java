package com.miri.materialdesign.demo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.miri.materialdesign.demo.R;
import com.miri.materialdesign.demo.model.Person;

import java.util.List;

/**
 * 〈一句话功能简述〉〈功能详细描述〉
 *
 * @author PengL, , 2015/11/30.
 */
public class RecyclerPersonAdapter extends RecyclerView.Adapter<RecyclerPersonAdapter.PersonVH> {

    private OnRecyclerViewListener onRecyclerViewListener;

    public void setOnRecyclerViewListener(OnRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    private final List<Person> persons;

    public RecyclerPersonAdapter(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public PersonVH onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // 给ViewHolder设置布局文件
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item_view, viewGroup, false);
        return new PersonVH(v);
    }

    @Override
    public void onBindViewHolder(PersonVH viewHolder, int position) {
        // 给ViewHolder设置元素
        Person p = persons.get(position);
        viewHolder.nameTv.setText(p.getName());
    }

    @Override
    public int getItemCount() {
        // 返回数据总数
        return persons == null ? 0 : persons.size();
    }


    /**
     * 重写的自定义ViewHolder
     */

    class PersonVH extends RecyclerView.ViewHolder {

        public View rootView;
        public TextView nameTv;

        public PersonVH(View v) {
            super(v);
            nameTv = (TextView) v.findViewById(R.id.tv_full_name);
            rootView = v.findViewById(R.id.card_view);
            rootView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != onRecyclerViewListener) {
                        onRecyclerViewListener.onItemClick(v, getAdapterPosition());
                    }
                }
            });
            rootView.setOnLongClickListener(new OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (null != onRecyclerViewListener) {
                        return onRecyclerViewListener.onItemLongClick(v, getAdapterPosition());
                    }
                    return false;
                }
            });
        }

    }
}
