package com.dan323.expresions.modal;

import com.dan323.expresions.base.Constant;

public final class ConstantModal implements ModalLogicalExpression, Constant {

    public static final ConstantModal TRUE = new ConstantModal(true);
    public static final ConstantModal FALSE = new ConstantModal(false);
    private final boolean val;

    private ConstantModal(boolean b) {
        val = b;
    }

    @Override
    public Constant falsehood() {
        return FALSE;
    }

    @Override
    public Constant truehood() {
        return TRUE;
    }

    public boolean getValue() {
        return val;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    @Override
    public boolean equals(Object ltl) {
        return (ltl instanceof ConstantModal) && ((ConstantModal) ltl).val == val;
    }

    @Override
    public int hashCode() {
        return val ? 1 : 0;
    }
}
