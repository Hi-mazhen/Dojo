package dojo.pattern.factory.abstractfactory;

import dojo.pattern.factory.IPayment;

public interface IPayFactory {
    IPayment createPayment();

    ISignature createSignature();
}
