package calculator;

import calculator.enums.EMathOperationsConstans;

public interface InterfaceMathOperation<T,S,U> {
    T execute (S firstObject, EMathOperationsConstans operation, U secondObject );
}
