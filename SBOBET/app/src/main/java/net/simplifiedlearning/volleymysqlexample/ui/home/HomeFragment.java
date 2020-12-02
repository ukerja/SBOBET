package net.simplifiedlearning.volleymysqlexample.ui.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.simplifiedlearning.volleymysqlexample.Product;
import net.simplifiedlearning.volleymysqlexample.ProductsAdapter;
import net.simplifiedlearning.volleymysqlexample.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

   private static final String URL_PRODUCTS = "https://sbobet-admin.godisfaith.com/SBOBET/function/getDataForMobile/getPredictionData.php";


    //a list to store all the products
    List<Product> productList;
    ProductsAdapter productsAdapter;
    //the recyclerview
    RecyclerView recyclerView;




    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

////        setHasOptionsMenu(true);
//        productList = new ArrayList<>();
//        recyclerView = root.findViewById(R.id.recylcerView);
//        loadProducts();
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
////        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setHasFixedSize(true);
//        return root;


            productList =new ArrayList<>();
            recyclerView =root.findViewById(R.id.recylcerView);
             recyclerView.setLayoutManager(new

            LinearLayoutManager(getContext()));
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
                                productList.add(new Product(
                                        product.getString("date"),
                                        product.getString("league_name"),
                                        product.getString("home_team"),
                                        product.getString("away_team"),
                                        product.getString("status"),
                                        product.getString("score")

                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            ProductsAdapter adapter = new ProductsAdapter(getActivity().getApplicationContext(), productList);
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