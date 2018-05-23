package io.github.ypsitau.examplesharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
	static final String KEY_EDITTEXT1 = "editText1";
	static final String KEY_EDITTEXT2 = "editText2";
	static final String KEY_EDITTEXT3 = "editText3";
	static final String KEY_SWITCH1 = "switch1";
	static final String KEY_SWITCH2 = "switch2";
	static final String KEY_SWITCH3 = "switch3";
	static final String KEY_SEEKBAR1 = "seekBar1";
	static final String KEY_SEEKBAR2 = "seekBar2";
	static final String KEY_SEEKBAR3 = "seekBar3";
	private EditText editText1;
	private EditText editText2;
	private EditText editText3;
	private Switch switch1;
	private Switch switch2;
	private Switch switch3;
	private SeekBar seekBar1;
	private SeekBar seekBar2;
	private SeekBar seekBar3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText1 = findViewById(R.id.editText1);
		editText2 = findViewById(R.id.editText2);
		editText3 = findViewById(R.id.editText3);
		switch1 = findViewById(R.id.switch1);
		switch2 = findViewById(R.id.switch2);
		switch3 = findViewById(R.id.switch3);
		seekBar1 = findViewById(R.id.seekBar1);
		seekBar2 = findViewById(R.id.seekBar2);
		seekBar3 = findViewById(R.id.seekBar3);
	}

	@Override
	protected void onStart() {
		super.onStart();
		SharedPreferences sharedPref = getPreferences(MODE_PRIVATE);
		editText1.setText(sharedPref.getString(KEY_EDITTEXT1, "value1"));
		editText2.setText(sharedPref.getString(KEY_EDITTEXT2, "value2"));
		editText3.setText(sharedPref.getString(KEY_EDITTEXT3, "value3"));
		switch1.setChecked(sharedPref.getBoolean(KEY_SWITCH1, false));
		switch2.setChecked(sharedPref.getBoolean(KEY_SWITCH2, false));
		switch3.setChecked(sharedPref.getBoolean(KEY_SWITCH3, false));
		seekBar1.setProgress(sharedPref.getInt(KEY_SEEKBAR1, 50));
		seekBar2.setProgress(sharedPref.getInt(KEY_SEEKBAR2, 50));
		seekBar3.setProgress(sharedPref.getInt(KEY_SEEKBAR3, 50));
	}

	@Override
	protected void onStop() {
		super.onStop();
		SharedPreferences sharedPref = getPreferences(MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPref.edit();
		editor.putString(KEY_EDITTEXT1, editText1.getText().toString());
		editor.putString(KEY_EDITTEXT2, editText2.getText().toString());
		editor.putString(KEY_EDITTEXT3, editText3.getText().toString());
		editor.putBoolean(KEY_SWITCH1, switch1.isChecked());
		editor.putBoolean(KEY_SWITCH2, switch2.isChecked());
		editor.putBoolean(KEY_SWITCH3, switch3.isChecked());
		editor.putInt(KEY_SEEKBAR1, seekBar1.getProgress());
		editor.putInt(KEY_SEEKBAR2, seekBar2.getProgress());
		editor.putInt(KEY_SEEKBAR3, seekBar3.getProgress());
		editor.commit();
	}
}
