package helper;

import model.entity.Dataset;
import model.entity.Item;
import usecase.CreateRandomItems;
import usecase.CreateRandomOrders;

import java.util.ArrayList;

public class DatasetRepository {
    private static Dataset dataset = new Dataset();

    public DatasetRepository(ArrayList<Item> items, int numberOfOrder, int capacity, int numberOfItemPerOrder){
        dataset.setCapacity(capacity);
        dataset.setNumberOfOrders(numberOfOrder);
        dataset.setNumberOfItemPerOrder(numberOfItemPerOrder);
//        dataset.setItems(new CreateRandomItems(numberOfItems).getItems());
        CreateRandomOrders orderRepo = new CreateRandomOrders(items, numberOfOrder, numberOfItemPerOrder);
        dataset.setOrders(orderRepo.getOrders());
        dataset.setTotalOfWeight(orderRepo.getTotalWeight());
    }

    public void setDataset(Dataset d){
        dataset = d;
    }

    public Dataset getDataset() {
        return dataset;
    }
}
