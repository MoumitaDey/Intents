package com.basics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ImplicitIntent extends Activity implements View.OnClickListener {

    private Button maps, email, market;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.implicit_intent);

        maps = (Button)findViewById(R.id.maps);
        email = (Button)findViewById(R.id.email);
        market = (Button)findViewById(R.id.market);

        maps.setOnClickListener(this);
        market.setOnClickListener(this);
        email.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.maps:
                String loc = "geo:28.5355,77.3910";
                Intent chooser;
                Intent intentMaps = new Intent(android.content.Intent.ACTION_VIEW);
                intentMaps.setData(Uri.parse(loc));
                chooser = Intent.createChooser(intentMaps,"Choose Maps");
                startActivity(chooser);
                break;

            case R.id.market:
                Intent intentMarket = new Intent(android.content.Intent.ACTION_VIEW);
                intentMarket.setData(Uri.parse("market://details?id=com.Hello_Hello.English.Main&hl=en"));
               // chooser = Intent.createChooser(intentMarket, "Chhose Market");
                startActivity(intentMarket);
                break;

            case R.id.email:
                String[] to = {"moumitadeymishra@gmail.com"};
                Intent intentEmail = new Intent(android.content.Intent.ACTION_SEND);
                intentEmail.setData(Uri.parse("mailto:"));
                intentEmail.putExtra(Intent.EXTRA_EMAIL, to);
                intentEmail.putExtra(Intent.EXTRA_SUBJECT, "Testing mailing System through Intent");
                intentEmail.putExtra(Intent.EXTRA_TEXT, "Hi, I was just checking whether an email can be send to you via Intent.");
                intentEmail.setType("message/rfc822");
                chooser = Intent.createChooser(intentEmail, "Choose Mail");
                startActivity(chooser);
                break;

        }
    }
}
