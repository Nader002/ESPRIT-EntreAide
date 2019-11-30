package com.esprit.EspritEntreAide.Service;

import com.codename1.facebook.FaceBookAccess;
import com.codename1.io.NetworkEvent;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
/**
 *
 * @author Fenina Malek
 */
public class FacebookShare {
    private static String token = "EAACEdEose0cBAOzEDEcEqqSJZCPd6P6IVzRu6LzDiFarcLIwaNquSUAEPfNWXkPck9dBZBFAzZBcv9UMXazzh5yJCwSXhm4C8clSHCTedsm4TaVd0xjd6SZArX6ZAOiFT9anYy4akmPkGHPzPwVdTwjQZBrtmCEAA1m0wtRriVhK5xZCGPZC6K3GI1h5DQ68ZAlQZD";

    public FacebookShare(String token) {
        FaceBookAccess.setToken(token);
    }

    public void share(String text) throws IOException {
	FaceBookAccess.getInstance().addResponseCodeListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent evt) {
		NetworkEvent ne = (NetworkEvent) evt;
		int code = ne.getResponseCode();
		FaceBookAccess.getInstance().removeResponseCodeListener(this);
	    }
	});
	FaceBookAccess.getInstance().postOnWall("me", text);
    }
    
}
