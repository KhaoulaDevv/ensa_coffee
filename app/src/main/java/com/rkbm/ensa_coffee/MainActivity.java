package com.rkbm.ensa_coffee;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Coffee> listCoffee;
    AdapterCoffees adapterCoffees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        listCoffee = new ArrayList<Coffee>();
        adapterCoffees = new AdapterCoffees(listCoffee, this);
        recyclerView.setAdapter(adapterCoffees);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "http://192.168.100.6:8080/coffee/listAll";
        JsonObjectRequest request = new JsonObjectRequest(url, this::function_onResponse, this::function_onError);
        queue.add(request);
    }

    void function_onResponse(JSONObject response){
        try {

            JSONArray array = response.getJSONArray("listCoffees");
            for (int i = 0; i < array.length(); i++) {
                JSONObject elt = array.getJSONObject(i);
                //Toast.makeText(MainActivity.this, elt.toString(),Toast.LENGTH_LONG).show();
                Coffee p = new Coffee(elt.getInt("id"), elt.getString("name"), elt.getString("imageUrl"),elt.getString("instructions") );
                listCoffee.add(p);
            }
            adapterCoffees.notifyDataSetChanged();

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }

    void function_onError (VolleyError error){
        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
    }

}