package diffutilrecyclerview.javademo.proxy;

/**
 * Created by bobo on 2017/3/10.
 */

public class BusinessProcessorImpl implements BusinessProcessor {
    public void processBusiness() {
        System.out.println("processing business.....");
    }

    @Override
    public void processBusiness(String ste) {
        System.out.println("processing business.....:" + ste);

    }
}
