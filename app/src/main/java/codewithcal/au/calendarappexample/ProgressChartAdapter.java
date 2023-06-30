package codewithcal.au.calendarappexample;

// ProgressDayAdapter.java
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProgressChartAdapter extends RecyclerView.Adapter<ProgressChartAdapter.ViewHolder> {

    private String[] daysOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    private int[] progressValues = {80, 50, 70, 30, 90, 60, 40};

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_progress_day, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String dayOfWeek = daysOfWeek[position];
        int progressValue = progressValues[position];

        holder.dayTextView.setText(dayOfWeek);
        holder.progressBar.setProgress(progressValue);
        holder.progressBar.setRotation(270);
    }

    @Override
    public int getItemCount() {
        return daysOfWeek.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ProgressBar progressBar;
        TextView dayTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBar);
            dayTextView = itemView.findViewById(R.id.dayTextView);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.weight = 1;
            itemView.setLayoutParams(params);
        }
    }
}