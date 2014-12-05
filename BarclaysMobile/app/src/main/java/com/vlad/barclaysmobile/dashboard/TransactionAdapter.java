package com.vlad.barclaysmobile.dashboard;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vlad.barclaysmobile.R;
import com.vlad.barclaysmobile.utils.Utils;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by Vladislavs on 06/11/2014.
 */
public class TransactionAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ViewHolder viewHolder;
    private Activity activity;
    private Random r = new Random();
    private String[] transactions = new String[]{"LNK BLOOMBERG LP CD 8118 05SEP14 ", "WWW.GIFFGAFF.CO.UK CD 5318 ", "M S 15MAR14 873717 74472468 ", "FORGN PYT240508997", "CO-OP GROUP 310211 CD 5318 ", "PAYPAL *CID LOUD B CD 8118 ", "NON-STG PURCH FEE CD 5318 ", "WWW.ALIEXPRESS.COM GB           04.70 VISAXR     1.64336 CD 5318 ", "PAYPAL *CHEN CANYI CD 8118 ", "NON-STG TRANS FEE 2.99% CD 8118 21APR14 ", "TESCO STORES 6151 CD 5318 ", "FORGN PYT241437567", "W M MORRISONS CD 5318 ", "TESCO STORES 6099 CD 8118 ", "LNK PRICESMART CON CD 8118 15OCT14 ", "LNK BLOOMBERG LP CD 8118 01AUG14 ", "LNK TESCO GLASG TR CD 8118 26MAR14 ", "M S 07SEP14 873717 74472468 ", "UNICEF UK 1025271444/543062 ", "M S 28JUN14 873717 74472468 ", "RYANAIR     224000 CD 8118 ", "TAY LETTING LTD", "T K MAXX LTD CD 8118 ", "Payment to Ollex LT           55.00 VISAXR     4.15722 CD 8118 ", "NON-STG TRANS FEE 2.99% CD 8118 ", "LNK TESCO BRMNSY M CD 8118 03AUG14 ", "UNIVERMAG SPORT RU         6864.00 VISAXR    59.95283 CD 8118 ", "BANKOMAT 729731 80 RU         6000.00 VISAXR    57.4988 CD 8118 10JUN14 ", "TAY LETTING LTO", "THE BRITISH MUSEUM CD 5318 ", "NON-STG TRANS FEE 2.99% CD 8118 16JUN14 ", "TESCO STORES 6198 CD 8118 ", "THE ARCH CLIMBING CD 8118 ", "CYBER ALTERNATIVE CD 8118 ", "CD 5318 10MAR14", "STARBUCKS CD 8118 ", "LNK EDIN ROYAL MIL CD 8118 12OCT14 ", "IndieGoGo Inc CD 8118 ", "LNK COOP GT WESTER CD 8118 27MAR14 ", "LNK PRICESMART CON CD 5318 09FEB14 ", "LNK TESCO BRMNSY M CD 8118 30AUG14 ", "BANKOMAT 729733 80 RU         7500.00 VISAXR    59.71813 CD 8118 21APR14 ", "LNK CAMDEN TOWN 2 CD 8118 05JUL14 ", "WAITROSE 644 CD 8118 ", "WWW.ALIEXPRESS.COM CD 5318 ", "ICELAND CD 5318 ", "NON-STG TRANS FEE 2.99% CD 5318 ", "M S 31AUG14 873717 74472468 ", "TESCO STORES 6055 CD 8118 ", "LNK TESCO BRMNSY M CD 8118 24AUG14 ", "NON-STG CASH FEE CD 8118 16JUN14 ", "TESCO STORES 6198 CD 5318 ", "VIVATK101623707276 EUROS        14.00 VISAXR     1.26126 CD 8118 ", "www.ecolines.net CD 8118 ", "LNK FINSBURY SQUAR CD 5318 12MAR14 ", "NON-STG PURCH FEE CD 8118 ", "LUL TICKET MACHINE CD 8118 ", "MAXIMA X CRD R015 EUROS        01.73 VISAXR     1.20139 CD 8118 ", "WWW.GIFFGAFF.CO.UK CD 8118 ", "LNK PRICESMART CON CD 8118 21SEP14 ", "LNK TESCO BRMNSY M CD 8118 07SEP14 ", "Amazon *Mktplce EU CD 5318 ", "M S 19JUL14 873717 74472468 ", "SPORTSDIRECT 435 CD 8118 ", "LNK TESCO BRMNSY M CD 8118 31AUG14 ", "Amazon EU CD 8118 ", "NON-STG CASH FEE CD 8118 18APR14 ", "M S 21SEP14 873717 74472468 ", "LNK PRICESMART CON CD 8118 19MAR14 ", "LNK QUEEN MARGARET CD 5318 08MAR14 ", "WWW.TICKETS-SCOTLA CD 8118 ", "TESCO STORES 5630 CD 8118 ", "M S 15FEB14 873717 74472468 ", "M S 25OCT14 873717 74472468 ", "NON-STG CASH FEE CD 8118 10JUN14 ", "RYANAIR     224000 CD 5318 ", "PP*5919CODE CD 8118 ", "SUBWAY CD 5318 ", "TESCO STORES 6151 CD 8118 ", "BANKOMAT 21549 187 RU         4000.00 VISAXR    58.03831 CD 8118 07JUN14 ", "Amazon *Mktplce EU CD 8118 ", "BANKOMAT 729733 80 RU         3000.00 VISAXR    57.65904 CD 8118 12JUN14 ", "MCDONALDS REST CD 8118 ", "RigasStarptautiska EUROS        17.00 VISAXR     1.24633 CD 8118 ", "BANKOMAT 729733 80 RU         2500.00 VISAXR    58.46586 CD 8118 16JUN14 ", "LNK BLOOMBERG LP CD 8118 25JUL14 ", "NON-STG CASH FEE CD 8118 07JUN14 ", "TESCO PFS 5959 CD 8118 ", "M S 23AUG14 873717 74472468 ", "M S 873717 74472468 ", "NON-STG CASH FEE CD 8118 24APR14 ", "NON-STG CASH FEE CD 8118 21APR14 ", "TSB  GLAS ST VINCE CD 8118 13OCT14 ", "PAYPAL *ENVATO MKP CD 8118 ", "M S 09FEB14 873717 74472468 ", "FOREIGN CASH FEE CD 8118 05JUN14 ", "M S 10AUG14 873717 74472468 ", "ICELAND CD 8118 ", "CROWDSURGE TICKETS CD 8118 ", "LNK BLOOMBERG LP CD 8118 19SEP14 ", "TESCO STORES 6099 CD 5318 ", "OUR CHARGE FT147985615271 FP24143756778898 ", "LNK PRICESMART CON CD 8118 26SEP14 ", "TESCO STORES 6158 CD 8118 ", "LUL TICKET MACHINE CD 5318 ", "NISA LOCAL CD 8118 ", "LNK TESCO MORE LON CD 8118 29JUN14 ", "BANKOMAT 729731 80 RU         4000.00 VISAXR    60.25004 CD 8118 24APR14 ", "LNK PRICESMART CON CD 8118 18MAR14 ", "LNK FENCHURCH STRE CD 8118 15AUG14 ", "VIRGINIJUS 500000000130372732 19JUL14 15:00 ", "M S 04OCT14 873717 74472468 ", "NON-STG TRANS FEE 2.99% CD 8118 10JUN14 ", "M S 05MAY14 873717 74472468 ", "NON-STG TRANS FEE 2.99% CD 8118 18APR14 ", "LNK BYRES ROAD CD 8118 05JUN14 ", "LNK BUCHANAN BUS G CD 8118 10OCT14 ", "LNK THOMASCOOK HAN CD 8118 11OCT14 ", "Cineworld GLA CP CD 8118 ", "TESCO-STORES 6485 CD 8118 ", "LNK BUCHANAN BUS G CD 8118 17OCT14 ", "NON-STG CASH FEE CD 8118 12JUN14 ", "VUELING AIRL CD 8118 ", "Payment to Ollex LT          100.00 VISAXR     4.40335 CD 8118 ", "NON-STG TRANS FEE 2.99% CD 8118 07JUN14 ", "ATM 5272 B. SANTAN CD 8118 05JUN14 ", "PAYPAL *XTRASACCES CD 8118 ", "LNK TESCO BRMNSY M CD 8118 14SEP14 ", "LNK N/RAIL LIVERPL CD 8118 18JUL14 ", "NON-STG TRANS FEE 2.99% CD 8118 24APR14 ", "LNK PRICESMART CON CD 8118 23MAY14 ", "LNK QUEEN MARGARET CD 5318 28FEB14 ", "LNK PRICESMART CON CD 5318 15FEB14 ", "BANKOMAT 729733 80 RU         4000.00 VISAXR    60.35003 CD 8118 18APR14 ", "WP-SCOACH ETICKET CD 5318 ", "BHS 090 CD 8118 ", "LNK RAJOUS  20-22 CD 8118 03JUN14 ", "SAINSBURYS S/MKTS CD 5318 ", "HILLHEAD SUBWAY CD 8118 ", "PP*CORSAIRS WARES CD 8118 ", "TFL CYCLE HIRE CD 8118 ", "MAXIMA LT X-732 LT          111.34 VISAXR     4.31718 CD 8118 ", "NON-STG TRANS FEE 2.99% CD 8118 12JUN14 ", "RETURNED S/O", "LUL TICKET OFFICE. CD 8118 ", "LNK PRICESMART CON CD 8118 01OCT14 ", "LIDL UK CD 8118 ", "LIDL UK CD 5318 ", "OUR CHARGE FT147393916271 FP24050899778898 ", "LNK PRICESMART CON CD 8118 28MAR14 ", "WP-SCOACH ETICKET CD 8118 ", "LNK BLOOMBERG LP CD 8118 22AUG14 ", "BOOTS UK CD 5318 ", "LNK BLOOMBERG LP CD 8118 18JUL14 ", "DYBALLS NEWS CD 8118 ", "LNK BLOOMBERG LP CD 8118 23JUL14 ", "SAINSBURYS S/MKTS CD 8118 "};
    private int month;
    public TransactionAdapter(Activity activity, int month) {
        this.month = month;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return 30;
    }

    @Override
    public String getItem(int position) {
        return "";//tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // View rowView = convertView;

        if (convertView == null) {
            inflater = (LayoutInflater.from(parent.getContext()));
            convertView = inflater.inflate(R.layout.row_transaction, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.balance = (TextView) convertView.findViewById(R.id.transaction_balance);
            viewHolder.date = (TextView) convertView.findViewById(R.id.transaction_date);
            viewHolder.description = (TextView) convertView.findViewById(R.id.transaction_description);
            Typeface tf = Utils.getBakerTypeface(activity);
            viewHolder.balance.setTypeface(tf);
            viewHolder.date.setTypeface(tf);
            viewHolder.description.setTypeface(tf);
            viewHolder.position = position;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.description.setText(genDesc().toUpperCase());
        viewHolder.date.setText(30 - position + r.nextInt(2) + "/"  + month);
        viewHolder.balance.setText("-£number".replace("number", new DecimalFormat("##.##").format(Math.random()*r.nextInt(150))));

        viewHolder.position = position;
        return convertView;

    }

    private String genDesc(){
        return transactions[r.nextInt(transactions.length)];
    }

    static class ViewHolder {
        TextView date;
        TextView description;
        TextView balance;
        int position;
    }
}
