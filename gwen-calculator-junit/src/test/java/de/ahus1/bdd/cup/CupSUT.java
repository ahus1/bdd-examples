package de.ahus1.bdd.cup;

import com.shazam.gwen.collaborators.Actor;
import com.shazam.gwen.collaborators.Arranger;
import com.shazam.gwen.collaborators.Asserter;
import com.shazam.gwen.gwt.Given;
import com.shazam.gwen.gwt.Then;
import com.shazam.gwen.gwt.When;
import de.ahus1.bdd.calculator.Cup;
import de.ahus1.bdd.cup.arrangement.CupArrangements;
import de.ahus1.bdd.cup.assertion.CupAssertions;

public class CupSUT implements Given<CupSUT.CupArranger>, When<CupSUT.CupActor>,
        Then<CupSUT.CupAsserter> {

    private CupAsserter asserter;
    private CupArranger arranger;
    private CupActor actor;
    private Context context;

    public CupSUT(Context context) {
        this.context = context;
        arranger = new CupArranger();
        actor = new CupActor();
        asserter = new CupAsserter();
    }

    public class CupArranger implements Arranger {

        public void withContents(long val) {
            context.cup(CupArrangements.initialize(val));
        }

        public void fromCupboard() {
            context.setCup(new Cup());
        }
    }

    public class CupActor implements Actor {
    }

    public class CupAsserter implements Asserter {

        public void contains(long val) {
            context.cup(CupAssertions.isFilledWith(val));
        }

    }

    public CupAsserter then() {
        return asserter;
    }

    public CupArranger given() {
        return arranger;
    }

    public CupActor when() {
        return actor;
    }

}
