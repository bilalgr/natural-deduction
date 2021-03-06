package com.dan323.classical;

import com.dan323.classical.proof.NaturalDeduction;
import com.dan323.expresions.classical.ClassicalLogicOperation;
import com.dan323.expresions.classical.ConstantClassic;
import com.dan323.proof.generic.FI;
import com.dan323.proof.generic.proof.ProofStep;

public final class ClassicFI extends FI<ClassicalLogicOperation, ProofStep<ClassicalLogicOperation>, NaturalDeduction> implements ClassicalAction {

    public ClassicFI(int i, int j) {
        super(i, j, () -> ConstantClassic.FALSE);
    }

}
