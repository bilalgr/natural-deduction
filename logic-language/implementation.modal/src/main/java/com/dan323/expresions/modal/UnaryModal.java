package com.dan323.expresions.modal;

import com.dan323.expresions.base.UnaryOperation;

public abstract class UnaryModal extends UnaryOperation<ModalLogicalOperation> implements ModalLogicalOperation {

    public UnaryModal(ModalLogicalOperation element) {
        super(element);
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 5 + ModalLogicalOperation.class.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return ModalLogicalOperation.modalOperationEquals(obj, super::equals);
    }
}
