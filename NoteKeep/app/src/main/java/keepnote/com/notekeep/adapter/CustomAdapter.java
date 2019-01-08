package keepnote.com.notekeep.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import keepnote.com.notekeep.R;
import keepnote.com.notekeep.data.FakeDataSource;
import keepnote.com.notekeep.data.ListItem;
import keepnote.com.notekeep.logic.Controller;
import keepnote.com.notekeep.view.ListActivity;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<ListItem> listOfData;
    private Controller controller;
    ListActivity mListActivityContext;

    public CustomAdapter(ListActivity context, List<ListItem> listData, Controller cntrller) {
        mListActivityContext = context;
        listOfData = listData;
        controller = cntrller;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup vg, int viewType) {

        LayoutInflater inflater =LayoutInflater.from(vg.getContext());
        View view =inflater.inflate(R.layout.item_data,vg,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        ListItem currentItem = listOfData.get(position);

        holder.coloredCircle.setBackgroundResource(currentItem.getColorRes());

        holder.dateTime.setText(currentItem.getDateTime());

        holder.msg.setText(currentItem.getMsg());

       /* holder.container.setOnClickListener(view->{

            controller.onListItemClick(listModel);
        });*/

    }

    @Override
    public int getItemCount() {
        return listOfData.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        View coloredCircle;
        TextView dateTime;
        TextView msg;
        ViewGroup container;

        CustomViewHolder(View itemView) {
            super(itemView);

            coloredCircle = itemView.findViewById(R.id.imv_list_item);
            dateTime = itemView.findViewById(R.id.lbl_date_time);
            msg = itemView.findViewById(R.id.lbl_msg);
            container = itemView.findViewById(R.id.root_list_item);

            container.setOnClickListener(view->{
                ListItem listModel = listOfData.get(this.getAdapterPosition());

                if(controller==null){
                    controller = new Controller(mListActivityContext, new FakeDataSource());
                }
                controller.onListItemClick(listModel);
            });

        }

    }

}
