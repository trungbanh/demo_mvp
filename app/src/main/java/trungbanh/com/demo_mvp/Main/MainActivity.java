package trungbanh.com.demo_mvp.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import trungbanh.com.demo_mvp.R;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ActionBar mActionBar;
    ImageView imgCam;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setDisplayShowHomeEnabled(true);

        imgCam = findViewById(R.id.img_camera);
        imgCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photo = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(photo, REQUEST_IMAGE_CAPTURE);
            }
        });

        Intent intent = getIntent();

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        mAdapter = new ItemAdapter(ListItem.getInstance().itemObjects);
        mRecyclerView.setAdapter(mAdapter);
        if (intent != null) {
            //ListItem.getInstance().itemObjects.add();
            mAdapter.notifyDataSetChanged();
        } else {
            ///
        }

    }
}
