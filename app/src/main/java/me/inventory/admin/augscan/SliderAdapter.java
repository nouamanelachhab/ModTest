package me.inventory.admin.augscan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public SliderAdapter(Context context)
    {
        this.context = context;

    }
    public int[] slide_images = {
            R.drawable.movies,
            R.drawable.download,
            R.drawable.free,

    };
    public String[] slide_headings = {
            "Movies,TV Series unlimited",
            "Downloadable content, Available offline",
            "100% Free, All Services are free",


    };
    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject( View view,  Object o) {
        return view ==(RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide1,container,false);
        ImageView slideImageView = (ImageView) view.findViewById(R.id.imageView2);
        TextView slideHeading =(TextView) view.findViewById(R.id.textView3);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
