package acitivites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.takeoffandroid.seatBookingrecyclerView.R;

import java.util.ArrayList;
import java.util.Arrays;

import adapter.SnacksListAdapter;
import utils.CustomRecyclerView;

public class SnacksListActivity extends AppCompatActivity {
    /**
     * shankar
     ***/
    private ArrayList personNames = new ArrayList<>(Arrays.asList("Popcorn", "Samosa", "Sweetcorn", "Cool Drinks", "Popcorn with Cooldrinks combo", "Sandwich & Burger"));
    private ArrayList personImages = new ArrayList<>(Arrays.asList(R.drawable.mveimg, R.drawable.mveimg, R.drawable.mveimg, R.drawable.mveimg, R.drawable.mveimg, R.drawable.mveimg));
    private CustomRecyclerView mSnacksListRecyclerView;
    private SnacksListAdapter snacksListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks_list);
        initComponents();
        setAdapter();
    }

    private void setAdapter() {
        mSnacksListRecyclerView.setAdapter(snacksListAdapter);
    }

    private void initComponents() {
        mSnacksListRecyclerView = (CustomRecyclerView) findViewById(R.id.theaterslist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        mSnacksListRecyclerView.setLayoutManager(linearLayoutManager);
        // call the constructor of CustomAdapter to send the reference and data to Adapter
        snacksListAdapter = new SnacksListAdapter(SnacksListActivity.this, personNames, personImages);
    }


}
