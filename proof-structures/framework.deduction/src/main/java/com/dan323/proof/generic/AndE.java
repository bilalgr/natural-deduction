package com.dan323.proof.generic;

import com.dan323.expresions.base.Conjunction;
import com.dan323.expresions.base.LogicOperation;
import com.dan323.proof.generic.proof.Proof;
import com.dan323.proof.generic.proof.ProofReason;
import com.dan323.proof.generic.proof.ProofStep;
import com.dan323.proof.generic.proof.ProofStepSupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author danco
 */
public abstract class AndE<T extends LogicOperation, Q extends ProofStep<T>> implements AbstractAction<T, Q> {

    private final int applyAt;
    private Function<Conjunction<T>, T> side;

    public AndE(int app, Function<Conjunction<T>, T> fun) {
        applyAt = app;
        side = fun;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && getClass().equals(obj.getClass())) {
            return ((AndE) obj).applyAt == applyAt;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 11 * applyAt;
    }

    @Override
    public boolean isValid(Proof<T, Q> pf) {
        return RuleUtils.isValidIndexAndProp(pf, applyAt) && RuleUtils.isOperation(pf, applyAt, Conjunction.class);
    }

    @Override
    public void applyStepSupplier(Proof<T, Q> pf, ProofStepSupplier<T, Q> supp) {
        T log = pf.getSteps().get(applyAt - 1).getStep();
        int assLevel = 0;
        if (!pf.getSteps().isEmpty()) {
            assLevel = Action.getLastAssumptionLevel(pf);
        }
        List<Integer> lst = new ArrayList<>();
        lst.add(applyAt);
        pf.getSteps().add(supp.generateProofStep(assLevel, side.apply((Conjunction<T>) log), new ProofReason("&E", lst)));
    }

    protected int getAppliedAt() {
        return applyAt;
    }

}
