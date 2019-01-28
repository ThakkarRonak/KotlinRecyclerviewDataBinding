package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.BR;
import com.example.myapplication.models.User;
import com.example.myapplication.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private ArrayList<User> mArrayListUser = new ArrayList<>();

    private Context mContext;

    public RecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * set arraylist to adapter
     *
     * @param mArrayList
     */
    public void setArrayListUser(ArrayList<User> mArrayList) {
        mArrayListUser = mArrayList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
                R.layout.row_user, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder holder, int position) {
        User obj = getObjForPosition(position);

        //bind object
        holder.bind(obj);
    }

    protected User getObjForPosition(int position) {
        return mArrayListUser.get(position);
    }


    @Override
    public int getItemCount() {
        return mArrayListUser.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;

        public MyViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object obj) {
            binding.setVariable(BR.user, obj);
            binding.executePendingBindings();
        }
    }
}
