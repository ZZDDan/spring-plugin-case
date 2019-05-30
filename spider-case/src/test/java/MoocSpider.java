import com.rxx.spider.simple.SimpleSpider;
import com.rxx.spider.util.HttpClientUtil;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.concurrent.CountDownLatch;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2019/5/29 17:05
 */
public class MoocSpider {
    private static final Logger logger = Logger.getLogger(SimpleSpider.class);
    private static String baseUrl = "https://www.imooc.com/u/";
//    private static long pid = 3024343，3028846,3028901，3028902，3030521, 3061485，3064251，3069407;
    private static long pid = 3070076;
    private static long uid = 0;
    static CountDownLatch latch=new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            long uid = pid + i * 500000;
            new Thread(()->{
                try {
                    MoocSpider.spider(uid);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "thread-" + i).start();
        }
        latch.await();
        logger.info("执行结束：uid-" + uid);
    }

    public static void spider(long pid) throws InterruptedException {
        // 爬取
        while(true) {
            String url = baseUrl + pid++;
            String pageData = HttpClientUtil.httpGet(url);
            if(pageData == null){
                continue;
            }

            // 解析
            Document document = new Document(url);
            document.html(pageData);
            Elements elements = document.select("#main > div.bg-other.user-head-info > div > div.user-info-right > h3 > span");

            for (Element e : elements) {
                String name = e.text();

                // 打印
                logger.info("\nNo." + Thread.currentThread().getName() +
                        "\turl:" + url +
                        "\tname:" + name);

                if("".equals(name)){
                    uid = pid - 1;
                    latch.countDown();
                    return;
                }
            }

            Thread.sleep(100);
        }
    }
}
