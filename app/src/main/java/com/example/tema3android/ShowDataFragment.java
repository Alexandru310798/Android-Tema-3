package com.example.tema3android;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@SuppressLint("ValidFragment")
public class ShowDataFragment extends android.app.Fragment {
    private RecyclerView recyclerView;
    private String url;
    private RecyclerView.Adapter myAdapter;
    private List<ToDo> todoList;
    @SuppressLint("ValidFragment")
    public ShowDataFragment(String url) {
        this.url = url;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view =  inflater.inflate(R.layout.fragment_show_data, container, false);
        recyclerView = container.findViewById(R.id.my_recycler_view_to_show_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        todoList = new ArrayList<>();
        loadRecyclerViewData();
         return view;

    }


    private  void loadRecyclerViewData()
    {
        final StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        ToDo toDo = new ToDo(jsonObject.getInt("id"),jsonObject.getInt("userId"),jsonObject.getString("title"),jsonObject.getString("completed"));
                        todoList.add(toDo);
                    }
                myAdapter =  new ToDoAdapter(todoList,getActivity());

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getActivity()));
        requestQueue.add(stringRequest);
    }


}
