package com.dan323.proof.modal;

import com.dan323.expresions.base.BinaryOperation;
import com.dan323.expresions.modal.ModalLogicalOperation;
import com.dan323.expresions.modal.ModalOperation;
import com.dan323.proof.generic.AndE;
import com.dan323.proof.modal.proof.ModalNaturalDeduction;
import com.dan323.proof.modal.proof.ProofStepModal;

public final class ModalAndE1<T> extends AndE<ModalOperation, ProofStepModal<T>, ModalNaturalDeduction<T>> implements ModalAction<T> {

    public ModalAndE1(int i) {
        super(i, BinaryOperation::getLeft);
    }

    @Override
    public void apply(ModalNaturalDeduction<T> pf) {
        applyStepSupplier(pf, ((assLevel, log, reason) -> new ProofStepModal<>(getState(pf), assLevel, (ModalLogicalOperation) log, reason)));
    }

    private T getState(ModalNaturalDeduction<T> pf) {
        return (pf.getSteps().get(getAppliedAt() - 1)).getState();
    }
}
