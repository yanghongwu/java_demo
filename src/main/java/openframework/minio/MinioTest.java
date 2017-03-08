package openframework.minio;

import java.io.FileInputStream;
import java.util.List;

/**
 * Created by yanghongwu on 2017/3/8.
 */
public class MinioTest {
    public static void main(String[] args) {
        try {
            MinioClient minioClient = new MinioClient("http://127.0.0.1:9000", "J501ZMZ3DU6KK2YOF4EN", "q2hWn4AO8Gj42MaKlr5mKicxFX0a4UiOkpJGOghd");
            // List buckets that have read access.
            List<Bucket> bucketList = minioClient.listBuckets();
            for (Bucket bucket : bucketList) {
                System.out.println(bucket.creationDate() + ", " + bucket.name());
            }
//            minioClient.setBucketPolicy("xloan", "uploads", BucketPolicy.WriteOnly);

            FileInputStream f = new FileInputStream("/tmp/wifi-03-05-2017__12:57:20.log");
            minioClient.putObject("xloan", "aaa/bbbb2", f, f.available(), MediaType.APPLICATION_OCTET_STREAM_VALUE);
//            minioClient.makeBucket("xloan.20170307");

//            minioClient.putObject("xloan", "ttttt/20160307", "/tmp/wifi-03-05-2017__12:57:20.log");
        } catch (Exception e) {
            System.out.println("Error occurred: " + e);
        }
    }

}
