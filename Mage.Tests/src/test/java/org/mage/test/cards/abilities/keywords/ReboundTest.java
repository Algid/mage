/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mage.test.cards.abilities.keywords;

import mage.constants.PhaseStep;
import mage.constants.Zone;
import org.junit.Test;
import org.mage.test.serverside.base.CardTestPlayerBase;

/**
 *
 * @author jeff
 */
public class ReboundTest extends CardTestPlayerBase{
    
    @Test
    public void testCastFromHandMovedToExile() {
        addCard(Zone.BATTLEFIELD, playerA, "Island", 1);
        addCard(Zone.HAND, playerA, "Distortion Strike");
        
        addCard(Zone.BATTLEFIELD, playerB, "Memnite", 1);

        castSpell(1, PhaseStep.PRECOMBAT_MAIN, playerA, "Distortion Strike", "Memnite");

        setStopAt(1, PhaseStep.BEGIN_COMBAT);
        execute();
        
        //check exile and graveyard
        
        assertExileCount("Distortion Strike", 1);
        assertGraveyardCount(playerA, 0);
    }
}
