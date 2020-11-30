package net.simplifiedlearning.volleymysqlexample.ui.togel;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.simplifiedlearning.volleymysqlexample.Product;
import net.simplifiedlearning.volleymysqlexample.ProductsAdapter;
import net.simplifiedlearning.volleymysqlexample.R;
import net.simplifiedlearning.volleymysqlexample.Togel;
import net.simplifiedlearning.volleymysqlexample.TogelAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TogelFragment extends Fragment {

    private TogelViewModel togelViewModel;

    private static final String URL_PRODUCTS = "http://192.168.1.7/koneksi/togelApi.php";

    //a list to store all the products
    List<Togel> togelList;
    ProductsAdapter productsAdapter;
    //the recyclerview
    RecyclerView recyclerView;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        togelViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TogelViewModel.class);
        View root = inflater.inflate(R.layout.fragment_togel, container, false);

////        setHasOptionsMenu(true);
//        productList = new ArrayList<>();
//        recyclerView = root.findViewById(R.id.recylcerView);
//        loadProducts();
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
////        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setHasFixedSize(true);
//        return root;
//
             togelList = new ArrayList<>();
             recyclerView = root.findViewById(R.id.recylcerView);
             recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
             recyclerView.setHasFixedSize(true);
       loadProducts();
       return root;

    }

    private void loadProducts() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject product = array.getJSONObject(i);

                                //adding the product to product list
                                togelList.add(new Togel(

                                        product.getString("period"),
                                        product.getString("day"),
                                        product.getString("date"),
                                        product.getString("number")

                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            TogelAdapter adapter = new TogelAdapter(getActivity().getApplicationContext(), togelList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        Volley.newRequestQueue(getContext()).add(stringRequest);
    }
}