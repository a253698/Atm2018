
package mavis.com.atm2018;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.row_trans, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

        // return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Log.d("TRANS", position + "");
        Transaction tran = trans.get(position);
        holder.dateTextView.setText(tran.getDate());
        holder.amountTextView.setText(tran.getAmount() + "");
        holder.typeTextView.setText(tran.getType() + "");
    }

    @Override
    public int getItemCount() {
        if (trans != null) {
            return trans.size();
        } else {
            return 0;
        }
    }

    private List<Transaction> trans;

    public List<Transaction> getTrans() {
        this.trans = trans;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView dateTextView;
        private TextView amoutTextView;
        private TextView typeTextView;
        public EditText amountTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            dateTextView = itemView.findViewById();
            amoutTextView = itemView.findViewById();
            typeTextView = itemView.findViewById();
        }
    }

    private void parseJackson(String s) {
        ObjectMapper objectMapper = new ObjectMapper();
    }try

    {
        final ArrayList<Transaction> list =
                objectMapper.readValue(s, new TypeReference<List<Transaction>>() {
                });
        Log.d("JSON", list.size() + "/" + list.get(0).getAmount());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setupRecyclerView(list);
            }
        });
    } catch(
    IOException e)

    {
        e.printStackTrace();
    }
}

private class Transaction {
}

private class LayoutInflater {
}

}
