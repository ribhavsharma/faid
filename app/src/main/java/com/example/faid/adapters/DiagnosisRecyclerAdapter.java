package com.example.faid.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.faid.R;
import com.example.faid.models.Diagnosis;
import com.example.faid.models.Symptom;
import com.example.faid.SymptomActivity;

import java.util.ArrayList;

public class DiagnosisRecyclerAdapter extends  RecyclerView.Adapter<DiagnosisRecyclerAdapter.ViewHolder> {

    private ArrayList<Diagnosis> mDiagnosis;
    private OnDiagnosisListener mOnDiagnosisListener;

    public DiagnosisRecyclerAdapter(ArrayList<Diagnosis> mDiagnosis, OnDiagnosisListener onDiagnosisListener) {
        this.mDiagnosis = mDiagnosis;
        this.mOnDiagnosisListener = onDiagnosisListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.diagnosis_list_item, viewGroup, false);
        return new ViewHolder(view, mOnDiagnosisListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.diagnosis.setText(mDiagnosis.get(i).getProfName());
        viewHolder.acc.setText(mDiagnosis.get(i).getAccuracy());
        viewHolder.desc.setText(mDiagnosis.get(i).getDiagnosis());
    }

    @Override
    public int getItemCount()  {
        return mDiagnosis.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView diagnosis;
        TextView acc;
        TextView desc;
        OnDiagnosisListener onDiagnosisListener;

        public ViewHolder(@NonNull View itemView, OnDiagnosisListener onDiagnosisListener) {
            super(itemView);
            diagnosis = itemView.findViewById(R.id.diagnosis);
            acc = itemView.findViewById(R.id.acc);
            desc = itemView.findViewById(R.id.desc);
            this.onDiagnosisListener = onDiagnosisListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onDiagnosisListener.OnClick(getAdapterPosition());
        }
    }

    public interface OnDiagnosisListener{
        void OnClick(int position);
    }

}


