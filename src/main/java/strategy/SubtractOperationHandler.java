package strategy;

import db.Storage;
import dto.ShopOperation;
import model.Fruit;

public class SubtractOperationHandler implements OperationHandler {
    @Override
    public int apply(ShopOperation shopOperation) {
        Fruit fruit = new Fruit(shopOperation.getFruitName());
        int oldAmount = Storage.storage.getOrDefault(fruit, 0);
        if (shopOperation.getQuantity() > oldAmount) {
            throw new RuntimeException("Not enough product");
        }
        int newAmount = oldAmount - shopOperation.getQuantity();
        return newAmount;
    }
}