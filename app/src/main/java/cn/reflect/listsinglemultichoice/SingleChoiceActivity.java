package cn.reflect.listsinglemultichoice;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SingleChoiceActivity extends Activity {

    ListView listView;
    MyListAdapter myListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_choice);

        listView = (ListView) findViewById(R.id.list_view);
        myListAdapter = new MyListAdapter();
        listView.setAdapter(myListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                myListAdapter.notifyDataSetChanged();
                Toast.makeText(SingleChoiceActivity.this, "用户选择的Item Position = " + listView.getCheckedItemPosition(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class MyListAdapter extends BaseAdapter {

        private String[] mStrings = {
                "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam",
                "Abondance", "Ackawi", "Acorn",
                "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag",
                "Airedale", "Aisy Cendre",
                "Allgauer Emmentaler", "Alverca", "Ambert", "American Cheese",
                "Ami du Chambertin", "Anejo Enchilado",
                "Anneau du Vic-Bilh", "Anthoriro"};

        public int getCount() {
            return mStrings.length;
        }

        public String getItem(int position) {
            return mStrings[position];
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if (convertView == null) {
                view = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.single_choice_item, parent,
                        false);
            } else {
                view = convertView;
            }

            TextView name = (TextView) view.findViewById(R.id.name);
            name.setText(getItem(position));

            RadioButton radio = (RadioButton) view.findViewById(R.id.radio);
            radio.setChecked(listView.isItemChecked(position));

            return view;
        }

    }

}
