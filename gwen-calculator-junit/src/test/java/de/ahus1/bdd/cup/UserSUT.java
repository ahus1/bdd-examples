package de.ahus1.bdd.cup;

import com.shazam.gwen.collaborators.Actor;
import com.shazam.gwen.gwt.When;
import de.ahus1.bdd.cup.action.CupActions;

public class UserSUT implements When<UserSUT.UserActor> {

    private UserActor actor;

    private Context context;

    public class UserActor implements Actor {

        public void drinks(int i) {
            context.cup(CupActions.drink(i));
        }

    }

    public UserSUT(Context context) {
        this.context = context;
        actor = new UserActor();
    }

    public UserActor when() {
        return actor;
    }

}
