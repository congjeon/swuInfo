package app.swuinfo.guru.com.swuinfo;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class CallActivity extends CommonActivity {

    private EditText editText;
    private Button btn1, btn2, btn3;
    private ListView listView;
    private CallListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        editText = (EditText) findViewById(R.id.edtFilter);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        listView = (ListView)findViewById(R.id.listView);

        adapter = new CallListAdapter(this);
        listView.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(CallActivity.this, R.drawable.telephone),"학생지원팀");
        adapter.addItem(ContextCompat.getDrawable(CallActivity.this, R.drawable.telephone),"정보전산팀");


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long id) {

                CallListItem item = (CallListItem) adapterView.getItemAtPosition(position);

                Drawable imgCallList = item.getImgCallList();
                String txtCallList = item.getTxtCallList();
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-0000-0000"));
                try {
                    startActivity(i);
                } catch (Exception e ) {
                    e.printStackTrace();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-1111-1111"));
                try {
                    startActivity(i);
                } catch (Exception e ) {
                    e.printStackTrace();
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-2222-2222"));
                try {
                    startActivity(i);
                } catch (Exception e ) {
                    e.printStackTrace();
                }
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                String strText = (String) adapterView.getItemAtPosition(i);
            }
        });
    } // end onCreate

} // end Class
