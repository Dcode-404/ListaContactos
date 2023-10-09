package com.example.lista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Lista_fragment extends Fragment {
    RecyclerView recyclerView,recyclerViewImagenes ;
    List<Persona> personas;
    SearchView searchView;

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.lista_fragment, container, false);

        personas = new ArrayList<>();
        personas.add(new Persona("Juan López", "Programador", "juan@gmail.com", "123456789", "España", R.drawable.juan));
        personas.add(new Persona("Pedro García", "Ingeniero", "pedro@gmail.com", "987654321", "Francia", R.drawable.pedro));
        personas.add(new Persona("María González", "Médico", "maria@gmail.com", "123456789", "Alemania", R.drawable.maria));
        personas.add(new Persona("Luis Pérez", "Artista", "luis@gmail.com", "987654321", "Francia", R.drawable.luis));
        personas.add(new Persona("Ana Martínez", "Escritora", "ana@gmail.com", "123456789", "España", R.drawable.ana));
        personas.add(new Persona("José Rodríguez", "Científico", "jose@gmail.com", "987654321", "Francia", R.drawable.jose));
        personas.add(new Persona("Paula Sánchez", "Veterinaria", "paula@gmail.com", "123456789", "España", R.drawable.paula));
        personas.add(new Persona("Marta García", "Periodista", "marta@gmail.com", "987654321", "Francia", R.drawable.marta));
        personas.add(new Persona("Antonio López", "Abogado", "antonio@gmail.com", "123456789", "España", R.drawable.antonio));
        personas.add(new Persona("Laura Martínez", "Profesora", "laura@gmail.com", "987654321", "Francia", R.drawable.laura));

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        CustomAdapter adapter = new CustomAdapter(getContext(), personas);
        recyclerView.setAdapter(adapter);

        recyclerViewImagenes = view.findViewById(R.id.recycler_view_horizontal);
        recyclerViewImagenes.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        ImageAdapter adapterImagenes = new ImageAdapter(getContext(), personas);
        recyclerViewImagenes.setAdapter(adapterImagenes);

        searchView = view.findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                List<Persona> filteredPersonas = new ArrayList<>();
                for (Persona persona : personas) {
                    if (persona.getNombre().contains(query) || persona.getProfesion().contains(query) || persona.getCorreo().contains(query) || persona.getNumero().contains(query) || persona.getPais().contains(query)) {
                        filteredPersonas.add(persona);
                    }
                }

                CustomAdapter adapter = new CustomAdapter(getContext(), filteredPersonas);
                recyclerView.setAdapter(adapter);
                searchView.clearFocus();

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<Persona> filteredPersonas = new ArrayList<>();
                for (Persona persona : personas) {
                    if (persona.getNombre().contains(newText) || persona.getProfesion().contains(newText) || persona.getCorreo().contains(newText) || persona.getNumero().contains(newText) || persona.getPais().contains(newText)) {
                        filteredPersonas.add(persona);
                    }
                }

                CustomAdapter adapter = new CustomAdapter(getContext(), filteredPersonas);
                recyclerView.setAdapter(adapter);

                return true;
            }
        });

        return view;
    }
}