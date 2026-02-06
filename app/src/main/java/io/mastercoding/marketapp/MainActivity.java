package io.mastercoding.marketapp;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    RecyclerView recyclerView;

    List<item> itemList;

    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);

        itemList = new ArrayList<>();
        item item1 = new item(R.drawable.fruit,"Fruits","Fresh Fruits from the Garden");
        item item2 = new item(R.drawable.vegitables,"Vegetables","Delicious Vegetables");
        item item3 = new item(R.drawable.bread,"Bakery","Bread, Wheat & Beans");
        item item4 = new item(R.drawable.beverage,"Beverages","Juice, Tea, Coffee & Soda");
        item item5 = new item(R.drawable.milk,"Milk","Milk, Shakes & Yogurt");
        item item6 = new item(R.drawable.popcorn,"Snacks","Popcorn, Donuts & Drinks");

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new MyAdapter(itemList);
        recyclerView.setAdapter(myAdapter);

        myAdapter.setClickListener(this);

    }

    @Override
    public void onClick(View v, int pos) {
        Toast.makeText(this, "You Choose: "+itemList.get(pos).getItemName(), Toast.LENGTH_SHORT).show();

    }
}