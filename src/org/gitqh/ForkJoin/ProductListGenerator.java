package org.gitqh.ForkJoin;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-30-22:34
 */
public class ProductListGenerator {
    public List<Product> generate(int size) {
        List<Product> ret = new ArrayList<>();
        for (int i=0;i<size;i++) {
            Product product = new Product();
            product.setName("Product "+i);
            product.setPrice(10);
            ret.add(product);
        }
        return ret;
    }
}
