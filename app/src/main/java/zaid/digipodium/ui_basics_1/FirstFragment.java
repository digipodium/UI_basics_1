package zaid.digipodium.ui_basics_1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Switch swTheme = view.findViewById(R.id.swTheme);
        TextInputLayout tilWrapper = view.findViewById(R.id.tilWrapper);
        final TextInputEditText editFavNum = view.findViewById(R.id.editFavNum);
        final CheckBox cbAgree = view.findViewById(R.id.cbAgree);
        final FloatingActionButton fab = view.findViewById(R.id.fab);
        final ProgressBar pb = view.findViewById(R.id.pb);
        RadioGroup rgFruit = view.findViewById(R.id.rgFruit);
        SeekBar sbVal = view.findViewById(R.id.sbVal);
        SeekBar sbVal2 = view.findViewById(R.id.sbVal2);
        RatingBar rbRate = view.findViewById(R.id.rbRate);
        final TextView tvMsg = view.findViewById(R.id.tvMsg);
        final CardView card = view.findViewById(R.id.card);

        tvMsg.setText("this is a simple message for others to read.");
        swTheme.setChecked(true);
        cbAgree.setEnabled(false);
        pb.setVisibility(View.INVISIBLE);

        swTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    card.setCardBackgroundColor(Color.WHITE);
                } else {
                    card.setCardBackgroundColor(Color.parseColor("#89ff93"));
                }
            }
        });

        rgFruit.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rLemon:
                        tvMsg.setText("You have select Lemon");
                        break;
                    case R.id.rPineapple:
                        tvMsg.setText("You have select PINEAPPLE");
                        break;
                    case R.id.eOrange:
                        tvMsg.setText("You have select ORANGE");
                        break;
                }
            }
        });

        sbVal.setProgress(39);
        sbVal.setMax(200);
        sbVal.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                editFavNum.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                fab.animate().rotationY(360*5).setDuration(300).start();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        rbRate.setRating(2.5f);
        rbRate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating == 5){
                    cbAgree.setEnabled(true);
                    pb.setVisibility(View.GONE);
                }
                if(rating == 0){
                    cbAgree.setEnabled(false);
                    pb.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}