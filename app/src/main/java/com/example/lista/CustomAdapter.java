package com.example.lista;

import android.content.Context;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
     Context context;
     List<Persona> personas;
    public CustomAdapter(Context context, List<Persona> personas) {
        this.context = context;
        this.personas = personas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Persona persona = personas.get(position);
        holder.nombre.setText(persona.getNombre());
        holder.profesion.setText(persona.getProfesion());
        holder.correo.setText(persona.getCorreo());
        holder.numero.setText(persona.getNumero());
        holder.pais.setText(persona.getPais());

        Glide.with(holder.itemView.getContext()).load(persona.getImagen()).into(holder.imagen);


    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imagen, abrir;
        TextView nombre,profesion,correo,numero,pais;
        ConstraintLayout constraintLayout;
        boolean expandible = false;

        public ViewHolder(View view) {
            super(view);

            imagen = view.findViewById(R.id.imagen_TV);
            nombre = view.findViewById(R.id.nombre_TV);
            profesion = view.findViewById(R.id.profesion_TV);
            correo = view.findViewById(R.id.correo_TV);
            numero = view.findViewById(R.id.numero_TV);
            pais = view.findViewById(R.id.pais_TV);
            abrir = view.findViewById(R.id.abrir);
            constraintLayout = view.findViewById(R.id.constraintLayout);

            AutoTransition transition = new AutoTransition();
            transition.setInterpolator(new AccelerateDecelerateInterpolator());

            abrir.setOnClickListener(view1 -> {
                if (expandible){
                    transition.setDuration(0);
                    TransitionManager.beginDelayedTransition((ViewGroup) constraintLayout.getParent(), transition);
                    constraintLayout.setVisibility(View.GONE);
                    abrir.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                    expandible = false;
                }else{
                    transition.setDuration(200);
                    TransitionManager.beginDelayedTransition((ViewGroup) constraintLayout.getParent(), transition);
                    constraintLayout.setVisibility(View.VISIBLE);
                    abrir.setImageResource(R.drawable.baseline_arrow_drop_up_24);
                    expandible = true;
                }
            });

        }
    }
}