package Exc2;

//

public class Main {

    public static void main(String[] args)  {
        CustomersPurchaseSortFind cpsf = new CustomersPurchaseSortFind();
//        loading example list of purchases from different customers, each purchase is object of the Purchase Class
        String fname = "customers.txt";

//method for loading data from file to finder class - CustomersPurchaseSortFind
        cpsf.readFile(fname);

// method for sorting data by customer name (asc), and secondarily by their id
        cpsf.showSortedBy("Nazwiska");

// method for sorting data by customer name (desc), and secondarily by their id
        cpsf.showSortedBy("Koszty");

// method for finding purchase data of customers with given ids
        String[] custSearch = { "c00001", "c00002" };

        for (String id : custSearch) {
            cpsf.showPurchaseFor(id);
        }
    }

}