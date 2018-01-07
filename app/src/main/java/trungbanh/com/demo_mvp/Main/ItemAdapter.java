package trungbanh.com.demo_mvp.Main;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import trungbanh.com.demo_mvp.Push.PushStatusActivity;
import trungbanh.com.demo_mvp.R;

/**
 * Created by banhtrung on 1/5/2018.
 */

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<ItemObject> itemObjects;

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_FOOTER = 2;

    ItemAdapter (ArrayList<ItemObject> itemObjects) {
        this.itemObjects = itemObjects;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER) {
            View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.header_item, parent, false);
            return new HeaderViewHolder (v);
        } else if(viewType == TYPE_FOOTER) {
            View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.footer_item, parent, false);
            return new FooterViewHolder(v);
        } else if(viewType == TYPE_ITEM) {
            View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.item_layout, parent, false);
            return new ItemViewHolder (v);
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {


        if (holder instanceof  HeaderViewHolder) {
            ((HeaderViewHolder) holder).edt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),PushStatusActivity.class) ;
                    v.getContext().startActivity(intent);
                }
            });
            ((HeaderViewHolder) holder).img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            // zậy Đăng nhập tài khoảnh của Git đi man 


        }
        if (holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).status.setText(itemObjects.get(position-1).getStatus());
            ((ItemViewHolder) holder).name.setText(itemObjects.get(position-1).getName());
            ((ItemViewHolder) holder).avt.setImageResource(R.drawable.a);
            ((ItemViewHolder) holder).like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemObjects.get(position-1).getLike().equals(false)) {
                        itemObjects.get(position-1).setLike(true);
                        ((ItemViewHolder) holder).like.setImageResource(R.drawable.liked);
                    } else {
                        itemObjects.get(position-1).setLike(false);
                        ((ItemViewHolder) holder).like.setImageResource(R.drawable.like);
                    }
                }
            });
        }
        if( holder instanceof FooterViewHolder) {

        }

    }

    @Override
    public int getItemCount() {
        return itemObjects.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;

        } else if (isPositionFooter(position)) {
            return TYPE_FOOTER;
        }

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position==0;
    }
    private boolean isPositionFooter(int position) {
        return position== itemObjects.size()+1;
    }


    class HeaderViewHolder extends RecyclerView.ViewHolder {

        Button edt ;
        ImageView img ;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            edt = itemView.findViewById(R.id.btn_editstatus);
            img = itemView.findViewById(R.id.img_img);
        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView avt;
        TextView name ;
        TextView status ;
        ImageView like ;

        public ItemViewHolder(View v) {
            super(v);
            avt = v.findViewById(R.id.img_avata);
            name = v.findViewById(R.id.tv_nick);
            status = v.findViewById(R.id.tv_status) ;
            like = v.findViewById(R.id.img_like);
        }
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View v) {
            super(v);

        }

    }
}
