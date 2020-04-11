package com.dan323.proof.modal;

import com.dan323.expresions.modal.DisjunctionModal;
import com.dan323.expresions.modal.ModalLogicalOperation;
import com.dan323.expresions.modal.ModalOperation;
import com.dan323.proof.generic.OrI;
import com.dan323.proof.generic.proof.Proof;
import com.dan323.proof.modal.proof.ProofStepModal;

public final class ModalOrI1<T> extends OrI<ModalOperation, ProofStepModal<T>> implements ModalAction<T> {

    public ModalOrI1(int i, ModalLogicalOperation intro) {
        super(i, intro, DisjunctionModal::new);
    }

    @Override
    public void apply(Proof<ModalOperation, ProofStepModal<T>> pf) {
        applyStepSupplier(pf, ((assLevel, log, reason) ->
                new ProofStepModal<>((pf.getSteps().get(getAt() - 1)).getState(), assLevel, (ModalLogicalOperation) log, reason)));
    }
}