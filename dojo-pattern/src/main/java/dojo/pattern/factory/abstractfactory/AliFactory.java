package dojo.pattern.factory.abstractfactory;

import dojo.pattern.factory.AliPayment;
import dojo.pattern.factory.IPayment;

public class AliFactory implements IPayFactory {
    @Override
    public IPayment createPayment() {
        return new AliPayment();
    }

    @Override
    public ISignature createSignature() {
        return new AliSignature();
    }
}
