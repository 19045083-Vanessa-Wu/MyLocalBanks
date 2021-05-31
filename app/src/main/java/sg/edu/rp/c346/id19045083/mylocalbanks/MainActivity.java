package sg.edu.rp.c346.id19045083.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    String optionClicked = "";
    ImageView DBSimg;
    ImageView OCBCimg;
    ImageView UOBimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);

        DBSimg = findViewById(R.id.imageViewDBS);
        OCBCimg = findViewById(R.id.imageViewOCBC);
        UOBimg = findViewById(R.id.imageViewUOB);
    }

// - - - - - - - - - - - - - - - For translation between English & Chinese - - - - - - - - - - - - - - -
    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu_language, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText(R.string.DisplayTextdbs);
            tvOCBC.setText(R.string.DisplayTextocbc);
            tvUOB.setText(R.string.DisplayTextuob);

        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText(R.string.translatedText_dbs);
            tvOCBC.setText(R.string.translatedText_ocbc);
            tvUOB.setText(R.string.translatedText_uob);

        } else {
            tvDBS.setText(getString(R.string.textTranslateError));
            tvOCBC.setText(getString(R.string.textTranslateError));
            tvUOB.setText(getString(R.string.textTranslateError));
        }

        return super.onOptionsItemSelected(item);
    }

// - - - - - - - - - - - - - - - For options to visit website or contact - - - - - - - - - - - - - - -
    @Override
    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_main, menu);

        if (v == tvDBS) {
            optionClicked = "dbs";
        } else if (v == tvOCBC) {
            optionClicked = "ocbc";
        } else if (v == tvUOB) {
            optionClicked = "uob";
        }
    }

    @Override
    public boolean onContextItemSelected (MenuItem item) {
        int id = item.getItemId();

        if (optionClicked.equalsIgnoreCase("dbs")){
            if (id == R.id.websiteSelection) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.dbswebsite)));
                startActivity(intent);
                return true;
            } else if (id == R.id.ContactSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.dbsContact)));
                startActivity(intentCall);
                return true;
            } else if (id == R.id.FavoriteSelection){
                if (tvDBS.getCurrentTextColor() == Color.RED) {
                    tvDBS.setTextColor(Color.BLACK);
                } else {
                    tvDBS.setTextColor(Color.RED);
                }
                return true;
            }

        } else if (optionClicked.equalsIgnoreCase("ocbc")) {
            if (id == R.id.websiteSelection) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.ocbcwebsite)));
                startActivity(intent);
                return true;
            } else if (id == R.id.ContactSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.ocbcContact)));
                startActivity(intentCall);
                return true;
            } else if (id == R.id.FavoriteSelection){
                if (tvOCBC.getCurrentTextColor() == Color.RED) {
                    tvOCBC.setTextColor(Color.BLACK);
                } else {
                    tvOCBC.setTextColor(Color.RED);
                }
                return true;
            }

        } else if (optionClicked.equalsIgnoreCase("uob")) {
            if (id == R.id.websiteSelection) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.uobwebsite)));
                startActivity(intent);
                return true;
            } else if (id == R.id.ContactSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.uobContact)));
                startActivity(intentCall);
                return true;
            } else if (id == R.id.FavoriteSelection){
                if (tvUOB.getCurrentTextColor() == Color.RED) {
                    tvUOB.setTextColor(Color.BLACK);
                } else {
                    tvUOB.setTextColor(Color.RED);
                }
                return true;
            }
        }

        return super.onContextItemSelected(item);
    }
}