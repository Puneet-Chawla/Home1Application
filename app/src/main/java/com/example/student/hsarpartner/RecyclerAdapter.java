package com.example.student.hsarpartner;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Student on 7/5/2017.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private Context context;
    private String[] titles =
            {"Electrical",
                    "Plumber",
                    "AC Technician",
                    "RO",
                    "Electronics",
                    "Carpenter",
                    "Painter",
                    "Computer, Printer",
                    "Packers and Movers",
                    "Refrigerator"
            };


    private int[] images = {
            R.drawable.electricalpng,
            R.drawable.plumberpng,
            R.drawable.acpng,
            R.drawable.ro,
            R.drawable.home1,
            R.drawable.carpenterpng1,
            R.drawable.painterpng,
            R.drawable.pcpng,
            R.drawable.deliveryman,
    R.drawable.ref};

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView itemImage;
        public TextView itemTitle;


        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();
                    Bundle b=new Bundle();
// oncluck on cardd view i want intent
                    switch(position)
                    {
                        case 0:
                            Intent i=new Intent(context,Registeration.class);
                            b.putString("stuff",String.valueOf(position));
                            i.putExtras(b);
                            context.startActivity(i);

                            break;
                        case 1:
                            Intent i1 = new Intent(context, Registeration.class);
                            b.putString("stuff",String.valueOf(position));
                            i1.putExtras(b);
                            context.startActivity(i1);
                            break;
                        case 2:
                            Intent i2=new Intent(context,Registeration.class);
                            b.putString("stuff",String.valueOf(position));
                            i2.putExtras(b);
                            context.startActivity(i2);
                            break;
                        case 3:
                            Intent i3=new Intent(context,Registeration.class);
                            b.putString("stuff",String.valueOf(position));
                            i3.putExtras(b);
                            context.startActivity(i3);
                            break;
                        case 4:
                            Intent i4=new Intent(context,Registeration.class);
                            b.putString("stuff",String.valueOf(position));
                            i4.putExtras(b);
                            context.startActivity(i4);
                            break;
                        case 5:
                            Intent i5=new Intent(context,Registeration.class);
                            b.putString("stuff",String.valueOf(position));
                            i5.putExtras(b);
                            context.startActivity(i5);
                            break;
                        case 6:
                            Intent i6=new Intent(context,Registeration.class);
                            b.putString("stuff",String.valueOf(position));
                            i6.putExtras(b);
                            context.startActivity(i6);
                            break;
                        case 7:
                            Intent i7=new Intent(context,Registeration.class);
                            b.putString("stuff",String.valueOf(position));
                            i7.putExtras(b);
                            context.startActivity(i7);
                            break;
                        case 8:
                            Intent i8=new Intent(context,Registeration.class);
                            b.putString("stuff",String.valueOf(position));
                            i8.putExtras(b);
                            context.startActivity(i8);
                            break;
                        case 9:
                            Intent i9=new Intent(context,Registeration.class);
                            b.putString("stuff",String.valueOf(position));
                            i9.putExtras(b);
                            context.startActivity(i9);
                            break;


                    }
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
