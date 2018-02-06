package acitivites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.takeoffandroid.seatBookingrecyclerView.R;

import java.util.ArrayList;
import java.util.List;

import adapter.TheaterseatsAdapter;
import interfaces.OnSeatSelected;
import items.AbstractItem;
import items.CenterItem;
import items.EdgeItem;
import items.EmptyItem;

/**
 * shankar
 ***/
public class TheaterSeatsActivity extends AppCompatActivity implements OnSeatSelected, View.OnClickListener {

    private static final int COLUMNS = 5;
    private TextView txtSeatSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();

    }

    private void initComponents() {
        initVariables();
        setClickListeners();
    }

    private void initVariables() {
        txtSeatSelected = (TextView) findViewById(R.id.txt_seat_selected);

        List<AbstractItem> items = new ArrayList<>();
        for (int i = 0; i < 30; i++) {

            if (i % COLUMNS == 0 || i % COLUMNS == 4) {
                items.add(new EdgeItem(String.valueOf(i)));
            } else if (i % COLUMNS == 1 || i % COLUMNS == 3) {
                items.add(new CenterItem(String.valueOf(i)));
            } else {
                items.add(new EmptyItem(String.valueOf(i)));
            }
        }

        GridLayoutManager manager = new GridLayoutManager(this, COLUMNS);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.lst_items);
        recyclerView.setLayoutManager(manager);

        TheaterseatsAdapter adapter = new TheaterseatsAdapter(this, items);
        recyclerView.setAdapter(adapter);
    }

    private void setClickListeners() {
        txtSeatSelected.setOnClickListener(this);
    }

    @Override
    public void onSeatSelected(int count) {

        txtSeatSelected.setText("Book " + count + " seats");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_seat_selected:
                onBookClicked();
                break;
            default:
                break;
        }
    }

    private void onBookClicked() {
        Intent mFoodListIntent = new Intent(this, SnacksListActivity.class);
        startActivity(mFoodListIntent);
    }
}
