package de.ahus1.bdd;

import de.ahus1.bdd.cup.*;
import org.junit.Test;

import static com.shazam.gwen.Gwen.*;

public class FeatureCup {

    // our context for arrange, act and assert
    private Context context = new Context();

    // our fixture regarding the lists
    private CupSUT theCup = new CupSUT(context);
    private UserSUT theUser = new UserSUT(context);

    @Test
    public void scenarioDrinking() {
        given(theCup).fromCupboard();
        given(theCup).withContents(200);
        when(theUser).drinks(5);
        then(theCup).contains(195);
    }

}
