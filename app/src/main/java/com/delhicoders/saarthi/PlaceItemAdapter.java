package com.delhicoders.saarthi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.delhicoders.saarthi.PlaceSelectionFragment.OnListFragmentInteractionListener;
import com.delhicoders.saarthi.models.RoutePlace;
import com.github.vipulasri.timelineview.TimelineView;

import java.util.ArrayList;

public class PlaceItemAdapter extends RecyclerView.Adapter<PlaceItemAdapter.ViewHolder> {

    private final ArrayList<RoutePlace> mValues;
    private final OnListFragmentInteractionListener mListener;

    public PlaceItemAdapter(ArrayList<com.delhicoders.saarthi.models.RoutePlace> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_fragment_place, parent, false);
        return new ViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNameView.setText(mValues.get(position).name);
        holder.mTimeView.setText(mValues.get(position).duration.text);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item_fragment_place has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position,getItemCount());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mNameView;
        public final TextView mTimeView;
        public RoutePlace mItem;
        public TimelineView timelineView;

        public ViewHolder(View view, int viewType) {
            super(view);
            mView = view;
            timelineView = view.findViewById(R.id.time_line_view);
            mNameView = view.findViewById(R.id.place_name);
            mTimeView = view.findViewById(R.id.time);
            timelineView.initLine(viewType);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTimeView.getText() + "'";
        }
    }
}
