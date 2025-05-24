package com.example.mobiledoctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MedicineAdapter extends ArrayAdapter<Medicine> {
    private final LayoutInflater inflater;

    // 생성자를 Context + List<Medicine> 로 바꿔줍니다.
    public MedicineAdapter(@NonNull Context context, @NonNull List<Medicine> meds) {
        super(context, 0, meds);
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull @Override
    public View getView(int pos, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_medicine, parent, false);
        }
        Medicine m = getItem(pos);

        TextView tvName     = convertView.findViewById(R.id.tvMedName);
        TextView tvEfficacy = convertView.findViewById(R.id.tvMedEfficacy);
        TextView tvUsage    = convertView.findViewById(R.id.tvMedUsage);
        TextView tvPrice    = convertView.findViewById(R.id.tvMedPrice);

        if (m != null) {
            tvName    .setText(m.getName());
            tvEfficacy.setText("효능: "   + m.getEfficacy());
            tvUsage   .setText("복용법: " + m.getUsage());
            tvPrice   .setText("가격: "   + m.getPrice());
        }
        return convertView;
    }
}
