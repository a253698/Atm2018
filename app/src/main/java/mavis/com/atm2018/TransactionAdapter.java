
package mavis.com.atm2018;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TransactionAdapter  extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        
       // return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if(trans != null){
            return trans.size();
        }else {
            return 0;
        }    }

      private List<Transaction> trans;

        public List<Transaction> getTrans() {
            this.trans = trans;
        }

 public static class ViewHolder extends RecyclerView.ViewHolder{

     private TextView dateTextView;
     private TextView amoutTextView;
     private TextView typeTextView;

     public ViewHolder(View itemView) {
         super(itemView);

         dateTextView = itemView.findViewById();
         amoutTextView = itemView.findViewById();
         typeTextView = itemView.findViewById();
     }
 }


    private class Transaction {
    }

    private class LayoutInflater {
    }
}
