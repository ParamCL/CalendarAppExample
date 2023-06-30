package codewithcal.au.calendarappexample;

// ProgressDayAdapter.java
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProgressDayAdapter extends RecyclerView.Adapter<ProgressDayAdapter.ViewHolder> {
    private List<Integer> progressList;
    private String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

    public ProgressDayAdapter(List<Integer> progressList) {
        this.progressList = progressList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_progress_day, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int progress = progressList.get(position);
        holder.progressBar.setProgress(progress);
        holder.dayTextView.setText(daysOfWeek[position]);
    }

    @Override
    public int getItemCount() {
        return progressList.size();
    }

    // ProgressDayAdapter.java
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ProgressBar progressBar;
        TextView dayTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            progressBar = itemView.findViewById(R.id.progressBar);
            dayTextView = itemView.findViewById(R.id.dayTextView);
        }
    }

}
