package com.example.grevocabhelper;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.widget.Button;

public class MultipleChoice extends Activity {
	private String value;
	private ArrayList<String> order;
	private LinearLayout buttonContainer;
	private Map<String, String> wordBank;
	private String randomKey;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multiple_choice);
		// Show the Up button in the action bar.
		setupActionBar();
		buttonContainer = (LinearLayout) findViewById(R.id.container);
		
		wordBank = new HashMap<String, String>();
		wordBank.put("acrid", "sharp; pungent");
		wordBank.put("boorish", "ill-mannered");
		wordBank.put("cynical", "believing that people act only out of selfish motives");
		wordBank.put("epistle", "a letter (form of communication)");
		wordBank.put("heresy", "against othodox opinion");
		wordBank.put("lance", "spear; spike; javelin");
		wordBank.put("obscure", "difficult to understand; partially hidden");
		wordBank.put("poignant", "deeply moving; strongly affecting the emotions");
		wordBank.put("respite", "a break; intermission");
		wordBank.put("acrophobia", "fear of heights");
		wordBank.put("terse", "concise; to the point");
		wordBank.put("debility", "weakness; incapacity");
		wordBank.put("epistolary", "concerned with letters; through correspondence");
		wordBank.put("obsequious", "servile; submissive");
		wordBank.put("polemical", "causing debate or argument");
		wordBank.put("timorous", "cowardly; fearful");
		wordBank.put("adroit", "skillful");
		wordBank.put("retention", "preservation; withholding");
		wordBank.put("pontification", "speak pompously or dogmatically");
		wordBank.put("obstreperous", "noisy and boisterous");
		wordBank.put("portend", "foretell");
		wordBank.put("bulwark", "fortification; barricade; wall");
		wordBank.put("posterity", "future generations");
		wordBank.put("torpor", "dormancy; sluggishness; inactivity");
		wordBank.put("officious", "domineering; intrusive; meddlesome");
		wordBank.put("posthumous", "after death");
		
		order = new ArrayList<String>();
		randomWords();
		firstTime();
	}
	
	private void randomWords(){
		order.clear();
		Random rand = new Random();
		List<String> keys = new ArrayList<String>(wordBank.keySet());
		randomKey = keys.get( rand.nextInt(keys.size()) );
		value = wordBank.get(randomKey);
		String value1 = wordBank.get(keys.get( rand.nextInt(keys.size())));
		String value2 = wordBank.get(keys.get( rand.nextInt(keys.size())));
		String value3 = wordBank.get(keys.get( rand.nextInt(keys.size())));

		order.add(value1);
		order.add(value2);
		order.add(value3);
		int num = rand.nextInt(4);
		order.add(num, value);
	}

	private void firstTime() {
		TextView txtView = (TextView)findViewById(R.id.text1);
		txtView.setText(randomKey);	
		
		Button p1_button = (Button)findViewById(R.id.button1);
		p1_button.setText(order.get(0));

		Button p2_button = (Button)findViewById(R.id.button2);
		p2_button.setText(order.get(1));

		Button p3_button = (Button)findViewById(R.id.button3);
		p3_button.setText(order.get(2));
		
		Button p4_button = (Button)findViewById(R.id.button4);
		p4_button.setText(order.get(3));
	}

	
	public void goToButton1(View view) {
		Button p1_button = (Button)findViewById(R.id.button1);
		if (order.get(0).equals(value)) {
    		p1_button.setTextColor(Color.parseColor("#006400")); 
    	} else {
    		p1_button.setTextColor(Color.RED);
    	}
	} 
	
	public void goToButton2(View view) {
		Button p2_button = (Button)findViewById(R.id.button2);
		if (order.get(1).equals(value)) {
    		p2_button.setTextColor(Color.parseColor("#006400")); 
    	} else {
    		p2_button.setTextColor(Color.RED);
    	}
	}
	
	public void goToButton3(View view) {
		Button p3_button = (Button)findViewById(R.id.button3);
		if (order.get(2).equals(value)) {
    		p3_button.setTextColor(Color.parseColor("#006400")); 
    	} else {
    		p3_button.setTextColor(Color.RED);
    	}
	}
	
	public void goToButton4(View view) {
		Button p4_button = (Button)findViewById(R.id.button4);
		if (order.get(3).equals(value)) {
    		p4_button.setTextColor(Color.parseColor("#006400")); 
    	} else {
    		p4_button.setTextColor(Color.RED);
    	}
	}
	
	public void goToNext(View view) {
		buttonContainer.removeAllViews();
		
		randomWords();
		
		TextView tv = new TextView(this);
        tv.setText(randomKey);
        buttonContainer.addView(tv);
        
		Button button1 = new Button(this);
		button1.setBackgroundColor(Color.WHITE);
		button1.setText(order.get(0));
		buttonContainer.addView(button1);
		
		Button button2 = new Button(this);
		button2.setBackgroundColor(Color.WHITE);
		button2.setText(order.get(1));
		buttonContainer.addView(button2);
		
		Button button3 = new Button(this);
		button3.setBackgroundColor(Color.WHITE);
		button3.setText(order.get(2));
		buttonContainer.addView(button3);
		
		Button button4 = new Button(this);
		button4.setBackgroundColor(Color.WHITE);
		button4.setText(order.get(3));
		buttonContainer.addView(button4);
		
		Button next = new Button(this);
		next.setText("Next");
		buttonContainer.addView(next);
		
	}
	


	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.multiple_choice, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
