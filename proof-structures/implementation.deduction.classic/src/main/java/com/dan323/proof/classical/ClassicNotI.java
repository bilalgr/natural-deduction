package com.dan323.proof.classical;

import com.dan323.expresions.classical.ClassicalLogicOperation;
import com.dan323.expresions.classical.NegationClassic;
import com.dan323.proof.generic.NotI;
import com.dan323.proof.generic.proof.ProofStep;

public final class ClassicNotI extends NotI<ClassicalLogicOperation, ProofStep<ClassicalLogicOperation>> implements ClassicalAction {

    public ClassicNotI() {
        super(NegationClassic::new);
    }

}