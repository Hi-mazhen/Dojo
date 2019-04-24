package dojo.pattern.factory.factorymethod;

import dojo.pattern.factory.IPayment;
import dojo.pattern.factory.UnionPayment;

public class UnionPayFactory implements IPayFactory {
    @Override
    public IPayment create() {
        return new UnionPayment();
    }
}
