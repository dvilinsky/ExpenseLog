package edu.brandeis.cs.dvilinsk.expenselog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ExpenseItemAdapter extends BaseAdapter {
    private List<ExpenseLogEntryData> items;
    private LayoutInflater inflater;

    public ExpenseItemAdapter(Context context) {
        this.items = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
        populateWithFakeData();
    }

    private static class ViewHolder {
        private TextView expenseDescription;
        private TextView expenseNotes;
        private TextView timeStamp;

        private ExpenseLogEntryData data;

        public ViewHolder(View view) {
            this.expenseDescription = (TextView) view.findViewById(R.id.expense_description);
            this.expenseNotes = (TextView) view.findViewById(R.id.expense_notes);
            this.timeStamp = (TextView) view.findViewById(R.id.timestamp);
        }

        public void bind(ExpenseLogEntryData data) {
            this.data = data;

            this.expenseNotes.setText(this.data.getNotes());
            this.timeStamp.setText(this.data.getTimeEntered().toString());
            this.expenseDescription.setText(this.data.getDescription());

        }
    }

    private void populateWithFakeData() {
        for (int i = 0; i < 3; i++) {
            items.add(new ExpenseLogEntryData("Expense " + i, "Description " + i));
        }
    }

    @Override
    public int getCount() {
        return items == null ? 0 : items.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View v = convertView;
        ExpenseLogEntryData data = (ExpenseLogEntryData) getItem(position);
        if (convertView == null) {
            //Here we inflate the xml file that holds our textviews
            v = this.inflater.inflate(R.layout.expense_entry, parent, false);

            //We give our viewholder an instance of the view that we are inflating
            viewHolder = new ViewHolder(v);

            //Let's us recycle views later
            v.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) v.getTag();
        }
        viewHolder.bind(data);

        //return how view with the data bound to the textviews
        return v;
    }

    @Override
    public long getItemId(int position) {
        return position; //what is the point of this
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    public void addItem(ExpenseLogEntryData item) {
        this.items.add(item);
    }
}
